(function ($) {
    $.extend({
        room: {}
    });

    /**
     * 表格内容
     */
    $.room.tableColumns = [{
        field: 'dsRegionName',
        title: '地市'
    }, {
        field: 'regionName',
        title: '区县'
    }, {
        field: 'chinaName',
        title: '机房名称'
    }, {
        field: 'roomNo',
        title: '机房编码'
    }, {
        field: 'alias',
        title: '机房别名'
    }, {
        field: 'stationName',
        title: '所属局站'
    }, {
        field: 'typeName',
        title: '机房类型'
    }, {
        field: 'className',
        title: '机房等级'
    }, {
        field: 'propertyName',
        title: '机房状态'
    }, {
        field: 'length',
        title: '长度(米)'
    }, {
        field: 'width',
        title: '宽度(米)'
    }, {
        field: 'area',
        title: '机房面积'
    }, {
        field: 'propertyBelongName',
        title: '产权归属'
    }, {
        field: 'reinforceName',
        title: '是否安装动力环境监控'
    }, {
        field: 'maintenanceUnit',
        title: '维护单位'
    }, {
        field: 'linkMan',
        title: '维护人'
    }, {
        field: 'notes',
        title: '备注'
    }, {
        field: 'longLocalName',
        title: '长本属性'
    }, {
        field: 'territorialNatureName',
        title: '属地性质'
    }, {
        field: 'constructionShareName',
        title: '共建 / 共享'
    }, {
        field: 'startTime',
        title: '开始时间'
    }, {
        field: 'contractExpiresTime',
        title: '合同到期时间'
    }, {
        field: 'createDate',
        title: '创建时间'
    }];

    /**
     * 初始化
     */
    $.room.init = function () {

    };
})(jQuery);