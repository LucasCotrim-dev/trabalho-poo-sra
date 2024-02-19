package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.UsuarioDAO;

@WebServlet(urlPatterns = {"/MenuController","/menu"})
@MultipartConfig
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UsuarioDAO usuarioDao = new UsuarioDAO();

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
        response.sendRedirect("menu.jsp");
    }


}
