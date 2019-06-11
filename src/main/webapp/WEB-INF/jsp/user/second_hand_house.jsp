<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../../../css/pgwslideshow.min.css">
		<script src="../../../js/pgwslideshow.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sHHiBU99pok0EjtMjUHapq4Fv3Gt1bee"></script>
		<style>
			html {
				width: 100%;
			}

			body {
				width: 100%;
			}

			#content {
				width: 80%;
			}

			.tophead_detail {
				display: inline-block;
			}

			.font {
				color: rgb(179, 179, 179);
			}

			.a_style:hover {
				text-decoration: none;
			}

			.attenion_share {
				display: inline-block;
				margin-left: 35%;
			}

			.detail {
				margin-top: 3%;
			}

			.pgwSlideshow {
				width: 55%;
			}

			ul {
				margin-left: -40px;
			}

			.icon_img {
				width: 3%;
				height: 3%;
			}

			.text_detail {
				width: 40%;
				float: right;
				margin-top: -34%;
				margin-right: -3%;
			}

			.price {
				font-size: xx-large;
				color: red;
				font-weight: 800;
			}

			.text_detail_ul {
				list-style: none;
			}

			.text_detail_li {
				margin-top: 1%;
			}

			.span_detail {
				color: rgb(85, 85, 85);
			}

			.agent_detail {
				float: right;
				margin-right: 35%;
			}




			.house_detail {
				margin-top: 7%;
				width: 55%;
			}

			.house_special {
				margin-top: 7%;
				width: 55%;
			}

			.watch_house_history {
				margin-top: 7%;
				width: 55%;
			}

			.Community_information {
				margin-top: 7%;
				width: 55%;
			}
			.map{

				margin-top: 7%;
				width: 55%;
			}
			.li {
				width: 30%;
				margin-right: 2%;
				margin-bottom: 1%;
			}



			.ul {
				margin-top: 5%;
				list-style: none;
			}

			.community_link {
				margin-left: 50%;
			}

			.community_show {
				display: block;
				float: right;
				margin-top: -28%;
			}
			.btn {
				border: none;
				background-color: white;
			}
			.community_img{
				width: 40%;
				height: 40%;
			}
			#allmap{
				height: 400px;
				width: 100%;
				background-color: red;
			}
		</style>
	</head>

	<body>
		<div class="container" id="content">
			<div class="top-head">
				<div class=" tophead_detail">
					<a class="font a_style" href="#">${house.communityEntity.addressHead.areaName}</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">${house.communityEntity.title}</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">当前房源</a><span>&nbsp;&nbsp;</span>
				</div>
				<div class="font attenion_share">
					<span><Button class="font btn">预约看房</button>(已有${house.traffic}人看过)</span>
					<span style="margin-left: 2%;"><a class="font a_style" href="#"><img class="icon_img" src="http://img.dmdream.cn/house/a64b965a-6dce-41a2-a13d-ef7cb852fdf3.png?imageslim">分享此小区</a></span>
				</div>
			</div>
			<div class="detail">
				<div class="xiaoquImg">
					<ul class="pgwSlideshow" style="display: flex;">
						<%--<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>
						<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>
						<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>--%>
						<c:forEach items="${house.showPics}" var="url">
							<li><img src="${url.picUrl}"></li>
						</c:forEach>
					</ul>
				</div>
				<div class="text_detail">
					<span class="price">${house.price}</span><span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;万</span>
					<p>${house.perPrice}元/平米</p>
					<hr />
					<ul class="text_detail_ul">
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;屋型<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.houseType.typeDescription}/${house.floorType.typeDescription}/${house.floor}楼/平层/精装</span></li>
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;朝向<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.orieType.typeDescription}</span></li>
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面积<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.area}㎡</span></li>
						<li class="font text_detail_li">建筑年代<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.communityEntity.age}年/${house.communityEntity.houseType.typeDescription}</span></li>
					</ul>
					<hr/>
					<ul class="text_detail_ul">
						<li class="font text_detail_li">小区名称<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;<a class="a_style" href="#">${house.communityEntity.title}</a>&nbsp;&nbsp;<a class="a_style" href="#allmap">地图</a></span></li>
						<li class="font text_detail_li">所在区域<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;<a class="a_style" href="#">${house.communityEntity.addressHead.abbreviation}</a>&nbsp;&nbsp;</span></li>
					</ul>
					<hr/>
					<div class="agent_datail">
						<img src="../../../imgs/agent1.jpg">
						<div class="agent_detail">
							<span style="font-weight: 800;">${house.agentEntity.username}</span>
							<span style="font-size: x-small;">&nbsp;&nbsp;评分${house.agentEntity.score}</span>
							<p style="font-size: x-small;margin-top: 5%;">有任何选房，买房，交税过户问题，欢迎咨询</p>
							<p style="font-size: small;color: red;font-weight: 600;margin-top: 2%;">${house.agentEntity.phone}</p>

						</div>
					</div>
				</div>
			</div>
			<div class="house_detail">
				<h4>基本信息</h4>
				<hr/>
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">基本属性</li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.houseType.typeDescription}">
							暂没数据
						</c:if><c:if test="${!empty house.houseType.typeDescription}">${ house.houseType.typeDescription}</c:if></span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.floor}">
							暂没数据
						</c:if><c:if test="${!empty house.floor}">${ house.floor}</c:if></span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">建筑面积&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.area}">
							暂没数据
						</c:if><c:if test="${!empty user}">${house.area}</c:if>㎡</span></li>
						<li class="font li li_style">建筑类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.communityEntity.houseType.typeDescription}">
							暂没数据
						</c:if><c:if test="${!empty house.communityEntity.houseType.typeDescription}">${ house.communityEntity.houseType.typeDescription}</c:if></span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">房屋朝向&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.orieType.typeDescription}">
							暂没数据
						</c:if><c:if test="${!empty house.orieType.typeDescription}">${ house.orieType.typeDescription}</c:if></span></li>
						<li class="font li li_style">装修情况&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.orieType.typeDescription}">
							暂没数据
						</c:if><c:if test="${!empty house.orieType.typeDescription}">${ house.orieType.typeDescription}</c:if></span></li>

					</div>
				</ul>
				<hr/>
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">交易属性</li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty createTime}">
							暂没数据
						</c:if><c:if test="${!empty createTime}">${ createTime}</c:if></span></li>
						<li class="font li li_style">房屋年限&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;"><c:if test="${empty house.ageType.typeDescription}">
							暂没数据
						</c:if><c:if test="${!empty house.ageType.typeDescription}">${house.ageType.typeDescription}</c:if></span></li>

					</div>

				</ul>
				<hr/>
				<span class="font">注：房源所示房屋用途，交易权属，建成年代，年产权限，建筑结构仅供参考，购房时以房本信息为准</span>
			</div>
			<div class="house_special">
				<h4>房源特色</h4>
				<hr />
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">房源标签</li>
						<li class="font li li_style">
							<span class="label label-primary">近地铁</span>
							<span class="label label-primary">好看</span>
							<span class="label label-primary">随时看房</span>
						</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">权限抵押</li>
						<li class="font li li_style">
							<span>业主2017年刚刚装修完</span>
						</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">户型介绍</li>
						<li class="font li li_style">

						</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">核心卖点</li>
						<li class="font li li_style">

						</li>
					</div>
					<hr />

            </div>
			<span class="font">注：土地使用起止年限详见业主土地证明材料或者查询相关政府部门的登记文件</span>
			<div class="watch_house_history">
				<h4>看房记录</h4>
				<br/>
				<span>当前房源总共被参观<span style="font-size: x-large ;font-weight: 800">${house.traffic}</span>次</span>
				<%--<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class=" li li_style">带看时间</li>
						<li style="width: 15%;" class=" li li_style">带看经纪人</li>
						<li style="width: 15%;" class=" li li_style">咨询电话</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">2019-06-10</li>
						<li style="width: 15%;" class="font li li_style">徐志强</li>
						<li style="width: 15%;" class="font li li_style">235345436436</li>
					</div>
					<hr />
				</ul>--%>
			</div>
			<div class="Community_information">
				<h4 style="display: inline;">${house.communityEntity.title}简介</h4>
				<span class="community_link">小区图片</span>
				<ul class="ul">
					<li class="font text_detail_li">小区均价<span class="span_detail" style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;${house.communityEntity.avgPrice}元/㎡</span></li>
					<li class="font text_detail_li">建筑年代<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.communityEntity.age}年建成</span></li>
					<li class="font text_detail_li">建筑类型<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.communityEntity.type}</span></li>
					<li class="font text_detail_li">栋楼总数<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;${house.communityEntity.buildingCounts}栋</span></li>
					<li class="font text_detail_li">挂牌房源<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;</span></li>

				</ul>
				<hr/>
				<img class="community_show community_img" src="http://pspq953ox.bkt.clouddn.com/house/31948204-2213-4cd5-8bcf-05862658d88a.jpg">

			</div>
			<div class="map">
				<h4>周边配套</h4>

				<div id="allmap" >


				</div>

			</div>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<script>
            var map = new BMap.Map("allmap");
            map.centerAndZoom(new BMap.Point(${house.communityEntity.longitude},${house.communityEntity.latitude}),15);
            map.enableScrollWheelZoom(true);
            var point = new BMap.Point(${house.communityEntity.longitude}, ${house.communityEntity.latitude});
            var marker = new BMap.Marker(point);
            map.addOverlay(marker);
			$(document).ready(function() {
				$('.pgwSlideshow').pgwSlideshow();


			});

		</script>
	</body>

</html>
