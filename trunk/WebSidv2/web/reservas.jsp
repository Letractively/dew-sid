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
                               Listado de mis Reservas
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
            <div class="box-header"><span class="title">Mis Reservas</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>N° reserva</div></th>
              <th><div>Espacio comun</div></th>
              <th><div>Fecha</div></th>
              <th><div>Hora</div></th>
              <th><div>N° horas</div></th>
              <th><div>Estado</div></th>      
              <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionReserva, sid.modelo.Reserva, sid.negocio.GestionEspacioComun, sid.modelo.EspacioComun" %>
            <tbody>
            <%  
                int code = obj.getIdresidente();
                GestionReserva re = new GestionReserva();
                Collection<Reserva> listado = re.misreservas(code);
                String estado;
                for(Reserva r:listado){
                int state = r.getEstado();
                if(state==1){
                    estado = "Activar";
                }else{
                    estado = "Usada";
                }
            %>
                <tr id="row_<% out.println(r.getIdreserva()); %>" class="letratablita">
                  <td><% out.println(r.getIdreserva()); %></td>
                  <td><% out.println(r.getNomespacio()); %></td>
                  <td><% out.println(r.getFecha()); %></td>
                  <td><% out.println(r.getHora()); %></td>
                  <td><% out.println(r.getTiempo()); %></td>
                  <td><% out.println(estado); %></td>
                  <td class="">
                    <!--<a data-original-title="Editar" data-placement="left" rel="tooltip" class="actualizar"  code="" href="#">
                    <i class="icon-edit icon-large"></i>
                    </a>-->
                    <a href="#" onclick="deletefile(<% out.println(r.getIdreserva()); %>);" class="delete" rel="tooltip" data-placement="right" data-original-title="Eliminar"><i class="icon-remove icon-large"></i></a>
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
            <div class="modal hide fade" id="modalreserva" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Reserva de espacio común</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos de reserva</h6>
            <form id="frmnuevareserva" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">Espacio comun</label>
            <select name="espaciocomun" id="espaciocomun">
               <option value="">[Seleccione]</option>
               <% 
                GestionEspacioComun esp = new GestionEspacioComun();
                Collection<EspacioComun> lista = esp.listado();
                for(EspacioComun r:lista){
               %>
               <option value="<%out.println(r.getIdespaciocomun());%>"><% out.println(r.getNombre()); %></option>
               <%
                }
               %>
            </select>
            </div>
            <div>
            <label for="nombre">Fecha reserva</label>
            <input type="text" required placeholder="Fecha reserva" id="fechar" name="fechar">
            </div>
            <div>
            <label for="nombre">Hora reserva</label>
            <select name="horar" id="horar">
            <option value="00:00">00:00</option>
            <option value="01:00">01:00</option>							
            <option value="02:00">02:00</option>									
            <option value="03:00">03:00</option>
            <option value="04:00">04:00</option>
            <option value="05:00">05:00</option>
            <option value="06:00">06:00</option>
            <option value="07:00">07:00</option>
            <option value="08:00">08:00</option>
            <option value="09:00">09:00</option>
            <option value="10:00">10:00</option>
            <option value="11:00">11:00</option>
            <option value="12:00">12:00</option>
            <option value="13:00">13:00</option>
            <option value="14:00">14:00</option>
            <option value="15:00">15:00</option>
            <option value="16:00">16:00</option>
            <option value="17:00">17:00</option>
            <option value="18:00">18:00</option>
            <option value="19:00">19:00</option>
            <option value="20:00">20:00</option>
            <option value="21:00">21:00</option>
            <option value="22:00">22:00</option>
            <option value="23:00">23:00</option>
            </select>
            </div>
            <div>
            <label for="nombre">N° horas</label>
            <select name="nhoras" id="nhoras">
               <option value="2">2</option>
               <option value="4">4</option>
            </select>
            </div>
            <div>
                <input type="hidden" id="codresidente" name="codresidente" value="<% out.print(obj.getIdresidente()); %>"> 
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
<script type="text/javascript">
$(document).ready(function(e){    
    $("#btn-save").click(function(){
      var idespa = $("#espaciocomun").val();
      var fechr  = $("fechar").val();
      var horar  = $("#horar").val();
      var nhoras = $("#nhoras").val();
      var idres  = $("#codresidente").val();
      if(idespa==''|| fechr=='' || horar==''){
         alert("Ingrese datos requeridos");
      }else{
         data = $("#frmnuevareserva").serialize();
         $.ajax({
             type:'post',
             url: 'RealizarReservaServlet',
             data:data,
             success:function(data){
                 if(data=="ok"){
                    alert("Reserva realizada con exito");
		    $("#modalresidente").modal("hide");
		    location.reload(true);
                  }else if(data=="err"){
                    alert("¡Error!..La fecha esta reservada");
                  }else{
                    alert("Error en la reserva");
                  }
             }
         })
     }
        
        
    });
});
//
function deletefile(code){
    if(confirm("¿Desea eliminar la reserva?")){
	$.ajax({
		type:'post',
		url:'EliminarReservaServlet',
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