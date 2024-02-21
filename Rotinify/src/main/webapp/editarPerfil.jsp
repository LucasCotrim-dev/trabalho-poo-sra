<!--Visualização da edição de perfil-->
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
<body
	style="background-image: url(images/background.png); background-size: cover;">
	<%
	String senhaAlterada = request.getParameter("senhaAlterada");
	if ("true".equals(senhaAlterada)) {
	%>
	<div style="text-align: center; margin-top: 20px;">
		<span style="color: green;">Senha alterada com sucesso!</span>
	</div>
	<%
	}
	%>
	<div id="container">
		<h1 class="edit-profile-title">EDITAR PERFIL</h1>
		<div class="profile-container">
			<form action="updateProfile" enctype="multipart/form-data">
				<div class="profile-image-container" id="profile-container">
					<!-- Div para a imagem de perfil -->
					<div class="profile-image-wrapper">
						<img id="fotoPerfil" src="<%=usuario.getFotoPerfil()%>"
							alt="Foto de Perfil" class="profile-image profile-image-circle"
							style="background-image: url('images/fotosPerfil/perfilVazio.png'); background-size: cover;">
					</div>
					<input type="hidden" name="foto_url" id="foto_url">
					<div class="edit-photo-button-wrapper">
						<button type="button" onclick="openImagePopup()">Editar
							Foto</button>
					</div>
				</div>


				<div id="box-formulario">

					<div class="form-group">
						<label class="texto-formulario" for="email">Email:</label>
						<div>
							<input type="email" id="email" name="email"
								value="<%=usuario.getEmail()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="texto-formulario" for="nome">Nome:</label>
						<div>
							<input type="text" id="nome" name="nome"
								value="<%=usuario.getNome()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="texto-formulario" for="cuidador">Nome do
							Cuidador:</label>
						<div>
							<input type="text" id="cuidador" name="cuidador"
								value="<%=usuario.getCuidador()%>">
						</div>
					</div>

				</div>

				<button id="button-salvar" type="submit">Salvar</button>
				<a href="alterarSenha.jsp"><button id="button-trocar-senha"
						type="button">Trocar Senha</button></a>
			</form>
		</div>
		<a href="menu.jsp" class="voltar-btn">Voltar</a>
		<div id="imagePopup" class="modal">
			<div class="modal-content">
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil1.png')">
					<img src="images/fotosPerfil/fotoPerfil1.png" alt="Imagem  1">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil2.png')">
					<img src="images/fotosPerfil/fotoPerfil2.png" alt="Imagem  2">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil3.png')">
					<img src="images/fotosPerfil/fotoPerfil3.png" alt="Imagem  3">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil4.png')">
					<img src="images/fotosPerfil/fotoPerfil4.png" alt="Imagem  4">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil5.png')">
					<img src="images/fotosPerfil/fotoPerfil5.png" alt="Imagem  5">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil6.png')">
					<img src="images/fotosPerfil/fotoPerfil6.png" alt="Imagem  6">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil7.png')">
					<img src="images/fotosPerfil/fotoPerfil7.png" alt="Imagem  7">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil8.png')">
					<img src="images/fotosPerfil/fotoPerfil8.png" alt="Imagem  8">
				</button>
				<button class="image-button"
					onclick="selectImage('images/fotosPerfil/fotoPerfil9.png')">
					<img src="images/fotosPerfil/fotoPerfil9.png" alt="Imagem  9">
				</button>
			</div>
		</div>
		<script>
			// Função para abrir o pop-up
			function openImagePopup() {
				var modal = document.getElementById("imagePopup");
				modal.style.display = "block";
			}

			// Função para fechar o pop-up
			function closeImagePopup() {
				var modal = document.getElementById("imagePopup");
				modal.style.display = "none";
			}

			// Função para selecionar uma imagem e fechar o pop-up
			function selectImage(imagePath) {
				var img = document.getElementById('fotoPerfil');
				img.src = imagePath;
				img.classList.add('profile-image-circle');
				img.classList.remove('empty'); // Remove a classe 'empty' se houver uma imagem selecionada
				closeImagePopup();

				document.getElementById('foto_url').value = imagePath;
			}

			// Quando a página é carregada, verifica se há uma imagem selecionada
			document.addEventListener('DOMContentLoaded', function() {
				var img = document.getElementById('fotoPerfil');
				if (!img.src) {
					img.classList.add('empty'); // Adiciona a classe 'empty' se não houver imagem selecionada
				}
			});

			// Fechar o pop-up ao clicar fora dele
			window.onclick = function(event) {
				if (event.target == document.getElementById("imagePopup")) {
					closeImagePopup();
				}
			}
		</script>
	</div>
</body>
</html>
