(function ($) {
    $.extend({
        customerBusiness: {}
    });

    /**
     * 表格内容
     */
    $.customerBusiness.tableColumns = [{
        field: 'businessTypeName',
        title: '业务类型'
    }, {
        field: 'businessPhone',
        title: '业务号码'
    }, {
        field: 'monthFee',
        title: '月费'
    }, {
        field: 'createStaffName',
        title: '创建人'
    }, {
        field: 'createDate',
        title: '创建时间'
    }];

    /**
     * 初始化
     */
    $.customerBusiness.init = function () {

    };

    /**
     * 初始化
     */
    $.customerBusiness.view = function (customerNo) {
        var _viewModal = $('#customerBusiness-query-modal');
        _viewModal.attr("customerNo", customerNo);
        _viewModal.modal('show');
    };
})(jQuery);