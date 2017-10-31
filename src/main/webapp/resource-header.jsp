<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 10/9/2017
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--Core Script--%>
<!-- Bootstrap Css-->
<link href="<c:url value="resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="resources/dist/css/sb-admin-2.css"/>" rel="stylesheet">

<!--jQUery UI -->
<link href="<c:url value="resources/vendor/jquery-ui/jquery-ui.min.css"/>" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<c:url value="resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">


<!-- jQuery -->
<script src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="resources/vendor/metisMenu/metisMenu.min.js"/>"></script>

<!-- jQuery UI -->
<script src="<c:url value="resources/vendor/jquery-ui/jquery-ui.min.js"/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<c:url value="resources/dist/js/sb-admin-2.js"/>"></script>

<style>
    .ui-datepicker {
        position: relative;
        z-index: 10000 !important;
    }
    .nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover{
        border-top: solid black 2px;
        border-radius: 2px;
    }
</style>