<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Tarefa"%>
<%@ page import="model.Evento"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
    href="styles/calendarioSemanal.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
    href="https://fonts.googleapis.com/css2?family=Fredoka:wdth,wght@95.3,300..700&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
    rel="stylesheet">
<title>Calendário Semanal</title>
</head>
<body>
    <h1>Monte sua Rotina</h1>
    <a href="menu.jsp" class="voltar-button"> <img
        src="images/home.png" alt="Voltar para o Menu">
    </a>
    <table>
        <tr>
            <th>Segunda-feira</th>
            <th>Terça-feira</th>
            <th>Quarta-feira</th>
            <th>Quinta-feira</th>
            <th>Sexta-feira</th>
            <th>Sábado</th>
            <th>Domingo</th>
            <th>Eventos</th>
        </tr>
        <tr>
            <% ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas"); %>
            <!-- Monday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Segunda-feira") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Segunda-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Tuesday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Terça-feira") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Terça-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Wednesday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Quarta-feira") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Quarta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Thursday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Quinta-feira") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Quinta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Friday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Sexta-feira") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Sexta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Saturday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Sábado") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Sábado" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Sunday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (Tarefa tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Domingo") && tarefa.getNome() != null && !tarefa.getNome().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <span class="nome-tarefa"><%= tarefa.getNome() %></span>
                            <div class="descricao-horario">
                                <span class="descricao-tarefa"><%= tarefa.getDescricao() %></span>
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem"
                                        class="imagem-horario"> <span class="horario-tarefa"><%= tarefa.getHorario() %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manage?dia_semana=Domingo" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Events -->
            <td class="coluna">
                <ul>
                    <% ArrayList<Evento> listaEventos = (ArrayList<Evento>) request.getAttribute("eventos"); %>
                    <% if (listaEventos != null) {
                        for (Evento evento : listaEventos) { %>
                    <li>
                        <div class="evento">
                            <span class="nome-evento"><%= evento.getNome() %></span>
                            <div class="descricao-data">
                                <span class="descricao-evento"><%= evento.getDescricao() %></span>
                                <div class="data-icon-container">
                                    <img src="images/calendar.jpg" alt="Descrição da imagem"
                                        class="imagem-data"> <span class="data-evento"><%= evento.getData() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } %>
                </ul>
                <a href="manageEvents" class="gerenciar-button">Gerenciar</a>
            </td>
        </tr>
    </table>
</body>
</html>
