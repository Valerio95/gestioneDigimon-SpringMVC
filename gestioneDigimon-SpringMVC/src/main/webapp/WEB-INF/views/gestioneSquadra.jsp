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

<br> <br>Gestisci la squadra dell' allenatore ${allenatore.nome} <br> <br>
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
		<c:forEach items="${allenatore.listaDigimon}" var="digimon">
		<tr>
			<td>${digimon.id}</td>
			<td>${digimon.nome}</td>
			<td>${digimon.atk}</td>
			<td>${digimon.def}</td>
			<td>${digimon.res}</td>
			<td>${digimon.hp}</td>
			<td>${digimon.evoluzione}</td>
			
			<td>
				
			    <a href="rimuviDigimon?id=${digimon.id}">Rimuovi</a>
				
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<br> <br>Scegli i digimon che vuoi aggiungere alla squadra<br> <br>
	
	
		<br> <br>Scegli un ordinamento<br> <br>
	<form action="ordinaLista" method="post">
	<select name="ordinamento" >
  <option value="OrdAtk">ordina per atk</option>
  <option value="OrdDef">ordina per def</option>
  <option value="OrdRes">ordina per res</option>
  <option value="OrdHp">ordina per hp</option>
  <option value="OrdEvo">ordina per evoluzione</option>

</select>
<input type="hidden" name="idAllenatore" value="${allenatore.id}">

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
		<form:form  action="aggiungiDigimon" method="post" >
		<tr>
			<td>${digimon.id}
			
			</td>
			<td>${digimon.nome}</td>
			<td>${digimon.atk}</td>
			<td>${digimon.def}</td>
			<td>${digimon.res}</td>
			<td>${digimon.hp}</td>
			<td>${digimon.evoluzione}</td>
			
			<td>
			
			    <input type="hidden" name="digimon" value="${digimon.id}">
				<input type="hidden" name="idAllenatore" value="${allenatore.id}">
				<input type="submit" name="azione" value="Aggiungi alla Squadra" />
				
				
			</td>
		</tr>
		</form:form>
		</c:forEach>
		
	</table>
</body>
</html>