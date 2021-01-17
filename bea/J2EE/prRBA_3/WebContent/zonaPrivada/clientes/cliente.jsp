<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.lang.*"%>
<%@ page import="rba.bbdd.*" %>
<%@ page import="java.util.*" %>
<%@ page import="rba.clientes.AccionCliente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<%
// en la variable path, cargamos el direccionamiento, para referenciar todos los enlaces
String path = request.getContextPath();
%>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Restaurante - Texto</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=path %>/css/mm_restaurant1.css" type="text/css" />
<link href="<%=path %>/css/mm_restaurant1.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
</head>

<%String idioma = (String) session.getAttribute("idioma");%>

<fmt:setLocale value="<%=idioma%>"/>
<fmt:setBundle basename="RbaEtiquetas" var="base" scope="session"/>

<body bgcolor="#0066cc">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr bgcolor="#99ccff">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td width="745" height="60" colspan="3" class="logo" nowrap="nowrap"> <fmt:message key="membrete" bundle="${base}" /><span class="tagline">|  <fmt:message key="membrete_leyenda" bundle="${base}" /></span></td>
	<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#003399">
		<td width="15" nowrap="nowrap">&nbsp;</td>
		<td height="36" colspan="3" id="navigation" nowrap="nowrap" class="navText">
			<a href="<%=path%>/zonaPrivada/menu.jsp"><fmt:message key="menu_Inicio" bundle="${base}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=path%>/zonaPrivada/clientes/cliente.jsp"><fmt:message key="menu_Clientes" bundle="${base}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="<%=path%>/zonaPrivada/mesas/mesa.jsp"><fmt:message key="menu_Mesas" bundle="${base}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="<%=path%>/zonaPrivada/reservas/reserva.jsp"><fmt:message key="menu_Reservas" bundle="${base}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=path %>/index.jsp?valido=0"><fmt:message key="menu_CerrarS" bundle="${base}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	</td>
	  	
	</tr>

	<tr bgcolor="#ffffff">
	<td width="15" valign="top"><img src="<%=path %>/css/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
	<td width="140" valign="top"><img src="<%=path %>/css/mm_spacer.gif" alt="" width="140" height="1" border="0" /></td>
	<td width="505" valign="top"><br />

		<%
	//
 	// variable inicializada a vacio, pero que nos va a dar la posicion de la pagina de la select
 	String cad="";
	// variable inicializada a cero, que nos indica la posicion en la select para su paginacion
	int inicio=0;
	// variable inicializada a CORREO que es el campo por el que se va a identificar al cliente
	// si no se toca el combo de eleccion de campo de busqueda siempre se ordenara por CORREO
	// si se tocara el desplegable este valor cambiaria al elegido
	String campo="correo";
	// variable inicializada a vacio, y es el valor que va a toma de la caja de texto de busqueda
	// si no se hace nada aunque se cambie el como de campo busqueda, no buscaria nada
	// ya que no hay ningun valor
	String textoabuscar="";

	//

	try{
		cad= request.getParameter("paginado");
		inicio= Integer.parseInt(cad);
	}catch(Exception e){
	inicio=0;}

	try {
		campo = request.getParameter("campo");
		if (campo==null){
			campo="correo";
		}
	}catch(Exception e){campo="correo";}

	try {
		textoabuscar= request.getParameter("texto");
		if (textoabuscar==null) {
			textoabuscar="";
		}
	}catch(Exception e){textoabuscar="";}


			//esta funcion genera la llamada al listado de clientes ordenado solo por
		//el campo correo
		//Set<Cliente> clientes=Cliente.ejecutaListaCliente(inicio);
		// esta funcion genera listado ordenado por campo de busqueda y muestra solo
		// el texto a buscar
		Set<Cliente> clientes=Cliente.ejecutaListaCampoCliente(inicio, campo,textoabuscar);
		System.out.println("clientes:" + clientes.toString());

%>

	<table border="0" cellspacing="0" cellpadding="2" width="440">
		<tr>
		<td class="pageName"><div align="center"><fmt:message key="GestiondeCliente" bundle="${base}" /></div></td>
		</tr>

		<tr>
		<td class="bodyText">
		<table width="438" border="1">

          <tr>
          	<th width="103" scope="col"><a href="<%=path %>/AccionCliente?campo=codigo&accion=8"><fmt:message key="Codigo" bundle="${base}" /></a></th>
            <th width="103" scope="col"><a href="<%=path %>/AccionCliente?campo=nombre&accion=8"><fmt:message key="Nombre" bundle="${base}" /></a></th>
            <th width="96" scope="col"><a href="<%=path %>/AccionCliente?campo=apellido1&accion=8"><fmt:message key="Apellido1" bundle="${base}" /></a></th>
            <th width="56" scope="col"><a href="<%=path %>/AccionCliente?campo=apellido2&accion=8"><fmt:message key="Apellido2" bundle="${base}" /></a></th>
            <th width="56" scope="col"><a href="<%=path %>/AccionCliente?campo=telefono&accion=8"><fmt:message key="Telefono" bundle="${base}" /></a></th>
            <th width="56" scope="col"><a href="<%=path %>/AccionCliente?campo=correo&accion=8"><fmt:message key="Correo" bundle="${base}" /></a></th>
            <th width="56" scope="col"><a href="<%=path %>/AccionCliente?campo=pass&accion=8"><fmt:message key="password" bundle="${base}" /></a></th>
            <th width="56" scope="col"><a href="<%=path %>/AccionCliente?campo=cp&accion=8"><fmt:message key="Cp" bundle="${base}" /></a></th>
            <th colspan="2" scope="col"><div align="center"></div>              <div align="center"></div></th>
            </tr>
            	<%
					Iterator<Cliente> it = clientes.iterator();
					while (it.hasNext()){
						Cliente u = it.next();
						int codigo = u.getCodigo();
				%>
          <tr>
	            <td><%=codigo%></td>
	            <td><%=u.getNombre() %></td>
	            <td><%=u.getApellido1() %></td>
	            <td><%=u.getApellido2() %></td>
	            <td><%=u.getTelefono() %></td>
	            <td><%=u.getCorreo() %></td>
	            <td><%=u.getPass() %></td>
	            <td><%=u.getCp() %></td>
	            <td width="63"><div align="center"><a href="<%=path%>/AccionCliente?accion=<%=1%>&codigo=<%=codigo%>" title="Eliminar Cliente"><fmt:message key="Eliminar" bundle="${base}" /></a></div></td>
	            <td width="84"><div align="center"><a href="<%=path%>/AccionCliente?accion=<%=2%>&codigo=<%=codigo%>" title="Modificar Cliente"><fmt:message key="Modificar" bundle="${base}" /></a></div></td>
	          </tr>
			   <tr>
					<%
					}
						//Mostrar la paginación correspondiente
						int totalpaginas= Cliente.calculaTotalPaginas();
						for (int i=0;i<=totalpaginas;i++){
							if (inicio!=i){
					%>
			<td>
			<a href="<%=path %>/zonaPrivada/clientes/cliente.jsp?paginado=<%=i%>" target="_self"><%=i%></a>-
			</td>
					<%

							}else{
					%>
			<td>
					<%=i %> -
			</td>
					<%

						}
					}
					%>
			</tr>
			<tr>
				<form id="form1" name="form1" method="post" action="<%=path %>/AccionCliente?accion=<%=7%>">
                	<p align="center">
                		<fmt:message key="CampoBusqueda" bundle="${base}" />:
                		<select name="CmbCampos" id="CmbCampos">
						<option value="codigo"><fmt:message key="Codigo" bundle="${base}" /></option>
                         <option value="nombre"><fmt:message key="Nombre" bundle="${base}" /></option>
                         <option value="apellido1"><fmt:message key="Apellido1" bundle="${base}" /></option>
                         <option value="apellido2"><fmt:message key="Apellido2" bundle="${base}" /></option>
                         <option value="telefono"><fmt:message key="Telefono" bundle="${base}" /></option>
                         <option value="correo" selected><fmt:message key="Correo" bundle="${base}" /></option>
                         <option value="pass"><fmt:message key="password" bundle="${base}" /></option>
                         <option value="cp"><fmt:message key="Cp" bundle="${base}" /></option>
                       </select>
                      </p>
                      <p align="center">
                      	<fmt:message key="Textoabuscar" bundle="${base}" />:
                       <input name="txtbuscar" type="text"/>
                 	   <input type="submit" name="submit" id="BtnBuscar" value="<fmt:message key="btnEnviar" bundle="${base}" />" />
						</p>

		    <p align="center">
		    <label>

	 					<a href="<%=path %>/AccionCliente?accion=<%=3%>" title="Añadir Cliente"><fmt:message key="AnadirCliente" bundle="${base}" /></a>
		    </label>
		    <br />
		    </p>


		 </form>

			</tr>

        </table>

		  <p>


		<p>&nbsp;</p>


		<br /></td>
		</tr>
		<tr>
		  <td class="bodyText">&nbsp;</td>
	    </tr>
	</table>
	<br />
	&nbsp;<br />	</td>
	<td valign="top">&nbsp;</td>
	<td width="100%">&nbsp;</td>
	</tr>


</table>
<tr>
		<center><fmt:message key="Graciasporutilizar" bundle="${base}" /></center>

  </tr>
</body>
</html>