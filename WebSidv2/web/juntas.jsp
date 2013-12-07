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
                                Junta
                            </h3>
                            <h5>
                               Listado de Juntas
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
    
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-junta" data-toggle="modal" href="#modaljunta" data-original-title="Nueva Junta">
                       <i class="icon-file-alt"></i>
                       <span>Nueva Junta</span>
                   </a>   
                </div>
                </div>
    	   </div>
           
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Juntas</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>ID Junta</div></th>
              <th><div>ID residente</div></th>
              <th><div>Expositor</div></th>
              <th><div>Tema</div></th>
              <th><div>Fecha de Ini</div></th>
              <th><div>Fecha de Fin</div></th>
              <th><div>Acuerdo</div></th>
              <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionJunta, sid.modelo.Junta" %>
            <tbody>
            <% 
                GestionJunta negocio = new GestionJunta();
                Collection<Junta> listado = negocio.listar();  
                for(Junta x: listado){
                int idjunta = x.getIdjunta();
                int idresidente = x.getIdresidente();
                String expositor = x.getExpositor();
                String tema = x.getTema();
                String fecha_ini = x.getFecha_ini();
                String fecha_fin = x.getFecha_fin();
                String acuerdo = x.getAcuerdo();
                                        
            %>
               <tr id="row_<% out.println(x.getIdjunta()); %>" class="letratablita">
                  <td><% out.println(idjunta); %></td>
                  <td><% out.println(idresidente);%></td>
                  <td><% out.println(expositor); %></td>
                  <td><% out.println(tema); %></td>
                  <td><% out.println(fecha_ini); %></td>
                  <td><% out.println(fecha_fin); %></td>
                  <td><% out.println(acuerdo); %></td>
                  <td class="">
                    <a data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                    <a href="#" onclick="eliminar(<% out.println(x.getIdjunta()); %>);" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar"><i class="icon-remove icon-large"></i></a>
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
        
            <div class="modal hide fade" id="modaljunta" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
            <h6 id="modal-formLabel">Ingreso de nueva junta</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Registro de Junta</h6>
            <form id="frmnuevajunta" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="idresidente">ID Residente</label>
            <input type="text" required placeholder="ID Residente" id="idresidente" name="idresidente">
            </div>
            <div>
            <label for="expositor">Expositor</label>
            <input type="text" required placeholder="Expositor" id="expositor" name="expositor">
            </div>
            <div>
            <label for="tema">Tema</label>
            <input type="text" required placeholder="Tema" id="tema" name="tema">
            </div>            
            <div>
            <label for="fecha_ini">Fecha de Inicio</label>
            <input type="date" required placeholder="Fecha de Inicio" id="fecha de inicio" name="fecha_ini">
            </div> 
            <div> 
            <label for="hora_ini">Hora de Inicio</label>
            <input type="time" required placeholder="Hora de Inicio" id="hora de inicio" name="hora_ini">
            </div>
            <div>
            <label for="fecha_fin">Fecha de Fin</label>
            <input type="date" required placeholder="Fecha de Fin" id="fecha de fin" name="fecha_fin">
            </div> 
            <div> 
            <label for="hora_fin">Hora de Fin</label>
            <input type="time" required placeholder="Hora de Fin" id="hora de fin" name="hora_fin">
            </div>
            <div>
            <label for="acuerdo">Acuerdo</label>
            <input type="text" required placeholder="Acuerdo" id="acuerdo" name="acuerdo">
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
            
            var idresidente = $("#idresidente").val();
            var expositor  = $("#expositor").val();
            var tema  = $("#tema").val();
            var fecha_ini  = $("#fecha_ini").val();
            var fecha_fin = $("#fecha_fin").val();
            var acuerdo = $("#acuerdo").val();
           
            if(idresidente=='' || expositor=='' || tema=='' || fecha_ini=='' || fecha_fin=='' || acuerdo=='' ){
                alert('Favor complete todo los campos');
            }else{
                data = $("#frmnuevajunta").serialize();
                $.ajax({
                    type:'post',
                    url :'InsertarJuntaServlet',
                    data:data,
                    success:function(data){
                        if(data=="ok"){
                            alert("Se grabó correctamente");
			    $("#modaljunta").modal("hide");
			    location.reload(true);
                        }else{
                            alert("La sala se encuentra separada - probar otra fecha y/o hora");
                        }
                    }

                });
            }
            
        });
        
    });
    
     function eliminar(code){
	if(confirm("¿Desea eliminar junta?")){
		$.ajax({
			type:'post',
			url:'EliminarJuntaServlet',
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