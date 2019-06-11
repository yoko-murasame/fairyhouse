<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Bootstrap 实例 - 模态框（Modal）插件</title>
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
	<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="../../../js/gritter/css/jquery.gritter.css" />
	<script type="text/javascript" src="../../../js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="../../../js/common.js"></script>
	<script type="text/javascript">
        var flag = false;
        $(document).ready(function() {
            $("#user").blur(function() {
                var phone = $("#user").val();
                if (phone.length==0) {
                    showGritter("消息","手机号不能为空!");
                    flag = false;
                } else if (!(/^1[3456789]\d{9}$/.test(phone))) {
                    showGritter("消息","请输入正确的手机号!");
                    flag = false;
                } else {
                    flag = true;
                }
            });
        });
	</script>
</head>
<style type="text/css">
	ul {
		list-style: none;
		margin: 0;
		padding: 0;
		display: block;
		list-style-type: disc;
	}

	li {
		list-style: none;
	}

	.input-group {
		width: 100%;
		text-align: center;
		margin: 0 auto;
	}

	#input_div_tel {
		margin: 20px 0;
	}

	#check {
		margin-left: 300px;
	}

	#user,#message_code{
		width: 50%;
		margin-left: 25%;
	}

	#message_code{
		margin-bottom: 20px;
	}

	#phone_reg {
		margin: 20px 280px 10px 0px;
	}

	#message_code_div {
		margin-top: 10px;
		margin-bottom: 20px;
		margin-right: 120px;
	}

	#input_div_check {
		margin: 20px 0 20px 0;
	}

	#input-group_code {
		margin: 20px 0 0 0;
	}
</style>

<body>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					账号密码登录
				</h4>
			</div>
			<div class="input-group" id="input_div_tel">
				<input type="text" placeholder="请输入手机号" maxlength="11" class="form-control" id="user" />
			</div>
			<div class="input-group" id="input_div_code">
				<input type="text" placeholder="请输入短信验证码" maxlength="11" class="form-control" id="message_code" />
			</div>

			<div class="modal-footer">
				<button class="btn" id="btnSendSms">发送验证码</button>
				<button type="button" class="btn" id="reg">
					登录
				</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

	<script>
		$(function () {
            $("#btnSendSms").click(function () {
				var phone = $("#user").val();
				var btn = $(this);
                if (flag) {
					getPostAjaxPromise("/sendSms",{phone:phone}).then(function (res) {
                        if (res.status == 200) {
                            showGritter("消息",res.msg);
                            btn.attr("disabled",true);
                        }else {
                            showGritter("错误", res.msg);
						}
					})
                }else{
					showGritter("消息","手机号不正确!");
				}
            });

            $("#reg").click(function () {
                var phone = $("#user").val();
                var code = $("#message_code").val();
                getPostAjaxPromise("/verifyUser",{phone:phone,smsCode:code}).then(function (res) {
                    if (res.status == 200) {
                        showGritter("消息",res.msg);
                        setTimeout(function () {
							window.location.href = "${pageContext.request.contextPath}/user/favorHouse";
                        }, 2000);
                    }else {
                        showGritter("错误", res.msg);
                    }
				})
            })
        })
	</script>
</div>
</body>

</html>