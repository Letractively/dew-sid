<%-- 
    Document   : viviendasresidente
    Created on : 05/12/2013, 01:29:13 PM
    Author     : JULIO
--%>

<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="tags.jsp" %>
    </head>
    <body>
        
    
<div class="sidebar-background">
        <div class="primary-sidebar-background"></div>
</div>

        <div class="main-content">
             <div class="container-fluid">
                <div class="row-fluid">

                    <div class="area-top clearfix">
                        <div class="pull-left header">
                            <h5>
                                residente : <%= session.getAttribute("snombre_residente").toString() %>
                            </h5>
                            
                             <h5>
                                vivienda : <%= session.getAttribute("svivienda").toString() %>
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>
        
                            
            
            <div class="modal-header">
            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h6 id="modal-formLabel">Generar cuotas</h6>
            </div>
                <div style="" class="modal-body">
            <h6 id="modal-formLabel">Datos personales</h6>
            <form id="frmgenerarcuotas" style="" class="form-horizontal fill-up separate-sections">
            <div>
            <div>
            <label for="nombre">Año</label>
            <input type="text" required placeholder="anio" id="anio" name="anio">
            </div>
            <label for="nombre">Importe</label>
            <input type="text" required placeholder="importe" id="importe" name="importe">
            </div>
            <div>
            <label for="nombre">Fecha Vencimiento</label>
            <input type="text" required placeholder="fechavenc" id="fechavenc" name="fechavenc">
            </div>
            <div>
            <label for="nombre">Periodo</label>
            <select name="identificacion" id="identificacion" onChange="ocultarcombos()">
               <option value="">[Seleccione periodo]</option>
               <option value="A">ANUAL</option>
               <option value="M">MENSUAL</option>
            </select>
            </div>
            <div>
            <label for="nombre" id="de">Desde</label>
            <select name="desde" id="desde">
               <option value="">[Seleccione periodo]</option>
               <option value="01">01</option>
               <option value="02">02</option>
               <option value="03">03</option>
               <option value="04">04</option>
               <option value="05">05</option>
               <option value="06">06</option>
               <option value="07">07</option>
               <option value="08">08</option>
               <option value="09">09</option>
               <option value="10">10</option>
               <option value="11">11</option>
               <option value="12">12</option>
            </select>
            </div>
           <div>
            <label for="nombre" id="ha">Hasta</label>
            <select name="hasta" id="hasta">
               <option value="">[Seleccione periodo]</option>
               <option value="01">01</option>
               <option value="02">02</option>
               <option value="03">03</option>
               <option value="04">04</option>
               <option value="05">05</option>
               <option value="06">06</option>
               <option value="07">07</option>
               <option value="08">08</option>
               <option value="09">09</option>
               <option value="10">10</option>
               <option value="11">11</option>
               <option value="12">12</option>
            </select>
            </div>
          
            </form>
            </div>
            <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default">Cancelar</button>
            <button id="btn-save" class="btn btn-blue">Guardar</button>
            </div>
          
            
            
            </div>
           
            <!-- -->
            </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function(){
        $('#btn-save').on('click',function(){
               var importex   = $("#importe").val();
               var fechavencx  = $("#fechavenc").val();
               var identificacionx   = $("#identificacion").val();
               var desdex  = $("#desde").val();
               var hastax   = $("#hasta").val();
               var aniox   = $("#anio").val();

               if(importex=='' || fechavencx=='' || identificacionx=='' || aniox==''){
                       alert('Ingrese todos los datos requeridos');
                   }else{
                       $.ajax({
                           type:'post',
                           url :'CuotaServlet',
                           data:{accion: "4", vimporte: importex,vfechavenc:fechavencx,videntificacion:identificacionx,vdesde:desdex,vhasta:hastax,vanio:aniox},
                           success:function(data){
                           if (data == "ok"){
                               alert("se generaron las cuentas correctamente");
                                self.close()
                           }
                           else
                               alert(data.toString());
                           }
                           

                       });
                       
                        
                   }

           });
           
       var dates = $("#fechavenc").datepicker({
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

    $('#fechavenc').keypress(function(){ return false;});
    $('#fechavenc').click(function(){ return false;});
       }); 
       
    function ocultarcombos(){
    if($("#identificacion").val() === "A"){
        $("#desde").hide();
        $("#hasta").hide();
        $("#de").hide();
        $("#ha").hide();
    }
    else{
        $("#desde").show();
        $("#hasta").show();
        $("#de").show();
        $("#ha").show();
    }
    }
        </script>