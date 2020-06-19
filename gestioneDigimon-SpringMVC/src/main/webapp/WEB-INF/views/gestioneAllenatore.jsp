<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
                <br> <br>Aggiungi un nuovo allenatore o gestisci quelli esistenti<br> <br>
	<form:form action="creaAllenatore" method="post" modelAttribute="allenatore">
			<table>
				<tr>
					<td>Nome: </td>
					<td><form:input path="nome" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Aggiungi"></td>
				</tr>						
			</table>
		</form:form>
	
	<table >
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Azione</th>
			
		</tr>
		<c:forEach items="${listaAllenatori}" var="allenatore">
		<tr>
			<td>${allenatore.id}</td>
			<td>${allenatore.nome}</td>
			
			<td>
				<a href="modificaAllenatore?id=${allenatore.id}">Modifica</a>
				&nbsp;&nbsp;&nbsp;
				<a href="eliminaAllenatore?id=${allenatore.id}">Elimina</a>
								&nbsp;&nbsp;&nbsp;
			    <a href="scegliAllenatore?id=${allenatore.id}">Scegli</a>
				
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>