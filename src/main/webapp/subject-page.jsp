<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 10/11/2017
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject</title>
    <c:import url="resource-header.jsp"/>
    <link href="<c:url value="resources/vendor/datatables/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.css"/>">
    <script src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables/js/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>
    <style>
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
                <h1 class="page-header">Subject</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <!-- main content go here -->
            <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                    <!-- Trigger the modal with a button -->
                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                            data-target="#add-new-subject-modal"><i class="glyphicon glyphicon-plus"></i></button>
                    <table id="subject-table" class="table table-bordered">
                        <thead>
                            <tr>
                                <th hidden>ID</th>
                                <th>#</th>
                                <th>Acronym:</th>
                                <th>Subject Name:</th>
                                <th>Available?</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach varStatus="status" items="${subjectList}" var="subject">
                            <tr>
                                <td hidden>${subject.id}</td>
                                <td>${status.count}</td>
                                <td>${subject.acronym}</td>
                                <td>${subject.name}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${subject.available}">
                                            <p class="text-success">Available</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="text-danger">Not Available</p>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="details-control"><i class="glyphicon glyphicon-collapse-down"></i></td>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <script>
                        function setDeleteSubjectId(id) {
                            $("#delete-subject-id").val(id);
                        }
                        function format(d){
                            return "<table class='pull-right'>" +
                                "<tr>" +
                                "<td>" +
                                "<button type='button' class='btn btn-danger' onclick='setDeleteSubjectId(" + d[0] +")' data-toggle='modal' data-target='#delete-subject'>Delete <i class='glyphicon glyphicon-trash'></i></button>" +
                                "<a class='btn btn-warning' href='viewSubject?id="+ d[0] +"'>View Details <i class='glyphicon glyphicon-chevron-right'></i></a>" +
                                "</td>" +
                                "</tr>" +
                                "</table>"
                        }
                        $(document).ready(function () {
                            var table = $("#subject-table").DataTable();
                            $('#subject-table tbody').on('click', 'td.details-control', function () {
                                var tr = $(this).closest('tr');
                                var row = table.row( tr );

                                if ( row.child.isShown() ) {
                                    // This row is already open - close it
                                    row.child.hide();
                                    tr.removeClass('shown');
                                }
                                else {
                                    // Open this row
                                    row.child(format(row.data())).show();
                                    tr.addClass('shown');
                                }
                            } );
                        });

                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="add-new-subject-modal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Subject</h4>
            </div>
            <form class="form-horizontal" id="form-add-new" action="SaveSubject" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Acronym: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtAcronym" id="txtAcronym" class="form-control" required>
                            <i class="glyphicon glyphicon-check-acronym"></i>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Subject Name: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <input type="text" name="txtName" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Description: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <textarea class="form-control" name="txtDescription" required></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">Is available: </label>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="available">
                            </label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="btnAction" value="1">Submit</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
            <script>
                $(document).ready(function () {
                    $("#txtAcronym").focusout(function () {
                        var acronym = $(this).val();
                        $.ajax({
                           url: "api/subjects/acronym",
                           data: {"txtAcronym": acronym},
                            dataType:"json",
                            success: function (data) {
                                var result = JSON.parse(data['result']);
                                console.log(result);
                                if(result == "1"){
                                    $("#txtAcronym").removeClass("form-control-active").addClass("form-control-danger");
                                    $(".glyphicon-check-acronym").removeClass("glyphicon-ok").addClass("glyphicon-remove");
                                } else {
                                    $("#txtAcronym").removeClass("form-control-danger").addClass("form-control-active");
                                    $(".glyphicon-check-acronym").removeClass("glyphicon-remove").addClass("glyphicon-ok");
                                }
                            },
                            error:function(data){
                               console.log(data);
                            }
                       })
                    });
                    $("#form-add-new").submit(function (event) {
                        if($("#txtAcronym").hasClass("form-control-danger")){
                            $("#txtAcronym").effect("shake");
                            event.preventDefault();
                            return false;
                        }
                    })
                })
            </script>
        </div>

    </div>
</div>
<div id="delete-subject" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Delete confirmation</h4>
            </div>
            <form class="form-horizontal" action="DeleteSubject" method="post">
                <div class="modal-body">
                    <p>Are you sure you want to delete this subject?</p>
                    <input id="delete-subject-id" hidden value="" name="txtId">
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