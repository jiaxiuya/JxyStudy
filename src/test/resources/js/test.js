bindClick();
$(".sk-bm-btn").unbind("click");
var ts = new Date(2016, 10, 24, 20, 0, 0) - new Date();
console.info("倒计时：" + ts / 1000 + "秒,请不要关闭浏览器！");
// 倒计时整点触发点击事件
window.setTimeout('$(".sk-bm-btn").trigger("MyClick")', ts);
// 每隔一秒钟执行一次
window.setInterval('check()', 500);
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
        if ($this.attr('class') == 'mtop30 sk-bm-btn sk-bm-btn02') {
            $this.attr('class', 'mtop30 sk-bm-btn sk-bm-btn02g');
        } else if ($this.attr('class') == 'sk-bm-btn t_but_bmmini t_ml10') {
            $this.attr('class', 'sk-bm-btn t_but_bmminig t_ml10');
        }
        $this.find("a").html("处理中...");
        $.ajax({
            type: 'post',
            url: '/registers/regist',
            data: 'claId=' + claId + "&timer=" + new Date().getTime(),
            dataType: 'json',
            success: function (res) {
                if (res.msg == '10000' && !res.queue) {
                    $("#footer-setClass").show();
                    var unpayB = parseInt($("#unpayB").get(0).innerHTML) + 1;
                    var claNum = parseInt($this.parents('.s-r-list-bm').children('.mtop20').children('.fixpng').html());
                    if (!isNaN(claNum)) {
                        $this.parents('.s-r-list-bm').children('.mtop20').children('.fixpng').html(claNum - 1);
                    }
                    $("#unpayB").html(unpayB);
                    var $pp = $this.parents(".func-srlistbm").find("p:first span");
                    var left = $pp.offset().left;
                    var top = $pp.offset().top;
                    var $target = $("#footer-setClass b.whiteBg01");
                    var tLeft = $target.offset().left;
                    var tTop = $target.offset().top;
                    var $ppClone = $pp.clone().removeClass("mtop20");
                    if ($this.attr('btnEnabled') == 'false') {
                        return false;
                    }
                    $(document.body).append($ppClone);
                    $ppClone.css({'position': 'absolute', 'left': (left) + 'px', 'top': top + 'px', 'z-index': '1000'});
                    $ppClone.animate({
                        opacity: 0.9,
                        left: tLeft - 18 + 'px',
                        top: tTop - 50 + 'px'
                    }, 2000, 'swing', function () {
                        $(this).fadeOut().remove();
                    });
                    $this.attr('btnEnabled', 'false');
                    $this.find("a").html("已报名");
                    $("#allPriceSpan").html(parseInt($("#allPriceSpan").html()) + parseInt(res.classInfo.cla_price));
                    newhtml = '<tr class=""><td class="textL"><a href="/classes/view/' + res.classInfo.cla_id + '" target="_blank">' + res.classInfo.cla_name + '</a></td> ';
                    newhtml += '<td class="textL">' + res.classInfo.cla_start_date + ' - ' + res.classInfo.cla_end_date + ' ' + res.classInfo.cla_classtime_names + '</td><td>' + res.classInfo.cla_classroom_name + ' </td><td>' + res.classInfo.cla_teacher_names + '</td><td>￥' + res.classInfo.cla_price + '</td> ';
                    newhtml += '<td><input type="button" onclick="cancelRegist(\'' + res.classInfo.cla_id + '\')" class="sk-btn-gray01" value="删除" id="button" name="button"></td></tr>';
                    $("#unPayTbody").append(newhtml);
                    globalClaId = '';
                } else {
                    if (res.msg == '请您先登录') {
                        $("#loginALink").click();
                        return false;
                    }
                    if (res.queue) {
                        $.each(res.msg.msg, function (idx, item) {
                            interSign = setInterval("getRegistQueueRes('" + item + "','" + claId + "')", 2000);
                        });
                        return false;
                    } else {
                        var showDiv = $this.parent().next();
                        if (res.count < 8) {
                            $this.tip({tipClass: "bm-tip03 fixpng", text: res.msg, delay: 1000});
                        } else if (res.count > 12) {
                            $this.tip({tipClass: "bm-tip01 fixpng", text: res.msg, delay: 1000});
                        } else {
                            $this.tip({tipClass: "bm-tip02 fixpng", text: res.msg, delay: 1000});
                        }
                        $this.find("a").html("报名失败");
                        globalClaId = '';
                    }
                }
            }
        });
    });
}