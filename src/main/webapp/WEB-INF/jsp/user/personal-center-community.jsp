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
									<a href="latestInfo">最新动态</a>
								</li>
								<li>
									<a href="favorHouse">关注房源</a>
								</li>
								<li>
									<a href="favorCommunity" class="choice-visited">关注小区</a>
								</li>
								<li>
									<a href="personalAgent">我的经纪人</a>
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
				<div id="info-title">共<span>1</span>个 关注小区</div>
				<div id="info-tab">
					<span class="info-visited">全部</span>
					<span>成交</span>
					<span>调价</span>
					<span>新上</span>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="../../../js/jquery-3.4.0.js"></script>
		<script type="text/javascript">
		</script>
	</body>

</html>