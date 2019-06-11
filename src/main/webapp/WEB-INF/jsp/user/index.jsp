<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../js/gritter/css/jquery.gritter.css"/>
    <script type="text/javascript" src="../../../js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="../../../js/common.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../css/right-navbar.css"/>
    <style type="text/css">
        body,
        a {
            background-color: #ccc;
            color: white !important;
        }

        #container {
            height: 1500px;
            width: 100%;
            padding: 0;
            width: calc(100% - 50px);
            margin: 0px;
        }

        .site-head {
            background: url(../../../imgs/banner1.jpg);
            opacity: 0.95;
            min-height: 800px;
            box-shadow: 0 7px 5px -5px #333;
        }

        #site-nav-container {
            margin: 0 auto;
        }

        #site-logo {
            margin: 0 20px;
        }

        #site-logo-container {
            width: 64px;
            height: 64px;
            background: no-repeat url(../../../imgs/logo.png);
        }

        #site-name-container {
            font-size: 15px;
            font-weight: bold;
            color: white;
            font-family: "微软雅黑";
        }

        #location-container {
            line-height: 80px;
        }

        #location {
            border: 1px solid #fff;
            height: 40px;
            border-radius: 25px;
            width: 80px;
            color: white;
            line-height: 25px;
            background-color: transparent;
        }

        #index-nav {
            position: relative;
            top: 20px;
            font-weight: bold;
            font-size: 20px;
        }

        #index-nav > li {
            margin-right: 20px;
        }

        .nav > li > a:hover,
        .nav > li > a:focus {
            color: #ccc !important;
            text-decoration: none !important;
            background-color: transparent !important;
        }

        #location:hover {
            color: #ccc;
        }

        #site-head-theme {
            font-size: 80px;
            font-weight: bold;
            font-family: "微软雅黑";
            width: 700px;
            position: absolute;
            color: white;
            top: 35%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        #site-head-search {
            width: 1000px;
            position: absolute;
            top: 55%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        .head-search {
            height: 70px !important;
        }

        #head-search-text {
            padding-left: 20px;
            font-size: 20px;
        }

        #head-search-btn {
            font-size: 23px;
            width: 130px;
            padding: 20px;
        }

        #search-type-nav {
            font-size: 18px;
        }

        .search-type > a {
            padding-bottom: 0px !important;
        }

        .caret {
            position: relative;
            left: 40%;
            border: 10px solid transparent !important;
            border-bottom: 10px solid !important;
        }

        .site-body {
            margin-top: 20px;
            height: 250px;
            width: 100%;
        }

        .map-find,
        .condition-find {
            width: 50%;
            height: 250px;
            float: left;
            border-right: 1px solid #333;
            box-sizing: border-box;
            text-align: center;
            padding: 40px 20px 20px 20px;
        }

        .intro-map,
        .intro-detail-map,
        .intro-condition,
        .intro-detail-condition {
            height: 30px;
            width: 100%;
            color: #333;
        }

        .intro-map,
        .intro-condition {
            margin-top: 20px;
            font-size: 22px;
        }

        .intro-detail-map,
        .intro-detail-condition {
            margin-top: 10px;
            font-size: 16px;
        }

        .map-find,
        .condition-find {
            cursor: pointer;
        }
    </style>
</head>

<body>
<div class="fixed-navbar">
    <ul class="nav" id="right-nav">
        <li>
            <a href="#"><img class="icon" src="../../../imgs/sale.png"/> </a>
        </li>
        <li>
            <a href="#"><img class="icon" src="../../../imgs/list.png"/></a>
        </li>
        <li>
            <a href="#"><img class="icon" src="../../../imgs/sale.png"/></a>
        </li>
        <li>
            <a href="#"><img class="icon" src="../../../imgs/list.png"/></a>
        </li>
    </ul>
</div>
<div class="container" id="container">
    <div class="site-head">
        <div class="site-header-login">
            <div class="container">
                <nav class="navbar-right navbar-transparent" role="navigation">
                    <div class="container-fluid">
                        <div>
                            <ul class="nav navbar-nav">
                              <%--  <li>
                                    <a href="#">登录</a>
                                </li>
                                <li>
                                    <a href="#">注册</a>
                                </li>--%>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <div class="site-header-nav">
            <div class="container" id="site-nav-container">
                <div class="col-md-1" id="site-logo">
                    <div id="site-logo-container"></div>
                    <div id="site-name-container">
                        玲珑之家
                    </div>
                </div>
                <div class="col-md-1" id="location-container">
                    <button type="button" class="btn btn-toolbar" id="location"><span
                            class="glyphicon glyphicon-map-marker"></span> 杭州
                    </button>
                </div>
                <div class="col-md-9 col-sm-8">
                    <nav id="index-nav" class="nav navbar-right navbar-transparent">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="/second/toSecondList">二手房</a>
                            </li>
                            <li>
                                <a href="#">新房</a>
                            </li>
                            <li>
                                <a href="#">小区</a>
                            </li>
                            <li>
                                <a href="#">商业办公</a>
                            </li>
                            <li>
                                <a href="#">经纪人</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <div id="site-head-theme" class="col-md-9">
            连接每个家的故事
        </div>
        <div id="site-head-search" class="col-lg-6">
            <div class="search-type-container container">
                <nav id="search-type-nav" class="nav navbar-left navbar-transparent">
                    <ul class="nav navbar-nav">
                        <li class="search-type">
                            <a href="#">找二手房</a>
                            <div class="caret" id="caret"></div>
                        </li>
                        <li class="search-type">
                            <a href="#">找新房</a>
                        </li>
                        <li class="search-type">
                            <a href="#">找小区</a>
                        </li>
                        <li class="search-type">
                            <a href="#">找经纪人</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <form action="/second/toSecondList" method="post">
                <div class="input-group">
                    <input type="hidden" name="sortField" value="traffic">
                    <input type="text" name="communityEntity.addressHead.areaName" class="form-control head-search"
                           id="head-search-text"
                           placeholder="请输入区域、商圈或小区名开始找房">
                    <span class="input-group-btn ">
                            <input type="submit" class="btn btn-success head-search" id="head-search-btn" value="开始找房">
						</span>
                </div>
            </form>
        </div>
    </div>
    <div class="site-body">
        <script>
            $(function () {
                $("#tomap").click(function () {
                    window.location.href = "${pageContext.request.contextPath}/map/jsdemo";
                })
            })
        </script>
        <div class="map-find" id="tomap">
            <img src="../../../imgs/map-find.png"/>
            <div class="intro-map">
                地图找房
            </div>
            <div class="intro-detail-map">
                为您精确定位，位置周边配套设施一览无余
            </div>
        </div>
        <div class="condition-find">
            <img src="../../../imgs/condition-find.png"/>
            <div class="intro-condition">
                条件查询
            </div>
            <div class="intro-detail-condition">
                根据您选择的条件，为你推荐房源
            </div>
        </div>
    </div>
    <div>
        <jsp:include page="commRecommend.jsp"/>
        <jsp:include page="newHouseRecommend.jsp"/>
    </div>
</div>
<%--<jsp:include page="footer.jsp"/>--%>
<script src="../../../js/jquery-3.4.0.js" type="text/javascript " charset="utf-8 "></script>
<script type="text/javascript " src="../../../js/bootstrap.js"></script>
<script src="../../../js/common.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>