<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Perfil</title>
<link rel="stylesheet" href="styles/editarPerfil.css">
<link
	href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
</head>
<body style="background-image: url(images/background.png); background-size: cover;">
    <div id="container">
        <h1 class="edit-profile-title">EDITAR PERFIL</h1>
        <div class="profile-container">
            <form action="updateProfile" enctype="multipart/form-data">
                <div class="profile-image-container" id="profile-container">
                    <img id="fotoPerfil" src="<%=usuario.getFotoPerfil()%>" alt="Foto de Perfil" class="profile-image profile-image-circle">
                    <input type="file" id="profile-image-upload" accept="images/*" style="display: none;" name="fotoPerfil">
                    <div id="edit-text" class="edit-text">Editar</div>
                </div>
                <div id="box-formulario">
    					
                    <div class="form-group">
                        <label class="texto-formulario" for="email">Email:</label>
                        <div>
                            <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>">
                        </div>
                    </div>
    
                    <div class="form-group">
                        <label class="texto-formulario" for="nome">Nome:</label>
                        <div>
                            <input type="text" id="nome" name="nome" value="<%= usuario.getNome() %>">
                        </div>
                    </div>
    
                    <div class="form-group">
                        <label class="texto-formulario" for="cuidador">Nome do Cuidador:</label>
                        <div>
                            <input type="text" id="cuidador" name="cuidador" value="<%= usuario.getCuidador() %>">
                        </div>
                    </div>
    
                </div>
               
                <button id="button-salvar" type="submit">Salvar</button>
                <a href="alterarSenha.jsp"><button id="button-trocar-senha" type="button">Trocar Senha</button></a>
            </form>
        </div>
        <script>
            document.getElementById('profile-container').addEventListener('mouseenter', function() {
                document.getElementById('edit-text').style.display = 'block';
            });
    
            document.getElementById('profile-container').addEventListener('mouseleave', function() {
                document.getElementById('edit-text').style.display = 'none';
            });
    
            document.getElementById('profile-container').addEventListener('click', function() {
                document.getElementById('profile-image-upload').click();
            });
    
            document.getElementById('profile-image-upload').addEventListener('change', function(e) {
                var file = e.target.files[0];
                var reader = new FileReader();
                reader.onload = function(e) {
                    var img = document.getElementById('fotoPerfil');
                    img.src = e.target.result;
                    img.classList.add('profile-image-circle'); // Adicione a classe para manter o tamanho do círculo
                }
                reader.readAsDataURL(file);
            });
        </script>
    </div>
</body>
</html>
