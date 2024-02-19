<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.Evento" %>
<%@ page import= "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Eventos</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/rotina.css">
</head>
<body>
    
    <h1>Lista de Eventos</h1>
    
    <a href="criarEvento.html">Criar Evento</a>

    <%
        ArrayList<Evento> listaEventos = (ArrayList<Evento>) request.getAttribute("eventos");
        if (listaEventos != null && !listaEventos.isEmpty()) {
            for (int i=0; i< listaEventos.size(); i++) {
    %>
                <div class="tarefa">
                    <h2><%= listaEventos.get(i).getNome() %></h2>
                    <span class="horario"><%= listaEventos.get(i).getHorario() %></span>
                    <p><%= listaEventos.get(i).getDescricao() %></p>
                    <p><%= listaEventos.get(i).getDia_semana() %></p>
                    <p><%= listaEventos.get(i).getData() %></p>
                    <a class="editar" href="selectEvent?id=<%= listaEventos.get(i).getId() %>&dia_semana=<%= request.getParameter("dia_semana") %>">Editar</a>
                    <a class="excluir" href="javascript: confirmar(<%=listaEventos.get(i).getId()%>)">Excluir</a>
                </div>
    <%
            }
        } else {
    %>
        <div class="no-tasks">
            <p>Nenhum evento encontrado.</p>
        </div>
    <%
        }
    %>
    <a href="main">Voltar para o Calendário Semanal</a>
    <script>
        function confirmar(id) {
            let resposta = confirm("Confirma a exclusão deste evento?")
            if (resposta === true) {
                window.location.href = "deleteEvent?id=" + id;
            }
        }
    </script>
</body>
</html>
