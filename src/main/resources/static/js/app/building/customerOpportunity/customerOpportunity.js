$(function () {
    var $customerOpportunityTableForm = $(".customerOpportunity-table-form");
    var settings = {
        url: ctx + "customerOpportunity/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingName: $customerOpportunityTableForm.find("input[name='buildingName']").val().trim(),
                customerName: $customerOpportunityTableForm.find("input[name='customerName']").val().trim()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'customerId',
            visible: false
        },{
            field: 'buildingId',
            visible: false
        }, {
            field: 'buildingName',
            title: '楼宇名称'
        }, {
            field: 'customerName',
            title: '客户名称'
        }, {
            field: 'floorNumber',
            title: '楼层'
        },{
            field: 'roomNumber',
            title: '房间号'
        }, {
            field: 'customerType',
            title: '客户类型'
        }, {
            field: 'customerIndustry',
            title: '客户行业'
        },{
            field: 'competitorName',
            title: '竞争对手名称'
        }, {
            field: 'competitorType',
            title: '竞争对手业务类型'
        }, {
            field: 'competitorEnd',
            title: '竞争对手合同到期情况'
        }, {
            field: 'keyPerson',
            title: '客户联系人'
        }, {
            field: 'keyPersonContact',
            title: '客户联系人电话'
        },{
            field: 'createDate',
            title: '创建时间'
        }]
    };

    $MB.initTable('customerOpportunityTable', settings);

    $("#search").click(function () {
        $MB.refreshTable('customerOpportunityTable');
    });

    $("#refresh").click(function () {
        refresh();
    });


$("#delete").click(function () {

    var selected = $("#customerOpportunityTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的商机客户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].customerId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中商机客户？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'customerOpportunity/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
});

    $("#exportExcel").click(function () {
        $.post(ctx + "customerOpportunity/excel", $(".customerOpportunity-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    $("#exportCsv").click(function () {
        $.post(ctx + "customerOpportunity/csv", $(".customerOpportunity-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    function refresh() {
        $(".customerOpportunity-table-form")[0].reset();
        $MB.refreshTable('customerOpportunityTable');
    }
});

