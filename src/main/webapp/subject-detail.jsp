<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>${subject.name}</title>
    <c:import url="resource-header.jsp"/>
</head>
<body>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${subject.name}'s detail</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-10 col-md-10 col-xs-12 col-sm-12 col-lg-offset-1 col-md-offset-1">
                <form class="form-horizontal" action="SaveSubject" method="post">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Acronym: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtAcronym" value="${subject.acronym}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Subject Name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtName" value="${subject.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Subject's Description</label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <textarea class="form-control" name="txtDescription">${subject.description}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Is available?: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="available" <c:if test="${subject.available}">checked</c:if> >
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 col-lg-offset-3 col-md-offset-3 col-xs-offset-3 col-sm-offset-3">
                            <input type="hidden" name="txtId" value="${subject.id}">
                            <button type="submit" name="btnAction" value="2" class="btn btn-success">
                                Save <i class="glyphicon glyphicon-save"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                    <h3><b>${subject.name}</b> is included in theses courses: </h3>
                </div>
                <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                    <c:choose>
                        <c:when test="${not empty coursesEqui}">
                            <table class="table table-bordered">
                                <tr>
                                    <th>Name</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                </tr>
                                <c:forEach var="coursesSubject" items="${coursesEqui}">
                                    <tr>
                                        <td>
                                            <a href="viewCourse?id=${coursesSubject.courses.id}" class="btn">${coursesSubject.courses.courseName} </a>
                                        </td>
                                        <td>${coursesSubject.courses.startDate}</td>
                                        <td>${coursesSubject.courses.endDate}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <p>This subject is not in any courses</p>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>