# Trabalho POO SRA
Incompletos/Não Iniciados 13/02 { 
    Mostrar imagens na rotina - incompleto, falta melhorar o design

    Cadastrar/logar com o google - incompleto, falta tantar corrigir aparência do botão e implementar o resto da lógica (adicionar no login também)

    Cadastro/login com o facebook - não iniciado

    Acessar nas páginas só se estiver logado- incompleto, apenas tenho direção geral informada pelo chatgpt (incluída no final)

    Edição de perfil - não iniciado

    Calendário - não iniciado
    
}

# ChatGPT Sobre forçar autenticação
Entendi! Se você deseja uma implementação simples apenas para redirecionar usuários para a página de login caso não estejam autenticados, aqui está um exemplo simplificado apenas com HTML e JavaScript:

html
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Página de Login</title>
<script>
  // Função para verificar se o usuário está logado
  function checkLoggedIn() {
    if (!localStorage.getItem('loggedIn')) {
      window.location.href = 'login.html'; // Redireciona para a página de login se não estiver logado
    }
  }

  // Função de login
  function login() {
    // Aqui você faria a autenticação, por exemplo, verificando as credenciais em um banco de dados
    // Por simplicidade, vamos assumir que o usuário está sempre autenticado com sucesso
    localStorage.setItem('loggedIn', 'true');
    window.location.href = 'pagina_principal.html'; // Redireciona para a página principal após o login bem-sucedido
  }

  // Função de logout
  function logout() {
    // Remove o flag de login do localStorage
    localStorage.removeItem('loggedIn');
    window.location.href = 'login.html'; // Redireciona para a página de login após o logout
  }
</script>
</head>
<body onload="checkLoggedIn()">
  <h1>Bem-vindo ao Site</h1>
  <p>Este é o conteúdo principal do seu site.</p>
  <button onclick="logout()">Logout</button>
</body>
</html>
Neste exemplo:

A função checkLoggedIn() é chamada quando a página é carregada. Ela verifica se o usuário está logado, olhando para o valor do loggedIn no localStorage. Se o usuário não estiver logado, ele será redirecionado para a página de login (login.html).

A função login() normalmente lidaria com o processo de login. Para simplicidade, ela assume que o usuário sempre é autenticado com sucesso e o redireciona para a página principal (pagina_principal.html).

A função logout() remove o flag loggedIn do localStorage e redireciona o usuário para a página de login (login.html).