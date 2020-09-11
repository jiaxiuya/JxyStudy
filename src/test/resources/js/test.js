bindClick();
$(".sk-bm-btn").unbind("click");
var ts = new Date(2016, 10, 24, 20, 0, 0) - new Date();
console.info("倒计时：" + ts / 1000 + "秒,请不要关闭浏览器！");
// 倒计时整点触发点击事件
window.setTimeout('$(".sk-bm-btn").trigger("MyClick")', ts);
// 每隔一秒钟执行一次
window.setInterval('check()', 100);
function check() {
    console.info($(".sk-bm-btn a").html());
    $(".sk-bm-btn").trigger("MyClick");
}

function bindClick() {
    $(".sk-bm-btn").bind("MyClick", function (e) {
        var $this = $(this);
        var claId = $this.attr('alt');
        if (claId != globalClaId && globalClaId != '') {
            return false;
        }
        globalClaId = claId;
        $this.find("a").html("处理中...");
        $.ajax({
            type: 'post',
            url: '/registers/regist',
            data: 'claId=' + claId + "&timer=" + new Date().getTime(),
            dataType: 'json',
            success: function (res) {
                if (res.msg == '10000' && !res.queue) {
                    $this.find("a").html("已报名");
                } else {
                    if (res.msg == '请您先登录') {
                        $("#loginALink").click();
                        return false;
                    }
                    if (res.queue) {
                        // $.each(res.msg.msg, function (idx, item) {
                            // interSign = setTimeout("getRegistQueueRes('" + item + "','" + claId + "')", 1000);
                        // });
                        return false;
                    } else {
                        console.info(res.msg);
                        $this.find("a").html("报名失败");
                    }
                }
            }
        });
    });
}

function getRegistQueueRes(sign, objId) {
    var $this = $("span[alt='" + objId + "']");
    $.ajax({
        type: 'post',
        url: '/Registers/getRegistQueueRes',
        data: 'sign=' + sign + "&timer=" + new Date().getTime() + "&objId=" + objId,
        dataType: 'json',
        async: false,
        success: function (res) {
            if (res.code == '5') {
                $this.find("a").html("已报名");
            } else {
                console.info(res.msg);
                if (res.code != 3 && res.code != 1) {
                    $this.find("a").html("报名失败");
                    globalClaId = '';
                }
            }
        },
        error: function () {
            var showDiv = $this.parent().next();
            $this.tip({tipClass: "bm-tip03 fixpng", text: "服务器错误！！", delay: 1000});
            globalClaId = '';
        }
    });
    return false;
}