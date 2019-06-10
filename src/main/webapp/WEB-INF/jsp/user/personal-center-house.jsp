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
			
			.container {
				width: 75%;
			}
			
			#content {
				margin-top: 20px;
				padding: 15px;
				padding-left: 0px;
			}
			
			#content>ul {
				margin: 0;
				padding: 0;
			}
			
			#content>ul>li {
				padding: 20px 0px;
				border-bottom: 1px dashed #ccc;
			}
			
			.house-a {
				color: #333!important;
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
				font-size: 20px;
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
				margin-top: 10px;
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
				margin-top: -32%;
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
									<a href="favorHouse" class="choice-visited">关注房源</a>
								</li>
								<li>
									<a href="favorCommunity">关注小区</a>
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
				<div id="info-title">共<span>1</span>套 关注房源</div>
				<div id="info-tab">
					<span class="info-visited">全部</span>
					<span>二手房</span>
					<span>新房</span>
				</div>
				<div id="content">
					<ul>
						<li>
							<a href="#" target=""><img class="img" src="../../imgs/house1.jpg" alt="红街公寓配套齐全  采光好 房东诚心出售"></a>
							<div class="detail_content">
								<div class="title">
									<a href="#" target="blank" class="house-a">红街公寓配套齐全 采光好 房东诚心出售</a>
								</div>
								<div class="address">
									<div class="houseInfo">
										<a href="#" target="" class="house-a"><span><img class="icon" src="../../../imgs/house.png">红街公寓</span> </a>
									<span>
									| 2室2厅 | 85.14平米 | 南 北 | 精装
									</span>
									</div>
								</div>
								<div class="flood">
									<div class="positionInfo">
										<span class="positionIcon"><img class="icon" src="../../../imgs/position.png">中楼层(共18层)2010年建板楼-</span>
										<a href="#" target="" class="house-a"><span>火车东站</span></a>
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
									<span><Button class="btn btn-default">关注</button></span>
									<span><Button class="btn btn-default">加入对比</button></span>
								</div>
							</div>
						</li>
						<li>
							<a href="#" target=""><img class="img" src="../../imgs/house1.jpg" alt="红街公寓配套齐全  采光好 房东诚心出售"></a>
							<div class="detail_content">
								<div class="title">
									<a href="#" target="blank" class="house-a">红街公寓配套齐全 采光好 房东诚心出售</a>
								</div>
								<div class="address">
									<div class="houseInfo">
										<a href="#" target="_blank" class="house-a"><span><img class="icon" src="../../../imgs/house.png">红街公寓</span> </a>
									<span>
									| 2室2厅 | 85.14平米 | 南 北 | 精装
									</span>
									</div>
								</div>
								<div class="flood">
									<div class="positionInfo">
										<span class="positionIcon"><img class="icon" src="../../../imgs/position.png">中楼层(共18层)2010年建板楼-</span>
										<a href="#" target="" class="house-a"><span>火车东站</span></a>
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
									<span><Button class="btn btn-default">关注</button></span>
									<span><Button class="btn btn-default">加入对比</button></span>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="../../../js/jquery-3.4.0.js"></script>
		<script type="text/javascript">
		</script>
	</body>

</html>