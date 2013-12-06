<%-- 
    Document   : viviendasresidente
    Created on : 05/12/2013, 01:29:13 PM
    Author     : JULIO
--%>

<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="tags.jsp" %>
    </head>
    <body>
        
    
<div class="sidebar-background">
        <div class="primary-sidebar-background"></div>
</div>

        <div class="main-content">
            <div class="container-fluid">
                <div class="row-fluid">

                    <div class="area-top clearfix">
                        <div class="pull-left header">
                            <h5>
                                Viviendas de : <%= session.getAttribute("snombre_residente").toString() %>
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
         <!-- popup que muestra las viviendas seleccionadas -->
            <div class="modal-header">
                    <h6 id="modal-formLabel">Seleccione una vivienda a generarle su(s) cuota(s)</h6>
            </div>
                <div style="" class="modal-body">
            
            <form id="frmvivienda" style="" class="form-horizontal fill-up separate-sections">
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>N°</div></th>
              <th><div>Zona</div></th>
              <th><div>Edificio</div></th>
              <th><div>Numero</div></th>
              <th><div>Tipo</div></th>
              <th><div>Dirección</div></th>
            <th><div>Seleccionar</div></th>
            </tr>
            </thead>
            <%@page import="sid.negocio.GestionVivienda, sid.modelo.Vivienda" %>
            <tbody>
            <% 
                
                if (session.getAttribute("sidresidente") != null){
                GestionVivienda objnegociovivienda = new GestionVivienda();
                Collection<Vivienda> listadovivienda = objnegociovivienda.listarviviendaporresidente( Integer.parseInt(session.getAttribute("sidresidente").toString()) );  
                for(Vivienda x: listadovivienda){ 
            %>
                <tr id="row_<% out.println(x.getIdvivienda()); %>" class="letratablita">
                  <td><% out.println(x.getIdvivienda()); %></td>
                  <td><% out.println(x.getZona()); %></td>
                  <td><% out.println(x.getEdificio()); %></td>
                  <td><% out.println(x.getNumero()); %></td>
                  <td><% out.println(x.getTipo()); %></td>
                  <td><% out.println(x.getDireccion()); %></td>
                  <td class="">
                      <a data-original-title="Seleccionar" data-placement="left" rel="tooltip" class="seleccionarvivienda"  idviviendav="<% out.println(String.valueOf( x.getIdvivienda())); %>" direccionv="<% out.println(x.getDireccion()); %>" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                 </td>
                </tr>
            <%
            }    }        
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
                <button data-dismiss="modal" class="btn btn-default" onclick="self.close()">Cancelar</button>
            </div>
           
            <!-- -->
            </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function(){
        $('.seleccionarvivienda').on('click',function(){
               var idviviendax   = $(this).attr('idviviendav');
               var direccionx  = $(this).attr('direccionv');



               if(idviviendax=='' || direccionx==''){
                       alert('No se ha seleccionado aún una vivienda');
                   }else{
                       $.ajax({
                           type:'post',
                           url :'CuotaServlet',
                           data:{accion: "2", vidvivienda: idviviendax,vdireccion:direccionx},
                           success:function(data){
                               if(data=="ok"){
                                   alert("se selecciono la vivienda: " + direccionx);
                                   mostrar();
                                   self.close()
                               }
                               else
                                   alert("ocurrio un error al seleccionar.");
                           }

                       });
                       
                        
                   }

           });
       }); 
       
    function mostrar(){
        $.ajax({
           type:'Get',
           url :'resgistrocuotas.jsp/mostrarviviendaseleccionada',
           data:{accion: ""},
           success:function(data){

           }

       });
    }
    
 
        </script>