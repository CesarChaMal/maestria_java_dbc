<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.UsersDTO" %>

<%
UsersDTO usuario = null;
java.util.ArrayList lista_personas = null;
usuario = (UsersDTO) session.getAttribute("usuario");
//lista_personas = (ArrayList) session.getAttribute("personas");
//Iterator it = lista_personas.iterator();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<%
if(usuario!=null)
{
%>
<HEAD>
	<TITLE>Sesion <%=usuario.getUserName().toUpperCase()%></TITLE>
</HEAD>
<%
}
%>

<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/functions.js" ></script>
<link href="<%=request.getContextPath()%>/module/css/estyle1.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/module/css/style.css" rel="stylesheet" type="text/css">

<body bgProperties="fixed" style="margin: 0px; padding: 0px; font-family: 'Trebuchet MS',verdana;" bgcolor="#d2d8c7">
	<BR><BR>
	
	<table width="100%" style="height: 100%;" cellpadding="10" cellspacing="0" border="0">
		<tr>
			<td width="16%" valign="top" bgcolor="#d2d8c7">
				<span style="background-color:Transparent;font-size:X-Small;font-weight:bold;">Usuario:</span>
				<span style="color:Blue;background-color:Transparent;font-family:Arial;font-size:X-Small;font-weight:bold;width:100%;"><%=usuario!=null?usuario.getUserName():""%></span>

				<BR>
				
				<table border="0" cellspacing="2" cellpadding="2" style="position:relative; left:5%; top:0%; width: 100%;">
				<tr>
					<td>
						<a class="button" href="#" 
						onclick="this.blur();submitform(document.forms.frmMenu,'<%=request.getContextPath()%>/RoadDotCom.do')" 
						style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
							<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">Road Dot Com</span>
						</a>
					</td>
				</tr>
				<tr>
					<td>
						<a class="button" href="#" 
						onclick="this.blur();submitform(document.forms.frmMenu,'<%=request.getContextPath()%>/RoadDotCom.do')" 
						style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
							<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">Bus Arrival Rate Dot Com</span>
						</a>
					</td>
				</tr>
				<tr>
					<td>
						<a class="button" href="#" 
						onclick="this.blur();submitform(document.forms.frmMenu,'<%=request.getContextPath()%>/RoadDotCom.do')" 
						style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
							<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">Bus Arrival Time Dot Com</span>
						</a>
					</td>
				</tr>
				</table>

			</td>
			<td width="84%" valign="top" bgcolor="#C0C0C0">
			
			<h1>Sesion <%=usuario.getUserName().toUpperCase()%></h1>
			
			<h2>My Transport Assistant</h2>
			
			<div class="wrapper" style="margin-right: 0px; margin-left: 0px;">	
				
				<form METHOD=POST name="frmMenu">

				<input type="hidden" name="user" value="">
			
				</form>

			</div>
			
			<br>
			<br>
			
			</td>
		</tr>
	</table>
</body>

</html>
