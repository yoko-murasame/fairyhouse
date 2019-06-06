$(function() {
	$(".table-bordered>tbody>tr>td").click(function() {
		var flag = $(this).children("input").is(':checked');
		if(!flag)
			$(this).children("input").prop("checked", true);
		if(flag)
			$(this).children("input").prop("checked", false);
	});
});