<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 10/9/2017
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <c:import url="resource-header.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${check == 1}">
                <h1 style='color:red;'>Username or Password must not be empty</h1><br/>
            </c:when>
            <c:when test="${check == 2}">
                <h1 style='color:red;'>Username or Password is invalid, try again</h1><br/>
            </c:when>
        </c:choose>
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="LoginController" method="POST">
                        <fieldset>
                            <div class="form-group input-group">
                                <input class="form-control" placeholder="Username" name="txtUsername" type="text" autofocus>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            </div>
                            <div class="form-group input-group">
                                <input class="form-control" placeholder="Password" name="txtPassword" type="password"
                                       value="">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> </span>
                            </div>
                            <%--<div class="checkbox">--%>
                                <%--<label>--%>
                                    <%--<input name="remember" type="checkbox" value="Remember Me">Remember Me--%>
                                <%--</label>--%>
                            <%--</div>--%>
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" name="btnSubmit" class="btn btn-lg btn-success btn-block" value="Login">Login</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
