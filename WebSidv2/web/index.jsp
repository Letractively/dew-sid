<html>
<head>

  <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800">


  <meta charset="utf-8">

  <!-- Always force latest IE rendering engine or request Chrome Frame -->
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">

  <title>..:: Administrador del Sistema de Condominios ::..</title>

  <link href="css/application.css" media="screen" rel="stylesheet" type="text/css" />
  <script src="js/application.js" type="text/javascript"></script>
  <script src="js/functions.js" type="text/javascript"></script>
</head>

<body>

<div class="navbar navbar-top navbar-inverse">
  <div class="navbar-inner">
    <div class="container-fluid">

      <a class="brand" href="#">Administrador Condominio Casa&deas</a>

      <!-- the new toggle buttons  -->

      <ul class="nav pull-right">

        <li class="toggle-primary-sidebar hidden-desktop" data-toggle="collapse" data-target=".nav-collapse-primary"><button type="button" class="btn btn-navbar"><i class="icon-th-list"></i></button></li>

        <li class="hidden-desktop" data-toggle="collapse" data-target=".nav-collapse-top"><button type="button" class="btn btn-navbar"><i class="icon-align-justify"></i></button></li>

      </ul>

      

    </div>
  </div>
</div>
<div class="container">
  
<div class="span4 offset4">


  <div class="padded">
    <form action="LoginServlet" method="post"> 
    <div class="login box" style="margin-top:80px;">

      <div class="box-header">
        <span class="title">Login</span>
      </div>

      <div class="box-content padded">
          <form action="LoginServlet" method="post" id="frmlogin">
            <div id="cnttexto">  
            <div class="input-prepend">
            <span class="add-on" href="#">
              <i class="icon-user"></i>
            </span>
                <input type="text" placeholder="email" name="email" id="email">
            </div>
            </div>
            <div id="cnttexto">
            <div class="input-prepend">
            <span class="add-on" href="#">
              <i class="icon-key"></i>
            </span>
                <input type="password" placeholder="password" name="password" id="password">
            </div>
            </div>
            <div id="cnttexto">
                <div class="cntizlogin">
                   Perfil de:
                </div>
                <div class="cntderlogin">
                   <select name="perfil" id="perfil">
                        <option value="">[Seleccionar]</option>
                        <option value="A">Administrador</option>
                        <option value="R">Residente</option>
                    </select> 
                </div>
            </div>
          <div>
            <input type="submit" class="btn btn-black" id="btenvia" value="Entrar">
            <span style="color:red;">${MENSAJE}</span>
          </div>
        </form>
            <div class="alert-error alert"></div>
        
      </div>

    </div>
   </form>
    
  </div>
</div>
</div>

</body>
</html>
<script type="text/javascript">
$(document).ready(function(e){
  $('#btenvia').click(function(){
    var error = 0;
    if($('#email').val()=="") {
      $('#email').focus();
      Growl.error({title: 'Validación', text: 'Ingresar un Email'}); 
      error = 1;
      return false;
    }else if($('#password').val()==""){
      Growl.error({title: 'Validación', text: 'Ingresar un Password'});
      $('#password').focus();
      error = 1;
      return false;
    }else if($('#perfil').val()==""){
      Growl.error({title: 'Validación', text: 'Seleccione perfil'});
      error=1;
      return false;
    }
    
   if(error==0){
      $("#frmlogin").submit();
   }
 	
   });
	
});
</script>