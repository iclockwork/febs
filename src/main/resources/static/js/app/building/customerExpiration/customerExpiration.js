$(function () {
    var $customerExpirationTableForm = $(".customerExpiration-table-form");
    var settings = {
        url: ctx + "customerExpiration/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingNo: $customerExpirationTableForm.find("input[name='buildingNo']").val().trim(),
                buildingName: $customerExpirationTableForm.find("input[name='buildingName']").val().trim(),
                customerName: $customerExpirationTableForm.find("input[name='customerName']").val().trim(),
                remindDate: $customerExpirationTableForm.find("input[name='remindDate']").val()
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
            field: 'remindFlag',
            title: '是否需要提醒',
            formatter: function (value, row, index) {
                if (value === 1) return '是';
                else return '否';
            }
        },{
            field: 'remindDate',
            title: '提醒时间'
        }]
    };

    $MB.initTable('customerExpirationTable', settings);

    $("#search").click(function () {
        $MB.refreshTable('customerExpirationTable');
    });

    $("#refresh").click(function () {
        $(".businessOpportunity-table-form")[0].reset();
        $MB.refreshTable('customerExpirationTable');
    });

// function deleteBusinessOpportunity() {
//     var selected = $("#customerExpirationTable").bootstrapTable('getSelections');
//     var selected_length = selected.length;
//     var contain = false;
//     if (!selected_length) {
//         $MB.n_warning('请勾选需要删除的用户！');
//         return;
//     }
//     var ids = "";
//     for (var i = 0; i < selected_length; i++) {
//         ids += selected[i].userId;
//         if (i !== (selected_length - 1)) ids += ",";
//         if (userName === selected[i].username) contain = true;
//     }
//     if (contain) {
//         $MB.n_warning('勾选用户中包含当前登录用户，无法删除！');
//         return;
//     }
//
//     $MB.confirm({
//         text: "确定删除选中用户？",
//         confirmButtonText: "确定删除"
//     }, function () {
//         $.post(ctx + 'user/delete', {"ids": ids}, function (r) {
//             if (r.code === 0) {
//                 $MB.n_success(r.msg);
//                 refresh();
//             } else {
//                 $MB.n_danger(r.msg);
//             }
//         });
//     });
// }

    $("#exportExcel").click(function () {
        $.post(ctx + "customerExpiration/excel", $(".customerExpiration-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    $("#exportCsv").click(function () {
        $.post(ctx + "customerExpiration/csv", $(".customerExpiration-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });
});

