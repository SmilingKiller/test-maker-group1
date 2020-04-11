(function () {

    /*
     * Definition of DOM variables
     */
    var dataTable = $('#paper-mgmt-table');
    var searchBox = $('#paper-keyword');

    /*
     * Definition of model variables
     */
    var selectedQuestion={}, papers,transitions;
    var syllabus=CONTEXT.project.syllabus;
    var selectedChapter={}, chapters;
    var knowledgePoints, languages, questionTypes;
    var projectUsers;
    var transitions4InitialStatus;

    /*
     * action urls
     */
    var listPapersURL = CONTEXT.ctx + '/web/project/current/list-papers.action';
    var paperPagingUrl=CONTEXT.ctx + '/web/project/current/paging-paper.action';

    var pagingHelper = new PaginationHelper(paperPagingUrl, listPapersURL, function (data) {
        papers=data.papers;
        console.log('%s questions loaded.', papers.length);
        displayQuestions(papers);
    });
    /*
     * Default function when the page loads
     */
    initialize();

    /**
     * Page initialization
     */
    function initialize() {
        pagingHelper.loadPagingInfo();
        loadData();
        new TableFilter(dataTable, searchBox);
    }

    $('#reload-paper-btn').click(function (e) {
        initialize();
    });

    // /**
    //  * Popup a modal of question details
    //  */
    // dataTable.on('click','.view-item', function (e) {
    //     e.preventDefault();
    //
    //     //gets the data-index attribute in the table and set selected kp per this index
    //     var index = $(this).closest('tr').data('index');
    //     selectedQuestion = papers[index];
    //     QuestionUtils.showQuestionDetailsModal({papers: selectedQuestion});
    // });


    function displayQuestions(papers) {
        AjaxUtils.getTemplateAjax(CONTEXT.ctx +'/assets/templates/questions/paper-list-table.hbs.html', function (template) {
            var templateData = {
                papers: papers,
                showActions: false,
                showDelete: false,
                showDetails: true
            };
            dataTable.empty();
            dataTable.append(template(templateData));
//            Dialogs.showAjaxLoadInfo($('.msg-area'), questions.length);
        });
    }
    function loadData() {
        return $.get(listPapersURL, {
            pageSize: pagingHelper.pageSize,
            pageNumber: pagingHelper.currentPage
        })
            .done(function (data, textStatus, jqXHR) {
                papers=data.papers;
                displayQuestions(papers);
            })
    }
})();
