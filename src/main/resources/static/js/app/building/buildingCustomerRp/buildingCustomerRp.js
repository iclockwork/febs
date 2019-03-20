(function ($) {
    $.extend({
        buildingCustomerRp: {}
    });

    /**
     * 表格内容
     */
    $.buildingCustomerRp.tableColumns = [{
        checkbox: true
    }, {
        field: 'dsRegionName',
        title: '地市'
    }, {
        field: 'regionName',
        title: '区县'
    }, {
        field: 'buildingNo',
        title: '楼宇编码'
    }, {
        field: 'buildingName',
        title: '楼宇名称'
    }, {
        field: 'standName',
        title: '九级地址名称'
    }, {
        field: 'customerNo',
        title: '客户编码'
    }, {
        field: 'customerName',
        title: '客户名称'
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
    $.buildingCustomerRp.init = function () {

    };
})(jQuery);