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
<title>参合登记管理</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%= basePath %>css/app.v2.css"
	type="text/css" />
</head>

<body>
	<%int i=1; %>
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
								<li class="active">参合登记管理</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h3 class="m-b-none">参合登记列表</h3>
							</div>

							<!-- 增删改结果提示 -->
							<jsp:include page="/common/top.jsp"></jsp:include>

							<section class="panel panel-default">
								<header class="panel-heading">参合登记管理列表</header>

								<form action="<%= basePath %>persinfo/perfamily" method="post"
									data-validate="parsley">
									<!-- 查询条件 -->
									<div class="row text-sm wrapper">
										<!-- 左侧条件 -->
										<div class="col-sm-10 m-b-xs">
											<div class="inline" style="margin-right:20px;">
												户主姓名 <input type="text" id="keyword" name="keyword"
													class="input-sm form-control inline" style="width: 150px;"
													placeholder="请输入户主姓名" value="${keyword}"
													data-rangelength="[0,30]">
												<button class="btn btn-sm btn-default">查询</button>
											</div>
										</div>
									</div>
								</form>
							</section>
						</section>
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen" data-target="#nav"></a>
				</section>
			</section>
		</section>
	</section>
	<script type="text/javascript" src="<%= basePath %>js/app.v2.js"></script>

	<!-- 获取各请求参数，组成URL -->
	<script type="text/javascript">
		
			var host="<%= basePath %>";
			
			//获取请求的URL
			function getRequestURL(page) {
				
				var pageNo = page;
				var pageCount = $("#pageCount").val();
				var keyword = $("#keyword").val();
				
				var url = host + "persinfo/list?pageNo=" + pageNo + "&pageCount=" + pageCount 
							+ "&keyword=" + keyword;
				return url;
			}
		
		</script>

	<script type="text/javascript"
		src="<%= basePath %>js/common/manage-common.js"></script>
	<!-- 校验 -->
	<script type="text/javascript"
		src="<%= basePath %>js/parsley/parsley.min.js"></script>
</body>

</html>