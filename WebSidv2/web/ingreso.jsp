<!DOCTYPE html>
<html lang="es-419">
<head>
	<meta charset="utf-8" />
</head>

<body>

<form action="" method="post">	
	<h3>Formulario bacan</h3>
	Fecha:	<input id="fecha" type="date" name="txtFecha" value="2013-04-18"/>
	<br/>
	Importe total: <input id="importe" type="number" name="txtImporte" required autofocus/>
	<br/>
	Correo: <input id="email" type="email" name="txtCorreo" required placeholder="Ingrese el correo aqu&iacute;" />
	<br/>
	WebSite: <input id="website" type="url" name="txtWebsite" required />
	<br/>
	Tel&eacute;fono: <input id="phone" type="tel" name="txtTelefono" required/>
	<br/>
	Distrito: <input type="text" list="distritos" name="txtDistrito" /> 
	<datalist id="distritos">
		<option value="Santa Anita"/>
		<option value="San Mart&iacute;n"/>
		<option value="San Miguel"/>
	</datalist>
	<br/>
	Direcci&oacute;n: <input type="search" name="txtDireccion"/>
	<br/>
	Indique la versi?n de PHP que conoce: <input id="version" type="number" value="3" min="3" max="5"/>
   	<br/>
	<button id="botonEnviar" type="submit">Enviar</button>		
	<p/>&nbsp;	
	Cualquier duda contactar a <a href="tel:+997391008">997391008</a>
</form>

</body>

</html>