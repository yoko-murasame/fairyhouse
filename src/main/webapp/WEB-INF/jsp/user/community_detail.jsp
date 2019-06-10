<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../../../css/pgwslideshow.min.css">
		<script src="../../../js/pgwslideshow.min.js"></script>
		<style>
			html {
				width: 100%;
			}
			
			body {
				width: 100%;
			}
			
			#content {
				width: 75%;
			}
			
			.btn {
				border: none;
				background-color: white;
			}
			
			.icon_img {
				width: 3%;
				height: 3%;
			}
			
			.share {
				float: right;
			}
			
			.tophead_detail {
				display: inline-block;
			}
			
			.attenion_share {
				display: inline-block;
				margin-left: 15%;
			}
			
			.font {
				color: rgb(179, 179, 179);
			}
			
			.a_style:hover {
				text-decoration: none;
			}
			
			.pgwSlideshow {
				width: 55%;
			}
			
			ul {
				margin-left: -40px;
			}
			
			.detail {
				margin-top: 3%;
			}
			
			
			
			.text_detail {
				width: 40%;
				float: right;
				margin-top: -40%;
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
				margin-right: 20%;
			}
			
			.consult_icon_img {
				width: 10%;
			}
			
			.consult_btn {
				width: 80%;
				background-color: rgb(221, 221, 221);
			}
			
			.house_detail {
				margin-top: 7%;
				width: 55%;
			}
			
			.house_link {
				margin-left: 55%;
			}
			
			.house_link:hover {
				text-decoration: none;
			}
			
			.img_show {
				margin-top: 5%;
			}
			
			.second_hand_house_show {
				float: left;
				width: 31%;
				margin-right: 2%;
			}
			
			.second_hand_house_text {
				font-size: x-small;
			}
			
			.second_hand_house_detailText {
				margin-top: 1%;
				margin-left: 40%;
			}
			
			.second_hand {
				display: block;
				width: 100%;
			}
			
			.house_deal {
				margin-top: 7%;
				width: 55%;
			}
			
			.li {
				width: 18%;
				margin-right: 2%;
			}
			
			.ul {
				margin-top: 5%;
			}
			
			.li_style {
				font-weight: 800;
			}
			.deal_btn{
			border: 1px solid gray;
			width: 100%;
			background-color: white;
			}
			.watch_dealprice{
				font-size: small;
				font-weight: 500;
			}
			.map{
			margin-top: 7%;
			}
		</style>
	</head>

	<body>
		<div class="container" id="content">
			<div class="top-head">
				<div class=" tophead_detail">
					<a class="font a_style" href="#">北京房产网</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">北京小区</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">石景山小区</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">鲁谷小区</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">远洋山水</a>
				</div>
				<div class="font attenion_share">
					<span><Button class="font btn">关注小区</button>(已有24235人关注此小区)</span>
					<span style="margin-left: 5%;"><a class="font a_style" href="#"><img class="icon_img" src="../../../imgs/show.png">分享此小区</a></span>
				</div>

			</div>
			<div class="detail">
				<div class="xiaoquImg">
					<ul class="pgwSlideshow">
						<li><img src="../../../imgs/community1.jpg"></li>
						<li><img src="../../../imgs/community1.jpg"></li>
						<li>
							<img src="../../../imgs/community1.jpg">

						</li>

					</ul>

				</div>
				<div class="text_detail">
					<span class="price">23040</span><span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;元/㎡</span>
					<span class="font" style="margin-left: 5%;">5月参考均价</span>
					<hr />
					<ul class="text_detail_ul">
						<li class="font text_detail_li">建筑年代<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;2011年建成</span></li>
						<li class="font text_detail_li">建筑类型<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;板楼</span></li>
						<li class="font text_detail_li">物业费用<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;1.8元/平米/月</span></li>
						<li class="font text_detail_li">物业公司<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;上海公司</span></li>
						<li class="font text_detail_li">开发商<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海公司</span></li>
						<li class="font text_detail_li">栋楼总数<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;34栋</span></li>
						<li class="font text_detail_li">房屋总数<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;4154户</span></li>
						<li class="font text_detail_li">附近门店<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;</span></li>

					</ul>
					<hr/>
					<div class="agent_datail">
						<img src="../../../imgs/agent1.jpg">
						<div class="agent_detail">
							<span style="font-weight: 800;">罗文浩</span>
							<span style="font-size: x-small;">&nbsp;&nbsp;评分4.8/235325人评价</span>
							<p style="font-size: x-small;margin-top: 3%;">有任何选房，买房，交税过户问题，欢迎咨询</p>
							<p style="font-size: small;color: red;font-weight: 600;margin-top: -2%;">400000000转0575</p>
							<button class="consult_btn"><div><img  class="consult_icon_img" src="../../../imgs/consult.png">&nbsp;&nbsp;咨询</div></button>
						</div>
					</div>
				</div>

			</div>
			<div class="house_detail">
				<h4 style="display: inline;">远洋山水优质二手房</h4>
				<a href="#" class="house_link">查看全部二手房</a>
				<div class="img_show">
					<div class="second_hand_house_show">
						<img class="second_hand" src="../../../imgs/second-hand_house1.jpg">
						<div class="second_hand_house_detailText">
							<p class="second_hand_house_text">423万</p>
							<p style="margin-left:-15%;" class="second_hand_house_text" style="margin-top: -2%;">120平/两室一厅</p>
						</div>
					</div>
					<div class="second_hand_house_show">
						<img class="second_hand" src="../../../imgs/second-hand_house1.jpg">
						<div class="second_hand_house_detailText">
							<p class="second_hand_house_text">423万</p>
							<p style="margin-left:-15%;" class="second_hand_house_text" style="margin-top: -2%;">120平/两室一厅</p>
						</div>
					</div>
					<div class="second_hand_house_show">
						<img class="second_hand" src="../../../imgs/second-hand_house1.jpg">
						<div class="second_hand_house_detailText">
							<p class="second_hand_house_text">423万</p>
							<p style="margin-left:-15%;" class="second_hand_house_text" style="margin-top: -2%;">120平/两室一厅</p>
						</div>
					</div>
				</div>
			</div>
			<div class="house_deal">
				<h4 >远洋山水小区成交记录</h4>
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 35%;" class="li li_style">房屋户型</li>
						<li class="li li_style">面积</li>
						<li class="li li_style">签约日期</li>
						<li class="li li_style">成交价</li>
					</div>
					<hr/>
					<div class="list-inline">
						<li style="width: 35%;" class="li">
							<p>三室一厅</p><span style="margin-top: -2%;">低楼层/15层 南 北/2007年建成</span></li>
						<li class="li">219.08平米</li>
						<li class="li">2019-05-26</li>
						<li class="li">6**万</li>
					</div>
					<hr/>
					<div class="list-inline">
						<li style="width: 35%;" class="li">
							<p>三室一厅</p><span style="margin-top: -2%;">低楼层/15层 南 北/2007年建成</span></li>
						<li class="li">219.08平米</li>
						<li class="li">2019-05-26</li>
						<li class="li">6**万</li>
					</div>
					<hr/>
					<div class="list-inline">
						<li style="width: 35%;" class="li">
							<p>三室一厅</p><span style="margin-top: -2%;">低楼层/15层 南 北/2007年建成</span></li>
						<li class="li">219.08平米</li>
						<li class="li">2019-05-26</li>
						<li class="li">6**万</li>
					</div>
					<hr/>
				</ul>
				<button class="deal_btn"><span class="watch_dealprice">查看全部成交价<span></button>

			</div>
			<div class="map">
			<h4>远洋山水周边配套</h4>
			  <img src="../../../imgs/map.PNG">
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
			$(document).ready(function() {
				$('.pgwSlideshow').pgwSlideshow();
			});
		</script>
	</body>

</html>