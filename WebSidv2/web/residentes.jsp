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
                                Residentes
                            </h3>
                            <h5>
                               Listado de Residentes
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
                       <span>Nuevo Residente</span>
                   </a>   
                </div>
                </div>
    	   </div>
           
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
              <th><div>Tipo document</div></th>
              <th><div>Fecha Nacimiento</div></th>
              <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionResidente, sid.modelo.Residente" %>
            <tbody>
            <% 
                GestionResidente negocio = new GestionResidente();
                Collection<Residente> listado = negocio.listar();  
                for(Residente x: listado){
                String doc = x.getDni();
                String docu;
                if(doc=="D"){
                    docu = "DNI";
                }else{
                    docu = "Pasaporte"; 
                }
            
            %>
                <tr id="" class="letratablita">
                  <td><% out.println(x.getIdresidente()); %></td>
                  <td><% out.println(x.getNombres() + "," + x.getApellidos()); %></td>
                  <td><% out.println(x.getEmail()); %></td>
                  <td><% out.println(docu); %></td>
                  <td><% //out.println(x.getFech_nac()); %></td>
                  <td class="">
                    <a data-original-title="Editar Residente" data-placement="left" rel="tooltip" class="actualizar"  fono="" tipid="" direc="" href="#" code="<% out.println(x.getIdresidente()); %>" >
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
            <!-- -->
            <div class="modal hide fade" id="modalresidente" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Ingreso de nuevo Residente</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos personales</h6>
            <form id="frmnuevoresidente" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">Nombre (*)</label>
            <input type="text" required placeholder="nombre" id="nombre" name="nombre">
            </div>
            <div>
            <label for="nombre">Apellidos</label>
            <input type="text" required placeholder="apellid" id="apellido" name="apellido">
            </div>
            <div>
            <label for="nombre">Email (*)</label>
            <input type="text" required placeholder="email" id="email" name="email">
            </div>
            
            <h6 id="modal-formLabel">Otros Datos</h6>
            <div>
            <label for="nombre">Fecha nacimiento</label>
            <input type="text" required placeholder="fechanac" id="apellido" name="fechanac">
            </div>
            <div>
            <label for="nombre">Datos de identificación</label>
            <select name="identificacion" id="identificacion">
               <option value="">[Seleccione documento]</option>
               <option value="D">DNI</option>
               <option value="P">Pasaporte</option>
            </select>
            </div>
            <div>
            <label for="nombre">Password</label>
            <input type="password" required placeholder="contrasena de cliente" id="direccion" name="contrasena">
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
                    <h6 id="modal-formLabel">Editar Residente</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos personales</h6>
            <form id="frmnuevoresidente" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">Nombre (*)</label>
            <input type="text" required placeholder="nombre" id="nombre" name="nombre">
            </div>
            <div>
            <label for="nombre">Apellidos</label>
            <input type="text" required placeholder="apellid" id="apellido" name="apellido">
            </div>
            <div>
            <label for="nombre">Email (*)</label>
            <input type="text" required placeholder="email" id="email" name="email">
            </div>
            
            <h6 id="modal-formLabel">Otros Datos</h6>
            <div>
            <label for="nombre">Fecha nacimiento</label>
            <input type="text" required placeholder="fechanac" id="apellido" name="fechanac">
            </div>
            <div>
            <label for="nombre">Datos de identificación</label>
            <select name="identificacion" id="identificacion">
               <option value="">[Seleccione documento]</option>
               <option value="D">DNI</option>
               <option value="P">Pasaporte</option>
            </select>
            </div>
            <div>
            <label for="nombre">Password</label>
            <input type="password" required placeholder="contrasena de cliente" id="direccion" name="contrasena">
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
    
    $('.actualizar').on('click',function(){
	var id   = $(this).attr('code');
	var nom  = $(this).attr('nom');
	var ape  = $(this).attr('ape');
	var mail = $(this).attr('mail');
	var pwd  = $(this).attr('pwd');
	var fono = $(this).attr('fono');
	var tipid= $(this).attr('tipid');
	var dir  = $(this).attr('direc');
	//aqui le pasamos los datos al formulario modal
	$('#codeupdate').val(id);
	$('#nomupdate').val(nom);
	$('#apeupdate').val(ape);
	$('#mailupdate').val(mail);
	$('#pwdupdate').val(pwd);
	$('#fonoupdate').val(fono);
	$('#idenupdate').val(tipid);
	$('#dirupdate').val(dir);
	$('#modalmodificar').modal();	
	
    });
    $(document).ready(function(){
        
        $("#btn-save").click(function(){
            
            var name = $("#nombre").val();
            var ape  = $("#apellido").val();
            var pwd  = $("#contrasena").val();
            var doc  = $("#identificacion").val();
            var mail = $("#email").val();
            var fech = $("fechanac").val();

            if(name=='' || ape=='' || pwd==''){
                alert('Ingrese datos requeridos');
            }else{
                data = $("#frmnuevoresidente").serialize();
                $.ajax({
                    type:'post',
                    url :'InsertarResidenteServlet',
                    data:data,
                    success:function(data){
                        if(data=="ok"){
                            alert("datos grabados con éxito");
			    $("#modalresidente").modal("hide");
			    location.reload(true);	
                        }else{
                            alert("Error en la grabación");
                        }
                    }

                });
            }
            
        });
        
    });
    
</script>