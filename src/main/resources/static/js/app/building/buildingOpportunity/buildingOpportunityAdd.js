var validator;
var $buildingOpportunityAddForm = $("#buildingOpportunity-add-form");
$(function () {

    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $buildingOpportunityAddForm.validate();
        $buildingOpportunityAddForm.find("input[name=regionId]").val($("#qx").val());
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "buildingOpportunity/add", $buildingOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "buildingOpportunity/update", $buildingOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#buildingOpportunity-add .btn-close").click(function () {
        closeModal();
    });

    function initDs() {
        var _ds = $("#ds");
        _ds.empty();
        $.post(ctx + "region/options", {
            gradeId: "2000004"
        }, function (r) {
            if (r.code === 0) {
                var data = r.msg;
                var html = [];
                html.push("<option value='' selected>---请选择---</option>");
                for (var i = 0; i < data.length; i++) {
                    var isSelectStr = "";
                    if (G_REGION_ID === data[i].regionId) {
                        isSelectStr = "selected=true";
                        $("#ds").attr("disabled", "disabled");
                    }
                    html.push("<option value='" + data[i].regionId + "' " + isSelectStr + ">" + data[i].regionName + "</option>");
                }
                _ds.append(html.join(''));

                _ds.change(function () {
                    initQx();
                });

                initQx();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function initQx() {
        var _ds = $("#ds");
        var _qx = $("#qx");
        _qx.empty();
        if (null !== _ds.val() && "" !== _ds.val()) {
            $.post(ctx + "region/options", {
                gradeId: "2000011",
                superRegionId: $("#ds").val()
            }, function (r) {
                if (r.code === 0) {
                    var data = r.msg;
                    var html = [];
                    html.push("<option value='' selected>---请选择---</option>");
                    for (var i = 0; i < data.length; i++) {
                        html.push("<option value='" + data[i].regionId + "'>" + data[i].regionName + "</option>");
                    }
                    _qx.append(html.join(''));
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    initDs();

});

function closeModal() {
    $("#save-button").attr("name", "save");
    $("#buildingOpportunity-add-modal-title").html('新增商机楼宇');
    $MB.closeAndRestModal("buildingOpportunity-add");
}




