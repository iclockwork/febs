(function ($) {
    $.extend({
        accessArea: {}
    });

    /**
     * 表格内容
     */
    $.accessArea.tableColumns = [{
        field: 'dsRegionName',
        title: '地市'
    }, {
        field: 'regionName',
        title: '区县'
    }, {
        field: 'accessAreaNo',
        title: '综合接入区编码'
    }, {
        field: 'accessAreaName',
        title: '综合接入区名称'
    }, {
        field: 'focusAreaName',
        title: '汇聚区名称'
    }, {
        field: 'areaTypeName',
        title: '所属区域'
    }, {
        field: 'isCompleteName',
        title: '是否已完成建设'
    }, {
        field: 'problem',
        title: '目前存在问题'
    }, {
        field: 'workLoad',
        title: '工作量'
    }, {
        field: 'notes',
        title: '备注'
    }, {
        field: 'createTime',
        title: '创建时间'
    }];

    /**
     * 初始化
     */
    $.accessArea.init = function () {

    };
})(jQuery);