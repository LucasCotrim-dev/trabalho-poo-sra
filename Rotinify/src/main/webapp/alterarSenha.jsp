<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Alterar Senha</title>
    <script>
        function validarFormulario() {
            var senhaAntiga = document.getElementById("senhaAntiga").value;
            var senhaNova = document.getElementById("senhaNova").value;
            var confirmacaoSenha = document.getElementById("confirmacaoSenha").value;

            if (senhaAntiga === "" || senhaNova === "" || confirmacaoSenha === "") {
                alert("Por favor, preencha todos os campos.");
                return false;
            }

            if (senhaNova !== confirmacaoSenha) {
                alert("A nova senha e a confirmação da senha não coincidem.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <h1>Alterar Senha</h1>
    <form action="updatePassword" onsubmit="return validarFormulario()">
        <div>
            <label for="senhaAntiga">Senha Antiga:</label>
            <input type="password" id="senhaAntiga" name="senhaAntiga">
        </div>
        <div>
            <label for="senhaNova">Nova Senha:</label>
            <input type="password" id="senhaNova" name="senhaNova">
        </div>
        <div>
            <label for="confirmacaoSenha">Confirmação da Nova Senha:</label>
            <input type="password" id="confirmacaoSenha" name="confirmacaoSenha">
        </div>
        <button type="submit">Alterar Senha</button>
    </form>
</body>
</html>
