<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaoCHSE61802
  Date: 24-Oct-17
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${fresher.firstName}</title>
    <c:import url="resource-header.jsp"/>
</head>
<body>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${fresher.firstName}'s detail</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-10 col-md-10 col-xs-12 col-sm-12 col-lg-offset-1 col-md-offset-1">
                <form class="form-horizontal" action="SaveFresher" method="post">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">First
                            name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtFirstName" value="${fresher.firstName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Last
                            Name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtLastName" value="${fresher.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Email: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input class="form-control" name="txtEmail" value="${fresher.email}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Birthday: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input class="form-control" name="txtDob" id="txtDob" value="${fresher.dob}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Phone: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input class="form-control" name="txtPhone" value="${fresher.phone}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Sex: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <c:choose>
                                <c:when test="${fresher.sex}"><input class="form-control" name="rbtSex" value="Male" readonly></c:when>
                                <c:otherwise><input class="form-control" name="rbtSex" value="Female" readonly></c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 col-lg-offset-3 col-md-offset-3 col-xs-offset-3 col-sm-offset-3">
                            <input type="hidden" name="txtId" value="${fresher.id}">
                            <button type="submit" name="btnAction" value="2" class="btn btn-success">
                                Save <i class="glyphicon glyphicon-save"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <script>
                    $(document).ready(function () {
                        $("#txtDob").datepicker({
                            dateFormat: "dd/mm/yy"
                        });
                    });
                </script>
            </div>
            <%--<div class="row">--%>
            <%--<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">--%>
            <%--<h3><b>${subject.name}</b> is included in theses courses: </h3>--%>
            <%--</div>--%>
            <%--<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">--%>
            <%--<c:choose>--%>
            <%--<c:when test="${not empty coursesEqui}">--%>
            <%--<table class="table table-bordered">--%>
            <%--<tr>--%>
            <%--<th>Name</th>--%>
            <%--<th>Start Date</th>--%>
            <%--<th>End Date</th>--%>
            <%--</tr>--%>
            <%--<c:forEach var="coursesSubject" items="${coursesEqui}">--%>
            <%--<tr>--%>
            <%--<td>--%>
            <%--<a href="viewCourse?id=${coursesSubject.courses.id}"--%>
            <%--class="btn">${coursesSubject.courses.courseName} </a>--%>
            <%--</td>--%>
            <%--<td>${coursesSubject.courses.startDate}</td>--%>
            <%--<td>${coursesSubject.courses.endDate}</td>--%>
            <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</table>--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
            <%--<p>This subject is not in any courses</p>--%>
            <%--</c:otherwise>--%>
            <%--</c:choose>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>
