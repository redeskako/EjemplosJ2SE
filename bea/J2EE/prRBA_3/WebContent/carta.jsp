<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>    
<%@ page import="java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>COCINA</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/mm_restaurant1.css" type="text/css" />
</head>
<%

String idioma = "en_EN";
//String idiomasession = (String) session.getAttribute("idioma2");
String idiomaparametro = request.getParameter("idioma2");

if (idiomaparametro != null){
	idioma = idiomaparametro;
}

%>


<fmt:setLocale value="<%=idioma%>"/>
<fmt:setBundle basename="RbaEtiquetas" var="base" scope="session"/>

<body bgcolor="#0066cc">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr bgcolor="#99ccff">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td width="745" height="60" colspan="3" class="logo" nowrap="nowrap"><br />
	  <fmt:message key="membrete" bundle="${base}" /><span class="tagline">| <fmt:message key="membrete_leyenda" bundle="${base}" /></span></td>
	<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#003399">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td height="36" colspan="3" id="navigation" nowrap="nowrap" class="navText"><a href="index.jsp?idioma2=<%=idioma %>"><fmt:message key="inicio"  bundle="${base}"/></a></td>
	<td>&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
	<td width="15" valign="top"><img src="css/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
	<td width="140" valign="top"><img src="css/mm_spacer.gif" alt="" width="140" height="1" border="0" /></td>
	<td width="505" valign="top"><br />
	<table border="0" cellspacing="0" cellpadding="2" width="610">
        <tr>
          <td colspan="7" class="pageName"><fmt:message key="cartamembrete" bundle="${base}" /></td>
        </tr>
		<tr>
         <td width="22%" height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td width="22%" height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td width="22%" height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td width="22%" height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
        </tr>
		<tr>
          <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}"/></a><br />
		  <fmt:message key="cartaprecio"  bundle="${base}"/>: 0.00</td>
		  <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}"/></a><br />
		  <fmt:message key="cartaprecio" bundle="${base}" />: 0.00</td>
		 <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}"/></a><br />
		  <fmt:message key="cartaprecio" bundle="${base}" />: 0.00</td>
		 <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}"/></a><br />
		  <fmt:message key="cartaprecio" bundle="${base}" />: 0.00</td>
        </tr>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
         <td height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
		  <td>&nbsp;</td>
		  <td height="110"><img src="/css/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" /></td>
        </tr>
		<tr>
          <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}" /></a><br />
		 <fmt:message key="cartaprecio" bundle="${base}" />: 0.00</td>
		  <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}" /></a><br />
		  <fmt:message key="cartaprecio" bundle="${base}" />: 0.00</td>
		 <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}" /></a><br />
		  <fmt:message key="cartaprecio"  bundle="${base}"/>: 0.00</td>
		 <td>&nbsp;</td>
		   <td valign="top" class="bodyText" nowrap="nowrap"><a href="javascript:;"><fmt:message key="cartanombreproducto" bundle="${base}" /></a><br />
		  <fmt:message key="cartaprecio"  bundle="${base}"/>: 0.00</td>
        </tr>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
      </table>	</td>
	<td>&nbsp;</td>
	</tr>

	<tr>
	<td width="15">&nbsp;</td>
    <td width="35">&nbsp;</td>
    <td width="710">&nbsp;</td>
	<td width="100%">&nbsp;</td>
  </tr>
</table>
</body>
</html>