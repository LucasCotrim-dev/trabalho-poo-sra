<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Tarefa"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Tarefas do Dia</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles/rotina.css">
</head>
<body>

	<h1>Lista de Tarefas</h1>

	<div class="button-wrapper">
		<a
			href="criarTarefa.jsp?dia_semana=<%=request.getAttribute("diaSelecionado")%>">Criar
			Tarefa</a>
	</div>

	<a class="back-button" href="main">Voltar para o Calendário Semanal</a>


	<%
	ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas");
	if (listaTarefas != null && !listaTarefas.isEmpty()) {
		for (int i = 0; i < listaTarefas.size(); i++) {
			String nomeTarefa = listaTarefas.get(i).getNome();
			if (nomeTarefa != null && !nomeTarefa.isEmpty()) {
	%>
	<div class="tarefa">
		<h2><%=nomeTarefa%></h2>
		<span class="horario"><%=listaTarefas.get(i).getHorario()%></span>
		<p><%=listaTarefas.get(i).getDescricao()%></p>
		<p><%=listaTarefas.get(i).getDia_semana()%></p>
		<a class="editar"
			href="select?id=<%=listaTarefas.get(i).getId()%>&dia_semana=<%=request.getParameter("dia_semana")%>">Editar</a>
		<a class="excluir"
			href="javascript: confirmar(<%=listaTarefas.get(i).getId()%>, '<%=request.getParameter("dia_semana")%>')">Excluir</a>
	</div>
	<%
	}
	}
	} else {
	%>
	<div class="no-tasks">
		<p>Nenhuma tarefa encontrada.</p>
	</div>
	<%
	}
	%>
	<script>
		function confirmar(id, diaSemana) {
			let resposta = confirm("Confirma a exclusão desta tarefa?")
			if (resposta === true) {
				window.location.href = "delete?id=" + id + "&dia_semana="
						+ diaSemana;
			}
		}
	</script>
</body>
</html>
