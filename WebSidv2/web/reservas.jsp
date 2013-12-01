<html>
<head>
<%@include file="tags.jsp" %>
</head>

<body>

<%@include file="cabecera.jsp" %>
    
<div class="sidebar-background">
        <div class="primary-sidebar-background"></div>
</div>

<%@include file="izquierda.jsp" %>

<div class="main-content">
            <div class="container-fluid">
                <div class="row-fluid">

                    <div class="area-top clearfix">
                        <div class="pull-left header">
                            <h3 class="title">
                                <i class="icon-user"></i>
                                Reserva de espacio común
                            </h3>
                            <h5>
                               Listado de Reservas
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
    
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-residente" data-toggle="modal" href="#modalreserva" data-original-title="Nueva reserva">
                       <i class="icon-file-alt"></i>
                       <span>Nueva reserva</span>
                   </a>   
                </div>
                </div>
    	   </div>
           
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Reservas</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>N° reserva</div></th>
              <th><div>Residente</div></th>
              <th><div>Espacio comun</div></th>
              <th><div>Fecha</div></th>
              <th><div>Hora</div></th>
              <th><div>N° horas</div></th>
              <th><div>Estado</div></th>      
              <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionResidente, sid.modelo.Residente" %>
            <tbody>
            
                <tr id="row_" class="letratablita">
                  <td>50</td>
                  <td>Juan perez</td>
                  <td>Gymnasio</td>
                  <td>2013-12-01</td>
                  <td>05:25</td>
                  <td>2</td>
                  <td>Usado</td>
                  <td class="">
                    <a data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar"  code="" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                    <a href="#" onclick="" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar"><i class="icon-remove icon-large"></i></a>
                  </td>
                </tr>
            
            </tbody>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
            <!-- -->
            <div class="modal hide fade" id="modalreserva" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Reserva de espacio común</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos de reserva</h6>
            <form id="frmnuevoresidente" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">Espacio comun</label>
            <select name="espaciocomun" id="espaciocomun">
               <option value="">[Seleccione espacio comun]</option>
               <option value="D">Gymansio</option>
               <option value="P">Cancha</option>
            </select>
            </div>
            <div>
            <label for="nombre">Fecha reserva</label>
            <input type="text" required placeholder="Fecha reserva" id="fechar" name="fechar">
            </div>
            <div>
            <label for="nombre">Hora reserva</label>
            <select name="nhoras" id="nhoras">
               <option value="11">11:00</option>
               <option value="12">12:00</option>
            </select>
            </div>
            <div>
            <label for="nombre">N° horas</label>
            <select name="nhoras" id="nhoras">
               <option value="2">2</option>
               <option value="4">4</option>
            </select>
            </div>
            </form>
            </div>
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            <button id="btn-save" class="btn btn-blue">Reservar</button>
            </div>
            </div>
            <!-- -->
            <!--
            <div class="modal hide fade" id="modalmodificar" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Editar Residente</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos personales</h6>
            <form id="frmuseredita" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">Nombre (*)</label>
            <input type="text" required placeholder="nombre" id="nomupdate" name="nomupdate">
            </div>
            <div>
            <label for="nombre">Apellidos</label>
            <input type="text" required placeholder="apellido" id="apeupdate" name="apeupdate">
            </div>
            <div>
            <label for="nombre">Email (*)</label>
            <input type="text" required placeholder="Email" id="mailupdate" name="mailupdate">
            </div>
            
            <h6 id="modal-formLabel">Otros Datos</h6>
            <div>
            <label for="nombre">Fecha nacimiento</label>
            <input type="text" required placeholder="Fecha nacimiento" id="fecupdate" name="fecupdate">
            </div>
            <div>
            <label for="nombre">Datos de identificación</label>
            <select name="idenupdate" id="idenupdate">
               <option value="">[Seleccione documento]</option>
               <option value="D">DNI</option>
               <option value="P">Pasaporte</option>
            </select>
            </div>
            <div>
            <label for="nombre">Password (*)</label>
            <input type="password" required placeholder="contrasena de cliente" id="pwdupdate" name="pwdupdate">
            </div> 
            <input type="hidden" id="codeupdate" name="codeupdate" value=""> 
            </form>
            </div>
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            <button id="btn-update" class="btn btn-blue">Editar</button>
            </div>
            </div>-->

</div>
    

</body>
</html>