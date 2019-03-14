$(function () {
    var $form = $(".address-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");

    var settings = {
        url: ctx + "address/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                dsRegionId: $ds.val(),
                regionId: $qx.val(),
                segmType: $form.find("select[name='segmType']").val(),
                standName: $form.find("input[name='standName']").val().trim()
            };
        },
        columns: [{
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
        }]
    };

    function search() {
        $MB.refreshTable('addressTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "address/excel";
        if ("excel" === fileType) {
            url = ctx + "address/excel";
        } else if ("csv" === fileType) {
            url = ctx + "address/csv";
        }
        $.post(url, $form.serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('addressTable', settings);

    $(".address-search").click(function () {
        search();
    });

    $(".address-refresh").click(function () {
        refresh();
    });

    $(".address-export-excel").click(function () {
        exportFile("excel")
    });

    $(".address-export-csv").click(function () {
        exportFile("csv")
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});