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

<h2>modifica il nome dell'allenatore</h2>
		<form:form action="creaAllenatore" method="post" modelAttribute="allenatore">
			<table>
			<tr>
					<td>ID: </td>
					<td>${allenatore.id}
						<form:hidden path="id"/>
					</td>
				</tr>		
				<tr>
					<td>Nome: </td>
					<td><form:input path="nome" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Modifica"></td>
				</tr>						
			</table>
		</form:form>
</body>
</html>