<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="portlet">
	<div class="portlet-title line">
		<div class="caption">
			<i class="icon-comments"></i>留言
		</div>
		<div class="tools">
			<a href="" class="collapse"></a> <a href="#portlet-config"
				data-toggle="modal" class="config"></a> <a href="" class="reload"></a>
		</div>
	</div>
	<div class="portlet-body" id="chats">
		<div class="scroller" data-height="450px" data-always-visible="1"
			data-rail-visible1="1">
			<ul class="chats">
				<c:forEach items="${requestScope.leaveMsgs}" var="msg">
					<c:if test="${msg.type eq 1}">
						<li class="out"><img class="avatar" alt=""
							src="<%=staticPath %>/image/avatar1.jpg" />
							<div class="message">
								<span class="arrow"></span> <a href="#" class="name">${msg.name}</a>
								<span class="datetime">at ${msg.leave_time }</span> <span
									class="body"> ${msg.msg } </span>
							</div></li>
					</c:if>
					<c:if test="${msg.type eq 2}">
						<li class="in"><img class="avatar" alt=""
							src="<%=staticPath %>/image/avatar.png" />
							<div class="message">
								<span class="arrow"></span> <a href="#" class="name">${msg.name}</a>
								<span class="datetime">at ${msg.leave_time }</span> <span
									class="body"> ${msg.msg } </span>
							</div></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>