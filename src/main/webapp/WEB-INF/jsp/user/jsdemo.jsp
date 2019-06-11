<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>城市名定位</title>
		<link rel="stylesheet" href="../../../css/bootstrap.css" />
		<link rel="stylesheet" href="../../../css/city-picker.css" />
		<style type="text/css">
			.BMap_cpyCtrl {
				display: none;
			}
			
			.anchorBL {
				display: none;
			}
			
			#allmap label {
				max-width: none;
			}
			
			#map-container {
				margin-top: 60px;
				box-shadow: 0 0 3px 3px #eee;
				padding: 5px 20px;
			}
			
			#map-search {
				padding-left: 10px;
			}
			
			#confirm {
				position: relative;
				top: -5px;
			}
			
			.map-show,
			.map-hide {
				height: 500px;
				float: left;
				margin: 16px 10px;
			}
			
			.map-show {
				width: calc(100% - 20px);
			}
			
			.map-hide {
				width: calc(60% - 20px);
			}
			
			.list-container-hide {
				display: none;
			}
			
			#list-container {
				width: calc(40% - 20px);
				height: 500px;
				float: right;
				box-sizing: border-box;
				margin: 0 10px;
				margin-top: 16px;
				box-shadow: 0 0 1px 1px #E0E0E0;
			}
			
			.map-community-one {
				box-sizing: border-box;
				padding: 5px;
				height: 130px;
				border-bottom: 1px dashed #333;
			}
			
			.map-community-img {
				box-sizing: border-box;
				width: 30%;
				height: 100%;
				padding: 10px 3px;
				float: left;
				cursor: pointer;
			}
			
			.map-community-img img {
				height: 100%;
				width: 100%;
			}
			
			.map-community-info {
				float: right;
				box-sizing: border-box;
				height: 100%;
				width: 70%;
				padding: 10px 10px;
			}
			
			.map-community-info-counts {
				padding: 10px;
				margin: 0;
				box-sizing: border-box;
				font-weight: bold;
				border-bottom: 1px solid #333;
				font-size: 18px;
			}
			
			.map-community-info-counts-number {
				color: #db4c3f;
				font-weight: bolder;
				font-size: 20px;
			}
			
			.map-community-info>p {
				margin-bottom: 3px;
			}
			
			.map-community-info-title {
				font-weight: bold;
				font-size: 16px;
			}
			
			.map-community-info-icon {
				height: 20px;
				width: 20px;
				padding: 3px;
				margin-right: 5px;
			}
			
			.map-community-info-avgprice {
				float: right;
				font-size: 20px;
				color: #db4c3f;
				font-weight: bold;
			}
			
			#map-list-ul {
				height: calc(100% - 50px);
				overflow-y: auto;
			}
			
			#map-list-ul>li {
				overflow: hidden;
				text-overflow: ellipsis;
				white-space: nowrap;
			}
			
			.community-info-back {
				float: right;
			}
		</style>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=9rkXTKt9Yjooe5uGYWPG7tdaGZ9OLAl3&s1"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
		<script src="../../../js/MakerClusterer.js"></script>
	</head>

	<body>
		<div class="container" id="map-container">
			<div style="position: relative;" id="map-search">
				<input readonly type="text" data-toggle="city-picker" size="70" id="county">
				<input type="button" name="confirm" class="btn-success" id="confirm" value="定位" />
			</div>
			<div id="allmap" class="map-show"></div>
			<div id="list-container" class="list-container-hide">
				<p class="map-community-info-counts">共有<span class="map-community-info-counts-number">100</span>个小区可供选择</p>
				<ul class="nav navbar" id="map-list-ul">
					<!--<li class="map-community-one">
						<div class="map-community-img">
							<img src="../../../imgs/house1.jpg" />
						</div>
						<div class="map-community-info">
							<p class="map-community-info-title">远洋山水</p>
							<p><span><img src="../../../imgs/house2.png"  class="map-community-info-icon"></span> 共1387个户型 </p>
							<p><span><img src="../../../imgs/collection.png"  class="map-community-info-icon"></span>石景山 塔楼/板楼 2003年建成</p>
							<p><span><img src="../../../imgs/people.png"  class="map-community-info-icon"></span>沈泽华<span class="map-community-info-avgprice">67268元/m²</span></p>
						</div>
					</li>-->
				</ul>
			</div>
		</div>

		<script type="text/javascript" src="../../../js/jquery-3.4.0.js"></script>
		<script src="../../../js/city-picker.data.js"></script>
		<script src="../../../js/city-picker.js"></script>
		<script type="text/javascript">
			var address = {};
			$(function() {
				var map = new BMap.Map("allmap");
				//初始化地图
				function myFun(result) {
					console.log(result);
					var cityName = result.name;
					map.centerAndZoom(cityName, 12);
				}
				var myCity = new BMap.LocalCity();
				myCity.get(myFun);
				map.enableScrollWheelZoom();
				$("#confirm").click(function() {
					var addr = $("#county").val();
					if(addr.trim() == "")
						return;
					var province = addr.split("/")[0];
					var city = addr.split("/")[1];
					var county = addr.split("/")[2];
					address.province = province;
					address.city = city;
					address.county = county;
					var map = new BMap.Map("allmap");
					map.enableScrollWheelZoom();
					getBoundary(county, map);
					//					map.centerAndZoom(county, 12);
					//					console.log(map);
					dw(map);
					$.ajax({
						type: 'post',
						url: "/map/getCommunities",
						data: address,
						async: false,
						dataType: 'json',
						success: function(back) {
							var data = back.data;
							$("#allmap").removeClass("map-show");
							$("#allmap").addClass("map-hide");
							$("#list-container").removeClass("list-container-hide");

							//							console.log(data);
							//							console.log(data.length);
							//							console.log($(".map-community-info-counts-number"));
							$(".map-community-info-counts-number")[0].innerHTML = data.length;
							var str = "";
							for(var i in data) {
								if(data[i].showPics.length == 0)
									str += "<li class='map-community-one'><div class='map-community-img'><img src='../../../imgs/house1.jpg' /></div>";
								else
									str += "<li class='map-community-one'><div class='map-community-img'><img src=" + data[i].showPics[0].picUrl + " /></div>";
								str += "<div class = 'map-community-info'><p class = 'map-community-info-title' > " + data[i].title + "</p>";
								str += "<p><span><img src='../../../imgs/house2.png'  class='map-community-info-icon'></span>共" + data[i].houseCounts + "个户型</p>";
								str += "<p><span><img src='../../../imgs/collection.png'  class='map-community-info-icon'></span>" + data[i].addressHead.areaName + " " + data[i].type + " " + data[i].age + "年建成</p>";
								if(typeof data[i].agentEntitySet[0] != "undefined")
									str += "<p><span><img src='../../../imgs/people.png'  class='map-community-info-icon'></span>" + data[i].agentEntitySet[0].username + "<span class='map-community-info-avgprice'>" + data[i].avgPrice + "元/m²</span></p></div></li>";
								else
									str += "<p><span><img src='../../../imgs/people.png'  class='map-community-info-icon'></span>" + "张三" + "<span class='map-community-info-avgprice'>" + data[i].avgPrice + "元/m²</span></p></div></li>";
							}
							$("#map-list-ul").empty();
							$("#map-list-ul").append(str);

							$(".map-community-img").click(function() {
								var index = $(this).parent().index();
								var infoStr = "<span class='map-community-info-counts-number'>" + data[index].title + "</span>共有<span class='map-community-info-counts-number'>" + data[index].houseEntities.length + "</span>个房源<span class='community-info-back'><img src='../../../imgs/back.png'/></span>";
								$(".map-community-info-counts").empty();
								$(".map-community-info-counts").append(infoStr);

								//								console.log(data);
								var houses = data[index].houseEntities;
								//								console.log(data[index]);
								//								console.log(houses[0]);
								//								console.log(data[index]);
								var houseStr = "";
								for(var i in houses) {
									if(houses[i].showPics.length == 0)
										houseStr += "<li class='map-community-one'><div class='map-community-img'><a href='/second/toInfoPage?id="+houses[i].id+"'><img src='../../../imgs/house1.jpg' /></a></div>";
									else
										houseStr += "<li class='map-community-one'><div class='map-community-img'><img src=" + houses[i].showPics[0].picUrl + " /></div>";
									houseStr += "<div class = 'map-community-info'><p class = 'map-community-info-title' > " + houses[i].title + "</p>";
									houseStr += "<p><span><img src='../../../imgs/house2.png'  class='map-community-info-icon'></span>" + houses[i].address + "</p>";
									houseStr += "<p><span><img src='../../../imgs/area.png'  class='map-community-info-icon'></span>" + houses[i].area + "m²</p>";
									//									if(typeof houses[i].agentEntitySet[0] != "undefined")
									//										houseStr += "<p><span><img src='../../../imgs/people.png'  class='map-community-info-icon'></span>" + data[index].agentEntitySet[0].username + "<span class='map-community-info-avgprice'>" + data[i].avgPrice + "元/m²</span></p></div></li>";
									//									else
									houseStr += "<p><span><img src='../../../imgs/people.png'  class='map-community-info-icon'></span>" + "张三" + "<span class='map-community-info-avgprice'>" + houses[i].perPrice + "元/m²</span></p></div></li>";
								}
								$("#map-list-ul").empty();
								$("#map-list-ul").append(houseStr);

								$(".community-info-back").click(function() {
									$("#confirm").trigger('click');
									var temp = "共有<span class='map-community-info-counts-number'>" + data.length + "</span>个小区可供选择";
									$(".map-community-info-counts").empty();
									$(".map-community-info-counts").append(temp);
								});
							});

						},
						error: function() {
							console.log("error");
						},
					});
				});
			});

			//定位区域，小地名，使用本地检索方法
			var dw = function(map) {
				var local = new BMap.LocalSearch(map, {
					renderOptions: {
						map: map
					}
				});

				//				var center = map.getCenter();
				//				console.log(map.getCenter())
				//				var point = new BMap.Point(center.lng, center.lat);
				//				map.centerAndZoom(point, 15);
				//				console.log(point);
				local.search('小区', '房地产', '住宅区');
				local.setMarkersSetCallback(function(pois) {
					//					console.log(pois);
					//清除所有覆盖物后，在叠加第一个点
					//					map.centerAndZoom(pois[0], 15);
					map.clearOverlays();
					var markers = [];
					for(var i = 0; i < pois.length; i++) {
						markers[i] = new BMap.Marker(pois[i].point);

						var label = new BMap.Label(pois[i].title.toString(), {
							offset: new BMap.Size(20, -10)
						});
						markers[i].setLabel(label);
						map.addOverlay(markers[i]);
						//根据获取到的poi id，查询边界坐标集合，画多边形
						var uid = pois[i].uid;
						queryUid(map, uid);
					};
					var markerClusterer = new BMapLib.MarkerClusterer(map, {
						markers: markers
					});
				});

				//				local.searchNearby('餐馆', center, 3000);
			}

			//获取小区信息
			function queryUid(map, uid) {
				$.ajax({
					async: false,
					url: "http://map.baidu.com/?pcevaname=pc4.1&qt=ext&ext_ver=new&l=12&uid=" + uid,
					dataType: 'jsonp',
					jsonp: 'callback',
					success: function(result) {
						content = result.content;
						if(null != content.geo && content.geo != undefined) {
							var geo = content.geo;
							var points = coordinateToPoints(geo);
							//point分组，得到多边形的每一个点，画多边形
							if(points && points.indexOf(";") >= 0) {
								points = points.split(";");
							}
							var arr = [];
							for(var i = 0; i < points.length - 1; i++) {
								var temp = points[i].split(",");
								arr.push(new BMap.Point(parseFloat(temp[0]), parseFloat(temp[1])));
							}
							var polygon = new BMap.Polygon(arr, {
								strokeColor: "red",
								strokeWeight: 2,
								strokeOpacity: 0.5
							}); //创建多边形
							map.addOverlay(polygon); //增加多边形
						}
					},
					timeout: 3000
				});
			}
			//获取市边界
			function getBoundary(county, map) { //获取边界       
				var bdary = new BMap.Boundary();
				bdary.get(county, function(rs) { //获取行政区域
					map.clearOverlays(); //清除地图覆盖物       
					var count = rs.boundaries.length; //行政区域的点有多少个
					for(var i = 0; i < count; i++) {
						var ply = new BMap.Polygon(rs.boundaries[i], {
							strokeWeight: 1,
							strokeColor: "#f00000"
						});
						//建立多边形覆盖物
						map.addOverlay(ply); //添加覆盖物
						map.setViewport(ply.getPath()); //调整视野         
					}
				});
				//				console.log(city);
				map.centerAndZoom(county, 16);
			}

			//坐标转换
			function coordinateToPoints(coordinate) {
				var points = "";
				if(coordinate) {
					var projection = BMAP_NORMAL_MAP.getProjection();

					if(coordinate && coordinate.indexOf("-") >= 0) {
						coordinate = coordinate.split('-');
					}
					//取点集合
					var tempco = coordinate[1];
					if(tempco && tempco.indexOf(",") >= 0) {
						tempco = tempco.replace(";", "").split(",");
					}
					//分割点，两个一组，组成百度米制坐标
					var temppoints = [];
					for(var i = 0, len = tempco.length; i < len; i++) {
						var obj = new Object();
						obj.lng = tempco[i];
						obj.lat = tempco[i + 1];
						temppoints.push(obj);
						i++;
					}
					//遍历米制坐标，转换为经纬度
					for(var i = 0, len = temppoints.length; i < len; i++) {
						//var pos = coordinate[i].split(',');
						var pos = temppoints[i];
						var point = projection.pointToLngLat(new BMap.Pixel(pos.lng, pos.lat));
						points += ([point.lng, point.lat].toString() + ";");
					}
				}
				return points;
			}
		</script>
	</body>

</html>