<%@page import="sun.swing.PrintColorUIResource"%>
<html>
<head>
<%@include file="tags.jsp" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
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
                                Registro de Cuotas
                            </h3>
                            <h5>
                               Listado de Cuotas Registradas
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
    
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-residente" data-toggle="modal" href="#modalresidente" data-original-title="Nuevo Residente">
                       <i class="icon-file-alt"></i>
                       <span>Seleccione Residente</span>
                   </a>   
                </div>
                </div>
    	   </div>
            
            <%--mostrar el nombre del residente--%>
            <div>
            <input type="hidden" required placeholder="id" id="idresidente" name="idresidente">
            </div>
            <div>
            <label for="Residente">Residente</label>
            <input type="text" required placeholder="residente seleccionado" id="nombres" name="nombres">
            </div>
    
    
    
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-residente" data-toggle="modal" href="#modalvivienda" data-original-title="Seleccione Vivienda">
                       <i class="icon-file-alt"></i>
                       <span>Seleccione Vivienda</span>
                   </a>   
                </div>
                </div>
    	   </div>
    
            
            <%--mostrar la vivienda seleccionada--%>
            <div>
            <input type="hidden" required placeholder="id" id="idvivienda" name="idvivienda">
            </div>
            <div>
            <label for="Residente">Residente</label>
            <input type="text" required placeholder="Vivienda Seleccionada" id="vivienda" name="vivienda">
            </div>
            
            
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-residente" data-toggle="modal" href="#modalresidente" data-original-title="Nuevo Residente">
                       <i class="icon-file-alt"></i>
                       <span>Registrar Nueva Cuota</span>
                   </a>   
                </div>
                </div>
    	   </div>
    
    
           <%--aca pasamos la accion--%><input type="hidden" required placeholder="id" id="accion" name="accion">
            
            <!-- popup que muestra los residentes para seleccionarlos -->
            <div class="modal hide fade" id="modalresidente" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Listado de residentes</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Seleccione un residente a generarle su(s) cuota(s)</h6>
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
              <th><div>Nombre</div></th>
              <th><div>Correo</div></th>
              <th><div>Tipo documento</div></th>
              <th><div>Seleccionar</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionResidente, sid.modelo.Residente" %>
            <tbody>
            <% 
                GestionResidente negocio = new GestionResidente();
                Collection<Residente> listado = negocio.listar();  
                for(Residente x: listado){
                String tipodoc = x.getTipodoc();
                String docu;
                if(tipodoc=="P"){
                    docu = "Pasaporte";
                }else{
                    docu = "DNI"; 
                }
            
            %>
                <tr id="row_<% out.println(x.getIdresidente()); %>" class="letratablita">
                  <td><% out.println(x.getIdresidente()); %></td>
                  <td><% out.println(x.getNombres() + "," + x.getApellidos()); %></td>
                  <td><% out.println(x.getEmail()); %></td>
                  <td><% out.println(docu); %></td>
                  <td class="">
                    <a data-original-title="Seleccionar" data-placement="left" rel="tooltip" class="Seleccionarresidente"  code="<% out.println(x.getIdresidente()); %>" nombres="<% out.println(x.getNombres() + " " + x.getApellidos()); %>" href="#">
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
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            </div>
            </div>
            <!-- -->
            
            
            <!-- popup que muestra las viviendas seleccionadas -->
            <div class="modal hide fade" id="modalvivienda" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Listado de viviendas del residente:</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Seleccione una vivienda a generarle su(s) cuota(s)</h6>
            <form id="frmvivienda" style="" class="form-horizontal fill-up separate-sections">
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
                
                if (session.getAttribute("vidresidente") != null){
                GestionVivienda objnegociovivienda = new GestionVivienda();
                Collection<Vivienda> listadovivienda = objnegociovivienda.listarviviendaporresidente( Integer.parseInt(session.getAttribute("vidresidente").toString()) );  
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
                    <a data-original-title="Seleccionar" data-placement="left" rel="tooltip" class="Seleccionarvivienda"  code="<% out.println(x.getIdvivienda()); %>" nombres="<% out.println(x.getDireccion()); %>" href="#">
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
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            </div>
            </div>
            <!-- -->
            
            

</div>
    

</body>
</html>

<script type="text/javascript">
    
    $('.seleccionarresidente').on('click',function(){
	var id   = $(this).attr('code');
	var nombres  = $(this).attr('nombres');
	
	//aqui le pasamos los datos al formulario modal
	$('#idresidente').val(id);
	$('#nombres').val(nombres);	
	
    if(nombres=='' || id==''){
            alert('No se ha seleccionado aún un residente');
        }else{
            
            $.ajax({
                type:'post',
                url :'CuotaServlet',
                data:{ accion:"1",idresidente:id.toString().trim()},
                success:function(data){
                    if(data == "ok"){
                        
                    }
                        
                }

            });
        }
            
        
    });
    
    
    $('.seleccionarvivienda').on('click',function(){
	var id   = $(this).attr('code');
	var nombres  = $(this).attr('nombres');
	
	//aqui le pasamos los datos al formulario modal
	$('#idresidente').val(id);
	$('#nombres').val(nombres);	
	
        if(nombres=='' || id==''){
                alert('No se ha seleccionado aún una vivienda');
            }else{
                $.ajax({
                    type:'Get',
                    url :'CuotaServlet',
                    data:{accion: "2", idresidente: id},
                    success:function(data){
                        
                    }

                });
            }
        
    });
    
 
    
</script>