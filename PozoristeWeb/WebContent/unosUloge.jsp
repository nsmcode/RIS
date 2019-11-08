<%@page import="managers.GlumacManager"%>
<%@page import="managers.PosetilacManager"%>
<%@page import="model.Predstava"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/PozoristeWeb/UnosUloge" method="post">
		<span>PREDSTAVA: </span> 
		<select name="predstava">
			<c:forEach items="${pred} var="p">
				<option value="${p.idPredstava}"> ${p.naziv} </option>
			</c:forEach>
			
			<% 
			List<Predstava> lista = GlumacManager.getPredstave(); 
			for(Predstava p : lista) {
				if(p==null) continue;
			%>
				<option value="<%=p.getNaziv()%>"><%=p.getNaziv()%></option>
			<%
			}
			%>
		</select> <br>
		<span>ULOGA: </span> <input type="text" name="ime"> <br>
		
		<input type="submit" value="Sacuvaj">
	</form>

</body>
</html>