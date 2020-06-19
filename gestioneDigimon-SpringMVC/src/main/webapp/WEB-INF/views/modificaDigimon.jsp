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
                    <h2>Inserisci i campi da modificare</h2>
		<form:form action="creaDigimon" method="post" modelAttribute="digimon">
			<table>
				<tr>
					<td>Nome: </td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Atk: </td>
					<td><form:input path="atk" /></td>
				</tr>
				<tr>
					<td>Def: </td>
					<td><form:input path="def" /></td>
				</tr>	
				<tr>
					<td>Res: </td>
					<td><form:input path="res" /></td>
				</tr>			
				<tr>
					<td>Hp: </td>
					<td><form:input path="hp" /></td>
				</tr>
				<tr>
					<td>Evoluzione: </td>
					<td><form:select path="evoluzione">
  <option value="PRIMARIO">PRIMARIO</option>
  <option value="PRIMO STADIO">PRIMO STADIO</option>
  <option value="INTERMEDIO">INTERMEDIO</option>
  <option value="CAMPIONE">CAMPIONE</option>
  <option value="EVOLUTO">EVOLUTO</option>
  <option value="MEGA">MEGA</option>
  
</form:select></td>
				</tr>			
				<tr>
					<td><input type="submit" value="Modifica"></td>
				</tr>						
			</table>
		</form:form>

</body>
</html>