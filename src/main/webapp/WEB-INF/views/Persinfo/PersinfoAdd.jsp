<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//获取静态资源的绝对路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="app">

<head>
<meta charset="utf-8" />
<title>完善参合登记信息</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=basePath%>css/app.v2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>js/fuelux/fuelux.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>js/bootstrap/css/bootstrap.min.css" type="text/css" />
</head>

<body>
	<section class="vbox">
		<section>
			<section class="hbox stretch">
				<section id="content">
					<section class="vbox">
						<section class="scrollable padder">
							<!-- 面包屑导航 -->
							<ul class="breadcrumb no-border no-radius b-b b-light pull-in">
								<li><a href="<%=basePath%>toWelcome"> <i
										class="fa fa-home"></i> 首页
								</a></li>
								<li><a href="<%=basePath%>persinfo/list"> 参合登记管理 </a></li>
								<li class="active">添加参合登记信息</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h2 class="m-b-none">添加参合登记信息</h2>
							</div>

							<form id="form" action="<%=basePath%>family/addper" method="post"
								class="form-horizontal" data-validate="parsley">

								<!-- 表单提交按钮 -->
								<div>
									<a href="<%=basePath%>persinfo/perfamily"
										class="btn btn-default"> <i class="fa  fa-chevron-left"></i>取消
									</a>
									<button type="submit" class="btn btn-dark">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
								<br /> <input type="hidden" name="fid" value="${family.fid}">
								<!--增加/修改表单-->
								<section class="panel panel-default">
									<header class="panel-heading font-bold">参合登记信息</header>
									<div class="panel-body">

										<div class="form-group">
											<label class="col-sm-4 control-label"> 姓名 </label>
											<div class="col-sm-5">
												<input type="text" name="persname"
													value="${family.mastername}" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭住址 </label>
											<div class="col-sm-5">
												<input type="text" name="address" value="${family.address}"
													class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭联系方式<font
												color="red"></font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="tel" value="${family.tel}"
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">身份证号 <font
												color="red">（必填）</font></label>
											<div class="col-sm-5">
												<input type="text" name="cardno" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">性别<font
												color="red">（必填）</font>
											</label> <label class="radio-inline"> <input
												style="margin-left: 5px" type="radio" name="sex" value="男">男
											</label> <label class="radio-inline"> <input
												style="margin-left: 5px" type="radio" name="sex" value="女">女
											</label>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">年龄 <font
												color="red">（必填）</font></label>
											<div class="col-sm-5">
												<input type="text" name="age" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 参合时间 <font
												color="red">（必填）</font></label>
											<div class="input-group date form_date col-sm-5">
												<input type="text" name="joinyear" class="form-control" />
												<span class="input-group-addon"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 参合证号 <font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="persnumber" class="form-control" />
											</div>
										</div>
									</div>
								</section>
							</form>
						</section>
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen" data-target="#nav"></a>
				</section>
				<aside class="bg-light lter b-l aside-md hide" id="notes">
					<div class="wrapper">Notification</div>
				</aside>
			</section>
		</section>
	</section>

	<!-- Bootstrap -->
	<!-- App -->
	<script type="text/javascript" src="<%=basePath%>js/app.v2.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/fuelux/fuelux.js"></script>

	<!-- 校验 -->
	<script type="text/javascript"
		src="<%=basePath%>js/parsley/parsley.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/bootstrap-jquery-tree/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript">
		$('.form_datetime').datetimepicker({
			//language:  'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1
		});
		$('.form_date').datetimepicker({
			language : 'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
		$('.form_time').datetimepicker({
			language : 'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 1,
			minView : 0,
			maxView : 1,
			forceParse : 0
		});
	</script>

</body>

</html>