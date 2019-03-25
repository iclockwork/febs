$(function () {
    var $form = $(".accessArea-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#accessAreaTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.accessArea.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.accessArea.tableColumns;
        }

        var settings = {
            url: ctx + "accessArea/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    accessAreaName: $form.find("input[name='accessAreaName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('accessAreaTable', settings);
    }

    function search() {
        $MB.refreshTable('accessAreaTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    function selectOk() {
        var selected = $("#accessAreaTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的综合接入区！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个综合接入区！');
            return;
        }
        var accessAreaId = selected[0].accessAreaId;
        var accessAreaName = selected[0].accessAreaName;

        console.log("accessAreaId:" + accessAreaId + ", accessAreaName:" + accessAreaName);

        var _selectModal = $("#accessArea-select-modal");
        var selectBackFormId = _selectModal.attr("selectBackFormId");
        if (selectBackFormId) {
            var _selectBackForm = $("#" + selectBackFormId);
            _selectBackForm.find("input[name='accessAreaId']").val(accessAreaId);
            _selectBackForm.find("input[name='accessAreaName']").val(accessAreaName);
        }

        _selectModal.modal('hide');
    }

    initTable();

    $(".accessArea-search").click(function () {
        search();
    });

    $(".accessArea-refresh").click(function () {
        refresh();
    });

    $(".accessArea-export-excel").click(function () {
        $.utils.exportFile(ctx + "accessArea/excel", $form.serialize());
    });

    $(".accessArea-export-csv").click(function () {
        $.utils.exportFile(ctx + "accessArea/csv", $form.serialize());
    });

    $(".accessArea-select-modal-ok").click(function () {
        selectOk();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});