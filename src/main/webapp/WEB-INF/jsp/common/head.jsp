<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="brand">&nbsp;&nbsp;&nbsp;&nbsp;WNJava&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav">
					<li class="active"><a href="/action/system/indexPage"><i
							class="icon-home icon-white"></i> 首页</a></li>
					<li><a href="/action/system/diary"><i
							class="icon-edit icon-white"></i> 日志</a></li>
					<li><a target="_black" href="/action/lovertime/index"><i
							class="icon-heart icon-white"></i> LoverTime</a></li>
					<li><a href="/action/system/indexPage#leaveMsgSec"><i
							class="icon-envelope icon-white"></i> 留言</a></li>
					<li><a href="/action/system/indexPage#aboutSec"><i
							class="icon-info-sign icon-white"></i> 关于</a></li>
				</ul>
				<ul class="nav pull-right">
					<li><a href="#" data-toggle="modal" data-target="#registModal"
						data-keyboard="true" data-backdrop="true"><i
							class="icon-plus-sign icon-white"></i> 注册</a></li>
					<li><a href="#" data-toggle="modal" data-target="#loginModal"
						data-keyboard="true" data-backdrop="true"><i
							class="icon-ok icon-white"></i> 登陆</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">wangning <b class="caret"></b> </a>
						<ul class="dropdown-menu">
							<li><a
								href="#"><i
									class="icon-home icon-black"></i> 个人主页</a></li>
							<li><a href="javascript:void(0)"><i
									class="icon-edit icon-black"></i> 日志：11篇</a></li>
							<li class="divider"></li>
							<li><a
								href="#"
								data-type="pjax"><i
									class="icon-pencil icon-black"></i> 写日志</a></li>
							<li class="divider"></li>
							<li><a href="#" onclick="userQuit();"><i
									class="icon-off icon-black"></i> 注销</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="fixed goToTopDiv hide pointer padding-small">
	<i onclick="goToTop()" class="icon-chevron-up icon-white icon-2x"></i>
</div>

<div id="main-frame"></div>



