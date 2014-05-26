<%@ page pageEncoding="utf-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]--><!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]--><!--[if !IE]><!--><html lang="en" class="no-js"><!--<![endif]--><!-- BEGIN HEAD --><%@ include file="common/global.jsp"%><head><meta charset="utf-8" /><meta content="width=device-width, initial-scale=1.0" name="viewport" /><%@ include file="common/head-content.jsp"%></head><!-- END HEAD --><!-- BEGIN BODY --><body class="page-header-fixed">	<%@ include file="common/header.jsp"%>	<!-- BEGIN CONTAINER -->	<div class="page-container">		<!-- BEGIN SIDEBAR -->		<div class="page-sidebar nav-collapse collapse">			<%@ include file="common/sideBar.jsp"%>		</div>		<!-- END SIDEBAR -->		<!-- BEGIN PAGE -->		<div class="page-content">			<!-- BEGIN PAGE CONTAINER-->			<div class="container-fluid">				<!-- BEGIN PAGE HEADER-->				<div class="row-fluid">					<div class="span12">						<!-- BEGIN STYLE CUSTOMIZER -->						<div class="color-panel hidden-phone">							<div class="color-mode-icons icon-color"></div>							<div class="color-mode-icons icon-color-close"></div>							<div class="color-mode">								<p>主题颜色</p>								<ul class="inline">									<li class="color-black current color-default"										data-style="default"></li>									<li class="color-blue" data-style="blue"></li>									<li class="color-brown" data-style="brown"></li>									<li class="color-purple" data-style="purple"></li>									<li class="color-grey" data-style="grey"></li>									<li class="color-white color-light" data-style="light"></li>								</ul>								<label> <span>布局(Layout)</span> <select									class="layout-option m-wrap small">										<option value="fluid" selected>流式布局(Fluid)</option>										<option value="boxed">盒式布局(Boxed)</option>								</select>								</label> <label> <span>标题(Header)</span> <select									class="header-option m-wrap small">										<option value="fixed" selected>固定(Fixed)</option>										<option value="default">默认(Default)</option>								</select>								</label> <label> <span>边栏(SideBar)</span> <select									class="sidebar-option m-wrap small">										<option value="fixed">固定(Fixed)</option>										<option value="default" selected>默认(Default)</option>								</select>								</label> <label> <span>底部(Footer)</span> <select									class="footer-option m-wrap small">										<option value="fixed">固定(Fixed)</option>										<option value="default" selected>默认(Default)</option>								</select>								</label>							</div>						</div>						<!-- END BEGIN STYLE CUSTOMIZER -->						<!-- BEGIN PAGE TITLE & BREADCRUMB-->						<h3 class="page-title">							<b>Kalor</b> <small>快速、敏捷、不凡 ...</small>						</h3>						<ul class="breadcrumb">							<li><i class="icon-home"></i> <a href="index">Home</a> <i								class="icon-angle-right"></i></li>							<li><a href="#">首页</a></li>						</ul>						<!-- END PAGE TITLE & BREADCRUMB-->					</div>				</div>				<!-- END PAGE HEADER-->				<div id="IndexMainPage">					<!-- BEGIN Kalor STATS -->					<div class="row-fluid">						<div class="span3 responsive" data-tablet="span6"							data-desktop="span3">							<div class="dashboard-stat green">								<div class="visual">									<i class="icon-user"></i>								</div>								<div class="details">									<div class="number">154</div>									<div class="desc">注册用户</div>								</div>								<a class="more" href="#"> 更多 <i									class="m-icon-swapright m-icon-white"></i>								</a>							</div>						</div>						<div class="span3 responsive" data-tablet="span6"							data-desktop="span3">							<div class="dashboard-stat blue">								<div class="visual">									<i class="icon-comments"></i>								</div>								<div class="details">									<div class="number">549</div>									<div class="desc">主题</div>								</div>								<a class="more" href="#"> 更多 <i									class="m-icon-swapright m-icon-white"></i>								</a>							</div>						</div>						<div class="span3 responsive" data-tablet="span6  fix-offset"							data-desktop="span3">							<div class="dashboard-stat purple">								<div class="visual">									<i class="icon-globe"></i>								</div>								<div class="details">									<div class="number">+43</div>									<div class="desc">前沿动态</div>								</div>								<a class="more" href="#"> 更多 <i									class="m-icon-swapright m-icon-white"></i>								</a>							</div>						</div>						<div class="span3 responsive" data-tablet="span6"							data-desktop="span3">							<div class="dashboard-stat yellow">								<div class="visual">									<i class="icon-book"></i>								</div>								<div class="details">									<div class="number">27</div>									<div class="desc">解决方案</div>								</div>								<a class="more" href="#"> 更多 <i									class="m-icon-swapright m-icon-white"></i>								</a>							</div>						</div>					</div>					<!-- END Kalor STATS -->					<div class="clearfix"></div>					<div class="row-fluid">						<div class="span6">							<!-- 消息动态 -->							<%@include file="index/tendency.jsp" %>						</div>						<div class="span6">							<!-- 留言 -->							<%@include file="index/leaveMsg.jsp" %>						</div>					</div>					<div class="clearfix"></div>					<div class="row-fluid">						<!-- server信息 -->						<%@include file="index/serverInfo.jsp" %>					</div>				</div>			</div>			<!-- END PAGE CONTAINER-->		</div>		<!-- END PAGE -->	</div>	<!-- END CONTAINER -->	<%@ include file="common/bottom.jsp"%>	<script type="text/javascript">// 		var _gaq = _gaq || [];//         _gaq.push(['_setAccount', 'UA-37564768-1']);//         _gaq.push(['_setDomainName', 'keenthemes.com']);//         _gaq.push(['_setAllowLinker', true]);//         _gaq.push(['_trackPageview']);//         (function() {// 	        var ga = document.createElement('script');// 	        ga.type = 'text/javascript';// 	        ga.async = true;// 	        ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';// 	        var s = document.getElementsByTagName('script')[0];// 	        s.parentNode.insertBefore(ga, s);//         })();	</script></body><!-- END BODY --></html>