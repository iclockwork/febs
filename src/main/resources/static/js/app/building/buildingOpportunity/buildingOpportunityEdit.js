var buildingOpportunity;
var $form = $('#buildingOpportunity-add');
$(function () {
    $("#update").click(function () {
        var selected = $("#buildingOpportunityTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的商机楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个商机楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        $.post(ctx + "buildingOpportunity/getBuildingOpportunity", {"buildingId": buildingId}, function (r) {
            if (r.code === 0) {
                $form.modal();
                buildingOpportunity = r.msg;
                $("#buildingOpportunity-add-modal-title").html('修改商机楼宇');
                $form.find("input[name='buildingId']").val(buildingOpportunity.buildingId);
                $form.find("select[name='ds']").val(buildingOpportunity.dsRegionId);
                $form.find("select[name='ds']").trigger("change");
                $form.find("select[name='buildingLevel']").val(buildingOpportunity.buildingLevel);
                $form.find("select[name='buildingType']").val(buildingOpportunity.buildingType);
                $form.find("input[name='buildingTypeName']").val(buildingOpportunity.buildingTypeName);
                $form.find("input[name='buildingAddress']").val(buildingOpportunity.buildingAddress);
                $form.find("input[name='buildingName']").val(buildingOpportunity.buildingName);
                $form.find("input[name='floorNumber']").val(buildingOpportunity.floorNumber);
                $form.find("input[name='area']").val(buildingOpportunity.area);
                $form.find("input[name='householderNumber']").val(buildingOpportunity.householderNumber);
                $form.find("input[name='propertyCompany']").val(buildingOpportunity.propertyCompany);
                $form.find("input[name='propertyManager']").val(buildingOpportunity.propertyManager);
                $form.find("input[name='propertyManagerContact']").val(buildingOpportunity.propertyManagerContact);
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
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
                    if (buildingOpportunity) {
                        $form.find("select[name='qx']").val(buildingOpportunity.regionId);
                        $form.find("select[name='qx']").trigger("change");
                    }
                    console.log("qx:"+_qx.val())
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    initDs();
});
