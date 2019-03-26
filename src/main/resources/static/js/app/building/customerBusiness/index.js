$(function () {
    var $form = $(".customerBusiness-table-form");

    function initTable() {
        var settings = {
            url: ctx + "customerBusiness/list",
            pageSize: 10,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    customerNo: $form.find("input[name='customerNo']").val()
                };
            },
            columns: $.customerBusiness.tableColumns
        };

        $MB.initTable('customerBusinessTable', settings);
    }

    function search() {
        $MB.refreshTable('customerBusinessTable');
    }

    function refresh() {
        $form[0].reset();

        var customerNoInitValue = $form.find("input[name='customerNo']").attr("initValue");
        if (customerNoInitValue) {
            $form.find("input[name='customerNo']").val(customerNoInitValue);
        }

        search();
    }

    initTable();

    $(".customerBusiness-search").click(function () {
        search();
    });

    $(".customerBusiness-refresh").click(function () {
        refresh();
    });

    $(".customerBusiness-export-excel").click(function () {
        $.utils.exportFile(ctx + "customerBusiness/excel", $form.serialize());
    });

    $(".customerBusiness-export-csv").click(function () {
        $.utils.exportFile(ctx + "customerBusiness/csv", $form.serialize());
    });
});