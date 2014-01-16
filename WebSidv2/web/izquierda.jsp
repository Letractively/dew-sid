<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.*, sid.modelo.Residente" %>
<%
    Residente obj = new Residente();
    obj = (Residente)session.getAttribute("USUARIO_ACTUAL");
    PrintWriter ou = response.getWriter();
    String tipo = obj.getPerfil();
    //ou.print("-"+tipo+"-");
%>
<div class="primary-sidebar">

            <!-- Main nav -->
            <ul class="nav nav-collapse collapse nav-collapse-primary">

            <li class="">
                    <span class="glow"></span>
                    <a href="misdatos.jsp">
                        <i class="icon-h-sign icon-2x"></i>
                        <span>Home</span>
                    </a>
             </li>
             <% 
             if(tipo.equals("A")){           //cuando es cadena es asi.
             %>
             <li class="active">
                    <span class="glow"></span>
                    <a href="residentes.jsp">
                        <i class="icon-user"></i>
                        <span>Residentes</span>
                    </a>
              </li>
              <li class="">
                    <span class="glow"></span>
                    <a href="viviendas.jsp">
                        <i class="icon-home"></i>
                        <span>Viviendas</span>
                    </a>
            </li>
            <li class="">
                    <span class="glow"></span>
                    <a href="registrocuotas.jsp">
                        <i class="icon-money"></i>
                        <span>Registro de Cuotas</span>
                    </a>
            </li>
            <li class="">
                    <span class="glow"></span>
                    <a href="visitas.jsp">
                        <i class="icon-ok"></i>
                        <span>Visitas</span>
                    </a>
            </li>
            <li class="">
                    <span class="glow"></span>
                    <a href="juntas.jsp">
                        <i class="icon-circle"></i>
                        <span>Juntas</span>
                    </a>
            </li>
            <li class="">
                    <span class="glow"></span>
                    <a href="listarcuotasven.jsp">
                        <i class="icon-envelope"></i>
                        <span>Morosos</span>
                    </a>
            </li>
           <% 
            }else{
           %> 
            <li class="">
                    <span class="glow"></span>
                    <a href="cuotas.jsp">
                        <i class="icon-money"></i>
                        <span>Cuotas</span>
                    </a>
            </li>
           
          <li class="dark-nav ">

                    <span class="glow"></span>
                    <a class="accordion-toggle collapsed" data-toggle="collapse" href="#CF52">
                        <i class="icon-suitcase icon-2x"></i>
                        <span>
                            Reservas
                            <i class="icon-caret-down"></i>
                        </span>

                    </a>

                    <ul id="CF52" class="collapse" style="height: 0px;">

                        <li class="">
                            <a href="fechaslibres.jsp">
                                <i class="icon-calendar"></i> Fechas libres
                            </a>
                        </li>

                        <li class="">
                            <a href="reservas.jsp">
                                <i class="icon-inbox"></i> Mis reservas
                            </a>
                        </li>
					</ul>

                </li>
					
            <li class="">
                    <span class="glow"></span>
                    <a href="quejas.jsp">
                        <i class="icon-warning-sign"></i>
                        <span>Quejas</span>
                    </a>
            </li>
            <li class="">
                    <span class="glow"></span>
                    <a href="mensajeria.jsp">
                        <i class="icon-envelope"></i>
                        <span>Mensajeria</span>
                    </a>
            </li>
           <% 
            }
           %>
        </ul>

</div>