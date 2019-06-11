<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
		<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="../../../js/gritter/css/jquery.gritter.css" />
		<script type="text/javascript" src="../../../js/gritter/js/jquery.gritter.js"></script>
		<script type="text/javascript" src="../../../js/common.js"></script>
		<link rel="stylesheet" type="text/css" href="../../../css/personal-center-head.css" />
	</head>

	<body>
		<div id="site-header-nav">
			<div class="container" id="site-nav-container">
				<div>
					<nav id="site-logo" class="navbar-left">
						<ul class="nav navbar-nav site-navbar">
							<li>
								<img src="../../../imgs/logo.png" id="site-logo-img" />
							</li>
							<li>
								<a href="/">玲珑之家</a>
							</li>
						</ul>
					</nav>
				</div>
				<div>
					<nav id="site-account" class="navbar-right">
						<ul class="nav navbar-nav site-navbar">
							<c:if test="${empty user}">
								<li>
									<%--<a href="#">一键登录</a>--%>
									<!-- 按钮触发模态框 -->
									<button class="btn" data-toggle="modal" data-target="#myModal" style="margin:11px 10px ">
										一键登录
									</button>
								</li>
							</c:if>
							<c:if test="${not empty user}">
								<li>
									<a href="/user/latestInfo">您好:${user.phone}</a>
								</li>
								<li>
									<a href="/user/logout">退出</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
				<div>
					<nav id="site-nav" class="navbar-right">
						<ul class="nav navbar-nav site-navbar">
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

		<jsp:include page="login-reg.jsp"/>

	</body>

</html>