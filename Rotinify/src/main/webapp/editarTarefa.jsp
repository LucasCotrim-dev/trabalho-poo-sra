<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Tarefa</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/criarTarefa.css">
</head>

<body>

    <div class="container">
        <h1>Criar Tarefa</h1>

        <form action="update">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%=request.getAttribute("nome")%>" required>

            <!-- Design Temporario para Testes -->
            <button id="listar-imagens-btn">Listar imagens</button>
            <div id="popup" class="popup">
                <div class="popup-content" id="popup-content"></div>
            </div>
			<!-- . -->
			
            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao"><%=request.getAttribute("descricao")%></textarea>

            <label for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" value="<%=request.getAttribute("horario") != null && 
            !request.getAttribute("horario").equals("") ? request.getAttribute("horario") : "00:00"%>" required>

			<label for="dia_semana">Dia da Semana:</label>
            <select id="dia_semana" name="dia_semana" required>
                <option value="Domingo">Domingo</option>
                <option value="Segunda-feira">Segunda-feira</option>
                <option value="Terça-feira">Terça-feira</option>
                <option value="Quarta-feira">Quarta-feira</option>
                <option value="Quinta-feira">Quinta-feira</option>
                <option value="Sexta-feira">Sexta-feira</option>
                <option value="Sábado">Sábado</option>
            </select>
            
            <button type="submit">Salvar Tarefa</button>
        </form>
    </div>

    <script>
        document.getElementById("listar-imagens-btn").addEventListener("click", function() {
            var popup = document.getElementById("popup");
            var popupContent = document.getElementById("popup-content");

            // Limpa o conteúdo do popup
            popupContent.innerHTML = "";

            var imagens = ['brincar.svg', 'dormir.svg'];

            // Adiciona cada imagem ao popup
            imagens.forEach(function(imagem) {
                var img = document.createElement("img");
                img.src = "images/" + imagem;
                popupContent.appendChild(img);
            });

            // Exibe o popup
            popup.style.display = "block";
        });
    </script>

</body>

</html>
