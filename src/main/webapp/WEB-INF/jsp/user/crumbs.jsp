<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/crumbs.css"/>
</head>

<body>
<div id="crumbs-table-container" style="width: 70%;">
    <form action="/second/toSecondList" method="post" id="multi-form">
        <input type="hidden" name="communityEntity.addressHead.areaName"
               value="${houseSearch.communityEntity.addressHead.areaName}">
        <input type="hidden" name="priceType.id" value="${houseSearch.priceType.id}">
        <input type="hidden" name="houseType.id" value="${houseSearch.houseType.id}">
        <input type="hidden" name="areaType.id" value="${houseSearch.areaType.id}">
        <input type="hidden" name="floorType.id" value="${houseSearch.floorType.id}">
        <input type="hidden" name="orieType.id" value="${houseSearch.orieType.id}">
        <input type="hidden" name="ageType.id" value="${houseSearch.ageType.id}">
        <input type="hidden" name="sortField" value="${sortField}">

        <table class="table table-bordered" id="crumbs">
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
                    <td>
                        <input
                                <c:if test="${houseSearch.floorType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>朝向</th>
                <c:forEach items="${dictMap['朝向']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.orieType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>楼龄</th>
                <c:forEach items="${dictMap['楼龄']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.ageType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>售价</th>
                <c:forEach items="${dictMap['售价']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.priceType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>房型</th>
                <c:forEach items="${dictMap['房型']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.houseType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>面积</th>
                <c:forEach items="${dictMap['面积']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.areaType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <%--<tr>
                <th>用途</th>
                <c:forEach items="${dictMap['用途']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>
            <tr>
                <th>电梯</th>
                <c:forEach items="${dictMap['电梯']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>
            <tr>
                <th>装修</th>
                <c:forEach items="${dictMap['装修']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>
            <tr>
                <th>供暖</th>
                <c:forEach items="${dictMap['供暖']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>
            <tr>
                <th>权属</th>
                <c:forEach items="${dictMap['权属']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>
            <tr>
                <th>楼房类型</th>
                <c:forEach items="${dictMap['楼房类型']}" var="dict">
                    <td><input type="checkbox"><span>${dict.typeDescription}</span></td>
                </c:forEach>
            </tr>--%>
        </table>
    </form>
</div>
<script src="../../../js/crumbs.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>