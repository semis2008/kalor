<%@page import="com.wnJava.util.StringUtil"%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	<div class="span12 blog-page">
		<div class="row-fluid">
			<div class="span9 article-block">
				<h1>
					<c:choose>
						<c:when test="${fn:length(diary.title) > 20}">
							<c:out value="${fn:substring(diary.title, 0, 20)}......"
								escapeXml="true" />
						</c:when>
						<c:otherwise>
							<c:out value="${diary.title}" escapeXml="true" />
						</c:otherwise>
					</c:choose>
				</h1>
				<div class="blog-tag-data">
					<img src="<%=staticPath%>/image/item_img.jpg" alt="">
					<div class="row-fluid">
						<div class="span6">
							<ul class="unstyled inline blog-tags">
								<li><i class="icon-tags"></i> <c:forTokens var="tag"
										items="${diary.tags }" delims="_">
										<a href="#">${tag }</a>
									</c:forTokens></li>
							</ul>
						</div>
						<div class="span6 blog-tag-data-inner">
							<ul class="unstyled inline">
								<li><i class="icon-calendar"></i> <a href="#">${diary.publish_time
										}</a></li>
								<li><i class="icon-comments"></i> <a href="#">${diary.reply_num
										} Comments</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!--end news-tag-data-->
				<div>
					<p>${diary.content }</p>
				</div>
				<hr>
				<h2>评论</h2>
				<div id="replyDiv">
					<div class="media">
					<a href="#" class="pull-left"> <img alt=""
						src="media/image/9.jpg" class="media-object">
					</a>
					<div class="media-body">
						<h4 class="media-heading">
							Media heading <span>5 hours ago / <a href="#">Reply</a></span>
						</h4>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<hr>
						<!-- Nested media object -->
						<div class="media">
							<a href="#" class="pull-left"> <img alt=""
								src="media/image/5.jpg" class="media-object">
							</a>
							<div class="media-body">
								<h4 class="media-heading">
									Media heading <span>17 hours ago / <a href="#">Reply</a></span>
								</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce
									dapibus, tellus ac cursus commodo, tortor mauris condimentum
									nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
									malesuada magna mollis euismod. Donec sed odio dui.</p>
									<hr/>
									<div class="media">
							<a href="#" class="pull-left"> <img alt=""
								src="media/image/5.jpg" class="media-object">
							</a>
							<div class="media-body">
								<h4 class="media-heading">
									Media heading <span>17 hours ago / <a href="#">Reply</a></span>
								</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce
									dapibus, tellus ac cursus commodo, tortor mauris condimentum
									nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
									malesuada magna mollis euismod. Donec sed odio dui.</p>
							</div>
						</div>
							</div>
						</div>
						<!--end media-->
						<hr>
						<div class="media">
							<a href="#" class="pull-left"> <img alt=""
								src="media/image/7.jpg" class="media-object">
							</a>
							<div class="media-body">
								<h4 class="media-heading">
									Media heading <span>2 days ago / <a href="#">Reply</a></span>
								</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce
									dapibus, tellus ac cursus commodo, tortor mauris condimentum
									nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
									malesuada magna mollis euismod. Donec sed odio dui.</p>
							</div>
						</div>
						<!--end media-->
					</div>
				</div>
				<!--end media-->
				<div class="media">
					<a href="#" class="pull-left"> <img alt=""
						src="media/image/6.jpg" class="media-object">
					</a>
					<div class="media-body">
						<h4 class="media-heading">
							Media heading <span>July 5,2013 / <a href="#">Reply</a></span>
						</h4>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
					</div>
				</div>
				<!--end media-->	
				</div>
				<hr>
				<div class="post-comment">
					<h3>Leave a Comment</h3>
					<form>
						<label>Name</label> <input type="text" class="span7 m-wrap">
						<label>Email <span class="color-red">*</span></label> <input
							type="text" class="span7 m-wrap"> <label>Message</label>
						<textarea class="span10 m-wrap" rows="8"></textarea>
						<p>
							<button class="btn blue" type="submit">Post a Comment</button>
						</p>
					</form>
				</div>
			</div>
			<!--end span9-->
			<div class="span3 blog-sidebar">
				<h2>谁看过</h2>
				<ul class="unstyled blog-images">
					<li><a class="fancybox-button" data-rel="fancybox-button"
						title="390 x 220 - keenthemes.com" href="media/image/1.jpg"> <img
							alt="" src="media/image/1.jpg">
					</a></li>
					<li><a href="#"><img alt="" src="media/image/2.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/3.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/4.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/5.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/6.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/8.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/10.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/11.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/1.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/2.jpg"></a></li>
					<li><a href="#"><img alt="" src="media/image/7.jpg"></a></li>
				</ul>
				<div class="space20"></div>
				<h2>热门</h2>
				<div class="top-news">
					<c:forEach items="${hotDiaries }" var="diary" varStatus="status">
						<c:choose>
							<c:when test="${status.count eq 1 }">
								<a href="#" class="btn red">
							</c:when>
							<c:when test="${status.count eq 2 }">
								<a href="#" class="btn green">
							</c:when>
							<c:when test="${status.count eq 3 }">
								<a href="#" class="btn blue">
							</c:when>
							<c:when test="${status.count eq 4 }">
								<a href="#" class="btn yellow">
							</c:when>
							<c:when test="${status.count eq 5 }">
								<a href="#" class="btn purple">
							</c:when>
							<c:otherwise>
								<a href="#" class="btn grey">
							</c:otherwise>
						</c:choose>
						<span> <c:choose>
								<c:when test="${fn:length(diary.title) > 15}">
									<c:out value="${fn:substring(diary.title, 0, 15)}......"
										escapeXml="true" />
								</c:when>
								<c:otherwise>
									<c:out value="${diary.title}" escapeXml="true" />
								</c:otherwise>
							</c:choose></span>
						<em>Posted on: ${diary.publish_time }</em>
						<em><c:forTokens var="tag" items="${diary.tags }" delims="_">
								<i class="icon-tags"></i> ${tag }
								</c:forTokens> </em>
						<i class="icon-fire top-news-icon"></i>
						</a>
					</c:forEach>
				</div>
				<div class="space20"></div>
				<h2>Blog Tags</h2>
				<ul class="unstyled inline sidebar-tags">
					<c:forTokens var="tag" items="${diary.tags }" delims="_">
						<li><a href="#"><i class="icon-tags"></i> ${tag }</a></li>
					</c:forTokens>
				</ul>
				<div class="space20"></div>
			</div>
			<!--end span3-->
		</div>
	</div>
</div>
<!-- END PAGE CONTENT-->
