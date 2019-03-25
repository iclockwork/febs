$(function () {
    var $form = $(".building-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#buildingTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.building.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.building.tableColumns);
        }

        var settings = {
            url: ctx + "building/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    regionId: $qx.val(),
                    buildingNo: $form.find("input[name='buildingNo']").val().trim(),
                    buildingName: $form.find("input[name='buildingName']").val().trim(),
                    buildingType: $form.find("select[name='buildingType']").val(),
                    buildingTypeName: $form.find("input[name='buildingTypeName']").val().trim(),
                    buildingAddress: $form.find("input[name='buildingAddress']").val().trim(),
                    state: $form.find("select[name='state']").val()
                };
            },
            columns: columns
        };

        $MB.initTable('buildingTable', settings);
    }

    function search() {
        $MB.refreshTable('buildingTable');
    }

    function refresh() {
        $form[0].reset();

        var stateInitValue = $form.find("select[name='state']").attr("initValue");
        if (stateInitValue) {
            $form.find("select[name='state']").val(stateInitValue);
        }

        search();
    }

    function openUpdate() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        $("#modal-building-edit-form").find("input[name='buildingId']").val(buildingId)
        $("#buildingModalMode").val("update");
        $("#modal-building-edit-title").html('修改楼宇');
        $('#modal-building-edit').modal('show');
    }

    function del() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        var contain = false;
        if (!selected_length) {
            $MB.n_warning('请勾选需要删除的楼宇！');
            return;
        }
        var buildingIds = "";
        for (var i = 0; i < selected_length; i++) {
            buildingIds += selected[i].buildingId;
            if (i !== (selected_length - 1)) buildingIds += ",";
        }

        $MB.confirm({
            text: "确定删除选中楼宇？",
            confirmButtonText: "确定删除"
        }, function () {
            $.post(ctx + 'building/delete', {buildingIds: buildingIds}, function (r) {
                if (r.code === 0) {
                    $MB.n_success(r.msg);
                    refresh();
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        });
    }

    function viewInspection() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要查看巡检记录的楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能查看一个楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        var buildingNo = selected[0].buildingNo;
        var _viewInspectionModal = $('#inspection-query-modal');
        _viewInspectionModal.attr("inspectionType", "1");
        _viewInspectionModal.attr("inspectionNo", buildingNo);
        _viewInspectionModal.modal('show');
    }

    function selectOk() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        var buildingNo = selected[0].buildingNo;
        var buildingName = selected[0].buildingName;
        var segmId = selected[0].segmId;
        var standName = selected[0].standName;

        var stateQuery = $form.find("select[name='state']").val();
        if ("1" === stateQuery && !segmId) {
            $MB.n_warning('请选择已覆盖并绑定了标准地址的楼宇！');
            return;
        }

        console.log("buildingId:" + buildingId + ", buildingNo:" + buildingNo + ", buildingName:" + buildingName + ", segmId:" + segmId + ", standName:" + standName);

        var _selectModal = $("#building-select-modal");
        var selectBackFormId = _selectModal.attr("selectBackFormId");
        if (selectBackFormId) {
            var _selectBackForm = $("#" + selectBackFormId);
            _selectBackForm.find("input[name='buildingId']").val(buildingId);
            _selectBackForm.find("input[name='buildingNo']").val(buildingNo);
            _selectBackForm.find("input[name='buildingName']").val(buildingName);
            _selectBackForm.find("input[name='buildingSegmId']").val(segmId);
            _selectBackForm.find("input[name='buildingSegmStandName']").val(standName);
        }

        _selectModal.modal('hide');
    }

    initTable();

    $(".building-search").click(function () {
        search();
    });

    $(".building-refresh").click(function () {
        refresh();
    });

    $(".building-export-excel").click(function () {
        $.utils.exportFile(ctx + "building/excel", $form.serialize());
    });

    $(".building-export-csv").click(function () {
        $.utils.exportFile(ctx + "building/csv", $form.serialize());
    });

    $(".building-select-modal-ok").click(function () {
        selectOk();
    });

    $(".building-add").click(function () {
        $("#buildingModalMode").val("add");
        $("#modal-building-edit-title").html('新增楼宇');
        $('#modal-building-edit').modal('show');
    });

    $(".building-update").click(function () {
        openUpdate();
    });

    $(".building-delete").click(function () {
        del();
    });

    $(".building-inspection").click(function () {
        viewInspection();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});