<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>jhook</title>
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
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>代码生成表单</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="signupForm">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">生成后存放路径：</label>
                            <div class="col-sm-8">
                                <input name="pathName" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">包名：</label>
                            <div class="col-sm-8">
                                <input name="packageName" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">模块名：</label>
                            <div class="col-sm-8">
                                <input name="modelName" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                                <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>sys、order等</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">表名：</label>
                            <div class="col-sm-8">
                                <input name="tableName" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文件类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control m-b" name="typeName">
                                    <option value="0">entity</option>
                                    <option value="1">controller</option>
                                    <option value="2">service</option>
                                    <option value="3">dao</option>
                                    <option value="4">xml</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--container-->
</div>
</body>
</html>