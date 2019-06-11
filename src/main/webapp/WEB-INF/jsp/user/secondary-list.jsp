<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		.containerr {
			width: 100%;
			margin-top: 1%;
			padding-left: 15%;
		}
		
		#contentt {
			margin-top: 5%;
			margin-left: -3.5%;}


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
			margin-top: -0.7%;
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
			width: 22%;
			height: 3%;
		}
		
		.li {
			width: 7%;
			margin-left: 0%;
		}
		.house_li{
			margin-bottom: 3%;
		}
	</style>

	<script>

	</script>
	<body>
		<div class="containerr">
			<div>
				<ul class="list-inline" >
					<li id="fist_li" class="li">
						<a class="sencondary-a" href="/second/toSecondList?keyword=${keyword}" id="fist_a">默认排序</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="/second/toSecondList?keyword=${keyword}&sortField=createTime&order=DESC">最新</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="/second/toSecondList?keyword=${keyword}&sortField=houseEntities.price&order=DESC">价格</a>
					</li>
					<li class="li">
						<a class="sencondary-a" href="/second/toSecondList?keyword=${keyword}&sortField=houseEntities.traffic">带看较多</a>
					</li>
				</ul>
			</div>
			<hr class="hr" />
			<div class="fist_head">
				<h4 class="total_house">共找到<span> 3862 </span>套杭州二手房</h4>
			</div>
			<div id="contentt">

				<c:forEach items="${pageModel.content}" var="comm">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${comm.title} 地址: ${comm.addressHead.areaName} ${comm.address}

					<ul>
						<c:forEach items="${comm.houseEntities}" var="house">

							<li class="house_li">
								<a href="/second/toInfoPage?id=${house.id}" target="_blank">
									<%--没有图片时默认显示--%>
									<c:if test="${empty house.showPics}">
										<img class="img" src="../../../imgs/house1.jpg" alt="${house.title}">
									</c:if>
									<c:if test="${not empty house.showPics}">
										<c:forEach items="${house.showPics}" var="pic" begin="0" end="0">
											<img class="img" src="${pic.picUrl}" alt="${house.title}">
										</c:forEach>
									</c:if>
								</a>
								<div class="detail_content">
									<div class="title">
										<a href="/second/toInfoPage?id=${house.id}" target="_blank" style="color: gray;">${house.title}</a>
									</div>
									<br />
									<div class="address">
										<div class="houseInfo">
											<a href="#" target="_blank"><span><img class="icon" src="../../../imgs/house.png">${comm.title}</span> </a>
											<span>
									| ${house.houseType.typeDescription} | ${house.area} | ${house.orieType.typeDescription} | ${house.floor}楼 |  ${house.floorType.typeDescription}
									</span>
										</div>
									</div>
									<div class="flood">
										<div class="positionInfo">
											<span class="positionIcon"><img class="icon" src="../../../imgs/position.png">${house.floorType.typeDescription}(第${house.floor}层)${comm.age}年建${comm.type}-</span>
											<%--这里需要跳转公寓列表--%>
											<a href="#" target="_blank"><span>${comm.addressHead.areaName}</span></a>
										</div>
									</div>
									<div class="followInfo">
										<span class="starIcon"><img class="icon" src="../../../imgs/collection.png">${fn:length(house.clientEntities)}人关注 / 共${fn:length(house.histories)}次带看 / <fmt:formatDate value="${house.createTime}" pattern="yyyy-MM"/>月发布</span>
									</div>
									<div class="tag">
										<span class="label label-primary">近地铁</span>
										<span class="label label-primary">好看</span>
										<span class="label label-primary">随时看房</span>
									</div>
									<div class="priceInfo">
										<div class="totalPrice">
											<span class="price_style"><fmt:formatNumber value="${house.price/10000}" type="number" pattern="￥000"/></span><span style="color: red; font-size: x-large;">万</span>
										</div>
										<div class="unitPrice">
											<span>单价${house.perPrice}元/平米</span>
										</div>
									</div>
									<div class="listButtonContainer">
										<span><Button class="btn" onclick="showGritter('消息','关注成功!')">关注</button></span>
										<span><Button class="btn" onclick="showGritter('消息','成功加入对比!')">加入对比</button></span>
									</div>
								</div>
							</li>

						</c:forEach>

					</ul>

				</c:forEach>

			</div>
		</div>

	</body>


</html>