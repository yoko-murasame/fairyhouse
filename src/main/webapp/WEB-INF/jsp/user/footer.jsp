<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<!--		<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<link rel="stylesheet" href="css/bootstrap.css" />-->
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">

		<style>
			.foot-container {
				padding-top: 30px;
				padding-bottom: 80px;
				width: 100%;
				margin-top: 5%;

				background-color: #333;
				box-shadow: 0 7px 5px -5px #333;
			}
			
			.brand,
			.bottom {
				font-size: 16px;
				color: #ffffff;
			}
			
			.content {
				margin-left: 15%;
			}
			
			.brand:visited {
				color: #ccc;
				text-decoration: none;
			}
			
			.brand:hover {
				color: white;
				text-decoration: none;
			}
			
			.about {
				text-decoration: none;
				color: white;
			}
			
			.about:hover {
				text-decoration: none;
			}
			
			#tel {
				color: rgb(4, 217, 137);
			}
			
			#link {
				color: white
			}
			
			.hover:hover {
				color: white;
			}
			
			#link {
				border: none;
				padding: 0;
				background-color: rgb(50, 50, 50);
			}
			
			.link_list {
				padding-left: 5px;
			}
			
			
			#footer_ul {
				font-weight: 800;
				padding-left: 7px;
				font-size: 20px;
				color: #222;
			}
			
			hr {
				margin-top: 3%;
				border-top: 1px solid gray;
				width: 80%;
				margin-left: 0%;
			}
			
		</style>
	</head>

	<body>
		<div class="foot-container">
			<div class="content">
				<ul class="list-inline" id="footer_ul">
					<li>
						<a href="#" class="about">关于玲珑之家</a>
					</li>
					<li>
						<a href="#" class="about">联系我们</a>
					</li>
					<li>
						<a href="#" class="about">加入我们</a>
					</li>
					<li>
						<a href="#" class="about">隐私声明</a>
					</li>
					<li>
						<a href="#" class="about">网站地图</a>
					</li>

					<li>
						<a href="#" class="about">友情链接</a>
					</li>
					<li style="margin-left: 30%;">
						<span id="tel">官方客服 1000010</span>
					</li>

				</ul>

				<hr />
				<span class="hover"><button id="link" >合作与友情链接</button></span>
				<br/>
				<br/>

				<div class="link_list" hidden="hidden">
					<ul class="list-inline">
						<li>
							<a href="#" class="brand">海澜之家</a>
						</li>
						<li>
							<a href="#" class="brand">耐克</a>
						</li>
						<li>
							<a href="#" class="brand">阿迪达斯</a>
						</li>
						<li>
							<a href="#" class="brand">安居客</a>
						</li>
						<li>
							<a href="#" class="brand">奥迪</a>
						</li>
						<li>
							<a href="#" class="brand">大众</a>
						</li>

					</ul>
				</div>

				<hr />
				<div class="bottom">
					<div class="copyright">玲珑之家（杭州）科技有限公司 | 网络经营许可证 京ICP备16057509号-2 | © Copyright©2010-2019 玲珑之家linglongzhijia.com版权所有
						<br>违法和不良信息举报电话：010-86440676 违法和不良信息举报邮箱：jubaoyouxiang@lianjia.com</div>
				</div>
			</div>
		</div>
		<script>
			$("#link").hover(function() {
				$(".link_list").show();
			})
		</script>
	</body>

</html>