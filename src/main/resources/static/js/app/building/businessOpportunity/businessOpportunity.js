$(function () {
    var $businessOpportunityTableForm = $(".businessOpportunity-table-form");
    var settings = {
        url: ctx + "businessOpportunity/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingNo: $businessOpportunityTableForm.find("input[name='buildingNo']").val().trim(),
                buildingName: $businessOpportunityTableForm.find("input[name='buildingName']").val().trim(),
                customerName: $businessOpportunityTableForm.find("input[name='customerName']").val().trim(),
                businessSource: $businessOpportunityTableForm.find("select[name='businessSource']").val(),
                businessType: $businessOpportunityTableForm.find("select[name='businessType']").val(),
                state: $businessOpportunityTableForm.find("select[name='state']").val()

            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'businessOpportunityId',
            visible: false
        },{
            field: 'buildingId',
            visible: false
        }, {
            field: 'buildingNo',
            title: '楼宇编码'
        }, {
            field: 'buildingName',
            title: '楼宇名称'
        }, {
            field: 'customerName',
            title: '客户名称'
        }, {
            field: 'businessSource',
            title: '商机来源',
            formatter: function (value, row, index) {
                if (value === 1) return '竞争对手';
                else if (value === 2) return '市场活动';
                else if (value === 3) return '客户';
                else if (value === 4) return '互联网';
                else return '其他';

            }
        }, {
            field: 'customerGrowth',
            title: '客户成长空间',
            formatter: function (value, row, index) {
                if (value === 1) return '高';
                else if (value === 2) return '中';
                else return '低';
            }
        }, {
            field: 'businessType',
            title: '商机类型',
            formatter: function (value, row, index) {
                if (value === 1) return '移动业务';
                else if (value === 2) return '固网业务';
                else if (value === 3) return '融合业务';
                else if (value === 4) return '创新业务';
                else return '其他';
            }
        }, {
            field: 'keyPerson',
            title: '客户联系人'
        },{
            field: 'keyPersonContact',
            title: '客户联系人电话'
        },{
            field: 'introduction',
            title: '商机简介'
        }, {
            field: 'state',
            title: '商机状态',
            formatter: function (value, row, index) {
                if (value === 3) return '<span class="badge badge-success">已签约</span>';
                if (value === 2) return '<span class="badge badge-warning">待签约</span>';
                if (value === 1) return '<span class="badge badge-warning">待转化</span>';
            }
        },{
            field: 'signStaffName',
            title: '签约人'
        },{
            field: 'signDate',
            title: '签约时间'
        },{
            field: 'createDate',
            title: '录入时间'
        }]
    };

    $MB.initTable('businessOpportunityTable', settings);
});

$("#search").click(function () {
    $MB.refreshTable('businessOpportunityTable');
});

$("#refresh").click(function () {
    $(".businessOpportunity-table-form")[0].reset();
    $MB.refreshTable('businessOpportunityTable');
});

function deleteBusinessOpportunity() {
    var selected = $("#businessOpportunityTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].businessOpportunityId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'businessOpportunity/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

$("#exportExcel").click(function () {
    $.post(ctx + "businessOpportunity/excel", $(".businessOpportunity-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
});

$("#exportCsv").click(function () {
    $.post(ctx + "businessOpportunity/csv", $(".businessOpportunity-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
});