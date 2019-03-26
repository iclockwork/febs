(function ($) {
    $.extend({
        inspection: {}
    });

    /**
     * 表格内容
     */
    $.inspection.tableColumns = [{
        field: 'inspectionTypeName',
        title: '巡检类型'
    }, {
        field: 'inspectionNo',
        title: '巡检编码'
    }, {
        field: 'position',
        title: '自动定位信息'
    }, {
        field: 'introduction',
        title: '拜访描述'
    }, {
        field: 'createStaffName',
        title: '巡检人'
    }, {
        field: 'createDate',
        title: '巡检时间'
    }];

    /**
     * 初始化
     */
    $.inspection.init = function () {

    };

    /**
     * 初始化
     */
    $.inspection.view = function (inspectionType, inspectionNo) {
        var _viewModal = $('#inspection-query-modal');
        _viewModal.attr("inspectionType", inspectionType);
        _viewModal.attr("inspectionNo", inspectionNo);
        _viewModal.modal('show');
    };
})(jQuery);