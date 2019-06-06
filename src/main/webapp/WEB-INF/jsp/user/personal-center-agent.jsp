<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人中心</title>
		<link rel="stylesheet" href="../../../css/personal-center-left.css" />
		<link rel="stylesheet" href="../../../css/personal-center-right.css" />
		<style>
			#info-title>span {
				color: #E4393C;
				margin: 0 10px;
			}
			
			.mainbox {
				display: block;
				position: relative;
			}
			
			.con-box {
				display: block;
			}
			/*经纪人listhead*/
			
			.list-head {
				width: 100%;
				height: 50px;
				line-height: 50px;
				padding: 0 26px;
				background: none repeat scroll 0 0 #FFF;
			}
			
			#list-title {
				font-size: 20px;
				font-weight: bold;
			}
			
			.pnumber {
				color: #E4393C;
				margin: 0 5px;
				font-size: 20px;
				font-family: tahoma;
				display: inline;
				padding: 3px;
				width: 40px;
				height: 18px;
			}
			/*经纪人主要模块*/
			
			.list-wrap {
				margin: 0;
				padding: 0;
				display: block;
				border-top: 1px solid #E0E0E0;
			}
			
			.agent-1st {
				margin: 0;
				padding: 0;
				list-style: none;
			}
			
			.agent-1st li {
				clear: both;
				width: 948px;
				padding: 26px 26px 6px 26px;
				border-bottom: 1px dotted #e1e1e1;
				position: relative;
				overflow: hidden;
			}
			
			.pic-panel {
				font-size: 0;
				position: relative;
				float: left;
				overflow: hidden;
				display: block;
				box-shadow: 0 0 1px 1px #eee;
			}
			
			.pic-panel a {
				text-decoration: none;
				outline: none;
			}
			
			.pic-panel img {
				display: inline;
				height: 90px;
				border: 0;
				vertical-align: top;
			}
			
			.info-panel {
				line-height: 50px;
				height: 50px;
				width: 750px;
				position: relative;
				float: right;
				padding-top: 4px;
			}
			
			.agent-name {
				height: 32px;
				display: block;
				position: relative;
				top: -20px;
			}
			
			.name {
				margin: 0;
				padding: 0;
				color: #555;
				overflow: hidden;
				font-weight: 700;
				float: left;
				text-overflow: ellipsis;
				font-size: 20px;
				white-space: nowrap;
				height: 32px;
				line-height: 20px;
				vertical-align: middle;
				font-family: "Hiragino Sans GB", "微软雅黑", "Microsoft YaHei", SimHei, Tahoma, "宋体b8b\4f53", SimSun, sans-serif;
			}
			
			.position {
				background: #f1f1f1;
				padding: 4px;
				color: #888888;
				margin-left: 10px;
				border-radius: 2px;
				font-size: 12px;
				position: relative;
				top: -5px;
			}
			
			.col-1 {
				width: 330px;
				float: left;
				position: relative;
				left: 55px;
				top: -10px;
			}
			
			.main-plate {
				overflow: hidden;
				clear: both;
				text-overflow: ellipsis;
				white-space: nowrap;
				color: #555;
				height: 18px;
				line-height: 18px;
				margin-top: 8px;
				font-weight: 700;
			}
			
			#mp-plate {
				color: #999999;
				font-weight: 400;
				white-space: nowrap;
				line-height: 18px;
			}
			
			#address a {
				text-decoration: none;
				outline: none;
				color: #555;
			}
			
			#address a:hover {
				text-decoration: underline;
			}
			
			.achievement {
				height: 31px;
				line-height: 31px;
				margin-top: 8px;
				width: 410px;
				white-space: nowrap;
				overflow: hidden;
				text-overflow: ellipsis;
				font-size: 14px;
				color: #999;
			}
			
			.col-2 {
				width: 129px;
				text-align: right;
				float: left;
				position: relative;
				top: -15px;
				left: 80px;
			}
			
			.high-plate {
				color: #e4393c;
				margin-top: 7px;
				width: 139px;
				position: relative;
				text-align: left;
			}
			
			.comment-num {
				font-size: 14px;
				color: #999;
				font-family: Arial;
				margin-top: 10.5px;
				text-align: left;
			}
			
			.num {
				font-size: 22px;
				font-weight: 700;
				margin-left: 4px;
				font-family: tahoma;
				letter-spacing: -1px;
			}
			
			.comment-num a {
				text-decoration: none;
				outline: none;
				color: #999;
			}
			
			.comment-num a:hover {
				text-decoration: underline;
			}
			
			.col-3 {
				width: 198px;
				float: right;
				position: relative;
				top: -20px;
				text-align: center;
				margin-top: 20px;
			}
			
			.col-3 h2 {
				margin: 0;
				padding: 0;
				font-size: 22px;
				color: #333333;
				font-weight: 700;
				float: left;
			}
			
			.method {
				text-align: left;
				color: #999999;
				clear: both;
				padding-top: 12px;
			}
			
			.changebg {
				background: #fafafa;
			}
		</style>
	</head>

	<body>
		<jsp:include page="personal-center-head.jsp" />
		<div id="user-main" class="container">
			<div id="choice-container">
				<div id="account-info">
					<div id="nic-pic"> <img src="../../../imgs/nic-pic.jpg" /></div>
					<div id="welcome">
						欢迎你，17****96
					</div>
					<div id="choice-nav">
						<nav class="navbar">
							<ul class="nav choice">
								<li>
									<a href="personalCenterLatest">最新动态</a>
								</li>
								<li>
									<a href="personalCenterFavorHouse">关注房源</a>
								</li>
								<li>
									<a href="personalCenterFavorCommunity">关注小区</a>
								</li>
								<li>
									<a href="personalCenterAgent" class="choice-visited">我的经纪人</a>
								</li>
								<li>
									<a href="#">个人资料</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<div id="info-container">
				<div class="mainbox">
					<div class="con-box">
						<div class="list-head">
							<div id="list-title">共有<span class="pnumber">20</span>名经纪人</div>
						</div>
						<div class="list-wrap">
							<ul class="agent-1st">
								<li>
									<div class="pic-panel">
										<a href=""><img src="../../imgs/nic-pic.jpg" /></a>
									</div>
									<div class="info-panel">
										<div class="agent-name">
											<a href="#">
												<h3 class="name">许海柱<h3>
											</a>
										<span class="position">店经理</span>
										</div>
									</div>
									<div class="col-1">
										<div class="main-plate">
											<span id="mp-plate">
												主营版块:&nbsp;&nbsp;
											</span>
											<span id="address">
												<a href="">萧山&nbsp;</a>
												<a href="">钱江世纪城</a>
												&nbsp;&nbsp;&nbsp;
											</span>
										</div>
										<div class="achievement">
											<span>历史成交8套,</span>&nbsp;
											<span>最近30天带看房51套</span>
										</div>
									</div>
									<div class="col-2">
										<div class="high-plate">
											综合评分<span class="num">5.0</span>
										</div>
										<div class="comment-num">
											<a href="">评论110条</a>
										</div>
									</div>
									<div class="col-3">
										<h2>4008897372转5400</h2>
										<p class="method">联系方式</p>
									</div>
								</li><li>
									<div class="pic-panel">
										<a href=""><img src="../../imgs/nic-pic.jpg" /></a>
									</div>
									<div class="info-panel">
										<div class="agent-name">
											<a href="#">
												<h3 class="name">许海柱<h3>
											</a>
										<span class="position">店经理</span>
										</div>
									</div>
									<div class="col-1">
										<div class="main-plate">
											<span id="mp-plate">
												主营版块:&nbsp;&nbsp;
											</span>
											<span id="address">
												<a href="">萧山&nbsp;</a>
												<a href="">钱江世纪城</a>
												&nbsp;&nbsp;&nbsp;
											</span>
										</div>
										<div class="achievement">
											<span>历史成交8套,</span>&nbsp;
											<span>最近30天带看房51套</span>
										</div>
									</div>
									<div class="col-2">
										<div class="high-plate">
											综合评分<span class="num">5.0</span>
										</div>
										<div class="comment-num">
											<a href="">评论110条</a>
										</div>
									</div>
									<div class="col-3">
										<h2>4008897372转5400</h2>
										<p class="method">联系方式</p>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
		<script type="text/javascript" src="../../../js/jquery-3.4.0.js"></script>
		<script type="text/javascript">
		</script>
	</body>

</html>