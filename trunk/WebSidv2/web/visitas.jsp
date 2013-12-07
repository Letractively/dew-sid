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
                                Visitas
                            </h3>
                            <h5>
                               Listado de Visitas
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
    
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-visita" data-toggle="modal" href="#modalvisita" data-original-title="Nueva Visita">
                       <i class="icon-file-alt"></i>
                       <span>Nueva Visita</span>
                   </a>   
                </div>
                </div>
    	   </div>
           
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Visitas</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>ID Visita</div></th>
              <th><div>DNI Visita</div></th>
              <th><div>Nombre</div></th>
              <th><div>Fecha de Visita</div></th>
              <th><div>ID Residente</div></th>
              <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionVisita, sid.modelo.Visita" %>
            <tbody>
            <% 
                GestionVisita negocio = new GestionVisita();
                Collection<Visita> listado = negocio.listar();  
                for(Visita x: listado){
                int idvisita = x.getIdvisita();
                int dnivisita = x.getDni_visita();
                String nombre = x.getNombre();
                String fechavisita = x.getFech_visita();
                int idresidente = x.getIdresidente();            
            %>
               <tr id="row_<% out.println(x.getIdvisita()); %>" class="letratablita">
                  <td><% out.println(idvisita); %></td>
                  <td><% out.println(dnivisita);%></td>
                  <td><% out.println(nombre); %></td>
                  <td><% out.println(fechavisita); %></td>
                  <td><% out.println(idresidente); %></td>
                  <td class="">
                    <a data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                    <a href="#" onclick="eliminar(<% out.println(x.getIdvisita()); %>);" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar"><i class="icon-remove icon-large"></i></a>
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
        
            <div class="modal hide fade" id="modalvisita" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
            <h6 id="modal-formLabel">Ingreso de nueva visita</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Registro de Visita</h6>
            <form id="frmnuevavisita" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">DNI</label>
            <input type="text" required placeholder="DNI visita" id="dnivisita" name="dnivisita">
            </div>
            <div>
            <label for="nombre">Nombre</label>
            <input type="text" required placeholder="Nombre visita" id="nomvisita" name="nomvisita">
            </div>
            <div>
            <label for="nombre">Fecha de visita</label>
            <input type="date" required placeholder="Fecha" id="fechvisita" name="fechvisita">
            </div>            
            <div>
            <label for="nombre">Hora de visita</label>
            <input type="time" required placeholder="Hora" id="horavisita" name="horavisita">
            </div>
            <div>
            <label for="nombre">ID visitado</label>
            <input type="text" required placeholder="Codigo de visitado" id="idvisitado" name="idvisitado">
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
            
            var dnivisita = $("#dnivisita").val();
            var nomvisita  = $("#nomvisita").val();
            var fechvisita  = $("#fechvisita").val();
            var horavisita  = $("#horavisita").val();
            var idvisitado = $("#idvistado").val();
           
            if(dnivisita=='' || nomvisita=='' || fechvisita=='' || horavisita=='' || idvisitado==''){
                alert('Favor complete todo los campos');
            }else{
                data = $("#frmnuevavisita").serialize();
                $.ajax({
                    type:'post',
                    url :'InsertarVisitaServlet',
                    data:data,
                    success:function(data){
                        if(data=="ok"){
                            alert("datos grabados con éxito");
			    $("#modalvisita").modal("hide");
			    location.reload(true);
                        }else{
                            alert("Error en la grabación");
                        }
                    }

                });
            }
            
        });
        
    });
    
    function eliminar(code){
	if(confirm("¿Desea eliminar visita?")){
		$.ajax({
			type:'post',
			url:'EliminarVisitaServlet',
			data:'id=' + code,
			success: function(data){
                            if(data=="ok"){
                                location.reload(true);
                            }else{
                               alert("error al eliminar");	
                            }
			}
		});
	}
   }
    
</script>