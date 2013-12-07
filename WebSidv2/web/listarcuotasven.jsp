<%-- 
    Document   : listarcuotasven
    Created on : Dec 6, 2013, 10:10:44 AM
    Author     : Juan Carlos
--%>

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
                                Cuotas Vencidas
                            </h3>
                            <h5>
                                <%--  Listado de Morosos --%>
                            </h5>
                        </div>


                    </div>
                </div>
            </div>



            <div class="container-fluid padded">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="box">
                            <div class="box-header"><span class="title">Listado de Morosos</span></div>
                            <div class="box-content">
                                <!-- find me in partials/data_tables_custom -->

                                <div id="dataTables">

                                    <table cellpadding="0" cellspacing="0" border="0" class="table dTable responsive">
                                        <thead>
                                            <tr>

                                            <th><div>Nombre y Apellido</div></th>
                                    <th><div>DNI</div></th>
                                            <th><div>Periodo</div></th>
                                            <th><div>Año</div></th>
                                       <th><div>Importe</div></th>
                                              <th><div>Fecha Vencimiento</div></th>
                                       <th><div>Dirección</div></th>

                                        </tr>
                                        </thead>
                                        <%@page import="java.util.*, sid.negocio.GestionCuota, sid.modelo.Cuota" %>
            <tbody>
            <% 
                GestionCuota negocio = new GestionCuota();
                Collection<Cuota> listado = negocio.listarvencidas();
                for(Cuota x: listado){
            %>
                <tr id="" class="letratablita">
                  <td><% //out.println(); %></td>
                  <td><% out.println(x.getResidente().getApellidos() + ", " + x.getResidente().getNombre()); %></td>
                  <td><% out.println(x.getResidente().getNro()); %></td>
                  <td><% out.println(x.getperiodo()); %></td>
                  <td><% out.println(x.getanio()); %></td>
                  <td><% out.println(x.getimporte()); %></td>
                  <td><% out.println(x.getfech_venc()); %></td>
                  <td><% out.println(x.getVivienda().getUbicacion()); %></td>
                  <td class="">
                    <a data-original-title="Editar Mensaje" data-placement="left" rel="tooltip" class="actualizar"  fono="" tipid="" direc="" href="#" >
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

            <div class="modal hide fade" id="modalmensajeria" style="display:none;" aria-hidden="true">
                <div class="modal-header">
                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Ingreso de Nuevo Mensaje</h6>
                </div>
                <div style="" class="modal-body">
                    <h6 id="modal-formLabel">Datos</h6>
                    <form id="frmnuevomensaje" style="" class="form-horizontal fill-up separate-sections">
                        <div>
                            <label for="nombre">Titulo (*)</label>
                            <input type="text" required placeholder="titulo" id="titulo" name="titulo">
                        </div>
                        <div>
                            <label for="nombre">Contenido</label>
                            <input type="text" required placeholder="contenido" id="apellido" name="contenido">
                        </div>
                        <div>
                            <label for="nombre">Fecha de Publicación</label>
                            <input type="text" required placeholder="fechapub" id="apellido" name="fechapub">
                        </div>
                        <div>


                    </form>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
                    <button id="btn-enviar" class="btn btn-blue">Enviar</button>
                </div>
            </div>


        </div>


    </body>
</html>

<script type="text/javascript">
    $(document).ready(function() {

        $("#btn-enviar").click(function() {

            var titulo = $("#titulo").val();
            var contenido = $("#contenido").val();
            var fechpub = $("fechapub").val();

            if (name == '' || ape == '' || pwd == '') {
                alert('Ingrese datos requeridos');
            } else {
                data = $("#frmnuevomensaje").serialize();
                $.ajax({
                    type: 'post',
                    url: 'InsertarResidenteServlet',
                    data: data,
                    success: function(data) {
                        if (data == 'ok') {
                            alert('Datos grabados');
                        } else {
                            alert('Error en la grabación');
                        }
                    }

                });
            }

        });

    });

</script>
