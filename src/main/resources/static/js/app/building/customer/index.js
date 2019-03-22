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

    function selectOk() {
        var selected = $("#customerTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的客户！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个客户！');
            return;
        }
        var customerId = selected[0].customerId;
        var customerNo = selected[0].customerNo;
        var customerName = selected[0].customerName;

        console.log("customerId:" + customerId + ", customerNo:" + customerNo + ", customerName:" + customerName);

        var selectBackFormId = $("#customer-select-modal").attr("selectBackFormId");
        if (selectBackFormId) {
            $("#" + selectBackFormId).find("input[name='customerId']").val(customerId);
            $("#" + selectBackFormId).find("input[name='customerNo']").val(customerNo);
            $("#" + selectBackFormId).find("input[name='customerName']").val(customerName);
        }

        $('#customer-select-modal').modal('hide');
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

    $(".customer-select-modal-ok").click(function () {
        selectOk();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});