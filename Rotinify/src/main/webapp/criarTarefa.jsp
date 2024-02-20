<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles/criarTarefa.css">
<title>Criar Tarefa</title>
</head>

<body>
	<div id="container">
		<h1>EDITAR TAREFA</h1>
		<div id="box-formulario">
			<form action="update">
				<label for="nome">Nome da tarefa:</label> <input
					class="box-formulario-digitar" type="text" id="nome" name="nome"
					required> <label for="descricao">Descrição:</label>
				<textarea class="box-formulario-digitar" id="descricao"
					name="descricao"></textarea>

				<label for="horario">Horário:</label> <input
					class="box-formulario-digitar" type="time" id="horario"
					name="horario" required> <label for="dia_semana">Dia
					da Semana:</label> <select class="box-formulario-digitar" id="dia_semana"
					name="dia_semana" required>

					<option value="Segunda-feira"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Segunda-feira"))
		? "selected"
		: ""%>>Segunda-feira</option>
					<option value="Terça-feira"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Terça-feira"))
		? "selected"
		: ""%>>Terça-feira</option>
					<option value="Quarta-feira"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quarta-feira"))
		? "selected"
		: ""%>>Quarta-feira</option>
					<option value="Quinta-feira"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quinta-feira"))
		? "selected"
		: ""%>>Quinta-feira</option>
					<option value="Sexta-feira"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sexta-feira"))
		? "selected"
		: ""%>>Sexta-feira</option>
					<option value="Sábado"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sábado")) ? "selected"
				: ""%>>Sábado</option>
					<option value="Domingo"
						<%=(request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Domingo"))
		? "selected"
		: ""%>>Domingo</option>
				</select>

				<div id="botao-salvar"></div>
					<button type="submit">Salvar Evento</button>
			</form>
		</div>
	</div>
</body>

</html>
