<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/criarTarefaVisual.css">
    <title>Criar Tarefa</title>
    <script>
        function openImagePopup() {
            // Obtenha a div do modal
            var modal = document.getElementById("myModal");

            // Exiba o modal
            modal.style.display = "flex";

            // Obtenha o elemento que fecha o modal
            var closeButton = document.getElementsByClassName("close")[0];

            // Quando o usuário clicar no botão de fechar (x), feche o modal
            closeButton.onclick = function() {
                modal.style.display = "none";
            }

            // Quando o usuário clicar em qualquer lugar fora do modal, feche-o
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        }
    </script>
</head>

<body>

    <div class="container">
        <h1>Criar Tarefa</h1>

        <form action="insert">
            <button type="button" onclick="openImagePopup()"> Selecionar Ação </button>

            <label for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" required>

            <label for="dia_semana">Dia da Semana:</label>
            <select id="dia_semana" name="dia_semana" required>
                
                <option value="Segunda-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Segunda-feira")) ? "selected" : "" %>>Segunda-feira</option>
                <option value="Terça-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Terça-feira")) ? "selected" : "" %>>Terça-feira</option>
                <option value="Quarta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quarta-feira")) ? "selected" : "" %>>Quarta-feira</option>
                <option value="Quinta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Quinta-feira")) ? "selected" : "" %>>Quinta-feira</option>
                <option value="Sexta-feira" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sexta-feira")) ? "selected" : "" %>>Sexta-feira</option>
                <option value="Sábado" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Sábado")) ? "selected" : "" %>>Sábado</option>
                <option value="Domingo" <%= (request.getParameter("dia_semana") != null && request.getParameter("dia_semana").equals("Domingo")) ? "selected" : "" %>>Domingo</option>
            </select>
            
            <button type="submit">Adicionar Tarefa</button>
        </form>
    </div>

    <div id="myModal" class="modal" style="display: none;">
        <div class="modal-content">
            <button class="image-button"><img src="images/imagensRotina/Acordar.svg" alt="Acordar"></button>
            <button class="image-button"><img src="images/imagensRotina/Almocar.svg" alt="Almoçar"></button>
            <button class="image-button"><img src="images/imagensRotina/Banho.svg" alt="Banho"></button>
            <button class="image-button"><img src="images/imagensRotina/Brincar.svg" alt="Brincar"></button>
            <button class="image-button"><img src="images/imagensRotina/CafeManha.svg" alt="Café da Manhã"></button>
            <button class="image-button"><img src="images/imagensRotina/Dormir.svg" alt="Dormir"></button>
            <button class="image-button"><img src="images/imagensRotina/Escola.svg" alt="Escola"></button>
            <button class="image-button"><img src="images/imagensRotina/Escovar.svg" alt="Escovar"></button>
            <button class="image-button"><img src="images/imagensRotina/Estudar.svg" alt="Estudar"></button>
            <button class="image-button"><img src="images/imagensRotina/Jantar.svg" alt="Jantar"></button>
            <button class="image-button"><img src="images/imagensRotina/TrocarRoupa.svg" alt="Trocar de Roupa"></button>
        </div>
    </div>
</body>

</html>
