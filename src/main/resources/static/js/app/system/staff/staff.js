(function ($) {
    $.extend({
        staff: {}
    });

    /**
     * 表格内容
     */
    $.staff.tableColumns = [{
        field: 'loginName',
        title: '登录名'
    }, {
        field: 'name',
        title: '姓名'
    }, {
        field: 'regionName',
        title: '区域名称'
    }, {
        field: 'deptName',
        title: '部门名称'
    }, {
        field: 'remark',
        title: '邮箱'
    },{
        field: 'phoneNo',
        title: '电话'
    }, {
        field: 'expDate',
        title: '帐号有效期'
    }, {
        field: 'identityId',
        title: '身份证号'
    }, {
        field: 'hrCode',
        title: '人力资源编码'
    }];

    /**
     * 初始化
     */
    $.staff.init = function () {

    };
})(jQuery);