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
                                Fechas libres
                            </h3>
                            <h5>
                                Ver fechas disponibles
                            </h5>
                        </div>


                    </div>
                </div>
            </div>

            <!--<div class="container-fluid padded">    
                <div class="action-nav-normal">
                <div class="span2 action-nav-button">
                   <a title="" class="tip nueva-residente" data-toggle="modal" href="#modalreserva" data-original-title="Nueva reserva">
                       <i class="icon-file-alt"></i>
                       <span>Nueva reserva</span>
                   </a>   
                </div>
                </div>
           </div>-->

            <div class="container-fluid padded">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="box">
                            <div class="box-header"><span class="title">Semana del  2-12-2013 al  8-12-2013</span></div>
                            <div class="box-content">
                                <div id="dataTables">

                                    <table cellpadding="0" cellspacing="0" border="1" class="table responsive">
                                        <thead>
                                            <tr class="fondotablita">
                                                <th><div>Hora</div></th>
                                        <th><div>Lunes</div></th>
                                        <th><div>Martes</div></th>
                                        <th><div>Miercoles</div></th>
                                        <th><div>Jueves</div></th>
                                        <th><div>Viernes</div></th>      
                                        <th><div>Sabado</div></th>
                                        <th><div>Domingo</div></th>
                                        </tr>
                                        </thead>
                                        <%@page import="java.util.*, sid.negocio.GestionReserva, sid.modelo.Reserva, sid.negocio.GestionEspacioComun, sid.modelo.EspacioComun" %>
                                        <tr>
                                            <td></td>  
                                            <td>2</td>
                                            <td>3</td>
                                            <td>4</td>
                                            <td>5</td>
                                            <td>6</td>
                                            <td>7</td>
                                            <td>8</td>
                                        </tr>
                                        <tbody>
                                            <%  
                                                GestionReserva objre = new GestionReserva();
                                                String hora, num,cad1,cad2,cad3,cad4,cad5,cad6,cad7,href,clase,texto,fondo1,fondo2,fondo3,fondo4,fondo5,fondo6,fondo7;
                                                int i;
                                                for (i = 6; i < 24; i++) {
                                                    hora = i + ":00";
                                                    
                                                    //for(Reserva x:listado){     
                                                   
                                            %>    
                                            <tr id="row_" class="letratablita">
                                                <td><% out.println(i);%>:00</td>
                                                    <%  String fecha1 = "2013-12-02";
                                                        Collection<Reserva> listado1 = objre.buscaxfecha(fecha1, hora);
                                                        int n1 = listado1.size(); //out.println(n1);
                                                        if(n1>0){
                                                            cad1 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo1= "fondocolumn";
                                                        }else{
                                                            cad1 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo1= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha1); %>" class="reser <% out.println(fondo1); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad1);%></a>
                                                </td>
                                                <%  String fecha2 = "2013-12-03";
                                                        Collection<Reserva> listado2 = objre.buscaxfecha(fecha2, hora);
                                                        int n2 = listado2.size();
                                                        if(n2>0){
                                                            cad2 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo2= "fondocolumn";
                                                        }else{
                                                            cad2 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo2= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha2); %>" class="reser <% out.println(fondo2); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad2);%></a>
                                                </td>
                                                    <%  String fecha3 = "2013-12-04";
                                                        Collection<Reserva> listado3 = objre.buscaxfecha(fecha3, hora);
                                                        int n3 = listado3.size();
                                                        if(n3>0){
                                                            cad3 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo3= "fondocolumn";
                                                        }else{
                                                            cad3 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo3= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha3); %>" class="reser <% out.println(fondo3); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad3);%></a>
                                                </td>
                                                    <%  String fecha4 = "2013-12-05";
                                                        Collection<Reserva> listado4 = objre.buscaxfecha(fecha4, hora);
                                                        int n4 = listado4.size();
                                                        if(n4>0){
                                                            cad4 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo4= "fondocolumn";
                                                        }else{
                                                            cad4 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo4= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha4); %>" class="reser <% out.println(fondo4); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad4);%></a>
                                                </td>
                                                      <%  String fecha5 = "2013-12-06";
                                                        Collection<Reserva> listado5 = objre.buscaxfecha(fecha5, hora);
                                                        int n5 = listado5.size();
                                                        if(n5>0){
                                                            cad5 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo5= "fondocolumn";
                                                        }else{
                                                            cad5 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo5= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha5); %>" class="reser <% out.println(fondo5); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad5);%></a>
                                                </td>
                                                    <%  String fecha6 = "2013-12-07";
                                                        Collection<Reserva> listado6 = objre.buscaxfecha(fecha6, hora);
                                                        int n6 = listado6.size();
                                                        if(n6>0){
                                                            cad6 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo6= "fondocolumn";
                                                        }else{
                                                            cad6 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo6= "";
                                                        }
                                                        
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha6); %>" class="reser <% out.println(fondo6); %>">
                                                    <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad6);%></a>
                                                </td>
                                                    <%  String fecha7 = "2013-12-08";
                                                        Collection<Reserva> listado7 = objre.buscaxfecha(fecha7, hora);
                                                        int n7 = listado7.size();
                                                        if(n7>0){
                                                            cad7 = "Reservado";
                                                            href = "";
                                                            clase= "urlcolor";
                                                            texto= "No disponible";
                                                            fondo7= "fondocolumn";
                                                        }else{
                                                            cad7 = "Reservar";
                                                            href = "#modalreserva";
                                                            clase= "";
                                                            texto= "Nueva reserva";
                                                            fondo7= "";
                                                        }
                                                    %>
                                                <td hora="<% out.println(hora);%>" fech="<% out.println(fecha7); %>" class="reser <% out.println(fondo7); %>">
                                                     <a title="" class="tip nueva-reserva <% out.println(clase); %>" data-toggle="modal" href="<% out.println(href); %>" data-original-title="<% out.println(texto); %>"><% out.println(cad7);%></a>
                                                </td>
                                            </tr>
                                            <%
                                                    //}
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
                            <label for="nombre">Espacio comun(*)</label>
                            <select name="espaciocomun" id="espaciocomun">
                                <option value="">[Seleccione]</option>
                                <%
                                    GestionEspacioComun esp = new GestionEspacioComun();
                                    Collection<EspacioComun> lista = esp.listado();
                                    for (EspacioComun r : lista) {
                                %>
                                <option value="<%out.println(r.getIdespaciocomun());%>"><% out.println(r.getNombre());%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <label for="nombre">Fecha reserva(*)</label>
                            <input type="text" required placeholder="Fecha reserva" id="fechar" name="fechar">
                        </div>
                        <div>
                            <label for="nombre">Hora reserva(*)</label>
                            <select name="horar" id="horar">
                                <option value="6:00">6:00</option>
                                <option value="7:00">7:00</option>
                                <option value="8:00">8:00</option>
                                <option value="9:00">9:00</option>
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
                            <label for="nombre">N° horas(*)</label>
                            <select name="nhoras" id="nhoras">
                                <option value="">[Seleccione]</option>
                                <option value="2">2</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <div>
                            <input type="hidden" id="codresidente" name="codresidente" value="<% out.print(obj.getIdresidente());%>"> 
                        </div>


                    </form>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
                    <button id="btn-save" class="btn btn-blue">Reservar</button>
                </div>
            </div>
            <!-- -->


        </div>


    </body>
</html>
<script type="text/javascript">

    var $obj = '';
    $(document).ready(function(e) {
        /*var dates = $("#fechar").datepicker({
            showOn: "both",
            buttonImage: "images/calendar.gif",
            buttonImageOnly: true,
            monthNamesShort: ['ene', 'feb', 'mar', 'abr', 'may', 'jun', 'jul', 'ago', 'sep', 'oct', 'nov', 'dic'],
            changeMonth: true,
            changeYear: true,
            yearRange: "-90:-18",
            numberOfMonths: 1
        });

        $('#fechar').keypress(function() {
            return false;
        });
        $('#fechar').click(function() {
            return false;
        });*/

        $(".reser").click(function() {
            var hora = $(this).attr("hora");
            var fech = $(this).attr("fech");
            var cad = $.trim(hora);
            //
            $("#fechar").val(fech);
            $("#horar").val(cad);
            $obj = $(this);
            //


        });

        $("#btn-save").click(function() {
            var idespa = $("#espaciocomun").val();
            var fechr = $("fechar").val();
            var horar = $("#horar").val();
            var nhoras = $("#nhoras").val();
            var idres = $("#codresidente").val();
            if (idespa == '' || fechr == '' || nhoras == '') {
                alert("Ingrese datos requeridos");
                return false;
            } else {
                data = $("#frmnuevareserva").serialize();
                $.ajax({
                    type: 'post',
                    url: 'RealizarReservaServlet',
                    data: data,
                    success: function(data) {
                        if (data == "ok") {
                            alert("Reserva realizada con exito");
                            $("#espaciocomun").val('');
                            $("#nhoras").val('');
                            //$obj.css('border', '1px solid red');  $("a").removeAttr("href");
                            $obj.css('background','#b6bfd2')
                            $obj.children('a').html('Reservado');
                            $obj.children('a').removeAttr('href');
                            //alert(url);  //      url = url.replace('#','');
                            $obj.children('a').css('color','red');
                            $('#modalreserva').modal('hide');
                            //location.reload(true);
                        } else if (data == "err") {
                            alert("¡Error!..La fecha esta reservada");
                        } else {
                            alert("Error en la reserva");
                        }
                    }
                })
            }


        });



    });

</script>