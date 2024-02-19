package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.Usuario;

@WebServlet(urlPatterns = { "/UsuarioController", "/cadastro", "/login", "/updateProfile", "/updatePassword" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public UsuarioController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/cadastro")) {
			cadastro(request, response);
		} else if (action.equals("/login")) {
			login(request, response);
		} else if (action.equals("/updateProfile")) {
			atualizarPerfil(request, response);
		} else if (action.equals("/updatePassword")) {
			alterarSenha(request, response);
		}else {
			response.sendRedirect("homepage.html");
		}

	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setCuidador(request.getParameter("cuidador"));
		usuario.setNome(request.getParameter("username"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("password"));

		if (!usuarioDao.verificarCadastro(usuario)) {
			usuarioDao.cadastroUsuario(usuario);
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect(
					"cadastro.html?error=true&username=" + usuario.getNome() + "&email=" + usuario.getEmail());
			return;
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setNome(request.getParameter("username"));
		usuario.setSenha(request.getParameter("password"));

		if (usuarioDao.verificarLogin(usuario)) {
			int idUsuario = usuarioDao.obterIdUsuario(usuario);

			// Define o ID do usuário na sessão
			request.getSession().setAttribute("idUsuario", idUsuario);
			request.setAttribute("usuario", usuario);

			Usuario usuarioCompleto = usuarioDao.obterUsuarioPorId(idUsuario);
			request.getSession().setAttribute("usuario", usuarioCompleto);

			response.sendRedirect("menu.jsp");
		} else {
			response.sendRedirect("login.html?error=true");
		}
	}

	protected void atualizarPerfil(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    int idUsuario = (int) request.getSession().getAttribute("idUsuario");

	    String nome = request.getParameter("nome");
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    String cuidador = request.getParameter("cuidador");

	    Usuario usuarioAtualizado = new Usuario(idUsuario, nome, email, senha, cuidador);
	    if (usuarioDao.verificarDuplicidade(usuarioAtualizado)) {
	        response.sendRedirect("editarPerfil.jsp?error=true");
	        return;
	    }

	    usuarioDao.atualizarPerfil(idUsuario, usuarioAtualizado);

	    // Atualize o objeto usuário na sessão com as novas informações
	    request.getSession().setAttribute("usuario", usuarioAtualizado);

	    // Redirecione para a página JSP que exibe o perfil do usuário
	    response.sendRedirect("menu.jsp");
	}


	protected void alterarSenha(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int idUsuario = (int) request.getSession().getAttribute("idUsuario");
	    String senhaAntiga = request.getParameter("senhaAntiga");
	    String senhaNova = request.getParameter("senhaNova");
	    String confirmacaoSenha = request.getParameter("confirmacaoSenha");

	    if (usuarioDao.verificarSenha(idUsuario, senhaAntiga)) {
	        // Verificar se a nova senha e a confirmação coincidem
	        if (senhaNova.equals(confirmacaoSenha)) {
	            // Atualizar a senha no banco de dados
	            usuarioDao.atualizarSenha(idUsuario, senhaNova);
	            response.sendRedirect("editarPerfil.jsp?senhaAlterada=true");
	            return;
	        } else {
	            response.sendRedirect("alterarSenha.jsp?erro=senhasDiferentes");
	            return;
	        }
	    } else {
	        response.sendRedirect("alterarSenha.jsp?erro=senhaAntigaIncorreta");
	        return;
	    }
	}
}
