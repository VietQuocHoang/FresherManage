<%--
  Created by IntelliJ IDEA.
  User: BaoCHSE61802
  Date: 26-Oct-17
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
    <c:import url="resource-header.jsp"/>
    <link href="<c:url value="resources/vendor/datatables/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.css"/>">
    <script src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables/js/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>
    <%--Plugin-Chosen CSS--%>
    <link href="<c:url value="resources/vendor/choosen_plugin/chosen.min.css"/>" rel="stylesheet" type="text/css">

    <%--Plugin-Chosen-JavaScript--%>
    <script src="<c:url value="resources/vendor/choosen_plugin/chosen.jquery.min.js"/>"></script>
    <style>
        .ui-datepicker {
            position: relative;
            z-index: 10000 !important;
        }
        .chosen-container .chosen-container-single{
            width: 100% !important;        }
    </style>
</head>
<body>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Test List</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                    <!-- Trigger the modal with a button -->
                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                            data-target="#add-new-test-modal"><i class="glyphicon glyphicon-plus"></i></button>
                    <table id="tests-table" class="table table-bordered">
                        <thead>
                        <tr>
                            <th hidden>ID</th>
                            <th>Test</th>
                            <th>Course</th>
                            <th>Subject</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="test" items="${listTest}">
                            <tr>
                                <td hidden>${test.id}</td>
                                <td>${test.name}</td>
                                <td>${test.coursesSubject.courses.courseName}</td>
                                <td>${test.coursesSubject.subject.acronym}</td>
                                <td class="details-control" id="${test.id}"><i
                                        class="glyphicon glyphicon-collapse-down"></i></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <script>
                        function setDeleteTestId(id) {
                            $("#delete-test-id").val(id);
                        }

                        function format(d) {
                            return "<table class='pull-right'>" +
                                "<tr>" +
                                "<td>" +
                                "<button type='button' class='btn btn-danger' onclick='setDeleteTestId(" + d[0] + ")' data-toggle='modal' data-target='#delete-test'>Delete <i class='glyphicon glyphicon-trash'></i></button>" +
                                "<a class='btn btn-warning' href='viewTest?id=" + d[0] + "'>View Details <i class='glyphicon glyphicon-chevron-right'></i></a>" +
                                "</td>" +
                                "</tr>" +
                                "</table>"
                        }

                        $(document).ready(function () {
                            var table = $('#tests-table').DataTable();
                            $('#tests-table tbody').on('click', 'td.details-control', function () {
                                var tr = $(this).closest('tr');
                                var row = table.row(tr);
                                if (row.child.isShown()) {
                                    // This row is already open - close it
                                    row.child.hide();
                                    tr.removeClass('shown');
                                }
                                else {
                                    // Open this row
                                    row.child(format(row.data())).show();
                                    tr.addClass('shown');
                                }
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<h2><a name="optgroup-support" class="anchor" href="#optgroup-support">&lt;optgroup&gt; Support</a></h2>--%>

<!-- add new modal -->
<div id="add-new-test-modal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Test</h4>
            </div>
            <form class="form-horizontal" action="SaveTest" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Name: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtTestName" class="form-control" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Question: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtQuestion" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Course-subject: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <div class="side-by-side clearfix">
                                <select id="selectCourseSubject" name="selectCourseSubject" data-placeholder="Course Subject" class="chosen-select form-control"
                                        tabindex="5">
                                    <c:forEach var="course" items="${listCourse}">
                                        <%--<c:set var="course" value="${list.courses}"/>--%>
                                        <optgroup label="${course.courseName}">
                                            <c:forEach var="courseSubject" items="${course.coursesSubjectList}">
                                                <c:set var="subject" value="${courseSubject.subject}"/>
                                                <option name="optCourseSubject" value="${courseSubject.id}">${subject.acronym}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </c:forEach>
                                </select>
                                <script>
                                    $(document).ready(function () {
                                        $("#selectCourseSubject").chosen({width:"95%"});
                                    })
                                </script>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" name="btnAction" value="1">Submit</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="delete-test" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Delete confirmation</h4>
            </div>
            <form class="form-horizontal" action="DeleteTest" method="post">
                <div class="modal-body">
                    <p>Are you sure you want to delete this test?</p>
                    <input id="delete-test-id" hidden value="" name="txtId">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger">Delete</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
