<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.TarefaVisual"%>
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
<title>Calendário Visual</title>
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
        </tr>
        <tr>
            <% ArrayList<TarefaVisual> listaTarefas = (ArrayList<TarefaVisual>) request.getAttribute("tarefas"); %>
            <!-- Monday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Segunda-feira") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Segunda-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Tuesday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Terça-feira") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Terça-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Wednesday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Quarta-feira") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Quarta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Thursday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Quinta-feira") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Quinta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Friday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Sexta-feira") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }


                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Sexta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Saturday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Sábado") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Sábado" class="gerenciar-button">Gerenciar</a>
            </td>
            <!-- Sunday -->
            <td class="coluna">
                <ul>
                    <% if (listaTarefas != null) {
                        for (TarefaVisual tarefa : listaTarefas) {
                            if (tarefa.getDia_semana().equals("Domingo") && tarefa.getCaminho_imagem() != null && !tarefa.getCaminho_imagem().isEmpty()) { %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%= tarefa.getCaminho_imagem() %>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%= tarefa.getHorario() %></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <% }
                        } } %>
                </ul>
                <a href="manageVisual?dia_semana=Domingo" class="gerenciar-button">Gerenciar</a>
            </td>
        </tr>
    </table>
</body>
</html>