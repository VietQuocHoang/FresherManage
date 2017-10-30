<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BaoCHSE61802
  Date: 30-Oct-17
  Time: 10:20
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
                <h1 class="page-header">Mark ${test_fresher.test.name} of ${test_fresher.fresher.firstName}</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-10 col-md-10 col-xs-12 col-sm-12 col-lg-offset-1 col-md-offset-1">
                <%--//TODO--%>
                <form class="form-horizontal" action="MarkController" method="post">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Test
                            name: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtTest" value="${test_fresher.test.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Fresher: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="text" class="form-control" name="txtFresherName"
                                   value="${test_fresher.fresher.firstName} ${test_fresher.fresher.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-xs-3 col-sm-3 control-label">Mark: </label>
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9">
                            <input type="number" step="0.1" min="0" max="10" class="form-control" name="txtMark"
                                   value="<c:choose>
                                            <c:when test="${test_fresher.mark == 11}">
                                                0
                                            </c:when>
                                            <c:otherwise>
                                                ${test_fresher.mark}
                                            </c:otherwise>
                                            </c:choose>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 col-lg-offset-3 col-md-offset-3 col-xs-offset-3 col-sm-offset-3">
                            <input type="hidden" name="txtId" value="${test_fresher.id}">
                            <button type="submit" name="btnAction" value="2" class="btn btn-success">
                                Save <i class="glyphicon glyphicon-save"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <a class='btn btn-warning' href='viewTest?id=${test_fresher.test.id}'>Back to mark another fresher<i
                        class='glyphicon glyphicon-chevron-right'></i></a>
            </div>
        </div>
    </div>
</body>
</html>
