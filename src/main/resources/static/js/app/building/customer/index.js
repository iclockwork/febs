$(function () {
    var settings = {
        url: ctx + "customer/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                customerName: $(".customer-table-form").find("input[name='customerName']").val().trim()
            };
        },
        columns: [{
            field: 'customerNo',
            title: '客户编码'
        }, {
            field: 'customerName',
            title: '客户名称'
        }, {
            field: 'keyPerson',
            title: '客户联系人'
        }, {
            field: 'monthFee',
            title: '月费'
        }, {
            field: 'remark',
            title: '备注'
        }]
    };

    function search() {
        $MB.refreshTable('customerTable');
    }

    function refresh() {
        $(".customer-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "customer/excel";
        if ("excel" === fileType) {
            url = ctx + "customer/excel";
        } else if ("csv" === fileType) {
            url = ctx + "customer/csv";
        }
        $.post(url, $(".customer-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('customerTable', settings);

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