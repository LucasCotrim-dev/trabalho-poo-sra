<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.Tarefa" %>
<%@ page import= "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tarefas do Dia</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/rotina.css">
</head>
<body>


    <div id="container">
        <h1>Lista de Tarefas</h1>
             
        <%  
        
        ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas");
        if (listaTarefas != null && !listaTarefas.isEmpty()) {
            for (int i=0; i< listaTarefas.size(); i++) { 
        
         %>
        

        <div id="box-main">

            <div id="box-tarefa-main">
                <p> <%= listaTarefas.get(i).getHorario() %></p>

                <div class="box-tarefa">
                    <div id="box-titulo-tarefa">
                        <h2 id="titulo-tarefa"> <%= listaTarefas.get(i).getNome() %></h2>
                    </div>
                    <p class="descricao-tarefa"> <%= listaTarefas.get(i).getDia_semana() %></p>
                    <p class="descricao-tarefa"> <%= listaTarefas.get(i).getDescricao() %></p>
                    <div id="box-botoes">
                        <a id="botao-excluir"
                            href="javascript: confirmar(<%=listaTarefas.get(i).getId()%>, '<%= request.getParameter("dia_semana") %>')">Excluir</a>
                        <a id="botao-editar"
                            href="select?id=<%= listaTarefas.get(i).getId() %>&dia_semana=<%= request.getParameter("dia_semana") %>">Editar</a>
                    </div>

                </div>

            </div>

        </div>

        <div id="box-botao-criar">
            <a class="botoes" id="botao-criar" href="criarTarefa.jsp?dia_semana=<%= request.getAttribute("diaSelecionado") %> "> Criar uma nova tarefa</a>
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

        <div id="link-voltar" >
            <a href="main">Voltar para o Calendário Semanal</a>
        </div>
        <script>
            function confirmar(id, diaSemana) {
                let resposta = confirm("Confirma a exclusão desta tarefa?")
                if (resposta === true) {
                    window.location.href = "delete?id=" + id + "&dia_semana=" + diaSemana;
                }
            }
        </script>
    </div>
</body>
</html>

