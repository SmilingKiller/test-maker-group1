<%--
  Created by IntelliJ IDEA.
  User: wangs
  Date: 2020/4/7
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--ADD 新增--%>
<div class="page-header">
    <h1>组卷功能
        <small>${PROJECT.name}</small>
    </h1>
</div>

<div class="container-fluid">
    <div class="row">
        <nav class="toolbar navbar navbar-default">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <!--todo:nelson id should change-->
                        <a id="show-edit-question-form-btn" class="btn btn-primary navbar-btn-tm" data-toggle="modal"
                           role="button"><i class="glyphicon glyphicon-plus-sign"></i>组卷</a>
                    </li>
                    <li>
                        <!--todo:nelson id should change-->
                        <a id="reload-question-btn" href="#" class="btn btn-primary navbar-btn-tm" role="button"><i
                                class="glyphicon glyphicon-refresh"></i>刷新</a>
                    </li>
                    <li>
                        <form class="navbar-form" role="search" onsubmit="return false;">
                            <div class="form-group">
                                <input id="question-keyword" type="text" class="form-control" placeholder="题目关键字">
                                <a id="search-syllabus-btn" class="btn btn-danger navbar-btn-tm"><i
                                        class="glyphicon glyphicon-search"></i></a>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
    </div>


    <div class="row">
        <jsp:include page="/WEB-INF/partials/client/paper-management/new-paper-form.jsp"/>
    </div>


    <div id="select-question-dialog" class="modal fade" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-header-warning">
                    <div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <span class="modal-title">组成试卷</span>
                    </div>
                </div>
                <div class="modal-body">
                    <h4>请选中题目</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
                </div>
            </div>
        </div>
    </div>


    <jsp:include page="/WEB-INF/partials/pagination-snippet.jsp"/>

    <div class="msg-area form-group">
    </div>
    <div class="row">
        <table id="question-mgmt-table" class="table table-striped table-bordered table-responsive table-condensed">
        </table>
    </div>
</div>
<script id="initial-status-transition" type="text/x-handlebars-template">
    <ul class="list-inline">
        {{#each transitions}}
        <li>
            <button class="transition-initial btn btn-primary" data-id="{{id}}">{{name}}</button>
        </li>
        {{/each}}
    </ul>
</script>

<script src="${ctx}/assets/js/client/paper-generating/paper-generating.js"></script>
