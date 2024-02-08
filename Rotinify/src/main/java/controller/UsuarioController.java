package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.Tarefa;
import model.TarefaDAO;
import model.Usuario;


@WebServlet(urlPatterns = {"/Controller", "/cadastro","/login"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    TarefaDAO tarefaDao = new TarefaDAO();
    Usuario usuario = new Usuario();

    public UsuarioController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/cadastro")) {
			cadastro(request,response);
		}else if(action.equals("/login")) {
			login(request,response);
		}else {
			response.sendRedirect("homepage.html");
		}
		
	}
	
	protected void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    usuario.setNome(request.getParameter("username"));
	    usuario.setEmail(request.getParameter("email"));
	    usuario.setSenha(request.getParameter("password"));
	    
	    if (!usuarioDao.verificarCadastro(usuario)) {
	    	usuarioDao.cadastroUsuario(usuario);
	        response.sendRedirect("login.html");
	    } else {
	        response.sendRedirect("cadastro.html?error=true&username=" + usuario.getNome() + "&email=" + usuario.getEmail());
	        return;
	    }	    
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    usuario.setNome(request.getParameter("username"));
	    usuario.setSenha(request.getParameter("password"));
	    
	    if (usuarioDao.verificarLogin(usuario)) {
	        response.sendRedirect("homepage.html");
	    } else {
	        response.sendRedirect("login.html?error=true");
	    }  
	}
}
