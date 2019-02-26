var validator;
var $businessOpportunityAddForm = $("#businessOpportunity-add-form");
$(function () {
    initDate();
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
    $('#signStaff').hide();
    $('#signStaff2').hide();
    $MB.closeAndRestModal("businessOpportunity-add");
}

function initDate() {
    $("input[name='signDate']").datetimepicker({
        format:'yyyy-mm-dd hh:mi:ss',  //格式  如果只有yyyy-mm-dd那就是0000-00-00
        autoclose:true,//选择后是否自动关闭
        minView:0,//最精准的时间选择为日期  0-分 1-时 2-日 3-月
        language:  'zh-CN', //中文
        weekStart: 1, //一周从星期几开始
        startView: 2,
        forceParse: 0,
        // daysOfWeekDisabled:"1,2,3", //一周的周几不能选 格式为"1,2,3"  数组格式也行
        todayBtn : true,  //在底部是否显示今天
        todayHighlight :false, //今天是否高亮显示
        // keyboardNavigation:true, //方向图标改变日期  必须要有img文件夹 里面存放图标
        showMeridian:false,  //是否出现 上下午
        initialDate:new Date()
        //startDate: "2017-01-01" //日期开始时间 也可以是new Date()只能选择以后的时间
    });
}
function showSignStaff() {
    $("select[name='state']").unbind("change").change(function() {
        if (this.value === '3') {
            $('#signStaff').show();
            $('#signStaff2').show();
        } else {
            $('#signStaff').hide();
            $('#signStaff2').hide();
        }
    });
}



