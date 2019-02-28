$(function () {
    var settings = {
        url: ctx + "restriction/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                serialNo: $(".restriction-table-form").find("input[name='serialNo']").val().trim(),
                descChina: $(".restriction-table-form").find("input[name='descChina']").val().trim(),
                keyword: $(".restriction-table-form").find("input[name='keyword']").val().trim(),
                keywordDesc: $(".restriction-table-form").find("input[name='keywordDesc']").val().trim()
            };
        },
        columns: [{
            field: 'serialNo',
            title: '流水号'
        }, {
            field: 'descChina',
            title: '属性名称'
        }, {
            field: 'keyword',
            title: '关键字'
        }, {
            field: 'keywordDesc',
            title: '关键字描述'
        }]
    };

    function search() {
        $MB.refreshTable('restrictionTable');
    }

    function refresh() {
        $(".restriction-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "restriction/excel";
        if ("excel" === fileType) {
            url = ctx + "restriction/excel";
        } else if ("csv" === fileType) {
            url = ctx + "restriction/csv";
        }
        $.post(url, $(".restriction-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    $MB.initTable('restrictionTable', settings);

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