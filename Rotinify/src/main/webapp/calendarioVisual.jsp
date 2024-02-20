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
            <%
            ArrayList<TarefaVisual> listaTarefas = (ArrayList<TarefaVisual>) request.getAttribute("tarefas");
            %>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Segunda-feira")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Segunda-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Terça-feira")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Terça-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Quarta-feira")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Quarta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Quinta-feira")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Quinta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Sexta-feira")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Sexta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Sábado")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Sábado" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <ul>
                    <%
                    if (listaTarefas != null) {
                        for (int i =   0; i < listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Domingp")) {
                    %>
                    <li>
                        <div class="tarefa">
                            <img alt="" src="<%=listaTarefas.get(i).getCaminho_imagem()%>">
                            <div class="descricao-horario">
                                <div class="horario-icon-container">
                                    <img src="images/hora.jpg" alt="Descrição da imagem" class="imagem-horario">
                                    <span class="horario-tarefa"><%=listaTarefas.get(i).getHorario()%></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <%
                            }
                        }
                    }
                    %>
                </ul> <a href="manageVisual?dia_semana=Domingo" class="gerenciar-button">Gerenciar</a>
            </td>
        </tr>
    </table>
</body>
</html>
