<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 10/9/2017
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${course.courseName}</title>
    <c:import url="resource-header.jsp"/>
    <link href="<c:url value="resources/vendor/datatables/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.css"/>">
    <script src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables/js/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>
</head>
<body>
<fmt:parseDate pattern="yyyy-MM-dd" value="${course.startDate}" var="parsedStartDate"/>
<fmt:parseDate pattern="yyyy-MM-dd" value="${course.endDate}" var="parsedEndDate"/>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${course.courseName}'s Detail</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-10 col-md-10 col-xs-12 col-sm-12 col-lg-offset-1 col-md-offset-1">
                <form class="form-horizontal" action="SaveCourse" method="post">
                    <div class="form-group">
                        <label class="col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Course's Name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="" class="form-control" value="${course.courseName}" name="txtCourseName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Course's Description: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <textarea name="txtCourseDescription" class="form-control">${course.courseDescription}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Start Date: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <div class="input-group">
                                <input type="text" class="form-control" value="<fmt:formatDate value="${parsedStartDate}" pattern="dd/MM/yyyy"/>" name="txtStartDate" id="txtStartDate">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">End Date: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <div class="input-group">
                                <input type="text" class="form-control" value="<fmt:formatDate value="${parsedEndDate}" pattern="dd/MM/yyyy"/>" name="txtEndDate" id="txtEndDate">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> </span>
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $("#txtStartDate").datepicker({
                                dateFormat: "dd/mm/yy"
                            });
                            $("#txtEndDate").datepicker({
                                dateFormat: "dd/mm/yy"
                            });
                        });
                    </script>
                    <div class="form-group">
                        <label class="col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Available: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="available" <c:if test="${course.available}">checked</c:if> >
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 col-lg-offset-3 col-md-offset-3 col-xs-offset-3 col-sm-offset-3">
                            <button type="submit" class="btn btn-success">Save <i class="glyphicon glyphicon-save"></i></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#tab-subject">Subject</a></li>
                <li><a data-toggle="tab" href="#tab-fresher">Fresher</a></li>
            </ul>
            <div class="tab-content">
                <div id="tab-subject" class="tab-pane fade in active">
                    <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">

                    </div>
                    <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                        <h3><b>${course.courseName}</b> included theses subjects: </h3>
                        <c:if test="${not empty course.coursesSubjectList}">
                            <table class="table table-bordered" id="table-included-subject">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Acronym: </th>
                                        <th>Name: </th>
                                        <th>Action: </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${course.coursesSubjectList}" var="coursesSubject" varStatus="status">
                                        <tr>
                                            <td>${status.index + 1}</td>
                                            <td>${coursesSubject.subject.acronym}</td>
                                            <td>${coursesSubject.subject.name}</td>
                                            <td>
                                                <form action="CourseAction" method="post">
                                                    <input type="hidden" value="${coursesSubject.courses.id}" name="txtCourseId">
                                                    <input type="hidden" value="${coursesSubject.id}" name="txtId">
                                                    <button class="btn btn-danger" name="btnAction" value="RemoveSubject">Remove <i class="glyphicon glyphicon-plus"></i> </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <script>
                                $(document).ready(function () {
                                   $("#table-included-subject").DataTable();
                                });
                            </script>
                        </c:if>
                    </div>
                    <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                        <h3>Others's courses: </h3>
                        <c:if test="${not empty notIncluded}">
                            <table class="table table-bordered" id="table-not-included-subject">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Acronym: </th>
                                    <th>Name: </th>
                                    <th>Action: </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="subject" items="${notIncluded}" varStatus="status">
                                    <tr>
                                        <td>${status.index + 1}</td>
                                        <td>${subject.acronym}</td>
                                        <td>${subject.name}</td>
                                        <td>
                                            <form method="post" action="CourseAction">
                                                <input type="hidden" value="${course.id}" name="txtCourseId"/>
                                                <input type="hidden" value="${subject.id}" name="txtSubjectId">
                                                <button type="submit" name="btnAction" value="AddSubject" class="btn btn-success">
                                                    Add This Subject <i class="glyphicon glyphicon-plus"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <script>
                                    $(document).ready(function () {
                                        $("#table-not-included-subject").DataTable();
                                    });
                                </script>
                            </table>
                        </c:if>
                    </div>
                </div>
                <div id="tab-fresher" class="tab-pane fade">

                </div>
            </div>

        </div>
    </div>
</div>
<div id="remove-subject" class="modal fade">
</div>
</body>
</html>
