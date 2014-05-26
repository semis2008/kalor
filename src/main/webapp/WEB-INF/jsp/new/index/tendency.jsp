<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-success">
												<i class="icon-bell"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												You have 4 pending tasks. <span
													class="label label-important label-mini"> Take
													action <i class="icon-share-alt"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">Just now</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New version v1.4 just lunched!</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">20 mins</div>
									</div>
							</a></li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-important">
												<i class="icon-bolt"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">Database server #12 overloaded.
												Please fix the issue.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">30 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-success">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">40 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-warning">
												<i class="icon-plus"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New user registered.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">1.5 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-success">
												<i class="icon-bell-alt"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												Web server hardware needs to be upgraded. <span
													class="label label-inverse label-mini">Overdue</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">2 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">3 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-warning">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">5 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">18 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">21 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">22 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">21 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">22 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">21 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">22 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">21 hours</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-info">
												<i class="icon-bullhorn"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">New order received. Please take care
												of it.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">22 hours</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="tab-pane" id="tab_1_2">
					<div class="scroller" data-height="450px" data-always-visible="1"
						data-rail-visible1="1">
						<ul class="feeds">
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New order received</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">10 mins</div>
									</div>
							</a></li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-important">
												<i class="icon-bolt"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												Order #24DOP4 has been rejected. <span
													class="label label-important label-mini">Take action
													<i class="icon-share-alt"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-success">
													<i class="icon-bell"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">New user registered</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">Just now</div>
									</div>
							</a></li>
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