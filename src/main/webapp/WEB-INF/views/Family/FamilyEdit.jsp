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
<title>家庭档案信息</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=basePath%>css/app.v2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>js/fuelux/fuelux.css"
	type="text/css" />
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
								<li><a href="<%=basePath%>family/list"> 家庭档案管理 </a></li>
								<li class="active">修改家庭档案信息</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h2 class="m-b-none">修改家庭档案信息</h2>
							</div>
							<form id="form" action="<%=basePath%>family/edit" method="post"
								class="form-horizontal" data-validate="parsley">
								<!-- 表单提交按钮 -->
								<div>
									<a href="<%=basePath%>family/list" class="btn btn-default">
										<i class="fa  fa-chevron-left"></i>取消
									</a>
									<button type="submit" class="btn btn-dark">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
								<br />
								<!--增加/修改表单-->
								<section class="panel panel-default">
									<header class="panel-heading font-bold">家庭档案信息</header>
									<div class="panel-body">
										<input type="hidden" name="fid" value="${family.fid}">
										<div class="form-group">
											<label class="col-sm-4 control-label"> 县级编号 </label>
											<div class="col-sm-5">
												<input type="text" name="countyno" class="form-control"
													value="${family.countyno}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">乡镇编号<font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="townshipno" class="form-control"
													value="${family.townshipno}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">村编号<font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="groupno" class="form-control"
													value="${family.groupno}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭编号<font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="familyno" class="form-control"
													value="${family.familyno}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 户主姓名 </label>
											<div class="col-sm-5">
												<input type="text" name="mastername" class="form-control"
													value="${family.mastername}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭人口数 </label>
											<div class="col-sm-5">
												<input type="text" name="familynumber" class="form-control"
													value="${family.familynumber}">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭住址 </label>
											<div class="col-sm-5">
												<input type="text" name="address" class="form-control"
													value="${family.address}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 家庭联系方式 </label>
											<div class="col-sm-5">
												<input type="text" name="tel" class="form-control"
													value="${family.tel}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 与户主的关系 </label>
											<div class="col-sm-5">
												<input type="text" name="bind" class="form-control"
													value="${family.bind}">
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
</body>

</html>