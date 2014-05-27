<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- BEGIN SIDEBAR MENU -->
<ul class="page-sidebar-menu">
	<li>
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	</li>
	<li>
		<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
		<form class="sidebar-search">
			<div class="input-box">
				<a href="javascript:;" class="remove"></a> <input type="text"
					placeholder="Search..." /> <input type="button" class="submit"
					value=" " />
			</div>
		</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->
	</li>
	<li class="start active "><a href="<%=contextPath%>/index"> <i
			class="icon-home"></i> <span class="title">首页</span> <span
			class="selected"></span>
	</a></li>
	<li class=""><a href="javascript:;"> <i class="icon-globe"></i>
			<span class="title">动态</span> <span class="arrow "></span>
	</a>
		<ul class="sub-menu">
			<li><a href="#"> 技术前沿</a></li>
			<li><a href="#"> 国内事件</a></li>
			<li><a href="#"> 国外事件</a></li>
			<li><a href="#"> 站内动态</a></li>
		</ul></li>
	<li class=""><a href="javascript:;"> <i class="icon-font"></i>
			<span class="title">Blog</span> <span class="arrow "></span>
	</a>
		<ul class="sub-menu">
			<li><a href="#"> 编程语言<span class="arrow"></span></a>
				<ul class="sub-menu">
					<li><a href="<%=contextPath%>/blog/java">Java</a></li>
					<li><a href="<%=contextPath%>/blog/java">C/C++</a></li>
					<li><a href="<%=contextPath%>/blog/java">Python</a></li>
				</ul></li>
			<li><a href="#"> 搜索技术<span class="arrow"></span></a>
				<ul class="sub-menu">
					<li><a href="<%=contextPath%>/blog/java">Lucence</a></li>
					<li><a href="<%=contextPath%>/blog/java">IK</a></li>
					<li><a href="#">Solr</a></li>
				</ul></li>
			<li><a href="#"> 数据库<span class="arrow"></span></a>
				<ul class="sub-menu">
					<li><a href="#">MySql</a></li>
					<li><a href="#">MongoDB</a></li>
					<li><a href="#">Oracle</a></li>
				</ul></li>
			<li><a href="#"> 软件开发<span class="arrow"></span></a>
				<ul class="sub-menu">
					<li><a href="#">敏捷开发</a></li>
					<li><a href="#">架构设计</a></li>
					<li><a href="#">设计模式</a></li>
				</ul></li>
			<li><a href="#"> Web 前端<span class="arrow"></span></a>
				<ul class="sub-menu">
					<li><a href="#">Html5</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JS/Jquery</a></li>
				</ul></li>
			<li><a href="#"> 其他</a></li>
		</ul></li>
	<li class=""><a href="javascript:;"> <i class="icon-briefcase"></i>
			<span class="title">关于Kalor</span> <span class="arrow "></span>
	</a>
		<ul class="sub-menu">
			<li><a href="#"> <i class="icon-time"></i> 时间线
			</a></li>
			<li><a href="#"> <i class="icon-cogs"></i> 即将开发
			</a></li>
			<li><a href="page_blog.html"> <i class="icon-comments"></i>
					开发日志
			</a></li>
			<li><a href="page_about.html"> <i class="icon-group"></i>
					关于我们
			</a></li>
			<li><a href="page_contact.html"> <i
					class="icon-envelope-alt"></i> 联系我
			</a></li>
		</ul></li>
	<li class=""><a href="javascript:;"> <i
			class="icon-map-marker"></i> <span class="title">网站地图</span></a></li>
</ul>
<!-- END SIDEBAR MENU -->