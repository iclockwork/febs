$(function () {
    var settings = {
        url: ctx + "buildingCustomerRp/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingNo: $(".buildingCustomerRp-table-form").find("input[name='buildingNo']").val().trim(),
                buildingName: $(".buildingCustomerRp-table-form").find("input[name='buildingName']").val().trim(),
                customerNo: $(".buildingCustomerRp-table-form").find("input[name='customerNo']").val().trim(),
                customerName: $(".buildingCustomerRp-table-form").find("input[name='customerName']").val().trim()
            };
        },
        columns: [{
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
        }]
    };

    function search() {
        $MB.refreshTable('buildingCustomerRpTable');
    }

    function refresh() {
        $(".buildingCustomerRp-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "buildingCustomerRp/excel";
        if ("excel" === fileType) {
            url = ctx + "buildingCustomerRp/excel";
        } else if ("csv" === fileType) {
            url = ctx + "buildingCustomerRp/csv";
        }
        $.post(url, $(".buildingCustomerRp-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('buildingCustomerRpTable', settings);

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