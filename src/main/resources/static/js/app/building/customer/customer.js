(function ($) {
    $.extend({
        customer: {}
    });

    /**
     * 表格内容
     */
    $.customer.tableColumns = [{
        field: 'dsRegionName',
        title: '地市'
    }, {
        field: 'regionName',
        title: '区县'
    }, {
        field: 'customerNo',
        title: '客户编码'
    }, {
        field: 'customerName',
        title: '客户名称'
    }, {
        field: 'industryTypeName',
        title: '所属行业'
    }, {
        field: 'keyPerson',
        title: '客户联系人'
    }, {
        field: 'keyPersonContact',
        title: '客户联系电话'
    }, {
        field: 'monthFee',
        title: '月费'
    }, {
        field: 'remark',
        title: '备注'
    }];

    /**
     * 初始化
     */
    $.customer.init = function () {

    };
})(jQuery);