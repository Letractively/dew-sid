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
                                Mis datos
                            </h3>
                            <h5>
                               Datos del administrador
                            </h5>
                        </div>

                        
                    </div>
                </div>
            </div>

            <div class="container-fluid padded">
                <div class="row-fluid">
                    <div class="span12">

                        <div class="box">
                            <div class="box-header">
                                <span class="title"><i class="icon-edit"></i>Editar mis datos</span>
                            </div>

                            <div class="box-content">

                                <form class="form-horizontal fill-up validatable" id="frmusuario" name="frmusuario">

                                    <div class="padded">

                                        <div class="control-group">
                                            <label class="control-label">Email</label>
                                            <div class="controls">
                                                <label class="control-labelsito">${sessionScope.USUARIO_ACTUAL.email}</label>
                                            </div>
                                        </div>
                                        
                                        <div class="control-group">
                                            <label class="control-label">Nombre</label>
                                            <div class="controls">
                                                <input type="text" class="validate[required]" data-prompt-position="topLeft" value="${sessionScope.USUARIO_ACTUAL.nombre}" id="nombre" name="nombre" />
                                            </div>
                                        </div>
                                        
                                        <div class="control-group">
                                            <label class="control-label">Apellido</label>
                                            <div class="controls">
                                                <input type="text" class="validate[required]" data-prompt-position="topLeft" value="${sessionScope.USUARIO_ACTUAL.apellido}" id="apellido" name="apellido" />
                                            </div>
                                        </div>

                                        
                                        <div class="control-group">
                                            <label class="control-label">Password</label>
                                            <div class="controls">
                                                <input type="password" id="password" class="validate[minSize[4]]" name="password">
                                                <span class="help-block note"><i class="icon-warning-sign"></i> Utilice una contraseña segura.</span>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">Confirmación</label>
                                            <div class="controls">
                                                <input type="password" id="password_confirmation" class="validate[equals[password],minSize[4]]"/>
                                            </div>
                                        </div>
                                        		<input name="idadmin" type="hidden" id="idadmin" value="">

                                    </div>

                                    <div class="form-actions">
                                        <button type="button" class="btn btn-blue" id="btnguardar">Guardar cambios</button>
                                        <button type="button" class="btn btn-default">Cancelar</button>
                                        
                                    </div>
                                </form>

                            </div>
                        </div>

                    </div>
                </div>

                </div>
        </div>
    

</body>
</html>