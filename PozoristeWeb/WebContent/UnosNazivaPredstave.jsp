<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/PozoristeWeb/UnosNazivaPredstave" method="get">
		<span>Naziv predstave: </span> <input type="text" name="nazivP">
		<br> 
		<input type="submit" value="Prikazi">
	</form>
	
	<table border=1>
	<th>Datum</th> <th>Naziv</th> <th>trajanje</th> <th>Scena</th> <th>Rezervacije</th>
	<c:forEach items="${lista }" var="i">
		<tr> 
			<td>${i.datum }</td> <td>${i.predstava.naziv }</td>
			<td>${i.predstava.trajanje }</td> <td>${i.scena.naziv }</td>
			<td><a href="/PozoristeWeb/SlobodnaMesta?id=${i.idIzvodjenje }">Prikazi mesta</a></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>