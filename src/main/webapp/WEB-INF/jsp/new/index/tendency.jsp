<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="portlet paddingless">
	<div class="portlet-title line">
		<div class="caption">
			<i class="icon-bell"></i> 动态
		</div>
		<div class="tools">
			<a href="" class="collapse"></a></a> <a href="" class="reload"></a>
		</div>
	</div>
	<div class="portlet-body">
		<!--BEGIN TABS-->
		<div class="tabbable tabbable-custom">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab_1_1" data-toggle="tab">主题</a></li>
				<li><a href="#tab_1_2" data-toggle="tab">News</a></li>
				<li><a href="#tab_1_3" data-toggle="tab">活跃用户</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab_1_1">
					<div class="scroller" data-height="435px" data-always-visible="1"
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
					<div class="scroller" data-height="435px" data-always-visible="1"
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
					<div class="scroller" data-height="435px" data-always-visible="1"
						data-rail-visible1="1">
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Robert Nilson</a> <span
											class="label label-success">Approved</span>
									</div>
									<div>29 Jan 2013 10:45AM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 10:45AM</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Eric Kim</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 12:45PM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span
											class="label label-important">In progress</span>
									</div>
									<div>19 Jan 2013 11:55PM</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Eric Kim</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 12:45PM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span
											class="label label-important">In progress</span>
									</div>
									<div>19 Jan 2013 11:55PM</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Eric Kim</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 12:45PM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span
											class="label label-important">In progress</span>
									</div>
									<div>19 Jan 2013 11:55PM</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Eric Kim</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 12:45PM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span
											class="label label-important">In progress</span>
									</div>
									<div>19 Jan 2013 11:55PM</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Eric Kim</a> <span class="label label-info">Pending</span>
									</div>
									<div>19 Jan 2013 12:45PM</div>
								</div>
							</div>
							<div class="span6 user-info">
								<img alt="" src="media/image/avatar.png" />
								<div class="details">
									<div>
										<a href="#">Lisa Miller</a> <span
											class="label label-important">In progress</span>
									</div>
									<div>19 Jan 2013 11:55PM</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--END TABS-->
	</div>
</div>