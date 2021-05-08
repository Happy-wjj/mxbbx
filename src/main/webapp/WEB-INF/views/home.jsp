<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  //获取静态资源的绝对路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
							+ request.getServerPort() + path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" href="<%= basePath %>css/app.v2.css"
	type="text/css" />
</head>

<body>
	<!-- 面包屑导航 -->
	<ul class="breadcrumb no-border no-radius b-b b-light">
		<li><a href="<%= basePath %>toWelcome"> <i class="fa fa-home"></i>
				首页
		</a></li>
	</ul>

	<!-- 欢迎信息 -->
	<section class="panel panel-default"
		style="border-bottom: 0px;margin-left: 15px; margin-right: 15px;">
		<div class="hero-unit well"
			style="background: url(<%= basePath%>images/bg.jpg);">
			<h1 style="color: #FFFFFF;">
				${sessionScope.user.usertruename}，您好！欢迎使用慢性病报销系统！</h1>
			<h3 style="color: #FFFFFF;">本系统旨在帮助农合经办人方便快捷计算结果，并且报销慢性病！</h3>
		</div>
	</section>

	<h3 style="text-align: center;">慢性病报销数据统计</h3>
	<section class="panel panel-default"
		style="margin-left:15px; margin-right: 15px;">
		<div class="row m-l-none m-r-none bg-light lter">
			<!-- 收到公文 -->
			<div class="col-sm-6 col-md-3 padder-v b-r b-light">
				<span class="fa-stack fa-2x pull-left m-r-sm"> <i
					class="fa fa-circle fa-stack-2x text-success"></i> <i
					class="fa fa-envelope fa-stack-1x text-white"></i>
				</span> <a class="clear" href="<%= basePath %>article/getMyReceiveList">
					<span class="h3 block m-t-xs"> <strong>${receivecount}</strong>
				</span> <small class="text-muted text-uc">私信预约</small>
				</a>
			</div>

			<!-- 待处理公文：只有审核人员和管理员才可以看到 -->
			<c:if
				test="${sessionScope.user.roleId == 1 || sessionScope.user.roleId == 2}">
				<div class="col-sm-6 col-md-3 padder-v b-r b-light">
					<span class="fa-stack fa-2x pull-left m-r-sm"> <i
						class="fa fa-circle fa-stack-2x text-warning"></i> <i
						class="fa fa-flask fa-stack-1x text-white"></i>
					</span> <a class="clear" href="<%= basePath %>article/toAduit"> <span
						class="h3 block m-t-xs"> <strong>${dealcount}</strong>
					</span> <small class="text-muted text-uc">今日已报销人数</small>
					</a>
				</div>
			</c:if>

			<!-- 被驳回公文 -->
			<div class="col-sm-6 col-md-3 padder-v b-r b-light">
				<span class="fa-stack fa-2x pull-left m-r-sm"> <i
					class="fa fa-circle fa-stack-2x text-danger"></i> <i
					class="fa fa-ban fa-stack-1x text-white"></i>
				</span> <a class="clear" href="<%= basePath %>article/toAduitResult"> <span
					class="h3 block m-t-xs"> <strong>${failcount}</strong>
				</span> <small class="text-muted text-uc">不符合条件人数</small>
				</a>
			</div>

			<!-- 等待审核通过公文 -->
			<div class="col-sm-6 col-md-3 padder-v b-r b-light">
				<span class="fa-stack fa-2x pull-left m-r-sm"> <i
					class="fa fa-circle fa-stack-2x icon-muted"></i> <i
					class="fa fa-clock-o fa-stack-1x text-white"></i>
				</span> <a class="clear" href="<%= basePath %>article/toAduitResult"> <span
					class="h3 block m-t-xs"> <strong>${waitcount}</strong>
				</span> <small class="text-muted text-uc">等待审核</small>
				</a>
			</div>
		</div>
	</section>

	<!-- 小贴士 -->
	<div class="col-lg-6">
		<section class="panel panel-default">
			<div class="carousel slide auto panel-body" id="c-slide">
				<ol class="carousel-indicators out">
					<li data-target="#c-slide" data-slide-to="0" class="active"></li>
					<li data-target="#c-slide" data-slide-to="1" class=""></li>
					<li data-target="#c-slide" data-slide-to="2" class=""></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<p class="text-center">
							<em class="h4 text-mute">极大地提高您的工作效率</em><br> <small
								class="text-muted">系统内置很多小组件，帮助您快速地完成工作任务！</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">适应多种终端，随时随地工作</em><br> <small
								class="text-muted"> 响应式网页设计使得您可以在您的移动设备上完成工作，就像在计算机上那样！
							</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">人性化的界面设计</em><br> <small
								class="text-muted">界面设计使得您与系统的交互轻松而自然，帮助您快速适应系统环境！</small>
						</p>
					</div>
				</div>
				<!-- 左右切换键 -->
				<a class="left carousel-control" href="#c-slide" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				</a> <a class="right carousel-control" href="#c-slide" data-slide="next">
					<i class="fa fa-angle-right"></i>
				</a>
			</div>
		</section>
	</div>

	<!-- 公文管理流程 -->
	<div class="col-lg-6">
		<section class="panel bg-dark">
			<div class="carousel slide carousel-fade panel-body" id="c-fade">
				<ol class="carousel-indicators out">
					<li data-target="#c-fade" data-slide-to="0" class="active"></li>
					<li data-target="#c-fade" data-slide-to="1" class=""></li>
					<li data-target="#c-fade" data-slide-to="2" class=""></li>
					<li data-target="#c-fade" data-slide-to="3" class=""></li>
					<li data-target="#c-fade" data-slide-to="4" class=""></li>
					<li data-target="#c-fade" data-slide-to="5" class=""></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<p class="text-center">
							<em class="h4 text-mute">慢性病报销流程</em><br> <small
								class="text-muted">下面来简单介绍一下系统中的慢性病报销流程。</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">Step 1:</em><br> <small
								class="text-muted">农合经办人点击慢性病报销链接;系统显示身份证号输入界面;农合经办人输入身份证号;系统判断该身份证号是否参合;</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">Step 2:</em><br> <small
								class="text-muted">系统显示参合人员信息及慢性病就诊信息录入界面;农合经办人录入慢性病就诊信息;系统判断慢性病就诊信息是否合法;系统保存慢性病就诊信息;
							</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">Step 3:</em><br> <small
								class="text-muted">系统判断就诊时间是否在慢性病证
								有效期内及疾病是否一致;系统显示慢性病就诊信息要求确认;农合经办人确认慢性病就诊信息; </small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">Step 4:</em><br> <small
								class="text-muted">系统读取当前年度的慢性病报销比例和封顶线;系统统计当前年度已报销慢性病金额;系统计算本次慢性病报销金额;系统显示本次慢性病报销信息要求确认;
							</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">Step 5:</em><br> <small
								class="text-muted">农合经办人确认本次慢性病报销信息;系统保存本次慢性病报销信息;系统打印签领表。

							</small>
						</p>
					</div>
					<div class="item">
						<p class="text-center">
							<em class="h4 text-mute">FAQ:我的填写被退回怎么办？</em><br> <small
								class="text-muted">审核不通过的慢性病报销表会被退回，您可以修改被退回的慢性病表。</small>
						</p>
					</div>
				</div>
				<a class="left carousel-control" href="#c-fade" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				</a> <a class="right carousel-control" href="#c-fade" data-slide="next">
					<i class="fa fa-angle-right"></i>
				</a>
			</div>
		</section>
	</div>
</body>
<script type="text/javascript" src="<%= basePath %>js/app.v2.js"></script>

</html>