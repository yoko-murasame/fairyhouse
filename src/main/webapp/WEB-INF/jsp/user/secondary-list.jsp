<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		.container {
			width: 75%;
			margin-top: 1%;
		}
		
		#content {
			margin-top: 5%;
			margin-left: -3.5%;
		}
		
		.sencondary-a {
			color: black;
			/*	font-size: large;*/
			display: block;
			width: 200%;
			padding-top: 10%;
			padding-bottom: 10%;
			padding-left: 10%;
			padding-right: 10%;
		}
		
		.sencondary-a:hover {
			color: black;
			text-decoration: none;
		}
		
		#fist_li {
			background-color: rgb(0, 185, 47);
		}
		
		#fist_a {
			color: white;
		}
		
		.hr {
			margin-top: -1%;
		}
		
		.detail_content {
			width: 40%;
			float: right;
			margin-right: 30%;
			min-width: 40%;
		}
		
		.title {
			font-size: x-large;
		}
		
		span {
			font-size: larger;
		}
		
		.priceInfo {
			width: 40%;
			margin-top: -29%;
			margin-left: 110%;
		}
		
		.totalPrice {
			font-size: x-large;
		}
		
		.price_style {
			color: red;
			font-weight: 700;
			margin-right: 4%;
			margin-left: 23%;
		}
		
		.unitPrice {
			margin-top: 5%;
		}
		
		.icon {
			width: 3%;
			height: 3%;
			margin-bottom: 1%;
			margin-right: 2%;
		}
		
		.tag {
			margin-top: 5%;
		}
		
		.label-primary {
			height: 5%;
			width: 5%;
		}
		
		.flood {
			margin-top: 2%;
		}
		
		.followInfo {
			margin-top: 2%;
		}
		
		.listButtonContainer {
			width: 50%;
			margin-top: -25%;
			margin-left: 110%;
		}
		
		.btn {
			border: 1px solid;
			background-color: white;
		}
		
		ul {
			list-style: none;
		}
		
		.img {
			width: 22%;
			height: 22%;
		}
		
		.icon_img {
			width: 25%;
			height: 25%;
		}
		
		.li {
			width: 7%;
			margin-left: 0%;
		}
	</style>

	<body>
		<div class="container">
			<div>
				<ul class="list-inline" id="footer_ul">
					<li id="fist_li" class="li">
						<a class="sencondary-a" href="#" id="fist_a">默认排序</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="#">最新</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="#">价格</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="#">面积</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="#">带看较多</a>
					</li>
					<li style="margin-left: 50%;" class="li">
						<img style="margin-right: 10%;" class="icon_img" src="../../../imgs/list_icon1.png">
						<img class="icon_img" src="../../../imgs/list_icon.png">
					</li>
				</ul>
			</div>
			<hr class="hr" />
			<div class="fist_head">
				<h4 class="total_house">共找到<span> 3862 </span>套杭州二手房</h4>
			</div>
			<div id="content">
				<ul>
					<li>
						<a href="#" target="_blank"><img class="img" src="../../imgs/house1.jpg" alt="红街公寓配套齐全  采光好 房东诚心出售"></a>
						<div class="detail_content">
							<div class="title">
								<a class="" href="#" target="_blank" style="color: gray;">红街公寓配套齐全 采光好 房东诚心出售</a>
							</div>
							<br />
							<div class="address">
								<div class="houseInfo">
									<a href="#" target="_blank"><span><img class="icon" src="../../../imgs/house.png">红街公寓<span> </a> 
									<span>
									| 2室2厅 | 85.14平米 | 南 北 | 精装 | 有电梯
									</span>
								</div>
							</div>
							<div class="flood">
								<div class="positionInfo">
									<span class="positionIcon"><img class="icon" src="../../../imgs/position.png">中楼层(共18层)2010年建板楼-</span>
									<a href="#" target="_blank"><span>火车东站</span></a>
								</div>
							</div>
							<div class="followInfo">
								<span class="starIcon"><img class="icon" src="../../../imgs/collection.png">51人关注 / 共36次带看 / 9个月以前发布</span>
							</div>
							<div class="tag">
								<span class="label label-primary">近地铁</span>
								<span class="label label-primary">好看</span>
								<span class="label label-primary">随时看房</span>
							</div>
							<div class="priceInfo">
								<div class="totalPrice">
									<span class="price_style">325</span><span style="color: red; font-size: x-large;">万</span>
								</div>
								<div class="unitPrice">
									<span>单价38173元/平米</span>
								</div>
							</div>
							<div class="listButtonContainer">
								<span><Button class="btn">关注</button></span>
								<span><Button class="btn">加入对比</button></span>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>

	</body>

</html>