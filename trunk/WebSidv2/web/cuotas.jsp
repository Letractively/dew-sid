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
                                Cuotas Pendientes
                            </h3>
                            <h5>
                               Listado de Cuotas pendientes
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
    
                   
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Cuotas pendientes</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->

            <div id="dataTables">

            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
               <th><div>ID</div></th>
              <th><div>PERIODO</div></th>
              <th><div>A�O</div></th>
              <th><div>NOMBRE</div></th>
              <th><div>DNI</div></th>
                <th><div>IMPORTE</div></th>
                <th><div>FECHA VENCIMIENTO</div></th>
                <th><div>IDV</div></th>
                <th><div>DIRECCION</div></th>
                <th><div>Opciones</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionCuota, sid.modelo.Cuota" %>
            <tbody>

                 <% 
                GestionCuota negocio = new GestionCuota();
                Collection<Cuota> listado = negocio.listarpendientes(1);
                for(Cuota x: listado){
            %>
                <tr id="" class="letratablita">
                  <td><% out.println(x.getIdCuotas()); %></td>
                  <td><% out.println(x.getperiodo()); %></td>
                  <td><% out.println(x.getanio()); %></td>
                  <td><% out.println(x.getResidente().getNombres()); %></td>
                  <td><% out.println(x.getResidente().getDni()); %></td>
                  <td><% out.println(x.getimporte()); %></td>
                  <td><% out.println(x.getfech_venc()); %></td>
                  <td><% out.println(x.getidvivienda()); %></td>
                  <td><% out.println(x.getVivienda().getDireccion()); %></td>
                  
                  <td class="">
                    <a data-original-title="Realizar Pago" data-placement="left" rel="tooltip" class="ingresar" vfechavenc="<% out.println(x.getfech_venc()); %>" vimporte="<% out.println(x.getimporte()); %>" vvivienda="<% out.println(x.getVivienda().getDireccion()); %>" vperiodo="<% out.println(x.getperiodo()); %>"  vidvivienda="<% out.println(x.getidvivienda()); %>" vidcuota="<% out.println(x.getIdCuotas()); %>"   data-toggle="modal" href="#modalpagocuota" data-original-title="Nuevo pago" >
                    <i class="icon-edit icon-large"></i>
                    </a>
                  </td>
                </tr>
            <%
                
            }            %>

            </tbody>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
        
            <div class="modal hide fade" id="modalpagocuota" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">�</button>
                    <h6 id="modal-formLabel">Registrar pago de Cuota</h6>
            </div>
           <div style="" class="modal-body">
            <h6 id="modal-formLabel">Registro de pago de cuota</h6>
            <form id="frmactualiza" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="nombre">NroCuota</label>
            <input type="text" required placeholder="nombre" id="idcuota" name="idcuota" readonly="true">
            
            </div>
            <div>
            <label for="nombre">Vivienda</label>
            <input type="text" required placeholder="apellid" id="vivienda" name="vivienda" readonly="true">
            </div>
            <div>
            <input type="hidden" required placeholder="apellid" id="idvivienda" name="idvivienda" readonly="true">
            </div>
            <div>                
            <label for="nombre">Periodo</label>
            <input type="text" required placeholder="email" id="periodo" name="periodo" readonly="true">
            </div>
            <div>
            <label for="nombre">Importe</label>
            <input type="text" required placeholder="fechanac" id="importe" name="importe" readonly="true">
            
            <label for="nombre">Fecha de vencimiento</label>
            <input type="text" required placeholder="fechanac" id="fechavenc" name="fechavenc" readonly="true">
            </div>
                
            <div>
            <label for="nombre">Tipo de pago</label>
            <select name="identificacion" id="identificacion">
               <option value="E">Efectivo</option>
               <option value="P">Cheque</option>
               <option value="T">Tarjeta</option>
            </select>
            </div>
                
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            <button id="btn-update" class="btn btn-blue">Realizar pago</button>
            </div>
            </form>
            </div>


</div>
    

</body>
</html>

<script type="text/javascript">
      $('.ingresar').on('click',function(){
	var idvivienda   = $(this).attr('vidvivienda');
	var idcuota  = $(this).attr('vidcuota');
        var periodo  = $(this).attr('vperiodo');
        var vivienda  = $(this).attr('vvivienda');
        var importe  = $(this).attr('vimporte');
        var fechavenc  = $(this).attr('vfechavenc');
	
	//aqui le pasamos los datos al formulario modal
	$('#idvivienda').val(idvivienda);
	$('#idcuota').val(idcuota);	
        $('#periodo').val(periodo);	
        $('#vivienda').val(vivienda);	
        $('#importe').val(importe);	
        $('#fechavenc').val(fechavenc);	
	
    });
    
    $(document).ready(function(){
        
        $("#btn-update").click(function(){
                        
                data = $("#frmactualiza").serialize();
                $.ajax({
                    type:'post',
                    url :'CuotaServlet',
                    data:data,
                    success:function(data){
                        alert(data);
                        if(data=='ok'){
                            alert('Datos grabados');
                        }else{
                            alert('Error en la grabaci�n');
                        }
                    }

                });
            
            
        });
        
    });
    
</script>