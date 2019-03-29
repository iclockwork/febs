(function ($) {
    $.extend({
        restriction: {}
    });

    /**
     * 表格内容
     */
    $.restriction.tableColumns = [{
        field: 'serialNo',
        title: '流水号'
    }, {
        field: 'descChina',
        title: '属性名称'
    }, {
        field: 'keyword',
        title: '关键字'
    }, {
        field: 'keywordDesc',
        title: '关键字描述'
    }];

    /**
     * 初始化
     */
    $.restriction.init = function () {

    };
})(jQuery);