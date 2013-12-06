<%-- 
    Document   : viviendas
    Created on : Dec 5, 2013, 12:05:02 PM
    Author     : pmurrugarras
--%>

<%@page import="sid.modelo.Vivienda"%>
<%@page import="sid.negocio.GestionVivienda"%>
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
                                <i class="icon-user"></i>
                                Viviendas
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
                   <a title="" class="tip nueva-vivienda" data-toggle="modal" href="#modalvivienda" data-original-title="Agregar Nueva Vivienda">
                       <i class="icon-file-alt"></i>
                       <span>Registrar Nueva Vivienda</span>
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
                  
                  <td><%    int tipoubicacion = Integer.parseInt(x.getTipoUbicacion());
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
            <div class="modal hide fade" id="modalvivienda" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Registro de nueva Vivienda</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Ingrese la Vivienda</h6>
            
            
            <form id="frmnuevovivienda" style="" class="form-horizontal fill-up separate-sections">
            <div>
                <input type="hidden" name="txtIdResidente" id="txtIdResidente" value="${sessionScope.USUARIO_ACTUAL.idresidente}">
                <label for="Ubicación">Ubicación:</label>
                <select name="cmbTipoUbicacion"  id="cmbTipoUbicacion">
                    <option value="1">Zona</option>
                    <option value="2">Edificio</option>
                </select>
            </div>
                <div>
            <label for="txtNumero">Numero</label>
            <input type="text" id="txtNumero" name="txtNumero">
            </div>
                
                <div>
            <label for="txtMetraje">Metraje</label>
            <input type="text" id="txtMetraje" name="txtMetraje">
            </div>
                
                <div>
                <label for="nombre">Tipo vivienda</label>
                <select name="cmbTipoVivienda"  id="cmbTipoVivienda">
                    <option value="1">Casa</option>
                    <option value="2">Departamento</option>
                </select>
            </div>
            
            
                <div>
                <label for="txtDireccion">Dirección</label>
                <textarea name="txtDireccion" rows="5" cols="40" id="Motivo">
                </textarea>
                </div>
            
                
            </form>
                </div>
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            <button id="btn-save" class="btn btn-blue">Guardar</button>
            </div>
            </div>
            <!-- -->
            
            <div class="modal hide fade" id="modalmodificar" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Editar Vivienda</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos de la Vivienda</h6>
            <form id="frmnuevovivienda" style="" class="form-horizontal fill-up separate-sections">
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
    
    $(document).ready(function(){
        
        $("#btn-save").click(function(){
            
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
        });
        
    });
    
</script>