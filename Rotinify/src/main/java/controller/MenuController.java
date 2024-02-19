package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Usuario;
import model.UsuarioAutista;
import model.UsuarioDAO;

@WebServlet(urlPatterns = {"/MenuController","/menu"})
@MultipartConfig
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    UsuarioAutista usuarioAutista = new UsuarioAutista();

    public MenuController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/menu")) {
            editarPerfil(request, response);
        }
    }

    protected void editarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idUsuario = (int) session.getAttribute("idUsuario");

        // Obtém a parte do arquivo da solicitação
        Part filePart = request.getPart("fotoPerfil");

        // Diretório onde as imagens de perfil serão armazenadas
        String uploadDir = "images";

        // Gera um nome de arquivo único para evitar substituição de arquivos
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String filePath = uploadDir + File.separator + fileName;

        // Salva o arquivo no diretório especificado
        filePart.write(filePath);

        // Atualiza as informações do perfil no banco de dados
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cuidador = request.getParameter("cuidador");

        // Atualiza as informações do usuário
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNome(nome);

        // Atualiza as informações do usuário autista (se existirem)
         usuarioAutista = (UsuarioAutista) session.getAttribute("usuarioAutista");
        if (usuarioAutista != null) {
            usuarioAutista.setCuidador(cuidador);
        }

        // Atualiza o banco de dados com as informações atualizadas
        usuarioDao.atualizarPerfil(idUsuario, usuario, usuarioAutista, filePath);

        response.sendRedirect("menu.jsp");
    }


}
