$(function () {
    var settings = {
        url: ctx + "building/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingName: $(".building-table-form").find("input[name='buildingName']").val().trim()
            };
        },
        columns: [{
            field: 'buildingNo',
            title: '楼宇编码'
        }, {
            field: 'buildingName',
            title: '楼宇名称'
        }, {
            field: 'createDate',
            title: '创建时间'
        }]
    };

    function search() {
        $MB.refreshTable('buildingTable');
    }

    function refresh() {
        $(".building-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "building/excel";
        if ("excel" === fileType) {
            url = ctx + "building/excel";
        } else if ("csv" === fileType) {
            url = ctx + "building/csv";
        }
        $.post(url, $(".building-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('buildingTable', settings);

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