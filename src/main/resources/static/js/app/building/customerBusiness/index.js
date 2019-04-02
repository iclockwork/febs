$(function () {
    var $form = $(".customerBusiness-table-form");
    var $selectMode = $("#customerBusinessTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            columns = $.customerBusiness.tableColumns;
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.customerBusiness.tableColumns;
        }

        var settings = {
            url: ctx + "customerBusiness/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    customerNo: $form.find("input[name='customerNo']").val()
                };
            },
            columns: columns
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

    function openUpdate() {
        var selected = $("#customerBusinessTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的业务！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个业务！');
            return;
        }
        var customerBusinessId = selected[0].customerBusinessId;
        $("#modal-customerBusiness-edit-form").find("input[name='customerBusinessId']").val(customerBusinessId);
        $("#customerBusinessModalMode").val("update");
        $("#modal-customerBusiness-edit-title").html('修改业务');
        $('#modal-customerBusiness-edit').modal('show');
    }

    function del() {
        var selected = $("#customerBusinessTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        var contain = false;
        if (!selected_length) {
            $MB.n_warning('请勾选需要删除的业务！');
            return;
        }
        var customerBusinessIds = "";
        for (var i = 0; i < selected_length; i++) {
            customerBusinessIds += selected[i].customerBusinessId;
            if (i !== (selected_length - 1)) customerBusinessIds += ",";
        }

        $MB.confirm({
            text: "确定删除选中业务？",
            confirmButtonText: "确定删除"
        }, function () {
            $.post(ctx + 'customerBusiness/delete', {customerBusinessIds: customerBusinessIds}, function (r) {
                if (r.code === 0) {
                    $MB.n_success(r.msg);
                    refresh();
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        });
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

    $(".customerBusiness-add").click(function () {
        var customerId = $form.find("input[name='customerNo']").attr("customerId");
        $("#modal-customerBusiness-edit-form").find("input[name='customerId']").val(customerId);
        $("#customerBusinessModalMode").val("add");
        $("#modal-customerBusiness-edit-title").html('新增业务');
        $('#modal-customerBusiness-edit').modal('show');
    });

    $(".customerBusiness-update").click(function () {
        openUpdate();
    });

    $(".customerBusiness-delete").click(function () {
        del();
    });
});