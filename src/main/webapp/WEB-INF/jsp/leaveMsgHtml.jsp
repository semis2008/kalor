<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<h3 class="major">
	<span><i class="icon-envelope-alt"></i> 留言</span>
</h3>
<ul class="unstyled quote-list">
	<c:forEach items="${leaveMsgs }" var="msg">
		<li><a href="#" title="${msg.name }"><img
			src="<%=staticPath %>${msg.user_photo }"
			class="img-polaroid" width="40px" height="40px" alt="" /> </a>
		<p title="${msg.msg }">
			${msg.msg }	
		</p> <span>-- <a href="#" title="${msg.name }">${msg.name }</a>,
			<em>${msg.leave_time }</em> </span>
	</li>
	</c:forEach>
	
</ul>
<a class="button button-alt" data-type="pjax" href="#">查看全部 <i
	class=" icon-hand-right"></i> </a>
