$(function() {
	$(".table-bordered>tbody>tr>td").click(function() {
		var flag = $(this).children("input").is(':checked');
		if(!flag)
			$(this).children("input").prop("checked", true);
		if(flag)
			$(this).children("input").prop("checked", false);

        var id = $(this).children("input").attr("data-id");
        var typeNum = $(this).children("input").attr("data-typeNum");
        console.log(id, typeNum);
		if(!flag){
            if(typeNum == 100001){
                $("#multi-form").children("input[name='floorType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='floorType.id']").val());
            }
            if(typeNum == 100002){
                $("#multi-form").children("input[name='orieType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='orieType.id']").val());
            }
            if(typeNum == 100003){
                $("#multi-form").children("input[name='ageType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='ageType.id']").val());
            }
            if(typeNum == 100004){
                $("#multi-form").children("input[name='priceType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='priceType.id']").val());
            }
            if(typeNum == 100005){
                $("#multi-form").children("input[name='houseType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='houseType.id']").val());
            }
            if(typeNum == 100006){
                $("#multi-form").children("input[name='areaType.id']").val(id);
            }
		}else{
            if(typeNum == 100001){
                $("#multi-form").children("input[name='floorType.id']").val(null);
            }
            if(typeNum == 100002){
                $("#multi-form").children("input[name='orieType.id']").val(null);
            }
            if(typeNum == 100003){
                $("#multi-form").children("input[name='ageType.id']").val(null);
            }
            if(typeNum == 100004){
                $("#multi-form").children("input[name='priceType.id']").val(null);
            }
            if(typeNum == 100005){
                $("#multi-form").children("input[name='houseType.id']").val(null);
            }
            if(typeNum == 100006){
                $("#multi-form").children("input[name='areaType.id']").val(null);
            }
        }
        $("#multi-form").submit();
	});


});
