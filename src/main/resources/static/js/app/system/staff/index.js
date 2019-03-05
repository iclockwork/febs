$(function () {
    var settings = {
        url: ctx + "staff/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                loginName: $(".staff-table-form").find("input[name='loginName']").val().trim(),
                name: $(".staff-table-form").find("input[name='name']").val().trim(),
                phoneNo: $(".staff-table-form").find("input[name='phoneNo']").val().trim()
            };
        },
        columns: [{
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
        }]
    };

    function search() {
        $MB.refreshTable('staffTable');
    }

    function refresh() {
        $(".staff-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "staff/excel";
        if ("excel" === fileType) {
            url = ctx + "staff/excel";
        } else if ("csv" === fileType) {
            url = ctx + "staff/csv";
        }
        $.post(url, $(".staff-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('staffTable', settings);

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