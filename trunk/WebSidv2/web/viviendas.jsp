
<%@page import="sid.negocio.GestionResidente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        <i class="icon-user"></i>Viviendas
                    </h3>
                    <h5>
                        Listado de Viviendas
                    </h5>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container-fluid padded">    
        <div class="action-nav-normal">
            <div class="span2 action-nav-button">
                <a title="" class="tip nueva-vivienda" data-toggle="modal" href="#modalvivienda" data-original-title="Agregar Vivienda">
                <i class="icon-file-alt"></i>
                <span>Registrar Vivienda</span>
                </a>   
            </div>
        </div>
    </div>
           
    <div class="container-fluid padded">
    <div class="row-fluid">
    <div class="span12">
    <div class="box">
    <div class="box-header"><span class="title">Listado de Viviendas</span></div>
    <div class="box-content">
    <!-- find me in partials/data_tables_custom -->
    <div id="dataTables">
        <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
                <th><div>Id. Vivienda</div></th>
                <th><div>Tipo Vivienda</div></th>
                <th><div>Tipo Ubicacion</div></th>
                <th><div>Ubicacion</div></th>
                <th><div>Numero</div></th>
                <th><div>Metraje</div></th>
                <th><div>Id Residente</div></th>
                <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionVivienda, sid.modelo.Vivienda" %>
            <tbody>
            <%
                GestionVivienda negocio = new GestionVivienda();
                Collection<Vivienda> listado = negocio.listarViviendas();
                for(Vivienda x: listado){
            %>
                <tr id="" class="letratablita">
                <td><% out.println(x.getIdvivienda()); %></td>
                <td><%    int tipoVivienda = Integer.parseInt(x.getTipoVivienda());
                            switch (tipoVivienda) {
                            case 1:  out.println("Casa");
                                     break;
                            case 2:  out.println("Departamento");
                                     break;
                            default: out.println("General");
                                     break;
                                      } 
                      %> </td>
                <td><% int tipoubicacion = Integer.parseInt(x.getTipoUbicacion());
                            switch (tipoubicacion) {
                            case 1:  out.println("Zona");
                                     break;
                            case 2:  out.println("Edificio");
                                     break;
                            default: out.println("General");
                                     break;
                                      } 
                  %> </td>
                  <td><% out.println(x.getUbicacion()); %></td>
                  <td><% out.println(x.getNumero()); %></td>
                  <td><% out.println(x.getMetraje()); %></td>
                  <td><% out.println(x.getIdresidente()); %></td>
                  <td>
                      <a href="#" data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar"  code="<% out.println(x.getIdresidente()); %>" >
                      <i class="icon-edit icon-large"></i></a>
                      <a href="#" onclick="eliminar(<% out.println(x.getIdresidente()); %>);" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar">
                      <i class="icon-remove icon-large"></i></a>
                  </td>
                </tr>
                <%
                }
                %>
            </tbody>
            </table>
            
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
            <!-- -->
            <div class="modal hide fade" id="modalvivienda" style="display:none;" aria-hidden="true">
                <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h6 id="modal-formLabel">Registro de Vivienda</h6>
                </div>
            <div style="" class="modal-body">
                <h6 id="modal-formLabel">Ingrese la Vivienda</h6>
                <form id="frmnuevovivienda" style="" class="form-horizontal fill-up separate-sections">
                <div>
                    <label for="tipovivienda">Tipo Vivienda</label>
                    <select name="cmbTipoVivienda"  id="cmbTipoVivienda">
                        <option value="1">Casa</option>
                        <option value="2">Departamento</option>
                    </select>
                </div> 
                <div>
                    <label for="tipoubicacion">Tipo Ubicación</label>
                    <select name="cmbTipoUbicacion"  id="cmbTipoUbicacion">
                        <option value="1">Zona</option>
                        <option value="2">Edificio</option>
                    </select>
                </div>
                <div>
                    <label for="ubicacion">Ubicación</label>
                    <input type="text" name="txtUbicacion" id="txtUbicacion">
                </div>
                <div>
                    <label for="txtNumero">Número</label>
                    <input type="text" id="txtNumero" name="txtNumero" maxlength="4">
                </div>
                <div>
                    <label for="txtMetraje">Metraje</label>
                    <input type="number" id="txtMetraje" name="txtMetraje">
                </div>
                    
                    
                    <div>
                        <h6 id="modal-formLabel">Residente Asignado</h6>
                        
                        <div class="container-fluid padded">    
                        <div class="action-nav-normal">
                        <div class="span2 action-nav-button">
                            <a title="" class="tip buscar-residente" data-toggle="modal" href="#modalresidente" data-original-title="Busca Residente">
                            <i class="icon-file-alt"></i>
                            <span>Buscar Residente</span>
                            </a>   
                        </div>
                        
                        </div>
                        <div>
                        <%--mostrar el nombre del residente--%>
                        
                        </div>
                        </div>
                        <div>
                            <label for="idResidente">Id de Residente</label>
                            <input type="text" id="txtIdResidente" name="txtIdResidente">
                            <label for="nomResidente">Residente seleccionado</label>
                        <input type="text" disabled id="txtNombres" name="txtNombres" >
                        </div>    
                   </div>
                </form>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
                <button id="btn-save" class="btn btn-blue">Guardar</button>
            </div>
            </div>
            
            
            <!--Formulario para Seleccionar el residente para asignarlo a una vivienda   -->
             
            <div class="modal hide fade" id="modalresidente" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Listado de Residentes</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Seleccione un residente para asignarle la vivienda</h6>
            <form id="frmresidente" style="" class="form-horizontal fill-up separate-sections">
                
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Residentes</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>N°</div></th>
              <th><div>Residente</div></th>
              <th><div>Seleccionar</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionResidente, sid.modelo.Residente" %>
            <tbody>
            <% 
                GestionResidente negocio1 = new GestionResidente();
                Collection<Residente> listado1 = negocio1.listar();  
                for(Residente x1: listado1){
                
            %>
                <tr id="row_<% out.println(x1.getIdresidente()); %>" class="letratablita">
                  <td><% out.println(x1.getIdresidente()); %></td>
                  <td><% out.println(x1.getNombre()+ ", " + x1.getApellidos()); %></td>
                  <td class="">
                    <a data-original-title="Seleccionar" data-placement="left" rel="tooltip"  class="Seleccionarresidente"  code="<% out.println(x1.getIdresidente()); %>" nombres="<% out.println(x1.getNombre() + " " + x1.getApellidos()); %>" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                 </td>
                </tr>
            <%
            }            
            %>
            </tbody>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>

            </form>
            </div>
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cerrar</button>
            </div>
            </div>
            <!-- -->           
            
            
            <!-- -->
            
            <div class="modal hide fade" id="modalmodificar" style="display:none;" aria-hidden="true">
                <div class="modal-header">
                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Editar Vivienda</h6>
                </div>
                <div style="" class="modal-body">
                <h6 id="modal-formLabel">Datos de la Vivienda</h6>
                <form id="frmmodificavivienda" style="" class="form-horizontal fill-up separate-sections">
                    <div>
                    <label for="tipoqueja">Tipo Vivienda </label>
                    <input type="text" required placeholder="tipoVivienda" id="nombre" name="tipoVivienda">
                    </div>
                    <div>
                    <label for="Motivo">Motivo</label>
                    <input type="text" required placeholder="Motivo" id="motivo" name="motivo">
                    </div>
                    <div>
                    <label for="Estado">Estado</label>
                    <input type="text" required placeholder="estado" id="estado" name="estado">
                    </div>
                </form>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
                    <button id="btn-save" class="btn btn-blue">Guardar</button>
                </div>
            </div>

</div>
</body>
</html>

<script type="text/javascript">
 
   
    //Envia el formulario de Vivienda Nueva al Servlet para grabar en BD
   //*********************************************************** 
    
$(document).ready(function(){
    
    $("#btn-save").click(function(){
            var tVi = $("#cmbTipoVivienda").val();
            var tUb  = $("#cmbTipoUbicacion").val();
            var uBi  = $("#txtUbicacion").val();
            var num  = $("#txtNumero").val();
            var met = $("#txtMetraje").val();
            var nom = $("#nombres").val();
            

            if(tVi=='' || tUb=='' || uBi=='' || num=='' ||  met=='' || nom==''){
                alert('Ingrese datos requeridos');
                return false;
            }else{    
                data = $("#frmnuevovivienda").serialize();
                $.ajax({
                    type:'post',
                    url :'InsertarViviendaServlet',
                    data:data,
                    success:function(data){
                        
                        if(data=="ok"){
                            alert("datos grabados con éxito");
                            $("#modalvivienda").modal("hide");
                            location.reload(true);    
                        }else{
                            alert("Error en la grabación");
                        }
                    }

                });
            }        
        });
        
    });
   //***********************************************************
   //Fin
   
   
     $(document).ready(function(){
   //***********************************************************
   //Selecciona un residente para poder asignarlo a una vivienda
       $('.Seleccionarresidente').on('click',function(){
           
            var id   = $(this).attr('code');
            var nombres  = $(this).attr('nombres');

            //aqui le pasamos los datos al formulario modal
            $('#txtIdResidente').val(id);
            $('#txtNombres').val(nombres);
            
   });
   //fin     
   //***********************************************************
   });
</script>
