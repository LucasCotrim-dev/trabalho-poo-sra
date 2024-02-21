<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Evento</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/criarTarefa.css">
</head>

<body style="background-image: url(images/background-tarefas2.jpg); background-size: cover;">

    <div class="container">
        <h1>Editar Evento</h1>

        <form action="updateEvent">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%=request.getAttribute("nome")%>" required>
			
            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao"><%=request.getAttribute("descricao")%></textarea>

            <label for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" value="<%=request.getAttribute("horario") != null && 
            !request.getAttribute("horario").equals("") ? request.getAttribute("horario") : "00:00"%>" required>

			<label for="dia_semana">Dia da Semana:</label>
            <select id="dia_semana" name="dia_semana" required>
				
				<option>Segunda-feira</option>
				<option>Terça-feira</option>
				<option>Quarta-feira</option>
				<option>Quinta-feira</option>
				<option>Sexta-feira</option>
				<option>Sábado</option>
				<option>Domingo</option>

            </select>
            
            <label for="data">Data:</label>
    		<input type="date" id="data" name="data" value="<%=request.getAttribute("data")%>" required>
            
            <button type="submit">Salvar Evento</button>
        </form>
    </div>
</body>

</html>
