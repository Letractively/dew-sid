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
                                Quejas
                            </h3>
                            <h5>
                               Listado de Quejas
                            </h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid padded">    
                <div class="action-nav-normal">
                    <div class="span2 action-nav-button">
                        <a title="" class="tip nueva-queja" data-toggle="modal" href="#modalqueja" data-original-title="Agregar Nueva Queja">
                            <i class="icon-file-alt"></i>
                            <span>Registrar Nueva Queja</span>
                        </a>
                    </div>
                </div>
           </div>
           
            <div class="container-fluid padded">
            <div class="row-fluid">
            <div class="span12">
            <div class="box">
            <div class="box-header"><span class="title">Listado de Quejas</span></div>
            <div class="box-content">
                    <!-- find me in partials/data_tables_custom -->
            <div id="dataTables">
            <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
            <thead>
            <tr>
              <th><div>Id. Queja</div></th>
              <th><div>Tipo de Queja</div></th>
              <th><div>Motivo</div></th>
              <th><div>Fecha de Queja</div></th>
              <th><div>Id. de Residente</div></th>
            </tr>
            </thead>
            <%@page import="java.util.*, sid.negocio.GestionQueja, sid.modelo.Queja" %>
            <tbody>
            <% 
                GestionQueja negocio = new GestionQueja();
                Collection<Queja> listado = negocio.listarQuejas();  
                for(Queja x: listado){
            %>
                <tr id="" class="letratablita">
                  <td><% out.println(x.getIdqueja()); %></td>
                  <td><%  
                  int tipoqueja = Integer.parseInt(x.getTipo_queja());
                  switch (tipoqueja) {
            case 1:  out.println("Atención");
                     break;
            case 2:  out.println("Limpieza");
                     break;
            case 3:  out.println("Mantenimiento");
                     break;
            case 4:  out.println("Seguridad");
                     break;
            case 5:  out.println("Separación de Ambientes");
                     break;
            case 6:  out.println("Vigilancia");
                     break;
            case 7:  out.println("Vecinos");
                     break;
            default: out.println("General");
                     break;
                      }
                  
%></td>
                  <td><% out.println(x.getMotivo()); %></td>
                  <td><% out.println(x.getFech_queja()); %></td>
                  <td><% out.println(x.getIdresidente()); %></td>
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
            <div class="modal hide fade" id="modalqueja" style="display:none;" aria-hidden="true">
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Registro de nueva Queja</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Ingrese la Queja</h6>
            
            
            <form id="frmnuevoqueja" style="" class="form-horizontal fill-up separate-sections">
            <div>
                <input type="hidden" name="txtIdResidente" id="txtIdResidente" value="${sessionScope.USUARIO_ACTUAL.idresidente}">
                <label for="nombre">Tipo de Queja</label>
                <select name="cmbTipoQueja"  id="tipoQueja">
                    <option value="1">Atención</option>
                    <option value="2">Limpieza</option>
                    <option value="3">Mantenimiento</option>
                    <option value="4">Seguridad</option>
                    <option value="5">Separación de Ambientes</option>
                    <option value="6">Vigilancia</option>
                    <option value="7">Vecinos</option>
                </select>
            </div>
            <div>
            <label for="fecha">Fecha de Ocurrencia</label>
            <input type="date" id="fechaOcurrencia" name="datFechaOcurrencia">
            </div>
            
                <div>
                <label for="motivo">Motivo</label>
                <textarea name="txtMotivo" rows="5" cols="40" id="Motivo">
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
                    <h6 id="modal-formLabel">Editar Queja</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos de la Queja</h6>
            <form id="frmnuevoresidente" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <label for="tipoqueja">Tipo Queja </label>
            <input type="text" required placeholder="tipoQueja" id="nombre" name="tipoQueja">
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
            
                data = $("#frmnuevoqueja").serialize();
                $.ajax({
                    type:'post',
                    url :'InsertarQuejaServlet',
                    data:data,
                    success:function(data){
                        if(data=="ok"){
                            alert("datos grabados con éxito");
                $("#modalqueja").modal("hide");
                location.reload(true);    
                        }else{
                            alert("Error en la grabación");
                        }
                    }

                });
          //  }
            
        });
        
    });
    
</script>