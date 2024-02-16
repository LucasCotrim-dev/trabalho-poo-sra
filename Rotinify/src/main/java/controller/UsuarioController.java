package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.Usuario;
import model.UsuarioAutista;


@WebServlet(urlPatterns = {"/UsuarioController", "/cadastro","/login"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Usuario usuario = new Usuario();
    UsuarioAutista usuarioAutista = new UsuarioAutista();

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
		usuarioAutista.setCuidador(request.getParameter("cuidador"));
		usuario.setNome(request.getParameter("username"));
	    usuario.setEmail(request.getParameter("email"));
	    usuario.setSenha(request.getParameter("password"));
	    
	    if (!usuarioDao.verificarCadastro(usuario)) {
	    	usuarioDao.cadastroUsuario(usuario, usuarioAutista);
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
	    	int idUsuario = usuarioDao.obterIdUsuario(usuario);
	        
	        // Define o ID do usuário na sessão
	        request.getSession().setAttribute("idUsuario", idUsuario);
	        request.setAttribute("usuario", usuario);
	        
	        UsuarioAutista usuarioAutista = new UsuarioAutista();
	        usuarioAutista.setCuidador(request.getParameter("cuidador"));
	        // Se houver outros atributos, preencha-os aqui também
	        request.getSession().setAttribute("usuarioAutista", usuarioAutista);

	        
	     // Obtém o usuário do banco de dados usando o ID
	        Usuario usuarioCompleto = usuarioDao.obterUsuarioPorId(idUsuario);
	        request.getSession().setAttribute("usuario", usuarioCompleto);

	        response.sendRedirect("menu.jsp");
	    } else {
	        response.sendRedirect("login.html?error=true");
	    }    
	}
}
