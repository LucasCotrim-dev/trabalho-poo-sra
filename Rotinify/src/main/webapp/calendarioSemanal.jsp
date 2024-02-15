<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.Tarefa" %>
<%@ page import= "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="styles/calendarioSemanal.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<title>Calendário Semanal</title>
</head>
<body>
    <h1>Monte sua Rotina</h1>
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
            <td class="coluna">
                <!-- Exibir tarefas para segunda-feira -->
                <ul>
                    <% ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas"); %>
                        <%if (listaTarefas != null){%>
                            <% for (int i=0; i< listaTarefas.size(); i++) {
                                if (listaTarefas.get(i).getDia_semana().equals("Segunda-feira")) { %>
                                    <li>
                                        <div class="tarefa">
                                            <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                        </div>
                                    </li>
                             <%}
                            }%>
                        <%}%>
                </ul>
                <!-- Botão Gerenciar -->
                <a href="manage?dia_semana=Segunda-feira" class="gerenciar-button">Gerenciar</a>
            </td>

            <td class="coluna">
                <!-- Exibir tarefas para segunda-feira -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Terça-feira")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <!-- Botão Gerenciar -->
                <a href="manage?dia_semana=Terça-feira" class="gerenciar-button">Gerenciar</a>
            </td>

            <td class="coluna">
                <!-- Exibir tarefas para quarta-feira -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Quarta-feira")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <a href="manage?dia_semana=Quarta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <!-- Exibir tarefas para quinta-feira -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Quinta-feira")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <a href="manage?dia_semana=Quinta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <!-- Exibir tarefas para sexta-feira -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Sexta-feira")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <a href="manage?dia_semana=Sexta-feira" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <!-- Exibir tarefas para sábado -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Sábado")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <a href="manage?dia_semana=Sabado" class="gerenciar-button">Gerenciar</a>
            </td>
            <td class="coluna">
                <!-- Exibir tarefas para domingo -->
                <ul>
                    <%if (listaTarefas != null){%>
                        <% for (int i=0; i< listaTarefas.size(); i++) {
                            if (listaTarefas.get(i).getDia_semana().equals("Domingo")) { %>
                                <li>
                                    <div class="tarefa">
                                        <%= listaTarefas.get(i).getNome() %> - <%= listaTarefas.get(i).getDescricao() %> (<%= listaTarefas.get(i).getHorario() %>)
                                    </div>
                                </li>
                         <%}
                        }%>
                   <%}%>
                </ul>
                <a href="manage?dia_semana=Domingo" class="gerenciar-button">Gerenciar</a>
            </td>
        </tr>
    </table>
</body>
</html>
