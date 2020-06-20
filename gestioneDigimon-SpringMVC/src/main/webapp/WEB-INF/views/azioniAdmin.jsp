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


		<br> <br>Scegli un 'azione<br> <br>
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
  <option value="PRIMO_STADIO">PRIMO STADIO</option>
  <option value="INTERMEDIO">INTERMEDIO</option>
  <option value="CAMPIONE">CAMPIONE</option>
  <option value="EVOLUTO">EVOLUTO</option>
  <option value="MEGA">MEGA</option>
  
</form:select></td>
				</tr>			
				<tr>
					<td><input type="submit" value="Aggiungi"></td>
				</tr>						
			</table>
		</form:form>
		
		 <br>Scegli un ordinamento<br>
	<form action="ordinaLista1" method="post">
	<select name="ordinamento" >
  <option value="OrdAtk">ordina per atk</option>
  <option value="OrdDef">ordina per def</option>
  <option value="OrdRes">ordina per res</option>
  <option value="OrdHp">ordina per hp</option>
  <option value="OrdEvo">ordina per evoluzione</option>

</select>
<input type="submit" value="Ordina">
	</form>
	<table >
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Atk</th>
			<th>Def</th>
			<th>Res</th>
			<th>Hp</th>
			<th>Evoluzione</th>
		</tr>
		<c:forEach items="${listaDigimon}" var="digimon">
		<tr>
			<td>${digimon.id}</td>
			<td>${digimon.nome}</td>
			<td>${digimon.atk}</td>
			<td>${digimon.def}</td>
			<td>${digimon.res}</td>
			<td>${digimon.hp}</td>
			<td>${digimon.evoluzione}</td>
			<td>
				<a href="modificaDigimon?id=${digimon.id}">Modifica</a>
				&nbsp;&nbsp;&nbsp;
				<a href="eliminaDigimon?id=${digimon.id}">Elimina</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>