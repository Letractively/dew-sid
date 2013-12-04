<div class="navbar navbar-top navbar-inverse">
            <div class="navbar-inner">
                <div class="container-fluid">

                    <a class="brand" href="misdatos.jsp">Administrador Condominio</a>

                    <ul class="nav pull-right">

                        <li class="toggle-primary-sidebar hidden-desktop" data-toggle="collapse" data-target=".nav-collapse-primary"><button type="button" class="btn btn-navbar"><i class="icon-th-list">				                        </i></button></li>

                        <li class="hidden-desktop" data-toggle="collapse" data-target=".nav-collapse-top"><button type="button" class="btn btn-navbar"><i class="icon-align-justify"></i></button></li>

                    </ul>

                    <div class="nav-collapse nav-collapse-top collapse">

                        <ul class="nav full pull-right">
                            <li class="dropdown user-avatar">
								
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <span>
                                        <img class="menu-avatar" src="images/avatars/avatar4.jpg" /><span>${sessionScope.USUARIO_ACTUAL.nombre}<i class="icon-caret-down"></i></span>
                                     </span>
                                </a>

                                <ul class="dropdown-menu">
									<li class="with-image">
                                        <div class="avatar">
                                            <img src="images/avatars/avatar4.jpg" />
                                        </div>
                                        <span>${sessionScope.USUARIO_ACTUAL.nombre}</span>
                                    </li>

                                    <li class="divider"></li>
									<li><a href="misdatos.jsp"><i class="icon-user"></i> <span>Perfil</span></a></li>
                                    <li><a href="#"><i class="icon-cog"></i> <span>Settings</span></a></li>
                                    <li><a href="#"><i class="icon-envelope"></i> <span>Mensajes</span> <span class="label label-dark-red pull-right">5</span></a></li>
                                    <li><a href="LogoutServlet"><i class="icon-off"></i> <span>Salir</span></a></li>
                                </ul>
                            </li>
                        </ul>


                        <ul class="nav pull-right">
                            <li class="active"><a href="misdatos.jsp" title="Go home"><i class="icon-home"></i>Home</a></li>
                            <!--<li><a href="residentes.jsp" title="Manage users"><i class="icon-user"></i>Residentes</a></li>-->
                        </ul>

                    </div>


                </div>
            </div>
</div>