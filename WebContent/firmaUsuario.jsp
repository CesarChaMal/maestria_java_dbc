<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>Login</title>
	</head>
	
	<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/functions.js" ></script>
	<link href="<%=request.getContextPath()%>/module/css/estyle1.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/module/css/style.css" rel="stylesheet" type="text/css">

	<body bgProperties="fixed" style="background: url(<%=request.getContextPath()%>/module/img/background.png) 0% 0% repeat;">
	
		<form METHOD=POST ACTION="<%=request.getContextPath()%>/Menu.do" onsubmit="return validaDatos();" name="frmUsuario">
			<table id="Table3" style="Z-INDEX: 101; LEFT: 8px; POSITION: absolute; TOP: 8px" cellSpacing="1"
				cellPadding="1" width="100%" border="0">
				<tr>
					<td align="center">
						<P>&nbsp;</P>
						<P><FONT face="Arial"><STRONG>Teclee su&nbsp;clave&nbsp;de usuario y contraseña para 
									accesar al sistema.</STRONG></FONT></P>
						<P>&nbsp;</P>
					</td>
				</tr>
			</table>
			<span id="Label1" style="font-family:Arial;font-size:Large;Z-INDEX: 106; LEFT: 392px; POSITION: absolute; TOP: 176px">Usuario:</span>
			<input type="submit" name="btnAceptar" value="ACEPTAR" id="btnAceptar" tabindex="3" style="font-family:Arial;font-size:Small;font-weight:bold;height:104px;width:120px;Z-INDEX: 102; LEFT: 616px; POSITION: absolute; TOP: 208px" />
			<input name="txtUsuario" type="text" id="txtLoginUSR" tabindex="1" title="Teclee por favor el usuario que se le proporciono." name="txtLoginUSR" onkeypress="Enter();" onblur="txtChangeUpperCase(this);" style="color:Blue;border-color:Gainsboro;border-width:5px;border-style:Inset;font-family:Arial;font-size:Medium;font-weight:bold;width:216px;Z-INDEX: 104; LEFT: 392px; POSITION: absolute; TOP: 208px" maxlength=15 size=15 />
			<input name="passwd" type="password" id="txtPassword" tabindex="2"  title="Teclee su contraseña la cual debe de ser mayor a 5 carateres." style="color:Blue;border-color:#E0E0E0;border-width:5px;border-style:Inset;font-size:Medium;font-weight:bold;width:216px;Z-INDEX: 105; LEFT: 392px; POSITION: absolute; TOP: 280px" maxlength=15 size=15/>
			<span id="Label2" style="color:Black;background-color:Transparent;font-family:Arial;font-size:Large;Z-INDEX: 107; LEFT: 392px; POSITION: absolute; TOP: 248px">Contraseña:</span>
			<script>
				document.getElementById("txtLoginUSR").focus();
			</script>
		</form>
		<%if(request.getAttribute("Error")!= null){%>
			<br><br><br><br>
			<center class="error">EL NOMBRE DE USUARIO O CONTRASEÑA ES INCORRECTA</center>		
		<%}%>
	</body>
</html>
