<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 10/9/2017
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .nav .navbar-top-links .navbar-right{
        background-color: #1D1D35;
    }
    .navbar-right .dropdown a{
        color: #1AC18F;
    }
    #side-menu{
        background-color: #1D1D35;
    }
    #side-menu li a{
        color: #1AC18F;
    }
</style>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="Dashboard">Fresher Manage</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Welcome, <c:out value="${cookie.username.value}"></c:out> <!-- replace user for --><i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="LogoutController"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav in" id="side-menu">
                <li>
                    <a href="Dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                </li>
                <li>
                    <a href="courses"><i class="fa fa-calendar fa-fw"></i> Courses </a>
                </li>
                <li>
                    <a href="subjects"><i class="fa fa-book fa-fw"></i> Subject </a>
                </li>
                <li>
                    <a href="FresherController"><i class="fa fa-users fa-fw"></i> Fresher </a>
                </li>
                <li>
                    <a href="TestController"><i class="fa fa-paper-plane fa-fw"></i> Test </a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>