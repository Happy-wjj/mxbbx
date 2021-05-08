<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/inc.jsp" %>
<%  //获取静态资源的绝对路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="app">

<head>
<meta charset="utf-8" />
<title>添加行政区域信息</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%= basePath %>css/app.v2.css"
	type="text/css" />
<link rel="stylesheet" href="<%= basePath %>js/fuelux/fuelux.css"
	type="text/css" />
	<link rel="stylesheet" href="<%= basePath %>css/bootstrap.css"
		  type="text/css" />
</head>

<body>
</div>
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
								<li><a href="<%= basePath %>area/list"> 行政区域管理 </a></li>
								<li class="active">添加行政区域信息</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h2 class="m-b-none">添加行政区域信息</h2>
							</div>

							<form id="form" action="<%= basePath %>area/add" method="post"
								class="form-horizontal" data-validate="parsley">

								<!-- 表单提交按钮 -->
								<div>
									<a href="<%= basePath %>area/list" class="btn btn-default">
										<i class="fa  fa-chevron-left"></i>取消
									</a>
									<button type="submit" class="btn btn-dark">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
								<br />

								<!--增加/修改表单-->
								<section class="panel panel-default">
									<header class="panel-heading font-bold">行政区域信息</header>
									<div class="panel-body">
										<div class="form-group col-md-3">
											<label for="provinceId">选择县级名称:</label>
											<select data-placeholder="县级名称"  name="province" id="provinceId" class="form-control"
													data-rel="chosen">
												<c:if test="${!empty provinceList}">
													<c:forEach items="${provinceList}" var="province">
														<option value="${province.provinceid}">${province.province}</option>
													</c:forEach>
												</c:if>
											</select>
										</div>
										<div class="form-group col-md-3">
											<label for="cityId">选择镇名称:</label>
											<select data-placeholder="城镇名称" name="city" id="cityId" class="form-control" data-rel="chosen">
												<option>城镇名称</option>
											</select>
										</div>
										<div class="form-group col-md-3" >
											<label for="areaId">选择村名称:</label>
											<select data-placeholder="村名称" name="area" id="areaId" class="form-control" data-rel="chosen">
												<option>选择村名称</option>
											</select>
										</div>
										<div class="form-group col-md-3" >
											<label for="groupid">选择村组名称:</label>
											<select data-placeholder="村组名称" name="gruopname" id="groupid" class="form-control" data-rel="chosen">
												<option>选择村组名称</option>
											</select>
										</div>
<%--										<div class="form-group">--%>
<%--											<label class="col-sm-4 control-label"> 区域名称 </label>--%>
<%--											<div class="col-sm-5">--%>

<%--												<input type="text" name="areaname" class="form-control" />--%>
<%--											</div>--%>
<%--										</div>--%>

<%--										<div class="form-group">--%>
<%--											<label class="col-sm-4 control-label"> 区域编码<font--%>
<%--												color="red">（必填）</font>--%>
<%--											</label>--%>
<%--											<div class="col-sm-5">--%>
<%--												<input type="text" name="cityno" class="form-control"--%>
<%--													data-required="true"/>--%>
<%--											</div>--%>
<%--										</div>--%>

<%--										<div class="form-group">--%>
<%--											<label class="col-sm-4 control-label"> 级别 </label>--%>
<%--											<div class="col-sm-5">--%>
<%--												<input type="text" name="level" class="form-control">--%>
<%--											</div>--%>
<%--										</div>--%>
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
	<script type="text/javascript">
		/*页面加载就开始执行*/
		$(document).ready(function () {
			$("#provinceId").change(function () {
				$.get("getCityByProvinceId/"+$("#provinceId").val(),function(data){
					if(data.status){
						var result = "<option>选择镇名称</option>";
						$.each(data.obj,function(n,value){
							result +="<option value='"+value.cityid+"'>"+value.city+"</option>";
						});
						$("#cityId").html('');
						$("#cityId").append(result);
					}
				},"json");
			});

			$("#cityId").change(function () {
				$.get("getAreaByCityId/"+$("#cityId").val(),function(data){
					if(data.status){
						var result = "<option>选择村名称</option>";
						$.each(data.obj,function(n,value){
							result +="<option value='"+value.areaid+"'>"+value.area+"</option>";
						});
						$("#areaId").html('');
						$("#areaId").append(result);
					}
				},"json");
			});

			$("#areaId").change(function () {
				$.get("getAreaByGroupId/"+$("#areaId").val(),function(data){
					if(data.status){
						var result = "<option>选择村组名称</option>";
						$.each(data.obj,function(n,value){
							console.log(value)
							result +="<option value='"+value.groupid+"'>"+value.gruopname+"</option>";
						});
						$("#groupid").html('');
						$("#groupid").append(result);
					}
				},"json");
			});
		});
	</script>

</body>

</html>