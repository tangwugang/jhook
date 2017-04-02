<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>lingdu测试页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="HandheldFriendly" content="true" />
    <meta name="MobileOptimized" content="320" />
    <meta name="apple-touch-fullscreen" content="yes" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx}/resources/css/test.css?v=1.4.0" rel="stylesheet"/>
    <script src="${ctx}/resources/js/jquery.min.js"></script>
    <script src="${ctx}/resources/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<script>
    $(document).ready(function() {
        if ($(window).width() < 1083) {
            $(".brand-img").css('height', 40);
        } else {
            $(".brand-img").css('height', 52);
        }

        $(window).resize(function() {
            if ($(window).width() < 1083) {
                $(".brand-img").css('height', 40);
            } else {
                $(".brand-img").css('height', 52);
            }
        });

        $('.dropdown-toggle').dropdownHover({
            "instantlyCloseOthers": true
        });
    });
</script>


<style>
    .nav-pills > li > a {
        width: 68px;
        text-align: center;
    }

    .navbar-box {
        box-shadow: 0 3px 5px rgba(0, 0, 0, .25);
    }

    .nav-pills > li + li {
        margin-left: 0;
    }

    .navbar-default {
        background-color: white;
    }

    .brand-img {
        width: auto;
        height: 52px;
    }

    .navbar-brand {
        padding: 0 15px;
    }

    .navbar-collapse {
        border-top: none;
        box-shadow: none;
    }

    .nav > li > a {
        padding-left: 5px;
        padding-right: 5px;
    }
</style>

<div class="navbar navbar-default navbar-fixed-top navbar-box">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img class="brand-img" src="http://z-innoway.com/public/web/images/logo.png" alt="中关村创业大街" /></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav nav-pills pull-right">
                <li>
                    <a class="active" href="/" data-hover="dropdown">首页</a>
                </li>

                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=16" data-toggle="dropdown" data-hover="dropdown">街区介绍</a>
                    <ul class="dropdown-menu">
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=16">街区介绍</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2086">公司介绍</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2131">管理团队</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=75">大事记</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=220">广告标识</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=47">友情链接</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=17">联系我们</a></li>
                    </ul>
                </li>

                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=11" data-hover="dropdown" data-toggle="dropdown">街区新闻</a>
                    <ul class="dropdown-menu">
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=10">街区动态</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=12">媒体报道</a></li>
                    </ul>
                </li>

                <li>
                    <a  data-hover="dropdown" href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=2" data-hover="dropdown">入驻机构</a>
                </li>

                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=3" data-hover="dropdown" data-toggle="dropdown">政策指南</a>
                    <ul class="dropdown-menu">
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=21">创业者</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=22">创服机构</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=26">政策汇编</a></li>
                    </ul>
                </li>

                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Activity&a=index" data-hover="dropdown">街区活动</a>
                </li>


                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=36" data-hover="dropdown" data-toggle="dropdown">服务平台</a>
                    <ul class="dropdown-menu">
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=36">创业会客厅</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=37">联合党委</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=38">联合团委</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Article&a=lists&id=41">新的社会阶层人士联谊会</a></li>
                    </ul>
                </li>

                <li>
                    <a href="http://www.innoway.jobs/" target="_blank" data-hover="dropdown">街区招聘</a>
                </li>

                <li>
                    <a  href="http://z-innoway.com/index.php?app=web&m=Apply&a=index" data-hover="dropdown" data-toggle="dropdown">预约租赁</a>
                    <ul class="dropdown-menu">
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Apply&a=index">参观报名</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Apply&a=venue">场地预约</a></li>
                        <li><a href="http://z-innoway.com/index.php?app=web&m=Apply&a=ad">宣传资源预约</a></li>
                    </ul>
                </li>

                <li>
                    <a href="http://www.z-innoway.com/en/" data-hover="dropdown">English</a>
                </li>
            </ul>
        </div>
        <!--navbar-->
    </div>
    <!--container-->
</div>

<script type="text/javascript">
    var newspics = new Array();
    newspics.push({
        "title": "美国知名孵化器YC到创业大街探访中国创新市场",
        "title_": "美国知名孵化器YC到创业大街探访中国创新市场...",
        "content": "12月5日，美国知名创业孵化器Y Combinator（即YC）首席运营官Qasar Younis带队来到中关...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2529"
    });newspics.push({
        "title": "创业大街再次迎来国际团队",
        "title_": "创业大街再次迎来国际团队...",
        "content": "11月28日，韩国创业振兴院（KISED）带领四支创业团队来到中关村创业大街，寻求资源对接，加速项目落地发展。...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2528"
    });newspics.push({
        "title": "中关村创业大街首届手机摄影大赛报名啦！",
        "title_": "中关村创业大街首届手机摄影大赛报名啦！...",
        "content": "提到创业，你会想到什么？激情、梦想、冒险…还有压力、汗水、泪水…&nbsp;破解一个困扰已久的技术难题时的欣喜...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2509"
    });newspics.push({
        "title": "【中关村创新创业季2016】Demo The World全球创新路演精彩回顾",
        "title_": "【中关村创新创业季2016】Demo The Wor...",
        "content": "热火朝天的中关村创新创业季2016即将于21日完美收官，DEMO The World 作为本届创业季“环球赛事...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2474"
    });newspics.push({
        "title": "【中关村创新创业季2016】因果树图灵——全球首个人工智能投顾产品发布",
        "title_": "【中关村创新创业季2016】因果树图灵——全球首个人...",
        "content": "2016年10月18日，中关村创新创业季组委会、因果树联合举办 2016.因果树图灵产品发布会活动。作为中关村...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2473"
    });newspics.push({
        "title": "【中关村创新创业季2016】黑马公开课——当代中关村与百年硅谷发展论坛成功举办",
        "title_": "【中关村创新创业季2016】黑马公开课——当代中关村...",
        "content": " &nbsp; &nbsp; &nbsp; 2016年10月17日下午，中关村创新创业季2016暨黑马公开课—...",
        "href": "http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2472"
    });
    $(document).ready(function() {

        /*首页推荐新闻鼠标特效*/
        $('.indexnews div a img').hover(
                function() {
                    $('.indexnews div div h4').addClass('grey22bs');
                },
                function() {
                    $('.indexnews div div h4').removeClass('grey22bs');
                }
        );

        /*入住机构鼠标特效*/
        $('.indexjigou .col-md-4').hover(
                function() {
                    $(this).addClass('hover');
                },
                function() {
                    $(this).removeClass('hover');
                }
        );

        $('#carousel-example-generic').carousel({
            interval: 7000,
            pause: ""
        });

        $('#carousel-example-generic-news').carousel({
            interval: 7000,
            pause: ""
        });

        var timer = setInterval(handler, 5000);

        $('#carousel-example-generic-news').on('slid.bs.carousel', function() {
            var index = $('#carousel-example-generic-news .active').index('#carousel-example-generic-news .item');
            $(".right_list_title").fadeOut(100, function() {
                $("#news_title").html(newspics[index].title_);
                $("#news_content").html(newspics[index].content);
                $("#news_title").attr("title", newspics[index].title);
                $("#news_title").attr("href", newspics[index].href);
                $(".right_list_title").fadeIn(500);
            });
        });

        /* at(dot)lipeng(at)gmail(dot)com for 街区活动*/
        $("#activity").css('height', $("#activity").width() * 0.618);
        $("#right-top-cover").css('height', ($("#activity").width() * 0.618 - 10) / 2);
        $(".right-bottom-cover").css('height', ($("#activity").width() * 0.618 - 10) / 2);
        $(".adaptive-img").css('height', $("#owl_container").width()/2);

        $(window).resize(function() {
            $("#activity").css('height', $("#activity").width() * 0.618);
            $("#right-top-cover").css('height', ($("#activity").width() * 0.618 - 10) / 2);
            $(".right-bottom-cover").css('height', ($("#activity").width() * 0.618 - 10) / 2);
            $(".adaptive-img").css('height', $("#owl_container").width()/2);
        });

        $(".out-box").hover(function() {
            $(this).children('.in-pic').stop().animate({
                'left': '-100%'
            }, 500);
        }, function() {
            $(this).children('.in-pic').stop().animate({
                'left': '0'
            }, 500);
        });

    });

    var handler = function() {
        $("#temp").prepend($("#demo .item .col-md-4:last-child").clone());
        $("#demo .item .col-md-4:last-child").remove();
        $("#temp").prepend($("#demo .item .col-md-4:last-child").clone());
        $("#demo .item .col-md-4:last-child").remove();
        $("#temp").prepend($("#demo .item .col-md-4:last-child").clone());
        $("#demo .item .col-md-4:last-child").remove();
        $("#temp").slideDown(600, function() {
            $("#demo .item").prepend($("#temp").html());
            $("#temp").html('').hide();
        });
    }

    var clear = function(timer) {
        clearInterval(timer);
    }

</script>


<style>
    .news_pic img {
        padding: 1px;
        width: 100%;
        height: 100%;
    }

    .news_pic {
        width: 100%;
        height: 100%;
        overflow: hidden;
    }

    .indexnews div a img:hover {}

    .right_list {
        width: 100%;
        overflow: hidden;
    }

    .right_list_title {
        width: 100%;
        overflow: hidden;
    }

    .text-overflow {
        display: block;
        word-break: keep-all;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .adaptive-img {
        width: 100%;
        height: auto;
    }

    .list_all {
        width: 100%;
    }

    .indexjigou .col-md-4.hover a {
        color: #cc0000;
    }

    .indexjigou .col-md-4.hover img {
        border: 4px solid #cc0000;
    }

    .out-box {
        position: relative;
        width: 100%;
        height: 100%;
        overflow: hidden;
    }

    .in-pic {
        position: absolute;
        width: 100%;
        height: auto;
        z-index: 2;
    }

    .bk-pic {
        position: relative;
        width: 100%;
        height: auto;
        visibility: hidden;
    }

    .active-info {
        position: absolute;
        width: 100%;
        height: 100%;
        padding: 0;
        background: #333333;
    }

    .tab-cell a {
        text-decoration: none;
    }

    .tab {
        display: table;
        width: 100%;
        height: 100%;
        table-layout: fixed;
    }

    .tab-cell {
        display: table-cell;
        vertical-align: middle;
        text-align: center;
        padding: 5px;
    }

    .activity-cover {
        width: 100%;
        height: 100%;
    }

    .justify {
        text-align: justify;
        text-justify: auto;
        text-justify: distribute;
        text-justify: inter-cluster;
        text-justify: inter-word;
        text-justify: inter-ideograph;
    }

    .info-text {
        width: 100%;
        color: white;
    }

    .indexhuodong {
        margin: 0;
    }

    .col-m {
        padding: 0;
    }

    .bigbox {
        width: 100%;
    }

    #right-top-cover {
        margin-bottom: 10px;
    }
</style>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <a href="http://www.z-innoway.com/jiejing"><img src="http://z-innoway.com/public/web/images/banner_n_07s.jpg" alt="..."></a>
        </div>
        <div class="item">
            <a href="http://www.innohall.cn/"><img src="http://z-innoway.com/public/web/images/banner_10.jpg" alt="..."></a>
        </div>
        <div class="item">
            <img src="http://z-innoway.com/public/web/images/banner_n_07.jpg" alt="...">
        </div>
        <div class="item">
            <img src="http://z-innoway.com/public/web/images/banner_12.jpg" alt="...">
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container justify">
    <h2>街区新闻</h2>
    <div class="row indexnews">

        <div id="owl_container" class="col-xs-12 col-sm-6 col-md-7 col-lg-7">
            <div id="carousel-example-generic-news" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <a target='_blank' title="美国知名孵化器YC到创业大街探访中国创新市场" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2529">
                            <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1207/08/58475adf893cf.png) center / cover no-repeat"></div>
                        </a>
                    </div>
                    <div class="item ">
                    <a target='_blank' title="创业大街再次迎来国际团队" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2528">
                        <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1206/15/584664961a1e0.png) center / cover no-repeat"></div>
                    </a>
                    </div>
                    <div class="item ">
                    <a target='_blank' title="中关村创业大街首届手机摄影大赛报名啦！" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2509">
                        <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1125/16/5837ef895a2d3.png) center / cover no-repeat"></div>
                    </a>
                    </div>
                    <div class="item ">
                    <a target='_blank' title="【中关村创新创业季2016】Demo The World全球创新路演精彩回顾" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2474">
                        <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1020/15/580875dc4606e.jpg) center / cover no-repeat"></div>
                    </a>
                    </div>
                    <div class="item ">
                    <a target='_blank' title="【中关村创新创业季2016】因果树图灵——全球首个人工智能投顾产品发布" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2473">
                        <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1020/09/58081ccb41f34.jpg) center / cover no-repeat"></div>
                    </a>
                    </div>
                    <div class="item ">
                    <a target='_blank' title="【中关村创新创业季2016】黑马公开课——当代中关村与百年硅谷发展论坛成功举办" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2472">
                        <div class="adaptive-img" style="background: url(http://z-innoway.com/data/uploads/2016/1020/09/58081c7f38e18.jpg) center / cover no-repeat"></div>
                    </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-5 col-lg-5">
            <div class="right_list_title">
                <h4 class="media-heading grey22b"><a id="news_title" title="美国知名孵化器YC到创业大街探访中国创新市场" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2529">美国知名孵化器YC到创业大街探访中国创新市场...</a></h4>
                <span id="news_content" class="grey14">12月5日，美国知名创业孵化器Y Combinator（即YC）首席运营官Qasar Younis带队来到中关...</span>
            </div>
            <div class="right_list m15px">
                <div class="list_all">
                    <li><a class="text-overflow" target='_blank' title="创业大街再次迎来国际团队" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2528">创业大街再次迎来国际团队</a></li><li><a class="text-overflow" target='_blank' title="中关村创业大街首届手机摄影大赛报名啦！" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2509">中关村创业大街首届手机摄影大赛报名啦！</a></li><li><a class="text-overflow" target='_blank' title="【中关村创新创业季2016】Demo The World全球创新路演精彩回顾" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2474">【中关村创新创业季2016】Demo The World全球创新路演精彩回顾</a></li><li><a class="text-overflow" target='_blank' title="【中关村创新创业季2016】因果树图灵——全球首个人工智能投顾产品发布" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2473">【中关村创新创业季2016】因果树图灵——全球首个人工智能投顾产品发布</a></li><li><a class="text-overflow" target='_blank' title="【中关村创新创业季2016】黑马公开课——当代中关村与百年硅谷发展论坛成功举办" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2472">【中关村创新创业季2016】黑马公开课——当代中关村与百年硅谷发展论坛成功举办</a></li><li><a class="text-overflow" target='_blank' title="【中关村创新创业季2016】央地协同创新创业论坛成功召开，再掀双创热潮！" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2471">【中关村创新创业季2016】央地协同创新创业论坛成功召开，再掀双创热潮！</a></li>                </div>
            </div>
        </div>

    </div>
</div>

<div class="container">
    <h2>入驻机构</h2>
    <div class="row indexjigou">
        <div id="indexJigou" data-ride="carousel">
            <div class="carousel-inner" id="demo" style="overflow:hidden;height:387px;">
                <div id="temp" style="display:none;width:100%;height:129px;"></div>
                <div class="item active">
                    <div class="col-md-4 m15px">
                        <div class="media">
                            <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0526/14/5382d949c32e6.gif" alt=""> </a>
                            <div class="media-body justify">
                                <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1">车库咖啡</a></h4>
                                <span class="grey12">成立于2011年4月，是中关村创业大街上最早的一批创业主题咖啡厅之一</span>
                            </div>
                        </div>
                    </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0526/14/5382d939c6df0.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2">3W咖啡</a></h4>
                            <span class="grey12">互联网主题馆，旗下包含3W咖啡馆、3W创新传媒、3W孵化器、3W基金、拉勾招聘</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=6"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0526/14/5382d8f746dae.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=6">Binggo咖啡</a></h4>
                            <span class="grey12">一家以咖啡和空间为载体，利用群智，跨界创新的创新型孵化器</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=7"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0526/14/5382d8e974cd9.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=7">36氪</a></h4>
                            <span class="grey12">国内极具影响力的创服平台。旗下拥有科技新媒体36氪、氪空间、36氪+ </span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=8"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2016/0617/16/5763b380549c3.jpg" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=8">创业黑马</a></h4>
                            <span class="grey12">国内领先的综合性创业服务平台。通过线上线下相结合的模式，向创业群体提供综合性创业服务。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=5"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0526/14/5382d90890208.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=5">飞马旅</a></h4>
                            <span class="grey12">中国首家服务业创业项目管理支持机构。关注四大领域：TMT；O2M；O2O；B2B</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=4"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0529/09/53868c2ee4454.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=4">联想之星</a></h4>
                            <span class="grey12">成立于2008年，是联想控股旗下的综合性专业投资孵化机构</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=95"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0606/15/53916abaacf73.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=95">言几又</a></h4>
                            <span class="grey12">以书店为背景、咖啡为渗透、主题活动为拉动，提供新生活方式用品的创新文化生活一体店</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=3"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/0626/09/53ab76be33b4d.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=3">天使汇</a></h4>
                            <span class="grey12">2011年11月11日正式上线运营。是个聚集创业者和投资人的投融资平台</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=672"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/1104/10/545839e6a4ba8.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=672">北京大学创业训练营</a></h4>
                            <span class="grey12">北京大学为更好的服务国家创新创业发展战略，由北京大学校友会牵头联合相关单位团体共同</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=673"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/1104/10/54583a40562ab.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=673">拉勾网</a></h4>
                            <span class="grey12">拉勾网，是一家专为工作3到10年的资深互联网从业者，提供成长方案的互联网垂直招聘网站。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=674"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2014/1127/18/5476f929554d7.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=674">亚杰汇</a></h4>
                            <span class="grey12">亚杰汇创始人俱乐部是由亚杰商会(AAMA)摇篮计划导师和创业家学员众筹发起创建的一家</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=678"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0629/14/5590e2f573467.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=678">IC咖啡</a></h4>
                            <span class="grey12">IC咖啡，一种新型的高科技产业“链”俱乐部。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=885"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0115/08/54b70fdccb3ae.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=885">创投圈</a></h4>
                            <span class="grey12">创投圈www.vc.cn成立于2011年5月</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=946"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0714/09/55a463120cdd1.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=946">清华经管创业者加速器</a></h4>
                            <span class="grey12">清华经管创业者加速器是一个体现清华精神，为全球优秀创业者和团队成长服务的创业加速平台。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1024"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0629/14/5590e3368a711.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1024">66号成长屋</a></h4>
                            <span class="grey12">66号成长屋位于中关村创业大街68号</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1103"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2016/0603/16/57513c7e9c126.png" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1103">InnoTREE因果树</a></h4>
                            <span class="grey12">InnoTREE –股权众筹生态圈打造者。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1331"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0629/13/5590d8a2ec94f.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1331">硬创邦</a></h4>
                            <span class="grey12">硬创邦是国内领先的硬件和创客教育平台，由雷锋网和好未来联合创办</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1335"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0629/14/5590e20a39f1b.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1335">金榕树</a></h4>
                            <span class="grey12">何为金榕树计划?金榕树计划的全称是“金榕树自媒体连接创业计划”</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1336"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0629/14/5590e27d9994b.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1336">聚创</a></h4>
                            <span class="grey12">聚创为创业者免费提供咖啡、办公、孵化、融资对接等一站式服务</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1412"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0714/12/55a49695b7894.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1412">虫洞创业之家</a></h4>
                            <span class="grey12">爱因斯坦告诉我们，“虫洞”是连接宇宙遥远区</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1448"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0721/10/55adb1f0922cf.jpg" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1448">创业邦</a></h4>
                            <span class="grey12">最懂创业者，离资本最近</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1449"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0724/09/55b18f271faf0.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1449">拓荒族</a></h4>
                            <span class="grey12">集办公、营销、孵化功能三位一体的企业发展生态圈</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1482"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2015/0731/15/55bb29cd76b19.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1482">洋葱投</a></h4>
                            <span class="grey12">洋葱投致力于为创业者打造一个全方位、宽领域、多元化的创投服务平台。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1857"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2016/0106/16/568cd5343f525.gif" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1857">可可豆创新孵化平台</a></h4>
                            <span class="grey12">可可豆创新孵化平台隶属于洛可可创新设计集团</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1929"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2016/0204/09/56b2ab8db9bea.jpg" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=1929">中科金</a></h4>
                            <span class="grey12">为科技企业提供多元化、多层次、全方位的金融服务。</span>
                        </div>
                    </div>
                </div><div class="col-md-4 m15px">
                    <div class="media">
                        <a class="pull-left" target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2029"> <img class="img-circle" src="http://z-innoway.com/data/uploads/2016/0324/11/56f35bf25b14c.jpg" alt=""> </a>
                        <div class="media-body justify">
                            <h4 class="media-heading grey18 m15px"><a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=2029">硬派空间</a></h4>
                            <span class="grey12">硬派空间位于中关村创业大街，由创业大街运营管理公司海置科创创办</span>
                        </div>
                    </div>
                </div>                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h2>街区活动</h2>
    <div class="row" style="margin-right: -5px; margin-left: -5px">

        <div id="activity" class="col-sm-6" style="padding-left: 5px; padding-right: 5px; margin-bottom: 10px">
            <div class="out-box">
                <div class="activity-cover in-pic" style="background: url(http://z-innoway.com/data/uploads/2016/1125/16/5837f05ed9ad7.png) center / cover no-repeat"></div>
                <div class="active-info">
                    <div class="tab">
                        <div class="tab-cell">
                            <a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Activity&a=detail&id=2510">
                                <h2 class="info-text text-overflow">中关村创业大街首届手机摄影大赛报名啦！</h2>
                                <h5 class="text-overflow">活动时间：2016-11-21</h5>
                                <h5 class="text-overflow"> 活动地点：中关村创业大街</h5>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="activity_right" class="col-sm-6" style="padding-left: 5px; padding-right: 5px">
                <div id="right-top-cover" class="out-box">
                    <div class="activity-cover in-pic" style="background: url(http://z-innoway.com/data/uploads/2016/0707/11/577dca0fe051d.png) center / cover no-repeat"></div>
                    <div class="active-info">
                        <div class="tab">
                            <div class="tab-cell">
                                <a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Activity&a=detail&id=2283">
                                    <h4 class="info-text text-overflow">招募 | 注册、孵化、资讯——创业会客厅线上平台需要在创新创业道路上前行的你！</h4>
                                    <h6 class="text-overflow"> 活动时间：2016-07-07</h6>
                                    <h6 class="text-overflow"> 活动地点：中关村创业大街</h6>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6" style="padding-right: 5px">
                        <div class="out-box right-bottom-cover">
                            <div class="activity-cover in-pic" style="background: url(http://z-innoway.com/data/uploads/2016/1125/16/5837f227648e1.png) center / cover no-repeat"></div>

                            <div class="active-info">
                                <div class="tab">
                                    <div class="tab-cell">
                                        <a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Activity&a=detail&id=2511">
                                            <h4 class="info-text text-overflow">“午间时光”，打开艺术之门</h4>
                                            <h6 class="text-overflow"> 时间：2016-11-28</h6>
                                            <h6 class="text-overflow"> 地点：中关村创业大街</h6>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-6" style="padding-left: 5px">
                        <div class="out-box right-bottom-cover">
                            <div class="activity-cover in-pic" style="background: url(http://z-innoway.com/data/uploads/2016/1125/16/5837f43e691b5.png) center / cover no-repeat"></div>

                            <div class="active-info">
                                <div class="tab">
                                    <div class="tab-cell">
                                        <a target='_blank' href="http://z-innoway.com/index.php?app=web&m=Activity&a=detail&id=2512">
                                            <h4 class="info-text text-overflow">【创业整理控】那些全球顶尖的孵化机构</h4>
                                            <h6 class="text-overflow"> 时间：2016-11-24<h6>
                                                <h6 class="text-overflow"> 地点：中关村创业大街<h6>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--row-->
        </div>


        <!--activity-right-->
    </div>
    <!--row-->
</div>
<!--container-->

<div class="footers">

    <div class="container">

        <div class="row">

            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">

                <a href="/"><img alt="首页" src="http://z-innoway.com/public/web/images/end_logo.gif" /></a>

            </div>

            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2"> <span class="white18">关于我们</span>

                <br/>

                <span class="grey12s">

					<a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=16">街区介绍</a><br/>

                    <a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=75">大事记</a><br/>

                    <a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=48">机构引进</a><br/>

                    <a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=47">友情链接</a><br/>

                    <a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=17">联系我们</a>

				</span>

            </div>



            <div class="hidden-xs col-sm-4 col-md-3 col-lg-2"> <span class="white18">合作伙伴</span>

                <br/>

                <span class="grey12s">

					<a target="_blank" href="http://www.intel.com" >英特尔</a><br/>

                    <a target="_blank" href="http://http://www.pwccn.com/">普华永道</a><br/>

                    韩国创业振兴院<br/>

                    京畿道创造经济革新中心<br/>

                    <a target="_blank" href="https://www.born2global.com/">Born2Global</a>

				</span>

            </div>



            <div class="hidden-xs col-sm-4 col-md-3 col-lg-2"> <span class="white18"> <a target="_blank" href="http://z-innoway.com/index.php?app=web&m=Article&a=detail&id=47">友情链接</a></span>

                <br/>

                <span class="grey12s">

                    <a target="_blank" href="http://www.haidianzhiye.com/">海淀置业</a><br/><a target="_blank" href="http://www.tiholding.cn/">清控科创</a><br/><a target="_blank" href="http://www.bjhd.gov.cn/">海淀区政府</a><br/><a target="_blank" href="http://www.zhongguancun.com.cn/">中关村海淀园</a><br/><a target="_blank" href="http://zgcxq.bjhd.gov.cn/">中关村西区办</a><br/><a target="_blank" href="http://www.zgc.gov.cn/">中关村管委会</a><br/>
                </span>

            </div>


            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2"> <span class="white18">联系我们</span>

                <br/>

                <span class="grey12s">

                    电话：010-62563080<br/>

                    工商注册：62563050-801<br/>

					空间租赁：62563080-803<br/>

                    地址：海淀区西大街29号<br/>

                    邮编：100080<br/>

                    <a href='http://weibo.com/innoway' target="_blank"><img alt="" src="http://z-innoway.com/public/web/images/weibo.gif" /></a>

                </span>

            </div>

            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2"><img alt="" src="http://z-innoway.com/public/web/images/weixinma.gif" /></div>

        </div>

    </div>

</div>

<div class="footer white12">版权所有：北京海置科创科技服务有限公司 京ICP备14017783号-1 京公网安备11010802017670</div>
<!--底over-->
<script src="${ctx}/resources/js/dropdown_hover.js"></script>
<script src="${ctx}/resources/js/top.js"></script>
</body>
</html>