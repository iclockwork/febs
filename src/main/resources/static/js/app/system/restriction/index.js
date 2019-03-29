$(function () {
    var $form = $(".restriction-table-form");

    function initTable() {
        var settings = {
            url: ctx + "restriction/list",
            pageSize: 10,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    serialNo: $form.find("input[name='serialNo']").val().trim(),
                    descChina: $form.find("input[name='descChina']").val().trim(),
                    keyword: $form.find("input[name='keyword']").val().trim(),
                    keywordDesc: $form.find("input[name='keywordDesc']").val().trim()
                };
            },
            columns: $.restriction.tableColumns
        };

        $MB.initTable('restrictionTable', settings);
    }

    function search() {
        $MB.refreshTable('restrictionTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    initTable();

    $(".restriction-search").click(function () {
        search();
    });

    $(".restriction-refresh").click(function () {
        refresh();
    });

    $(".restriction-export-excel").click(function () {
        $.utils.exportFile(ctx + "restriction/excel", $form.serialize());
    });

    $(".restriction-export-csv").click(function () {
        $.utils.exportFile(ctx + "restriction/csv", $form.serialize());
    });
});