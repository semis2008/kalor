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
				<h2>
					类目 <em>'${category }'</em> 下的Blog
				</h2>
				<c:forEach items="${diaries }" var="diary">
					<div class="row-fluid">
						<div class="span4 blog-img blog-tag-data">
							<img src="<%=staticPath%>/image/image2.jpg" alt="">
							<ul class="unstyled inline">
								<li><i class="icon-calendar"></i> <a href="#">${diary.publish_time
										}</a></li>
								<li><i class="icon-comments"></i> <a href="#">${diary.reply_num
										} 回复</a></li>
							</ul>
							<br />
							<ul class="unstyled inline blog-tags">
								<c:forTokens var="tag" items="${diary.tags }" delims="_">
									<li><i class="icon-tags"></i> <a href="#">${tag }</a></li>
								</c:forTokens>
							</ul>
						</div>
						<div class="span8 blog-article">
							<h2>
								<a href="#"> <c:choose>
										<c:when test="${fn:length(diary.title) > 15}">
											<c:out value="${fn:substring(diary.title, 0, 15)}......"
												escapeXml="true" />
										</c:when>
										<c:otherwise>
											<c:out value="${diary.title}" escapeXml="true" />
										</c:otherwise>
									</c:choose>
								</a>
							</h2>
							<p>
								<c:choose>
									<c:when test="${fn:length(diary.content) > 160}">
										<c:out value="${fn:substring(diary.content, 0, 160)}......"
											escapeXml="true" />
									</c:when>
									<c:otherwise>
										<c:out value="${diary.content}" escapeXml="true" />
									</c:otherwise>
								</c:choose>
							</p>
							<a class="btn blue" href="page_blog_item.html"> Read more <i
								class="m-icon-swapright m-icon-white"></i>
							</a>
						</div>
					</div>
					<hr>
				</c:forEach>
			</div>
			<!--end span9-->
			<div class="span3 blog-sidebar">
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
				<h2>随机Blog</h2>
				<ul class="unstyled blog-images">
					<li><a class="fancybox-button" data-rel="fancybox-button"
						title="390 x 220 - keenthemes.com"
						href="<%=staticPath%>/image/1.jpg"> <img alt=""
							src="<%=staticPath%>/image/1.jpg">
					</a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/2.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/3.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/4.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/5.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/6.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/8.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/10.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/11.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/1.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/2.jpg"></a></li>
					<li><a href="#"><img alt=""
							src="<%=staticPath%>/image/7.jpg"></a></li>
				</ul>
				<div class="space20"></div>
				<h2>最新回复</h2>
				<div class="blog-twitter">
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>2 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>2 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>2 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>2 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>2 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>5 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
					<div class="blog-twitter-block">
						<a href="">@keenthemes</a>
						<p>At vero eos et accusamus et iusto odio.</p>
						<a href="#"><em>http://t.co/sBav7dm</em></a> <span>7 hours
							ago</span> <i class="icon-twitter blog-twiiter-icon"></i>
					</div>
				</div>
			</div>
			<!--end span3-->
		</div>
		<div class="pagination pagination-right">
			<ul>
				<li><a href="#">Prev</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li class="active"><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">Next</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- END PAGE CONTENT-->