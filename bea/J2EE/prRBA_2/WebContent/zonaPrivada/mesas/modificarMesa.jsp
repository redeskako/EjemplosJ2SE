<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="java.lang.*" %>
<%@ page import="rba.bbdd.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath();%>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Restaurante - PÃ¡gina principal</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=path%>/css/mm_restaurant1.css" type="text/css" />


</head>

<body bgcolor="#0066cc">

<table width="100%" height="101" border="0" cellpadding="0" cellspacing="0">
<tr bgcolor="#99ccff">
		<td width="15" nowrap="nowrap" >
			<img src="<%=path%>/css/mm_spacer.gif" alt="" width="15" height="1" border="0" />
		</td>
		<td height="60" colspan="3" class="logo" nowrap="nowrap"><br />
			Restaurante Bicicleta Atomica<span class="tagline">| Donde los sentidos revaran lo inimaginable</span>
		</td>
		<td width="40">&nbsp;</td>
		<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#003399">
		<td width="15" nowrap="nowrap">&nbsp;</td>
		<td height="36" colspan="3" id="navigation" nowrap="nowrap" class="navText">
			<a href="clientes/cliente.jsp">Clientes</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="mesas/mesa.jsp">Mesas</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="reservas/reserva.jsp">Reservas</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="listados/listado.jsp">Listados</a>&nbsp;&nbsp;&nbsp;&nbsp;
      	</td>
	  	<td width="40">&nbsp;</td>
		<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
		<td colspan="6">
			<img src="<%=path%>/css/mm_spacer.gif" alt="" width="1" height="1" border="0" />
		</td>
	</tr>
	<%Integer codigo = Integer.parseInt(request.getParameter("codigo"));
	   Set<Mesa> mesas=Mesa.ejecutaBusquedaMesa(codigo);

		Iterator<Mesa> it = mesas.iterator();
		while (it.hasNext()){
			Mesa u = it.next();
	%>
	<form action="/rba.mesas/accionMesa.java?codigo=6" method="post">
    	<table width="200" border="1">
          <caption>
            Formulario de Modificacion de Mesa
          </caption>
          <tr>
            <th scope="col">Campos</th>
            <th scope="col">Valores</th>
          </tr>
          <tr>
            <th scope="row">Codigo: </th>
            <td><%=u.getCodigo()%></td>
          </tr>
          <tr>
            <th scope="row">Num Sillas: </th>
            <td><input name="txtNumSillas" type="text" value="<%=u.getSillas()%>"></td>
          </tr>

        </table>
        <input name="txtAceptar" type="submit">

    </form>
	<%
	}
	%>

</table>

</body>
</html>