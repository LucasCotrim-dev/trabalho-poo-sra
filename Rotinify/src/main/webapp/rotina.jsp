<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.Tarefa" %>
<%@ page import= "java.util.ArrayList" %>

<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="rotina.css">
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    color: #333;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

a {
    display: block;
    text-align: center;
    margin-bottom: 20px;
    color: #007bff;
    text-decoration: none;
}

.tarefa {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 0 auto 20px; /* Aplica margens automáticas para centralizar horizontalmente */
    max-width: 600px; 
}

.tarefa h2 {
    margin-top: 0;
    color: #333;
}

.horario {
    font-size: 14px;
    color: #666;
}

.pergunta {
    font-weight: bold;
    color: #007bff;
    cursor: pointer;
}

.excluir {
    color: #dc3545;
    cursor: pointer;
}
.no-tasks {
    text-align: center;
}
.editar {
    color: #007bff;
    cursor: pointer;
    margin-right: 10px; /* Adicione margem à direita para separar do botão de exclusão */
}

</style>
<title>Rotina</title>
</head>
<body>
	
	<h1>Rotina</h1>
    
    <a href="criarTarefa.html">Criar Tarefa</a>

    <%
        ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas");
        if (listaTarefas != null && !listaTarefas.isEmpty()) {
            for (int i=0; i< listaTarefas.size(); i++) {
            	Tarefa tarefa = listaTarefas.get(i);
    %>
                <div class="tarefa">
                <h2><%= tarefa.getNome() %></h2>
                <span class="horario"><%= tarefa.getHorario() %></span>
                <p><%= tarefa.getDescricao() %></p>
                <p><strong>Categoria:</strong> <%= tarefa.getCategoria() %></p>
                <a class="editar" href="select?id=<%= tarefa.getId() %>">Editar</a>
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
        function excluirTarefa() {
            if (confirm("Tem certeza que deseja excluir esta tarefa?")) {
                // Adicione aqui a lógica para excluir a tarefa, se necessário
            }
        }
        
    </script>
</body>
</html>