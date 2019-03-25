$(function () {
    var $form = $(".inspection-table-form");

    function initTable() {
        var settings = {
            url: ctx + "inspection/list",
            pageSize: 10,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    inspectionType: $form.find("select[name='inspectionType']").val(),
                    inspectionNo: $form.find("input[name='inspectionNo']").val().trim()
                };
            },
            columns: $.inspection.tableColumns
        };

        $MB.initTable('inspectionTable', settings);
    }

    function search() {
        $MB.refreshTable('inspectionTable');
    }

    function refresh() {
        $form[0].reset();

        var inspectionTypeInitValue = $form.find("select[name='inspectionType']").attr("initValue");
        if (inspectionTypeInitValue) {
            $form.find("select[name='inspectionType']").val(inspectionTypeInitValue);
        }

        var inspectionNoInitValue = $form.find("input[name='inspectionNo']").attr("initValue");
        if (inspectionNoInitValue) {
            $form.find("input[name='inspectionNo']").val(inspectionNoInitValue);
        }

        search();
    }

    initTable();

    $(".inspection-search").click(function () {
        search();
    });

    $(".inspection-refresh").click(function () {
        refresh();
    });

    $(".inspection-export-excel").click(function () {
        $.utils.exportFile(ctx + "inspection/excel", $form.serialize());
    });

    $(".inspection-export-csv").click(function () {
        $.utils.exportFile(ctx + "inspection/csv", $form.serialize());
    });
});