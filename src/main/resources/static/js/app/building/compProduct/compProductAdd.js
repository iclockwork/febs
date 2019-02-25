var validator;
var $businessOpportunityAddForm = $("#businessOpportunity-add-form");
$(function () {
    showSignStaff();

    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $businessOpportunityAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "businessOpportunity/add", $businessOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("businessOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "businessOpportunity/update", $businessOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("businessOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#businessOpportunity-add .btn-close").click(function () {
        closeModal();
    });

});

function closeModal() {
    $("#save-button").attr("name", "save");
    $("#businessOpportunity-add-modal-title").html('新增商机');
    $MB.closeAndRestModal("businessOpportunity-add");
}

function initDate() {
    $("input[name='signDate']").daterangepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
}

function showSignStaff() {
    $("select[name='state']").change(function() {
        if (this.value === '3') {
            $('#signStaff').show();
            $('#signStaff2').show();
        } else {
            $('#signStaff').hide();
            $('#signStaff2').hide();
        }
    });
}



