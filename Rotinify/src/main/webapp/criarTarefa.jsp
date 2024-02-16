<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/criarTarefa.css">
    <title>Criar Tarefa</title>
</head>

<body>

    <div class="container">
        <h1>Criar Tarefa</h1>

        <form action="insert">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>

            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao"></textarea>

            <label for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" required>

            <label for="dia_semana">Dia da Semana:</label>
			<select id="dia_semana" name="dia_semana" required>
			    
				<option value="Segunda-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Segunda-feira")) ? "selected" : "" %>>Segunda-feira</option>
				<option value="Terça-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Terça-feira")) ? "selected" : "" %>>Terça-feira</option>
				<option value="Quarta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quarta-feira")) ? "selected" : "" %>>Quarta-feira</option>
				<option value="Quinta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quinta-feira")) ? "selected" : "" %>>Quinta-feira</option>
				<option value="Sexta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sexta-feira")) ? "selected" : "" %>>Sexta-feira</option>
				<option value="Sábado" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sábado")) ? "selected" : "" %>>Sábado</option>
				<option value="Domingo" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Domingo")) ? "selected" : "" %>>Domingo</option>
			</select>
            
            <button type="submit">Criar Tarefa</button>
        </form>
    </div>
</body>

</html>
