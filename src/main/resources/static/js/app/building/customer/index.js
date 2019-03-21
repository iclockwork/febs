$(function () {
    var $form = $(".customer-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#customerTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.customer.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.customer.tableColumns;
        }

        var settings = {
            url: ctx + "customer/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    regionId: $qx.val(),
                    customerNo: $form.find("input[name='customerNo']").val().trim(),
                    customerName: $form.find("input[name='customerName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('customerTable', settings);
    }

    function search() {
        $MB.refreshTable('customerTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    initTable();

    $(".customer-search").click(function () {
        search();
    });

    $(".customer-refresh").click(function () {
        refresh();
    });

    $(".customer-export-excel").click(function () {
        $.utils.exportFile(ctx + "customer/excel", $form.serialize());
    });

    $(".customer-export-csv").click(function () {
        $.utils.exportFile(ctx + "customer/csv", $form.serialize());
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});