$(function () {
    var $form = $(".staff-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#staffTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.staff.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.staff.tableColumns;
        }

        var settings = {
            url: ctx + "staff/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    loginName: $form.find("input[name='loginName']").val().trim(),
                    name: $form.find("input[name='name']").val().trim(),
                    phoneNo: $form.find("input[name='phoneNo']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('staffTable', settings);
    }

    function search() {
        $MB.refreshTable('staffTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    function selectOk() {
        var selected = $("#staffTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的人员！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个人员！');
            return;
        }
        var staffId = selected[0].staffId;
        var staffName = selected[0].name;
        var username = selected[0].loginName;
        var email = selected[0].remark;
        var mobile = selected[0].phoneNo;

        console.log("staffId:" + staffId + ", staffName:" + staffName + ", username:" + username + ", email:" + email + ", mobile:" + mobile);

        var _selectModal = $("#staff-select-modal");
        var selectBackFormId = _selectModal.attr("selectBackFormId");
        if (selectBackFormId) {
            var _selectBackForm = $("#" + selectBackFormId);
            _selectBackForm.find("input[name='staffId']").val(staffId);
            _selectBackForm.find("input[name='staffName']").val(staffName);
            _selectBackForm.find("input[name='username']").val(username);
            _selectBackForm.find("input[name='email']").val(email);
            _selectBackForm.find("input[name='mobile']").val(mobile);
        }

        _selectModal.modal('hide');
    }

    initTable();

    $(".staff-search").click(function () {
        search();
    });

    $(".staff-refresh").click(function () {
        refresh();
    });

    $(".staff-export-excel").click(function () {
        $.utils.exportFile(ctx + "staff/excel", $form.serialize());
    });

    $(".staff-export-csv").click(function () {
        $.utils.exportFile(ctx + "staff/csv", $form.serialize());
    });

    $(".staff-select-modal-ok").click(function () {
        selectOk();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});