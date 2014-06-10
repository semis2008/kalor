<%@ page pageEncoding="utf-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]--><!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]--><!-- BEGIN HEAD --><%@ include file="common/global.jsp"%><head><meta charset="utf-8" /><meta content="width=device-width, initial-scale=1.0" name="viewport" /><%@ include file="common/head-content.jsp"%><link href="<%=staticPath%>/css/index.css" rel="stylesheet"	type="text/css" /></head><!-- END HEAD --><!-- BEGIN BODY --><body>	<%@ include file="common/header.jsp"%>	<!-- BEGIN CONTAINER -->	<div id="content">		<!-- 设置需要显示的属性 -->		<c:set var="leftHotDiary" scope="request" value="${leftHotDiary }" />		<c:set var="rightHotDiary" scope="request" value="${rightHotDiary }" />		<c:set var="topDiary" scope="request" value="${topDiary }" />		<header class="no-radius image hero-unit" id="banner-head">			<div class="container text-center margin-top-middle">				<h1>					<img alt="Kalor" src="<%=staticPath%>/img/logo.png">				</h1>			</div>			<div class="text-center logo-info">				<h2>					<a href="#">Kalor</a> <small><em class="text-info">-							-或许可以做成一个最简捷的社区~</em> </small>				</h2>			</div>		</header>		<div id="main-wrapper" class="container">			<div class="row">				<div class="span3">					<div class="sidebar">						<!-- Sidebar -->						<!-- Recent Posts -->						<section>							<h3 class="major">								<span><i class="icon-list-ul"></i> 最新博文</span>							</h3>							<ul class="unstyled side-ul">								<c:forEach items="${latestDiaries }" var="diary">									<li>										<h5>											<a href="<%=contextPath %>/blog/${diary.id }"><i												class="icon-file-alt"></i> <c:choose>													<c:when test="${fn:length(diary.title) > 13}">														<c:out value="${fn:substring(diary.title, 0, 13)}..."															escapeXml="true" />													</c:when>													<c:otherwise>														<c:out value="${diary.title}" escapeXml="true" />													</c:otherwise>												</c:choose> </a>										</h5>										<ul class="meta inline">											<li><i class="icon-time"></i><a												href="javascript:void(0);"> <fmt:formatDate														value="${diary.publish_time }" type="date"														dateStyle="long" /></a></li>											<li><i class="icon-comment"></i><a												href="javascript:void(0);"> ${diary.reply_num}</a></li>										</ul>									</li>								</c:forEach>							</ul>							<a class="button button-alt" href="#">查看全部 <i								class=" icon-hand-right"></i>							</a>						</section>						<!-- /Recent Posts -->						<!-- 活跃用户 -->						<section id="activeUserSec">							<h3 class="major">								<span><i class="icon-user-md"></i> 活跃用户</span>							</h3>							<ul class="unstyled inline">								<c:forEach items="${activeUsers }" var="user">									<li class="padding-mini"><a href="#" title="${user.name }">											<img src="<%=staticPath %>/${user.photo}"											class="img-polaroid" width="32px" height="32px" alt="">											<span class="activeUserName text-center">${user.name}										</span>									</a></li>								</c:forEach>							</ul>							<a class="button button-alt" href="javascript:void(0)">查看全部 <i								class="icon-hand-right"></i>							</a>						</section>						<!-- /活跃用户 -->						<!-- 留言 -->						<section id="leaveMsgListSec">							<h3 class="major">								<span><i class="icon-envelope-alt"></i> 留言</span>							</h3>							<ul class="unstyled quote-list">								<c:forEach items="${leaveMsgs }" var="msg">									<li><a href="#" title="${msg.name }"><img											src="<%=staticPath %>${msg.user_photo }" class="img-polaroid"											width="40px" height="40px" alt="" /> </a>										<p title="${msg.msg }">											<c:choose>												<c:when test="${fn:length(msg.msg) > 15}">													<c:out value="${fn:substring(msg.msg, 0, 15)}......"														escapeXml="true" />												</c:when>												<c:otherwise>													<c:out value="${msg.msg}" escapeXml="true" />												</c:otherwise>											</c:choose>										</p> <span>-- <a href="#" title="${msg.name }">${msg.name												}</a>, <em><fmt:formatDate value="${msg.leave_time }"													type="date" dateStyle="long" /></em>									</span></li>								</c:forEach>							</ul>							<a class="button button-alt" href="#">查看全部 <i								class=" icon-hand-right"></i>							</a>						</section>						<!-- /留言 -->						<!-- 热门标签 -->						<section id="hotTagSec">							<h3 class="major">								<span><i class="icon-tags"></i> Hot Tags</span>							</h3>							<p>								<c:forEach items="${hotTags }" var="tag">									<a href="#" class="margin-small tagSize${tag.weight }">${tag.name}</a>								</c:forEach>							</p>						</section>						<!-- /热门标签 -->						<!-- /Sidebar -->					</div>				</div>				<div class="span9" id="right-content">					<!-- 引入indexPageHtml -->					<%@ include file="indexPageHtml.jsp"%>				</div>			</div>		</div>	</div>	<!-- 底部 -->	<%@ include file="common/bottom.jsp"%>	<script src="<%=staticPath%>/js/goTop.js<%=version%>"		type="text/javascript"></script></body></html>