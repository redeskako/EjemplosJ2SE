<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="java.lang.*"%>
<%@ page import="rba.bbdd.*" %>
<%@ page import="java.util.*" %>
<%@ page import="rba.mesas.AccionMesa" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<%
// en la variable path, cargamos el direccionamiento, para referenciar todos los enlaces
String path = request.getContextPath();
%>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>MESA</title>
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
<body bgcolor="#0066cc">
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	<%
	//
 	// variable inicializada a vacio, pero que nos va a dar la posicion de la pagina de la select
 	String cad="";
	// variable inicializada a cero, que nos indica la posicion en la select para su paginacion
	int inicio=0;
	// variable inicializada a CODIGO que es el campo por el que se va a identificar al cliente
	// si no se toca el combo de eleccion de campo de busqueda siempre se ordenara por CODIGO
	// si se tocara el desplegable este valor cambiaria al elegido
	String campo="codigo";
	// variable inicializada a vacio, y es el valor que va a toma de la caja de texto de busqueda
	// si no se hace nada aunque se cambie el como de campo busqueda, no buscaria nada
	// ya que no hay ningun valor
	String textoabuscar="";


	try{
		cad= request.getParameter("paginado");
		inicio= Integer.parseInt(cad);
	}catch(Exception e){
	inicio=0;}

	try {
		campo = request.getParameter("campo");
		if (campo==null){
			campo="codigo";
		}
	}catch(Exception e){campo="codigo";}

	try {
		textoabuscar= request.getParameter("texto");
		if (textoabuscar==null) {
			textoabuscar="";
		}
	}catch(Exception e){textoabuscar="";}
		//esta funcion generaba la llamada al listado de clientes ordenado solo por
		//el campo correo
		//Set<Mesa> mesas=Mesa.ejecutaListaMesa(inicio);
		// esta funcion genera listado ordenado por campo de busqueda y muestra solo
		// el texto a buscar
		Set<Mesa> mesas=Mesa.ejecutaListaCampoMesa(inicio,campo,textoabuscar);



%>
	<tr bgcolor="#99ccff">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td width="745" height="60" colspan="3" class="logo" nowrap="nowrap">Restaurante Bicicleta Atomica<span class="tagline">| Donde los sentidos revelaran lo inimaginable</span></td>
	<td width="100%">&nbsp;</td>
	</tr>

		<tr bgcolor="#003399">
		<td width="15" nowrap="nowrap">&nbsp;</td>
		<td height="36" colspan="3" id="navigation" nowrap="nowrap" class="navText">
			<a href="<%=path%>/zonaPrivada/menu.jsp">Inicio</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=path%>/zonaPrivada/clientes/cliente.jsp">Clientes</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="<%=path%>/zonaPrivada/mesas/mesa.jsp">Mesas</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		<a href="<%=path%>/zonaPrivada/reservas/reserva.jsp">Reservas</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=path %>/index.jsp?valido=0">Cerrar Sesion</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	</td>
	  	<td width="40">&nbsp;</td>
		<td width="100%">&nbsp;</td>
	</tr>
	<tr bgcolor="#ffffff">
	<td width="15" valign="top"><img src="<%=path %>/css/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
	<td width="140" valign="top"><img src="<%=path %>/css/mm_spacer.gif" alt="" width="140" height="1" border="0" /></td>
	<td width="505" valign="top"><br />
	<table border="0" cellspacing="0" cellpadding="2" width="440">
		<tr>
		<td class="pageName"><div align="center">Gestion de Mesas</div></td>
		</tr>

		<tr>
		<td class="bodyText">
		<table width="438" border="1">

          <tr>
            <th width="103" scope="col"><a href="<%=path %>/zonaPrivada/mesas/mesa.jsp?campo='codigo'">Codigo</a></th>
            <th width="96" scope="col"><a href="<%=path %>/zonaPrivada/mesas/mesa.jsp?campo='numSillas'">Num Sillas</a></th>

            <th colspan="2" scope="col"><div align="center"></div>              <div align="center"></div></th>
            </tr>
            	<%
					Iterator<Mesa> it = mesas.iterator();
					while (it.hasNext()){
						Mesa u = it.next();
						int codigo = u.getCodigo();

				%>
          <tr>
            <td><%=codigo%></td>
            <td><%=u.getSillas() %></td>

            <td width="63"><div align="center"><a href="<%=path%>/AccionMesa?accion=<%=1%>&codigo=<%=codigo%>" title="Eliminar Mesa">Eliminar</a></div></td>
	        <td width="84"><div align="center"><a href="<%=path%>/AccionMesa?accion=<%=2%>&codigo=<%=codigo%>" title="Modificar Mesa">Modificar</a></div></td>
          </tr>
			   <tr>
			<%
					}
				//Mostrar la paginación correspondiente
				int totalpaginas= Mesa.calculaTotalPaginasM();
				for (int i=0;i<=totalpaginas;i++){
					if (inicio!=i){
			%>
			<td>
			<a href="<%=path %>/zonaPrivada/mesas/mesa.jsp?paginado=<%=i %>" target="_self"><%=i %></a>-
			</td>
			<%

					}else{
			%>
			<td>
					<%=i %>-
			</td>
			<%
					}
				}


			%>
			</tr>
			<tr>

		  	<form id="form1" name="form1" method="post" action="<%=path %>/AccionMesa?accion=<%=7%>">
		                	<p align="center">
		                		Campo de Busqueda:
		                		<select name="CmbCampos" id="CmbCampos">
		                         <option value="codigo">Codigo</option>
		                         <option value="numSillas">Num Sillas</option>
		                    </select>
		                	</p>
		                	<p align="center">
		                		Texto a buscar:
		                		<input name="txtbuscar" type="text"/> 	 <input type="submit" name="submit" id="BtnBuscar" value="Buscar" />
		                     </p>



				    <p align="center">
				    <label>

									    <a href="<%=path %>/AccionMesa?accion=<%=3%>" title="Añadir Mesa">Añadir Mesa</a>
				    </label>
				    <br />

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
		<center>Gracias por utilizar RBA 1.0</center>

  </tr>

</body>
</html>