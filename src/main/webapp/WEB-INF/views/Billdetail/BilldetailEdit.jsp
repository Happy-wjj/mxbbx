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
<title>慢性病报销信息</title>
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
								<li><a href="<%= basePath %>billdetail/list"> 慢性病报销管理 </a>
								</li>
								<li class="active">修改慢性病报销信息</li>
							</ul>

							<!-- 表格标题 -->
							<div class="m-b-md">
								<h2 class="m-b-none">修改慢性病报销信息</h2>
							</div>

							<form id="form" action="<%= basePath %>billdetail/edit"
								method="post" class="form-horizontal" data-validate="parsley">

								<!-- 表单提交按钮 -->
								<div>
									<a href="<%= basePath %>billdetail/list"
										class="btn btn-default"> <i class="fa  fa-chevron-left"></i>取消
									</a>
									<button type="submit" class="btn btn-dark">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
								<br />

								<!--增加/修改表单-->
								<section class="panel panel-default">
									<header class="panel-heading font-bold">慢性病报销信息</header>
									<div class="panel-body">

										<input type="hidden" name="id" value="${billdetail.id}">


										<div class="form-group">
											<label class="col-sm-4 control-label"> 报销单号 </label>
											<div class="col-sm-5">
												<input type="text" name="billno" class="form-control"
													value="${billdetail.billno}" readonly="true">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 慢病症号 </label>
											<div class="col-sm-5">
												<input type="text" name="mbno" class="form-control"
													value="${billdetail.mbno}" readonly="true">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 身份证号 </label>
											<div class="col-sm-5">
												<input type="text" name="cardno" class="form-control"
													value="${billdetail.cardno}" readonly="true">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 封顶线 </label>
											<div class="col-sm-5">
												<input type="text" name="maxline" class="form-control"
													value="${zcpolicy.maxline}" readonly="true" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label"> 已报销金额 </label>
											<div class="col-sm-5">
												<input type="text" name="allcost" class="form-control"
													value="${billdetail.allcost}" readonly="true">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> 本次报销金额<font
												color="red">（必填）</font>
											</label>
											<div class="col-sm-5">
												<input type="text" name="bxpay" class="form-control"
													placeholder="本次报销金额的最大值=封顶线-已报销金额">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-4 control-label"> </label>
											<div class="col-sm-5">
												<span><font color="red">本次报销金额的最大值若大于封顶线-已报销金额，或者没有填写本次报销金额，则会停留在此界面，不能跳转到其他界面</font></span>
											</div>
										</div>

										<%-- <div class="form-group">
	                                            <label class="col-sm-4 control-label">
	                                            	发票
	                                            </label>
	                                            <div class="col-sm-5">
	                                                <input type="text" name="treatinno" class="form-control" value="${billdetail.treatinno}">
	                                            </div>
	                                        </div>
	                                        
	                                        <div class="form-group">
	                                            <label class="col-sm-4 control-label">
	                                            	就诊机构
	                                            </label>
	                                            <div class="col-sm-5">
	                                                <input type="text" name="treatagenname" class="form-control" 
	                                                	value="${billdetail.treatagenname}">
	                                            </div>
	                                        </div> --%>

										<%-- 
	                                        <div class="form-group">
	                                            <label class="col-sm-4 control-label">参合发票</label>
	                                            
	                                            <div class="col-sm-5">
	                                                <select name="id" class="form-control m-b">
	                                                	<c:forEach items="${persinfo}" var="persinfo">
	                                                		<option value="${persinfo.id}"
	                                                			<c:if test="${persinfo.id == user.persinfo.perid}">selected = "selected"</c:if>
	                                                		>${persinfo.invnumber}</option>
	                                                	</c:forEach>
	                                                </select>
	                                            </div>
	                                        </div> --%>

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