<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaoCHSE61802
  Date: 27-Oct-17
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${testObj.name}</title>
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

        .chosen-container .chosen-container-single {
            width: 100% !important;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${testObj.name}'s detail</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-10 col-md-10 col-xs-12 col-sm-12 col-lg-offset-1 col-md-offset-1">
                <form class="form-horizontal" action="SaveTest" method="post">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Test
                            name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtTestName" value="${testObj.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Question: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtQuestion" value="${testObj.questions}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Course-subject: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <div class="side-by-side clearfix">
                                <select id="selectCourseSubject" name="selectCourseSubject"
                                        data-placeholder="Course Subject" class="chosen-select form-control"
                                        tabindex="5">
                                    <c:forEach var="course" items="${listCourse}">
                                        <%--<c:set var="course" value="${list.courses}"/>--%>
                                    <optgroup label="${course.courseName}">
                                        <c:forEach var="courseSubject" items="${course.coursesSubjectList}">
                                            <c:set var="subject" value="${courseSubject.subject}"/>
                                            <option name="optCourseSubject"
                                                    value="${courseSubject.id}">${subject.acronym}</option>
                                        </c:forEach>
                                    </optgroup>
                                    </c:forEach>
                                    <script>
                                        $(document).ready(function () {
                                            $("#selectCourseSubject").chosen({width: "100%"});
                                            $("#selectCourseSubject").val("${testObj.coursesSubject.id}").trigger("chosen:updated");
                                        })
                                    </script>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 col-lg-offset-3 col-md-offset-3 col-xs-offset-3 col-sm-offset-3">
                            <input type="hidden" name="txtId" value="${testObj.id}">
                            <button type="submit" name="btnAction" value="2" class="btn btn-success">
                                Save <i class="glyphicon glyphicon-save"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </div>
    <div class="row">
        <ul class="nav nav-tabs">
            <%--<li class=""><a data-toggle="tab" href="#tab-subject">Subject</a></li>--%>
            <li class="active"><a data-toggle="tab" href="#tab-fresher">Fresher</a></li>
        </ul>
        <div class="tab-content">
            <div id="tab-fresher" class="tab-pane fade in active">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <h3><b>${testObj.name}</b> done: </h3>
                    <c:if test="${not empty listTestFresherMarked}">
                        <table class="table table-bordered" id="table-included-fresher">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Fresher:</th>
                                <th>Test:</th>
                                <th>Mark:</th>
                                <th>Marked Date:</th>
                                <th>Action:</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listTestFresherMarked}" var="test_fresher" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${test_fresher.fresher.firstName} ${test_fresher.fresher.lastName}</td>
                                    <td>${test_fresher.test.name}</td>
                                    <td>${test_fresher.mark}</td>
                                    <td>${test_fresher.markDate}</td>
                                    <td>
                                        <form method="post" action="TestFresherController">
                                            <input type="hidden" value="${test_fresher.id}" name="txtTestFresherId"/>
                                            <button type="submit" name="btnAction" value="2"
                                                    class="btn btn-warning">
                                                Remark <i class="glyphicon glyphicon-pencil
"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <script>
                            $(document).ready(function () {
                                $("#table-included-fresher").DataTable();
                            });
                        </script>
                    </c:if>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <h3>Not mark: </h3>
                    <c:if test="${not empty listTestFresherNotMark}">
                        <table class="table table-bordered" id="table-not-mark-test">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Fresher:</th>
                                <th>Test:</th>
                                <th>Action:</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="test_fresher" items="${listTestFresherNotMark}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${test_fresher.fresher.firstName} ${test_fresher.fresher.lastName}</td>
                                    <td>${test_fresher.test.name}</td>
                                    <td>
                                        <form method="post" action="TestFresherController">
                                            <input type="hidden" value="${test_fresher.id}" name="txtTestFresherId"/>
                                            <button type="submit" name="btnAction" value="2"
                                                    class="btn btn-success">
                                                Mark <i class="glyphicon glyphicon-plus"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <script>
                                $(document).ready(function () {
                                    $("#table-not-mark-test").DataTable();
                                });
                            </script>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
