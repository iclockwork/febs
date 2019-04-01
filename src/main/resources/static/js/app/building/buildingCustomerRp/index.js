$(function () {
    var $form = $(".buildingCustomerRp-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#buildingCustomerRpTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.buildingCustomerRp.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.buildingCustomerRp.tableColumns);
        }

        var settings = {
            url: ctx + "buildingCustomerRp/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    regionId: $qx.val(),
                    buildingNo: $form.find("input[name='buildingNo']").val().trim(),
                    buildingName: $form.find("input[name='buildingName']").val().trim(),
                    customerNo: $form.find("input[name='customerNo']").val().trim(),
                    customerName: $form.find("input[name='customerName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('buildingCustomerRpTable', settings);
    }

    function search() {
        $MB.refreshTable('buildingCustomerRpTable');
    }

    function refresh() {
        $(".buildingCustomerRp-table-form")[0].reset();

        var buildingNoInitValue = $form.find("input[name='buildingNo']").attr("initValue");
        if (buildingNoInitValue) {
            $form.find("input[name='buildingNo']").val(buildingNoInitValue);
        }

        var customerNoInitValue = $form.find("input[name='customerNo']").attr("initValue");
        if (customerNoInitValue) {
            $form.find("input[name='customerNo']").val(customerNoInitValue);
        }

        search();
    }

    function del() {
        var selected = $("#buildingCustomerRpTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        var contain = false;
        if (!selected_length) {
            $MB.n_warning('请勾选需要删除的楼宇客户关系！');
            return;
        }
        var buildingCustomerRpIds = "";
        for (var i = 0; i < selected_length; i++) {
            buildingCustomerRpIds += selected[i].buildingCustomerRpId;
            if (i !== (selected_length - 1)) buildingCustomerRpIds += ",";
        }

        $MB.confirm({
            text: "确定删除选中楼宇客户关系？",
            confirmButtonText: "确定删除"
        }, function () {
            $.post(ctx + 'buildingCustomerRp/delete', {buildingCustomerRpIds: buildingCustomerRpIds}, function (r) {
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

    $(".buildingCustomerRp-search").click(function () {
        search();
    });

    $(".buildingCustomerRp-refresh").click(function () {
        refresh();
    });

    $(".buildingCustomerRp-export-excel").click(function () {
        $.utils.exportFile(ctx + "buildingCustomerRp/excel", $form.serialize());
    });

    $(".buildingCustomerRp-export-csv").click(function () {
        $.utils.exportFile(ctx + "buildingCustomerRp/csv", $form.serialize());
    });

    $(".buildingCustomerRp-add").click(function () {
        $("#buildingCustomerRpModalMode").val("add");
        $("#modal-buildingCustomerRp-edit-title").html('新增楼宇客户关系');
        $('#modal-buildingCustomerRp-edit').modal('show');
    });

    $(".buildingCustomerRp-delete").click(function () {
        del();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});