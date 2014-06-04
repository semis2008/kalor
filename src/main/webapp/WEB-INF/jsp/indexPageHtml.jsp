<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  
<article> <!-- 推荐日志 --> <section id="topDiarySec" class="diarySec">
	<%@include file="topDiaryHtml.jsp" %>
 </section> <!-- /推荐日志 --> <!-- 热门日志 --> <section id="hotDiarySec">
<h3 class="major">
	<span><i class="icon-lightbulb"></i> 热门日志</span>
</h3>
<div>
	<div class="span3">
		<ul class="unstyled">
		<c:forEach items="${hotDiaries}" var="diary">
			<li><a data-type="pjax" href="#"><i  class="icon-lightbulb"
				 ></i> ${diary.title }</a> <em>[${diary.reply_num }/${diary.read_num }]</em>
			</li>
		</c:forEach>
		</ul>
	</div>
	<div class="span4">
		<ul class="unstyled">
			 <c:forEach items="${hotDiaries}" var="diary">
			<li><a data-type="pjax" href="#"><i  class="icon-lightbulb"
				 ></i> ${diary.title }</a> <em>[${diary.reply_num }/${diary.read_num }]</em>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>
<a class="button" data-type="pjax" href="# ">查看全部 <i
	class=" icon-hand-right"></i> </a> </section> <!-- /热门日志 --> <!-- 关于 --> <section
	id="aboutSec">
<h3 class="major">
	<span><i class="icon-info-sign"></i> 关于</span>
</h3>
<div class="row">
	<div class="span2">
		<img style="width: 80px; height: 80px"
			src="<%=staticPath %>/img/wn_head01.jpg"
			class="img-rounded margin-bottom-middle" />
		<h5>我是王宁，本站的作者，毕业一年,程序员。</h5>
		<ul>
			<li>喜欢创造的快乐。</li>
			<li>喜欢<span class="label label-info">宅</span>。</li>
			<li>游泳篮球LOL,And<span class="label label-info">进击の巨人</span></li>
			<li>喜欢各种萌物，单身...</li>
		</ul>
	</div>

	<div class="span5">
		<img style="width: 200px; height: 80px"
			src="<%=staticPath%>/img/logo.png"
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
	<div class="span7 alert alert-info row margin-top-small"><i class="icon-github"></i> GitHub源码地址 ：
		https://github.com/semis2008/wnJava/</div>
</div>
</section> <!-- /关于WnJava --> <!-- 发布留言 --> <section id="leaveMsgSec">
<h3 class="major">
	<span><i class="icon-envelope"></i> 给我留言</span>
</h3>
<div class="row">
	<div class="span3">
		<input type="text" placeholder="Name" id="leave-msg-name" class="text">
	</div>
	<div class="span4">
		<input type="email" placeholder="Email" id="leave-msg-email" class="text">
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
			<li><a class="button" >留言</a></li>
			<li><a class="button button-alt"  >清空</a>
			</li>
		</ul>
	</div>
</div>
</section> <!-- /发布留言 --> </article>
