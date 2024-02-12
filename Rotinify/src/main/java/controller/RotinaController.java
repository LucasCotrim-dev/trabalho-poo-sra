package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefa;
import model.TarefaDAO;

@WebServlet(urlPatterns = {"/RotinaController", "/main", "/insert", "/select"})
public class RotinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDAO tarefaDao = new TarefaDAO();
	Tarefa tarefa = new Tarefa();
       
    public RotinaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			tarefas(request,response);
		}else if(action.equals("/insert")) {
			adicionarTarefa(request,response);	
		}else if (action.equals("/select")) { 
	        listarTarefa(request, response);   
	    }
	}
	
	
	
	
	protected void tarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ArrayList<Tarefa> listaTarefas = tarefaDao.listarTarefas();
	    request.setAttribute("tarefas", listaTarefas);
	    RequestDispatcher rd = request.getRequestDispatcher("rotina.jsp");
	    rd.forward(request, response);
	}
	
	protected void adicionarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
	    tarefa.setNome(request.getParameter("nome"));
	    tarefa.setDescricao(request.getParameter("descricao"));
	    tarefa.setHorario(request.getParameter("horario"));
	    tarefa.setCategoria(request.getParameter("categoria"));
	    
	    tarefaDao.adicionarTarefa(tarefa);  
	    
	    response.sendRedirect(request.getContextPath() + "/main");
	}
	
	protected void listarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String id = request.getParameter("id");
		System.out.println(id);
	}
	
}
