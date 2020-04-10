<%--
  Created by IntelliJ IDEA.
  User: wangs
  Date: 2020/4/9
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Modal -->
<div id="new-paper-modal" class="modal fade" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title" id="myModalLabel">组成试卷</h3>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--modified by wsl-->
                    <form id="generate-paper-form" class="form-horizontal title-border-form">
<%--                        wsl: this part is useless--%>
<%--                        <div id="q-id-section" class="form-group hidden">--%>
<%--                            <label class="col-md-2 control-label">ID</label>--%>
<%--                            <div class="col-md-3">--%>
<%--                                <input id="question-id" class="form-control" type="text" readonly>--%>
<%--                            </div>--%>
<%--                            <label class="cold-md-2">当前状态</label>--%>
<%--                            <span id="question-status" class="form-control-static"></span>--%>
<%--                            <span id="change-status-container"></span>--%>
<%--                        </div>--%>
                        <fieldset>
                            <legend>${PROJECT.syllabus.level} (${PROJECT.syllabus.version})</legend>
<%--                            <div class="form-group">--%>
<%--                                <label class="col-md-2 control-label">章节</label>--%>
<%--                                <div class="col-md-4 col-lg-4">--%>
<%--                                    <select id="chapter-select" class="form-control select-list" data-placeholder="选择章节">--%>
<%--                                        <option></option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <label class="col-md-2 control-label">知识点</label>--%>
<%--                                <div class="col-md-10">--%>
<%--                                    &lt;%&ndash;<button type="button" class="btn btn-primary">分配选中知识点</button>&ndash;%&gt;--%>
<%--                                    <select id="knowledge-point-select" class="form-control select-list" data-placeholder="选择知识点">--%>
<%--                                        <option></option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </fieldset>

                        <div class="form-group">
                            <%--<label class="col-md-2 control-label">类型</label>--%>
                            <%--<div class="col-md-2">--%>
                            <%--<select id="question-type-list" name="type" class="select-list-simple form-control" data-placeholder="选择类型">--%>
                            <%--<option></option>--%>
                            <%--</select>--%>
                            <%--</div>--%>
                            <label class="col-md-2 control-label">作者</label>
                            <div class="col-md-2 col-lg-2">
                                <select id="author-list" class="select-list user-select-list form-control" data-placeholder="选择作者" required>
                                    <option></option>
                                </select>
                            </div>
<%--                            <label class="col-md-2 control-label">评审</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <select id="reviewer-list" class="select-list user-select-list form-control" data-placeholder="选择评审" required>--%>
<%--                                    <option></option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
                            <%--<label class="col-md-2 control-label">语言</label>--%>
                            <%--<div class="col-md-2">--%>
                            <%--<select id="question-language-list" name="language" class="select-list-simple form-control" data-placeholder="选择语言">--%>
                            <%--<option></option>--%>
                            <%--</select>--%>
                            <%--</div>--%>
<%--                            <label class="col-md-2 control-label">质管</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <select id="question-qa-list" name="qa" class="select-list user-select-list form-control" data-placeholder="选择质管">--%>
<%--                                    <option></option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
                        </div>

                        <div class="form-group">
<%--                            &lt;%&ndash;<label class="col-md-2 control-label">作者</label>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;<div class="col-md-2 col-lg-2">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;<select id="author-list" class="select-list user-select-list form-control" data-placeholder="选择作者" required>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;<option></option>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;</select>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;</div>&ndash;%&gt;--%>
                                <label class="col-md-2 control-label">试卷名称</label>
                                <div class="col-md-2">
                                    <input id='paperName' name="paperName" type='text'  required>
                                </div>
<%--                            <label class="col-md-2 control-label">类型</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <select id="question-type-list" name="type" class="select-list-simple form-control" data-placeholder="选择类型">--%>
<%--                                    <option></option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <label class="col-md-2 control-label">出题开始日期</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <input id='authorStartDate' name="authorStartDate" type='text' class="datepicker form-control" required>--%>
<%--                            </div>--%>
<%--                            <label class="col-md-2 control-label">出题结束日期</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <input id="authorFinishDate" name="authorFinishDate" type='text' class="form-control datepicker" required>--%>
<%--                            </div>--%>
<%--                        </div>--%>

                        <div class="form-group">
<%--                            <label class="col-md-2 control-label">评审</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                            <select id="reviewer-list" class="select-list user-select-list form-control" data-placeholder="选择评审" required>--%>
<%--                            <option></option>--%>
<%--                            </select>--%>
<%--                            </div>--%>
<%--                            <label class="col-md-2 control-label">语言</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <select id="question-language-list" name="language" class="select-list-simple form-control" data-placeholder="选择语言">--%>
<%--                                    <option></option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
                            <label class="col-md-2 control-label">备注信息</label>
                            <div class="col-md-2">
                                <textarea id='paper-description' name="description" class=" form-control" rows="1" required></textarea>
                            </div>
<%--                            <label class="col-md-2   control-label">评审结束日期</label>--%>
<%--                            <div class="col-md-2">--%>
<%--                                <input id='reviewFinishDate' name="reviewFinishDate" type='text' class="datepicker form-control" required>--%>
<%--                            </div>--%>
                        </div>

                        <%--<div class="form-group">--%>
                        <%--<label class="col-md-2 control-label">质管</label>--%>
                        <%--<div class="col-md-2">--%>
                        <%--<select id="question-qa-list" name="qa" class="select-list user-select-list form-control" data-placeholder="选择质管">--%>
                        <%--<option></option>--%>
                        <%--</select>--%>
                        <%--</div>--%>
                        <%--</div>--%>

                    </form>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
<%--                <button id="save-question-btn" type="button" class="btn btn-primary">提交题目</button>--%>
                <button id="submit-paper-btn" type="button" class="btn btn-primary">提交试卷</button>
            </div>
        </div>
    </div>
</div>

<script id="knowledge-point-list-template" type="text/x-handlebars-template">
    {{#each aaData}}
    <option value="{{id}}" data-index="{{@index}}">{{number}} {{title}}</option>
    {{/each}}
</script>
<script id="language-list-template" type="text/x-handlebars-template">
    {{#each aaData}}
    <option value="{{id}}" data-index="{{@index}}">{{name}}</option>
    {{/each}}
</script>
<script id="question-type-list-template" type="text/x-handlebars-template">
    {{#each aaData}}
    <option value="{{id}}" data-index="{{@index}}">{{name}}</option>
    {{/each}}
</script>
