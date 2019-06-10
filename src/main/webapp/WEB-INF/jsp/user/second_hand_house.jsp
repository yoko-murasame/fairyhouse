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
				margin-left: 8%;
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
				margin-top: -39.5%;
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
			
			.li_style {
				font-weight: ;
			}
			
			.ul {
				margin-top: 5%;
				list-style: none;
			}
			
			.community_link {
				margin-left: 55%;
			}
			
			.community_show {
				display: block;
				float: right;
				margin-top: -30%;
			}
			.btn {
				border: none;
				background-color: white;
			}
		</style>
	</head>

	<body>
		<div class="container" id="content">
			<div class="top-head">
				<div class=" tophead_detail">
					<a class="font a_style" href="#">玲珑之家北京站</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">北京二手房</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">西城二手房</a><span>&nbsp;&gt;&nbsp;</span>
					<a class="font a_style" href="#">当前房源</a><span>&nbsp;&nbsp;</span>
				</div>
				<div class="font attenion_share">
					<span><Button class="font btn">关注房源</button>(已有24235人关注此小区)</span>
					<span><Button class="font btn">预约看房</button>(已有24235人看过)</span>
					<span style="margin-left: 2%;"><a class="font a_style" href="#"><img class="icon_img" src="../../../imgs/show.png">分享此小区</a></span>
				</div>
			</div>
			<div class="detail">
				<div class="xiaoquImg">
					<ul class="pgwSlideshow">
						<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>
						<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>
						<li><img src="../../../imgs/second_hand_house_show1.jpg"></li>
					</ul>
				</div>
				<div class="text_detail">
					<span class="price">799</span><span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;万</span>
					<p>123214万/平米</p>
					<hr />
					<ul class="text_detail_ul">
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;屋型<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;3室一厅/底层/共6层/平层/精装</span></li>
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;朝向<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;东 西</span></li>
						<li class="font text_detail_li">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面积<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;59.7平米</span></li>
						<li class="font text_detail_li">建筑年代<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;1982年建/板楼</span></li>
					</ul>
					<hr/>
					<ul class="text_detail_ul">
						<li class="font text_detail_li">小区名称<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;<a class="a_style" href="#">裕中西里</a>&nbsp;&nbsp;<a class="a_style" href=#"">地图</a></span></li>
						<li class="font text_detail_li">所在区域<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;<a class="a_style" href="#">西城</a>&nbsp;&nbsp;<a class="a_style" href=#"">马匍</a>&nbsp;&nbsp;<a class="a_style" href=#"">三至四环</a>&nbsp;&nbsp;<a class="a_style" href=#"">近8号线安华桥站</a></span></li>
						<li class="font text_detail_li">看房时间<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;提前预约随时可看</span></li>
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
				<h4>基本信息</h4>
				<hr/>
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">基本属性</li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">3室1厅1厨1卫</span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">底层(共6层)</span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">3室1厅1厨1卫</span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">底层(共6层)</span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">3室1厅1厨1卫</span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">底层(共6层)</span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">3室1厅1厨1卫</span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">底层(共6层)</span></li>

					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">房屋户型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">3室1厅1厨1卫</span></li>
						<li class="font li li_style">所在层楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">底层(共6层)</span></li>

					</div>
				</ul>
				<hr/>
				<ul class="ul">
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">交易属性</li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">2019-06-05</span></li>
						<li class="font li li_style">交易权属&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">商品房</span></li>
					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">2019-06-05</span></li>
						<li class="font li li_style">交易权属&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">商品房</span></li>
					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">2019-06-05</span></li>
						<li class="font li li_style">交易权属&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">商品房</span></li>
					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">2019-06-05</span></li>
						<li class="font li li_style">交易权属&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">商品房</span></li>
					</div>
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style"></li>
						<li class="font li li_style">挂牌时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">2019-06-05</span></li>
						<li class="font li li_style">交易权属&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: black;">商品房</span></li>
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
						<li style="width: 15%;" class="font li li_style">税费解析</li>
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
							<span class="label label-primary">近地铁</span>
							<span class="label label-primary">好看</span>
							<span class="label label-primary">随时看房</span>
						</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">户型介绍</li>
						<li class="font li li_style">
							<span class="label label-primary">近地铁</span>
							<span class="label label-primary">好看</span>
							<span class="label label-primary">随时看房</span>
						</li>
					</div>
					<hr />
					<div class="list-inline">
						<li style="width: 15%;" class="font li li_style">核心卖点</li>
						<li class="font li li_style">
							<span class="label label-primary">近地铁</span>
							<span class="label label-primary">好看</span>
							<span class="label label-primary">随时看房</span>
						</li>
					</div>
					<hr />

            </div>
			<span class="font">注：土地使用起止年限详见业主土地证明材料或者查询相关政府部门的登记文件</span>
			<div class="watch_house_history">
				<h4>看房记录</h4>
				<ul class="ul">
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
				</ul>
			</div>
			<div class="Community_information">
				<h4 style="display: inline;">裕中西里简介</h4>
				<a href="#" class="a_style community_link">查看小区详情</a>
				<ul class="ul">
					<li class="font text_detail_li">小区均价<span class="span_detail" style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;13994元/㎡</span></li>
					<li class="font text_detail_li">建筑年代<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;2011年建成</span></li>
					<li class="font text_detail_li">建筑类型<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;板楼</span></li>
					<li class="font text_detail_li">栋楼总数<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;34栋</span></li>
					<li class="font text_detail_li">挂牌房源<span class="span_detail">&nbsp;&nbsp;&nbsp;&nbsp;</span></li>

				</ul>
				<hr/>
				<img class="community_show" src="../../../imgs/commuity2.jpg">

			</div>
			<div class="map">
				<h4>周边配套</h4>
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