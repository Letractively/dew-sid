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
              <th><div>Numero documento</div></th>
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
                String tipodoc = x.getTipodoc();
                String docu;
                /*if(tipodoc=="P"){
                    docu = "Pasaporte";
                }else{
                    docu = "DNI"; 
                }*/
            
            %>
                <tr id="row_<% out.println(x.getIdresidente()); %>" class="letratablita">
                  <td><% out.println(x.getIdresidente()); %></td>
                  <td><% out.println(x.getNombres() + "," + x.getApellidos()); %></td>
                  <td><% out.println(x.getEmail()); %></td>
                  <td><% out.println(x.getNro()); %></td>
                  <td><% out.println(x.getFech_nac()); %></td>
                  <td class="">
                    <a data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar"  code="<% out.println(x.getIdresidente()); %>" pwd="<% out.println(x.getPassword()); %>" nom="<% out.println(x.getNombres()); %>" ape="<% out.println(x.getApellidos()); %>" mail="<% out.println(x.getEmail()); %>"   tipid="<% out.println(x.getTipodoc()); %>" nrodoc="<% out.println(x.getNro()); %>"   fech="<% out.println(x.getFech_nac()); %>" pwd="<% out.println(x.getPassword()); %>" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>
                    <a href="#" onclick="eliminar(<% out.println(x.getIdresidente()); %>);" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar"><i class="icon-remove icon-large"></i></a>
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
            <input type="text" required placeholder="apellido" id="apellido" name="apellido">
            </div>
            <div>
            <label for="nombre">Email (*)</label>
            <input type="text" required placeholder="email" id="email" name="email">
            </div>
            
            <h6 id="modal-formLabel">Otros Datos</h6>
            <div>
            <label for="nombre">Fecha nacimiento</label>
            <input type="text" required placeholder="fechanac" id="fechanac" name="fechanac">
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
            <label for="nombre">Nro Documento</label>
            <input type="password" required placeholder="Nro documento" id="direccion" name="numdoc">
            </div>
            <div>
            <label for="nombre">Password (*)</label>
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
            <label for="nombre">Nro Documento</label>
            <input type="text" required placeholder="Nro documento" id="numdocupdate" name="numdocupdate">
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
	var fecha= $(this).attr('fech');
	var tipid= $(this).attr('tipid');
        var ndoc = $(this).attr('nrodoc');
	
	//aqui le pasamos los datos al formulario modal
	$('#codeupdate').val(id);
	$('#nomupdate').val(nom);
	$('#apeupdate').val(ape);
	$('#mailupdate').val(mail);
        $('#pwdupdate').val(pwd);
        $('#fecupdate').val(fecha);
	$('#idenupdate').val(tipid);
        $('#numdocupdate').val(ndoc);
	$('#modalmodificar').modal();	
	
    });
    
    $(document).ready(function(){
        
     /*var dates = $("#fechanac").datepicker({
            //dateFormat: 'yy-mm-dd', //dd-mm-yy
            showOn: "both",
            buttonImage: "images/calendar.gif",
            buttonImageOnly: true,
            monthNamesShort: ['ene','feb','mar','abr','may','jun','jul','ago','sep','oct','nov','dic'],
            changeMonth: true,
            changeYear: true,
            yearRange: "-90:-18",	
            numberOfMonths: 1
    });

    $('#fechanac').keypress(function(){ return false;});
    $('#fechanac').click(function(){ return false;});*/   
        
        $("#btn-save").click(function(){
            
            var name = $("#nombre").val();
            var ape  = $("#apellido").val();
            var pwd  = $("#contrasena").val();
            var doc  = $("#identificacion").val();
            var ndoc = $("#numdoc").val();
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
                        }else if(data=="err"){
                            alert("El correo ingresado ya existe");
                        }else{
                            alert("Error en la grabación");
                        }
                    }

                });
            }
            
        });
        
        $('#btn-update').click(function(){
		var name = $("#nomupdate").val();
		var ape  = $("#mailupdate").val();
		var pwd  = $("#pwdupdate").val();
		if(name=='' || ape=='' || pwd==''){
			alert('Ingrese datos requeridos');
		}else{
			datin = $('#frmuseredita').serialize();
			$.ajax({
				type:'post',
				url:'ActualizarResidenteServlet',
				data:datin,
				success: function(data){
					if(data=='okis'){
						alert('datos actualizados con éxito');
						$('#modalmodificar').modal('hide');
						location.reload(true);
					}else{
						alert('ocurrió un error');
					}
				}
			});
		}
		
	});
        
        
    });
    
    function eliminar(code){
	if(confirm("¿Desea eliminar residente?")){
		$.ajax({
			type:'post',
			url:'EliminarResidenteServlet',
			data:'id=' + code,
			success: function(data){
                            if(data=="okis"){
                                location.reload(true);
                               //$("#row_" + code).remove();
                               //alert('Se elimino cliente');	
                            }else{
                               alert("error al eliminar");	
                            }
			}
		});
	}
   }
    
</script>