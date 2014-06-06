<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<li class="active"><a href="<%=contextPath %>/index"><i
							class="icon-home icon-white"></i> 首页</a></li>
					<li><a data-type="pjax" href="<%=contextPath %>/blog"><i
							class="icon-edit icon-white"></i> 博文</a></li>
					<li><a href="<%=contextPath %>/index#leaveMsgSec"><i
							class="icon-envelope icon-white"></i> 留言</a></li>
					<li><a href="<%=contextPath %>/index#aboutSec"><i
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
						data-toggle="dropdown">sss<b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="icon-home icon-black"></i>
									个人主页</a></li>
							<li><a href="javascript:void(0)"><i
									class="icon-edit icon-black"></i> 日志：11篇</a></li>
							<li class="divider"></li>
							<li><a href="#" data-type="pjax"><i
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

<!-- 弹出对话框 -->
<!-- 登录 -->
<div class="modal hide fade" id="loginModal">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>
			<span class="label label-info"><i class="icon-user icon-white"></i>欢迎您登录WNJava,开始轻松之旅~</span>
		</h3>
	</div>
	<div class="modal-body">
		<div class="well form-inline">
			<input type="email" id="txtEmailLogin" name="txtEmailLogin"
				class="input-medium" placeholder="帐号" /> <input type="password"
				id="txtPasswordLogin" name="txtPasswordLogin" class="input-medium"
				placeholder="密码" /> <label class="checkbox"> <input
				type="checkbox" id="rememberMe" name="rememberMe" /> 记住我
			</label>
			<button onclick="userLogin()" class="btn btn-primary">登录</button>
		</div>
	</div>
</div>
<!-- 注册 -->
<div class="form-horizontal">
	<div class="modal hide fade" id="registModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">×</a>
			<h3>
				<span class="label label-info offset1"><i
					class="icon-plus icon-white"></i>欢迎您注册WNJava，马上开始吧~</span>
			</h3>
		</div>
		<div class="modal-body">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="input01">您的尊姓大名</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i> </span><input
								type="text" size="16" id="txtNameRegist" name="txtNameRegist"
								required />
						</div>
						<p class="help-block">字母，数字，汉字皆可</p>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="input02">您的Email</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-envelope"></i> </span><input
								type="email" size="16" id="txtEmailAddressRegist"
								name="txtEmailAddressRegist" required />
						</div>
						<p class="help-block">邮箱将直接作为您登录的帐号哦</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input03">您要使用的密码</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-asterisk"></i> </span><input
								type="text" size="16" id="txtPasswordRegist"
								name="txtPasswordRegist" required />
						</div>
						<p class="help-block">字母，数字皆可</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input04">请再输入一次密码</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-asterisk"></i> </span><input
								type="password" size="16" id="txtPasswordCon"
								name="txtPasswordCon" required />
						</div>
						<p class="help-block">两次密码输入必须一致</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input05">请输入验证码</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-asterisk"></i> </span><input
								class="span2" type="password" size="8" id="txtRandImg"
								name="txtRandImg" required />
						</div>
						<img src="<%=contextPath %>/RandImg"
							onclick="this.src='<%=contextPath %>/RandImg?d='+Math.random();" />
					</div>
				</div>

				<div class="control-group">
					<button class="btn btn-primary offset1" onclick="userRegist();">确认注册</button>
					<button data-dismiss="modal" aria-hidden="true" class="btn">取消</button>
				</div>
			</fieldset>
		</div>
	</div>
</div>
<div class="fixed goToTopDiv hide pointer padding-small">
	<i onclick="goToTop()" class="icon-chevron-up icon-white icon-2x"></i>
</div>

<div id="main-frame"></div>