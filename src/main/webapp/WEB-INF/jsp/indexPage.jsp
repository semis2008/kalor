<%@ page pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="common/global.jsp"%>
<%-- global set --%>
<html>
<head>
<%@ include file="common/head-content.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<%=cssPath%>/index.css<%=version%>" />
</head>
<body>
	<%@ include file="common/head.jsp"%>
	<div id="content">
		<header class="no-radius image" id="banner-head">
			<div class="container text-center">
				<h2>
					<img alt="WN Java" src="<%=imgPath%>/logo.png">
				</h2>
			</div>
			<div class="text-center logo-info">
				<h2>
					<a href="#">Wn Java</a> <small><em class="text-info">-
							-或许可以做成一个最简捷的社区~</em> </small>
				</h2>
			</div>
		</header>
		<div id="main-wrapper" class="container">
			<div>
				<div class="span3">
					<div class="sidebar">
						<!-- 最新日志 -->
						<section>
							<h3 class="major">
								<span><i class="icon-list-ul"></i> 最新日志</span>
							</h3>
							<ul class="unstyled side-ul">
								<c:forEach items="${latestDiaries}" var="diary">
									<li>
										<h5>
											<a href="#"><i class="icon-file-alt"></i>${diary.title}</a>
										</h5>
										<ul class="meta inline">
											<li><i class="icon-time"></i><a
												href="javascript:void(0);"> ${diary.publish_time}</a></li>
											<li><i class="icon-comment"></i><a
												href="javascript:void(0);"> ${diary.reply_num}</a></li>
										</ul>
									</li>
								</c:forEach>
							</ul>
							<a data-type="pjax" class="button button-alt" href="#">查看全部 <i
								class=" icon-hand-right"></i>
							</a>
						</section>

						<!-- 活跃用户 -->
						<section id="activeUserSec">
							<h3 class="major">
								<span><i class="icon-user-md"></i> 活跃用户</span>
							</h3>
							<ul class="unstyled inline">
								<c:forEach items="${activeUsers}" var="activeUser">
									<li class="padding-mini"><a href="#"
										title="${activeUser.name}"> <img
											src="<%=imgPath %>../../${activeUser.photo}"
											class="img-polaroid" width="32px" height="32px" alt="">
											<span class="activeUserName text-center">
												${activeUser.name} </span>
									</a></li>
								</c:forEach>
							</ul>
							<a class="button button-alt" href="javascript:void(0)">查看全部 <i
								class="icon-hand-right"></i>
							</a>
						</section>
						<!-- /活跃用户 -->

						<!-- 留言 -->
						<section id="leaveMsgListSec">
							<h3 class="major">
								<span><i class="icon-envelope-alt"></i> 留言</span>
							</h3>
							<ul class="unstyled quote-list">
								<c:forEach items="${leaveMsgs}" var="leaveMsg">
									<li><a href="#" title="${leaveMsg.name}"><img src="<%=imgPath %>../../${leaveMsg.user_photo}"
											class="img-polaroid" width="40px" height="40px" alt="" /> </a>
										<p title="${leaveMsg.msg}">${leaveMsg.msg}</p> <span>--
											<a href="#" title="${leaveMsg.name}">${leaveMsg.name}</a>, <em>${leaveMsg.leave_time}</em>
									</span></li>
								</c:forEach>
							</ul>
							<a class="button button-alt" data-type="pjax" href="#">查看全部 <i
								class=" icon-hand-right"></i>
							</a>
						</section>
						<!-- /留言 -->

						<!-- 热门标签 -->
						<section id="hotTagSec">
							<h3 class="major">
								<span><i class="icon-tags"></i> Hot Tags</span>
							</h3>
							<p>
								<c:forEach items="${hotTags}" var="tag">
									<a href="#" class="margin-small tagSize${tag.weight}">${tag.name}</a>
								</c:forEach>
							</p>
						</section>
						<!-- /热门标签 -->
					</div>
				</div>
				<div class="span8" id="right-content">
					<!-- Content -->
					<article>
						<!-- 推荐日志 -->
						<section id="topDiarySec" class="diarySec">
							
							<h3 class="major">
	<span><i class="icon-star-empty"></i> 推荐日志</span>
</h3>
<div>
	<img width="60px" height="60px" alt="" class="img-polaroid left"
		src="<%=imgPath %>../../${topDiary.author_photo}" />
	<blockquote>
		<h3 class="muted">
			${topDiary.title}
			<em title="回复/阅读数">[${topDiary.reply_num}/${topDiary.read_num}]</em>
		</h3>
		<small> <em><a class="text-info" title="查看他发布的所有博文"
				href="#">${topDiary.author_name}></a>
				发布于 ${topDiary.publish_time}</em> </small>
	</blockquote>
</div>
<div>
	<p>${topDiary.content}</p>
</div>

<a class="button" data-type="pjax" href="#">阅读全文 <i
	class="icon-chevron-down"></i> </a>
<a href="javascript:void(0)"
	onclick="changeTopDiary(${topDiary.id})"
	onmouseover="$('.changeTopDiary i').addClass('icon-spin');"
	onmouseout="$('.changeTopDiary i').removeClass('icon-spin');"
	title="换一篇" class="changeTopDiary"><i class="icon-refresh icon-2x"></i>
</a>							


						</section>
						<!-- /推荐日志 -->
						<!-- 热门日志 -->
						<section id="hotDiarySec">
							<h3 class="major">
								<span><i class="icon-lightbulb"></i> 热门日志</span>
							</h3>
							<div>
								<div class="span3">
									<ul class="unstyled">
										<c:forEach items="${hotDiaries['left']}" var="diary">
											<li><a href="#"> <i class="icon-lightbulb" ></i> 
													${diary.title}
												</a> <em>[${diary.reply_num}/${diary.read_num}]</em></li>
										</c:forEach>
									</ul>
								</div>
								<div class="span4">
									<ul class="unstyled">
										<c:forEach items="${hotDiaries['right']}" var="diary">
											<li><a href="#"> <i class="icon-lightbulb" ></i> 
														 ${diary.title}
												</a> <em>[${diary.reply_num}/${diary.read_num}]</em></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<a class="button" href="#">查看全部 <i class=" icon-hand-right"></i>
							</a>
						</section>
						<!-- /热门日志 -->
						<!-- 关于 -->
						<section id="aboutSec">
							<h3 class="major">
								<span><i class="icon-info-sign"></i> 关于</span>
							</h3>
							<div class="row">
								<div class="span2">
									<img style="width: 80px; height: 80px"
										src="<%=imgPath%>/wn_head01.jpg"
										class="img-rounded margin-bottom-middle" />
									<h5>我是王宁，本站的作者，毕业一年,程序员。</h5>
									<ul>
										<li>喜欢创造的快乐。</li>
										<li>喜欢<span class="label label-info">宅</span>。
										</li>
										<li>游泳篮球LOL,And<span class="label label-info">进击の巨人</span></li>
										<li>喜欢各种萌物，单身...</li>
									</ul>
								</div>

								<div class="span5">
									<img style="width: 200px; height: 80px"
										src="<%=imgPath%>/logo.png"
										class="img-rounded margin-bottom-middle" />
									<p>
									<h5>现在大家看到的wnJava的设计样式，算是第三版了，相比前面的版本，第三版主要进行了以下几处的改进：</h5>
									<ul class="">
										<li>重新设计了全站的样式</li>
										<li>采用Pjax来实现模块间的跳转。</li>
										<li>完善了用户主页。</li>
										<li>删除了图册功能。</li>
										<li>进一步完善了代码的质量。</li>
									</ul>
									</p>
								</div>
							</div>
							<div class="row">
								<div class="span7 alert alert-info row margin-top-small">
									<i class="icon-github"></i> GitHub源码地址 ：
									https://github.com/semis2008/wnJava/
								</div>
							</div>
						</section>
						<!-- /关于WnJava -->
						<!-- 发布留言 -->
						<section id="leaveMsgSec">
							<h3 class="major">
								<span><i class="icon-envelope"></i> 给我留言</span>
							</h3>
							<div class="row">
								<div class="span3">
									<input type="text" placeholder="Name" id="leave-msg-name"
										class="text">
								</div>
								<div class="span4">
									<input type="email" placeholder="Email" id="leave-msg-email"
										class="text">
								</div>
							</div>
							<div class="row">
								<div class="span7">
									<textarea rows="5" placeholder="Message" id="leave-msg-content"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="span8">
									<ul class="unstyled inline">
										<li><a class="button" href="javascript:leaveMsg('2')">留言</a></li>
										<li><a class="button button-alt"
											href="javascript:resetLeaveMsgForm('2')">清空</a></li>
									</ul>
								</div>
							</div>
						</section>
						<!-- /发布留言 -->
					</article>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/bottom.jsp"%>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/index.js"></script>
</body>
</html>



