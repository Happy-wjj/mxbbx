<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  //获取静态资源的绝对路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
							+ request.getServerPort() + path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="app">

<head>
<meta charset="utf-8" />
<title>添加学生信息</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%= basePath %>css/app.v2.css"
	type="text/css" />
<link rel="stylesheet" href="<%= basePath %>js/fuelux/fuelux.css"
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
								<li><a href="<%= basePath %>toWelcome"> <i
										class="fa fa-home"></i> 首页
								</a></li>
								<li><a href="<%= basePath %>point/list"> 农合经办点管理 </a></li>
								<li class="active">添加农合经办点信息</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h2 class="m-b-none">添加农合经办点信息</h2>
							</div>

							<form id="form" action="<%= basePath %>point/add" method="post"
								class="form-horizontal" data-validate="parsley">

								<!-- 表单提交按钮 -->
								<div>
									<a href="<%= basePath %>point/list" class="btn btn-default">
										<i class="fa  fa-chevron-left"></i>取消
									</a>
									<button type="submit" class="btn btn-dark">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
								<br />

								<!--增加/修改表单-->
								<section class="panel panel-default">
									<header class="panel-heading font-bold">农合经办点信息</header>
									<div class="panel-body">

										<div class="form-group">
											<label class="col-sm-4 control-label"> 行政名称 </label>
											<div class="col-sm-5">
												<%--            <s:select class="form-control" name="pointname" id="pointname"  
                                                      list="page.list" value="standardId" listKey="pointName" listValue="${point.pointname}"
                                                       headerKey="" headerValue="---请选择材料---" theme="simple"/>  --%>
												<input type="text" name="pointname" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 行政编码<font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="pointno" class="form-control"
													data-required="true" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 机构编码 </label>
											<div class="col-sm-5">
												<input type="text" name="agencyno" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 机构名称 </label>
											<div class="col-sm-5">
												<input type="text" name="agencyname" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 级别 </label>
											<div class="col-sm-5">
												<input type="text" name="level" class="form-control">
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
	<script type="text/javascript" src="<%= basePath %>js/app.v2.js"></script>
	<script type="text/javascript" src="<%= basePath %>js/fuelux/fuelux.js"></script>

	<!-- 校验 -->
	<script type="text/javascript"
		src="<%= basePath %>js/parsley/parsley.min.js"></script>
</body>

</html>