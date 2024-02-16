<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Usuario" %>
<%@ page import="model.Usuario, model.UsuarioAutista" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario"); 
    UsuarioAutista usuarioAutista = (UsuarioAutista) session.getAttribute("usuarioAutista");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Perfil</title>
    <link rel="stylesheet" href="styles/editarPerfil.css">
    <link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <h1 class="edit-profile-title">Editar Perfil</h1>
    <div class="profile-container">
        <form action="menu" enctype="multipart/form-data">
            <div class="profile-image-container" id="profile-container">
                <img id="profile-image" src="<%=usuario.getFotoPerfil()%>" alt="Foto de Perfil" class="profile-image">
                <input type="file" id="profile-image-upload" accept="image/*" style="display: none;" name="fotoPerfil">
                <div id="edit-text" class="edit-text">Editar</div>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>">
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha">
            </div>
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" value="<%= usuario.getNome() %>">
            </div>
            <div class="form-group">
                <label for="cuidador">Nome do Cuidador:</label>
                <input type="text" id="cuidador" name="cuidador" value="<%= usuarioAutista.getCuidador() %>">
            </div>
            <button type="submit">Salvar</button>
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
                document.getElementById('profile-image').src = e.target.result;
            }
            reader.readAsDataURL(file);
        });
    </script>
</body>
</html>
