<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="portlet paddingless">
	<div class="portlet-title line">
		<div class="caption">
			<i class="icon-bell"></i> 主题动态
		</div>
		<div class="tools">
			<a href="" class="collapse"></a><a href="" class="reload"></a>
		</div>
	</div>
	<div class="portlet-body">
		<!--BEGIN TABS-->
		<div class="tabbable tabbable-custom">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab_1_1" data-toggle="tab">最新</a></li>
				<li><a href="#tab_1_2" data-toggle="tab">热门</a></li>
				<li><a href="#tab_1_3" data-toggle="tab">活跃用户</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab_1_1">
					<div class="scroller" data-height="450px" data-always-visible="1"
						data-rail-visible="0">
						<ul class="feeds">
							<c:forEach items="${latestDiaries }" var="diary">
								<li>
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-info">
													<i class="icon-book"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">
													${diary.title } <span
														class="label label-success label-mini"> 查看详情 <i
														class="icon-share-alt"></i>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">
											${diary.time_before }
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="tab-pane" id="tab_1_2">
					<div class="scroller" data-height="450px" data-always-visible="1"
						data-rail-visible1="1">
						<ul class="feeds">
							<c:forEach items="${hotDiaries }" var="diary">
								<li>
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-important">
													<i class="icon-book"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">
													${diary.title } <span
														class="label label-success label-mini"> 查看详情 <i
														class="icon-share-alt"></i>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">
											${diary.time_before }
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="tab-pane" id="tab_1_3">
					<div class="scroller relative" data-height="450px"
						data-always-visible="1" data-rail-visible1="1">
						<c:forEach items="${requestScope.activeUsers }" var="usersRow">
							<div class="row-fluid">
								<c:forEach items="${usersRow }" var="user">
									<div class="span6 user-info">
										<img alt="" src="<%=staticPath%>/image/avatar.png" />
										<div class="details">
											<div>
												<a href="#">${user.name }</a>
												<c:choose>
													<c:when test="${user.user_level eq 1 }">
														<span class="label label-info">注册用户</span>
													</c:when>
													<c:when test="${user.user_level eq 2 }">
														<span class="label label-success">管理员</span>
													</c:when>
													<c:when test="${user.user_level eq 3 }">
														<span class="label label-important">Author</span>
													</c:when>
												</c:choose>
											</div>
											<div>${user.logon_time }</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!--END TABS-->
	</div>
</div>