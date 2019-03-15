(function ($) {
    $.extend({
        address: {}
    });

    /**
     * 表格内容
     */
    $.address.tableColumns = [{
        field: 'dsRegionName',
        title: '地市'
    }, {
        field: 'regionName',
        title: '区县'
    }, {
        field: 'standName',
        title: '标准地址全称'
    }, {
        field: 'segmName',
        title: '分段地址名称'
    }, {
        field: 'alias',
        title: '地址别名'
    }, {
        field: 'parentStandName',
        title: '上级地址名称'
    }, {
        field: 'segmTypeName',
        title: '地址等级'
    }, {
        field: 'x',
        title: '经度'
    }, {
        field: 'y',
        title: '纬度'
    }, {
        field: 'isUserName',
        title: '是否可受理'
    }, {
        field: 'isBindDire',
        title: '是否绑定局向'
    }, {
        field: 'isBindDevice',
        title: '是否绑定设备'
    }, {
        field: 'comRegionName',
        title: '接入点名称'
    }, {
        field: 'serviceRegionName',
        title: '业务点名称'
    }, {
        field: 'custGroupName',
        title: '客户分群'
    }, {
        field: 'createTime',
        title: '录入时间'
    }, {
        field: 'modiryDate',
        title: '修改时间'
    }];

    /**
     * 初始化
     */
    $.address.init = function () {

    };
})(jQuery);