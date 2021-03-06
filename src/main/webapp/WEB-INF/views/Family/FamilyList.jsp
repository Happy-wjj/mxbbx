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
<title>家庭档案管理</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=basePath%>css/app.v2.css"
	type="text/css" />
</head>

<body>
	<%
		int i = 1;
	%>
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
								<li class="active">家庭档案管理</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h3 class="m-b-none">家庭档案列表</h3>
							</div>

							<!-- 增删改结果提示 -->
							<jsp:include page="/common/top.jsp"></jsp:include>

							<section class="panel panel-default">
								<header class="panel-heading">家庭档案管理列表</header>

								<form action="<%=basePath%>family/list" method="post"
									data-validate="parsley">
									<!-- 查询条件 -->
									<div class="row text-sm wrapper">
										<!-- 左侧条件 -->
										<div class="col-sm-10 m-b-xs">
											<div class="inline" style="margin-right:20px;">
												家庭编号 <input type="text" id="keyword" name="keyword"
													class="input-sm form-control inline" style="width: 150px;"
													placeholder="请输入家庭编码" value="${keyword}"
													data-rangelength="[4,30]">

												<button class="btn btn-sm btn-default">查询</button>
											</div>

											<a href="<%=basePath%>family/toAdd"
												class="btn btn-dark btn-sm"> <i class="fa fa-plus"></i>
												新增
											</a>

										</div>
									</div>

									<!-- 表格主体和数据 -->
									<div class="table-responsive">
										<table class="table table-striped b-t b-light text-sm">
											<!-- 顶表头 -->
											<thead>
												<tr>
													<th style="text-align: center;">序号</th>
													<th style="text-align: center;">县级编号</th>
													<th style="text-align: center;">乡镇编号</th>
													<th style="text-align: center;">村编号</th>
													<th style="text-align: center;">家庭编号</th>
													<th style="text-align: center;">户主姓名</th>
													<th style="text-align: center;">家庭人口数</th>
													<th style="text-align: center;">家庭住址</th>
													<th style="text-align: center;">家庭联系方式</th>
													<th style="text-align: center;">与户主的关系</th>
													<th style="text-align: center;">操作</th>
												</tr>
											</thead>

											<!-- 数据 -->
											<tbody>

												<%-- 判断有无数据 --%>
												<c:choose>
													<c:when test="${!empty page.list}">
														<c:forEach items="${page.list}" var="family">
															<tr>
																<td style="line-height: 30px;text-align: center;"><%=i++%></td>
																<td style="line-height: 30px;text-align: center;">${family.countyno}</td>
																<td style="line-height: 30px;text-align: center;">${family.townshipno}</td>
																<td style="line-height: 30px;text-align: center;">${family.groupno}</td>
																<td style="line-height: 30px;text-align: center;">${family.familyno}</td>
																<td style="line-height: 30px;text-align: center;">${family.mastername}</td>
																<td style="line-height: 30px;text-align: center;">${family.familynumber}</td>
																<td style="line-height: 30px;text-align: center;">${family.address}</td>
																<td style="line-height: 30px;text-align: center;">${family.tel}</td>
																<td style="line-height: 30px;text-align: center;">${family.bind}</td>
																<td style="line-height: 30px;text-align: center;">
																	<a
																	href="<%= basePath %>family/toEdit?fid=${family.fid}"
																	class="btn btn-warning btn-sm">修改</a> <a
																	href="<%= basePath %>family/delete?fid=${family.fid}"
																	class="btn btn-success btn-sm">删除</a>
																</td>
															</tr>
														</c:forEach>
													</c:when>

													<%-- 没数据 --%>
													<c:otherwise>
														<tr>
															<td style="text-align: center;" colspan="6">
																<div class="alert alert-success"
																	style="font-size: 18px;">没有找到记录</div>
															</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>

									<!-- 分页控件 -->
									<jsp:include page="/common/footer.jsp"></jsp:include>

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
	<script type="text/javascript" src="<%=basePath%>js/app.v2.js"></script>

	<!-- 获取各请求参数，组成URL -->
	<script type="text/javascript">
	
		var host = "<%=basePath%>";
	
		//获取请求的URL
		function getRequestURL(page) {
			var pageNo = page;
			var pageCount = $("#pageCount").val();
			var keyword = $("#keyword").val();
	
			var url = host + "family/list?pageNo=" + pageNo + "&pageCount=" + pageCount
				+ "&keyword=" + keyword;
			return url;
		}
	</script>

	<script type="text/javascript"
		src="<%=basePath%>js/common/manage-common.js"></script>
	<!-- 校验 -->
	<script type="text/javascript"
		src="<%=basePath%>js/parsley/parsley.min.js"></script>
</body>

</html>