<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Editar Tarefa</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/criarTarefaVisual.css">
    <script>
    window.onload = function() {
        var modal = document.getElementById("myModal");
        var closeButton = document.getElementsByClassName("close")[0];

        closeButton.onclick = function() {
            modal.style.display = "none";
        }

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    }

    // Function to open the image popup modal
    // Function to open the image popup modal
function openImagePopup() {
    // Obtenha a div do modal
    var modal = document.getElementById("myModal");

    // Exiba o modal
    modal.style.display = "flex";

    // Adicione event listeners para os botões de imagem
    var imageButtons = document.getElementsByClassName("image-button");
    for (var i =  0; i < imageButtons.length; i++) {
        imageButtons[i].addEventListener("click", function() {
            // Atualize a imagem selecionada
            var selectedImage = document.getElementById("selectedImage");
            var clickedImageSrc = this.firstChild.src;
            selectedImage.src = clickedImageSrc;
            selectedImage.style.display = "block";
            document.getElementById("imagem").value = clickedImageSrc;

            // Feche o modal
            modal.style.display = "none";
        });
    }
}


</script>
</head>

<body style="background-image: url(images/background-tarefas2.jpg); background-size: cover;">

    <div class="container">
        <h1>Editar Tarefa</h1>
<img id="selectedImage" src="<%= request.getAttribute("imagem") %>" alt="Imagem Selecionada" style="display: <%= request.getAttribute("imagem") != null ? "block" : "none" %>">
        <form action="updateVisual">

            <input type="hidden" id="imagem" name="imagem" value="<%= request.getAttribute("imagem") %>" required>
            <button type="button" onclick="openImagePopup()">Selecionar Imagem</button>

            <label for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" value="<%= request.getAttribute("horario") !=null &&
                !request.getAttribute("horario").equals("") ? request.getAttribute("horario") : "00:00" %>"
                required>

            <label for="dia_semana">Dia da Semana:</label>
            <select id="dia_semana" name="dia_semana" required>
                <option value="Segunda-feira" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Segunda-feira")) ? "selected" : "" %>>Segunda-feira
                </option>
                <option value="Terça-feira" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Terça-feira")) ? "selected" : "" %>>Terça-feira
                </option>
                <option value="Quarta-feira" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Quarta-feira")) ? "selected" : "" %>>Quarta-feira
                </option>
                <option value="Quinta-feira" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Quinta-feira")) ? "selected" : "" %>>Quinta-feira
                </option>
                <option value="Sexta-feira" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Sexta-feira")) ? "selected" : "" %>>Sexta-feira
                </option>
                <option value="Sábado" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Sábado")) ? "selected" : "" %>>Sábado</option>
                <option value="Domingo" <%= (request.getParameter("dia_semana") != null &&
                    request.getParameter("dia_semana").equals("Domingo")) ? "selected" : "" %>>Domingo</option>
            </select>
            <button type="submit">Salvar Tarefa</button>
        </form>
    </div>

    <div id="myModal" class="modal" style="display: none;">
        <div class="modal-content">
        <span class="close">&times;</span>
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
            <span></span>
        </div>
         
    </div>
</body>

</html>
