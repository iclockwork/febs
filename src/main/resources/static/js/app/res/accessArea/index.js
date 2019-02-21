$(function () {
    var settings = {
        url: ctx + "accessArea/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                accessAreaName: $(".accessArea-table-form").find("input[name='accessAreaName']").val().trim()
            };
        },
        columns: [{
            field: 'accessAreaNo',
            title: '综合接入区编码'
        }, {
            field: 'accessAreaName',
            title: '综合接入区名称'
        }, {
            field: 'focusAreaName',
            title: '汇聚区名称'
        }, {
            field: 'areaTypeName',
            title: '所属区域'
        }, {
            field: 'dsRegionName',
            title: '所属地市'
        }, {
            field: 'isCompleteName',
            title: '是否已完成建设'
        }, {
            field: 'problem',
            title: '目前存在问题'
        }, {
            field: 'workLoad',
            title: '工作量'
        }, {
            field: 'notes',
            title: '备注'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    };

    function search() {
        $MB.refreshTable('accessAreaTable');
    }

    function refresh() {
        $(".accessArea-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "accessArea/excel";
        if ("excel" === fileType) {
            url = ctx + "accessArea/excel";
        } else if ("csv" === fileType) {
            url = ctx + "accessArea/csv";
        }
        $.post(url, $(".accessArea-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('accessAreaTable', settings);

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