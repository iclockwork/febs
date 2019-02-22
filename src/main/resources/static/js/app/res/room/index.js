$(function () {
    var settings = {
        url: ctx + "room/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                chinaName: $(".room-table-form").find("input[name='chinaName']").val().trim()
            };
        },
        columns: [{
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
            field: 'regionName',
            title: '所属区域'
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
        }]
    };

    function search() {
        $MB.refreshTable('roomTable');
    }

    function refresh() {
        $(".room-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "room/excel";
        if ("excel" === fileType) {
            url = ctx + "room/excel";
        } else if ("csv" === fileType) {
            url = ctx + "room/csv";
        }
        $.post(url, $(".room-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('roomTable', settings);

    $(".zmdi-search").click(function () {
        search();
    });

    $(".zmdi-refresh-alt").click(function () {
        refresh();
    });

    $("#exportExcel").click(function () {
        exportFile("excel")
    });

    $("#exportCsv").click(function () {
        exportFile("csv")
    });
});