<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../../../css/crumbs.css" />
	</head>

	<body>
		<div id="crumbs-table-container" style="width: 70%;">
			<table class="table table-bordered" id="crumbs" >
				<tr>
					<th>位置</th>
					<td>区域</td>
				</tr>
				<tr id="district-level">
					<th></th>
					<td>朝阳区</td>
					<td>二道区</td>
					<td>高新区</td>
					<td>经开区</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>楼层</th>
					<c:forEach items="${dictMap['楼层']}" var="dict">
						<td><input type="checkbox"><span>${dict.typeDescription}</span></td>
					</c:forEach>
				</tr>
				<tr>
					<th>朝向</th>
					<c:forEach items="${dictMap['朝向']}" var="dict">
						<td><input type="checkbox"><span>${dict.typeDescription}</span></td>
					</c:forEach>
				</tr>
				<tr>
					<th>楼龄</th>
					<c:forEach items="${dictMap['楼龄']}" var="dict">
						<td><input type="checkbox"><span>${dict.typeDescription}</span></td>
					</c:forEach>
				</tr>
				<tr>
					<th>售价</th>
					<c:forEach items="${dictMap['售价']}" var="dict">
						<td><input type="checkbox"><span>${dict.typeDescription}</span></td>
					</c:forEach>
				</tr>
				<tr>
					<th>标签</th>
				</tr>
				<tr>
					<th>楼层</th>
				</tr>
				<tr>
					<th>朝向</th>
				</tr>
				<tr>
					<th>楼龄</th>
				</tr>
				<tr>
					<th>类型</th>
				</tr>
				<tr>
					<th>供暖</th>
				</tr>
			</table>
		</div>
		<script src="../../../js/jquery-3.4.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/crumbs.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>