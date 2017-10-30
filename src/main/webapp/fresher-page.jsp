<%--
  Created by IntelliJ IDEA.
  User: BaoCHSE61802
  Date: 17-Oct-17
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fresher</title>
    <c:import url="resource-header.jsp"/>
    <link href="<c:url value="resources/vendor/datatables/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.css"/>">
    <script src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables/js/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>
    <style>
        .ui-datepicker {
            position: relative;
            z-index: 10000 !important;
        }

        .glyphicon-ok{
            color: #3d8b3d;
        }
        .glyphicon-remove{
            color: #9f191f;
        }
        .form-control-active{
            border-color: #3d8b3d;
        }
        .form-control-danger{
            border-color: #9f191f;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <c:import url="navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Fresher List</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                    <!-- Trigger the modal with a button -->
                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                            data-target="#add-new-fresher-modal"><i class="glyphicon glyphicon-plus"></i></button>
                    <table id="freshers-table" class="table table-bordered">
                        <thead>
                        <tr>
                            <th hidden>ID</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Day of Birth</th>
                            <th>Sex</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="fresher" items="${listFresher}">
                            <tr>
                                <td hidden>${fresher.id}</td>
                                <td>${fresher.firstName}</td>
                                <td>${fresher.lastName}</td>
                                <td>${fresher.email}</td>
                                <td>${fresher.phone}</td>
                                <td>${fresher.dob}</td>
                                <td><c:choose>
                                    <c:when test="${fresher.sex}">Male</c:when>
                                    <c:otherwise>Female</c:otherwise>
                                </c:choose></td>
                                <td class="details-control"  id="${fresher.id}"><i class="glyphicon glyphicon-collapse-down"></i></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <script>
                        function setDeleteFresherId(id) {
                            $("#delete-fresher-id").val(id);
                        }

                        function format(d) {
                            return "<table class='pull-right'>" +
                                "<tr>" +
                                "<td>" +
                                "<button type='button' class='btn btn-danger' onclick='setDeleteFresherId(" + d[0] + ")' data-toggle='modal' data-target='#delete-fresher'>Delete <i class='glyphicon glyphicon-trash'></i></button>" +
                                "<a class='btn btn-warning' href='viewFresher?id=" + d[0] + "'>View Details <i class='glyphicon glyphicon-chevron-right'></i></a>" +
                                "</td>" +
                                "</tr>" +
                                "</table>"
                        }

                        $(document).ready(function () {
                            var table = $('#freshers-table').DataTable();
                            $('#freshers-table tbody').on('click', 'td.details-control', function () {
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

<!-- add new modal -->
<div id="add-new-fresher-modal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Course</h4>
            </div>
            <form class="form-horizontal" id="form-add-new-fresher" action="SaveFresher" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">First name: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtFirstName" class="form-control" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Last name: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtLastName" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Email: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtEmail" id="txtEmail" class="form-control">
                            <i class="glyphicon glyphicon-check-email"></i>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Phone: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtPhone" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Day of birth: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <div class="input-group">
                                <input type="text" class="form-control ui-datepicker" id="txtDob" name="txtDob"
                                       required>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Sex: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <label class="radio-inline"><input type="radio" name="rbtSex" id="rbtMale" value="Male" > Male</label>
                            <label class="radio-inline"><input type="radio" name="rbtSex" value="Female"> Female</label>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $("#txtDob").datepicker({
                                dateFormat: "dd/mm/yy"
                            });
                            $("#txtEmail").focusout(function () {
                                var email = $(this).val();
                                $.ajax({
                                    url: "api/check-email",
                                    data: {"txtEmail": email},
                                    dataType:"json",
                                    success: function (data) {
                                        var result = JSON.parse(data['result']);
                                        console.log(result);
                                        if(result == "1"){
                                            $("#txtEmail").removeClass("form-control-active").addClass("form-control-danger");
                                            $(".glyphicon-check-email").removeClass("glyphicon-ok").addClass("glyphicon-remove");
                                        } else {
                                            $("#txtEmail").removeClass("form-control-danger").addClass("form-control-active");
                                            $(".glyphicon-check-email").removeClass("glyphicon-remove").addClass("glyphicon-ok");
                                        }
                                    },
                                    error:function(data){
                                        console.log(data);
                                    }
                                })
                            });
                            $("#form-add-new-fresher").submit(function (event) {
                                if($("#txtEmail").hasClass("form-control-danger")){
                                    $("#txtEmail").effect("shake");
                                    event.preventDefault();
                                    return false;
                                }
                            });
                            document.getElementById("rbtMale").selected = true;
                        });

                    </script>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="btnAction" value="1">Submit</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="delete-fresher" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Delete confirmation</h4>
            </div>
            <form class="form-horizontal" action="DeleteFresher" method="post">
                <div class="modal-body">
                    <p>Are you sure you want to delete this fresher?</p>
                    <input id="delete-fresher-id" hidden value="" name="txtId">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger">Delete</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
            <%--<script>--%>
                <%--$('#delete-fresher').on('show.bs.modal', function (e) {--%>
                    <%--$(this).find('.modal-body').html('Fired By: ' + e.relatedTarget.id);--%>
                <%--})--%>
            <%--</script>--%>
        </div>
    </div>
</div>
</body>
</html>
