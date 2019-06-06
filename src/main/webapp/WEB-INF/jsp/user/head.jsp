<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">

		<style>
			.container {
				width: 100%;
				height: 5%;
				background-color: white;
				margin-top: 1%;
			}
			
			.head-a {
				color: rgb(192, 192, 192);
				font-size: small;
			}
			
			.list-inline {
				margin-left: 15%;
			}
			
			.head-a:hover {
				color: black;
				text-decoration: none;
			}
			
			.hr {
				margin-top: 0.5%;
				border-top: 1px solid gray;
			}
		</style>
	</head>

	<body>
		<div class="container">
			<ul class="list-inline">
				<li>
					<a class="head-a" href="#">首页</a>
				</li>
				<li>
					<a class="head-a" href="#">二手房</a>
				</li>
				<li>
					<a class="head-a" href="#">新房</a>
				</li>
				<li>
					<a class="head-a" href="#">小区</a>
				</li>
				<li>
					<a class="head-a" href="#">经纪人</a>
				</li>

				<li>
					<a class="head-a" href="#">房价</a>
				</li>
				<li>
					<a class="head-a" href="#" target="_blank">工具</a>
				</li>
				<li>
					<a class="head-a" href="#" target="_blank">发布房源</a>
				</li>
				<li style="margin-left: 25%;">
					<div class="login" id="">
						<a class="head-a" href="#" id="" rel="#">登录</a>/
						<a class="head-a" href="#" id="" rel="#">注册</a>
						<a class="head-a" href="#" id="">退出</a>
					</div>
				</li>
				<li style="margin-left: 3%;">
					<div class="phone"><span style="color: rgb(192,192,192);">热线电话1010-9666</span></div>
				</li>

			</ul>
			<hr class="hr">
		</div>
	</body>

</html>