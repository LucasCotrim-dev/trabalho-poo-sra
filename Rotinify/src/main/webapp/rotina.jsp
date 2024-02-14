<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.Tarefa" %>
<%@ page import= "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Rotina do Dia</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="rotina.css">
</head>
<body>
	
	<h1>Lista de Tarefas</h1>
    
    <a href="criarTarefa.html">Criar Tarefa</a>

    <%
        ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas");
        if (listaTarefas != null && !listaTarefas.isEmpty()) {
            for (int i=0; i< listaTarefas.size(); i++) {
    %>
           	<div class="tarefa">
                <h2><%= listaTarefas.get(i).getNome() %></h2>
                <span class="horario"><%= listaTarefas.get(i).getHorario() %></span>
                <p><%= listaTarefas.get(i).getDescricao() %></p>
                <p><%= listaTarefas.get(i).getDia_semana() %></p>
                <a class="editar" href="select?id=<%= listaTarefas.get(i).getId() %>">Editar</a>
                <a class="excluir" href="javascript: confirmar(<%=listaTarefas.get(i).getId()%>)">Excluir</a>
                
            </div>
    <%
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
    function confirmar(id) {
    	let resposta = confirm("Confirma a exclusão desta tarefa?")
    	if (resposta === true) {
    		window.location.href = "delete?id=" + id
    	}
    }
    </script>
</body>
</html>