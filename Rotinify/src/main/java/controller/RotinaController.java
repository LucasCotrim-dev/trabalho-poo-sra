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
import model.CalendarioDAO;

@WebServlet(urlPatterns = {"/RotinaController","/manage", "/main", "/insert", "/select", "/update", "/delete"})
public class RotinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDAO tarefaDao = new TarefaDAO();
	Tarefa tarefa = new Tarefa();
	CalendarioDAO calendarioDao = new CalendarioDAO();
       
    public RotinaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/manage")) {
	        tarefas(request,response);
		}else if(action.equals("/main")) {
			tarefasCalendario(request,response);
		}else if(action.equals("/insert")) {
			adicionarTarefa(request,response);	
		}else if (action.equals("/select")) { 
	        listarTarefa(request, response);   
	    }else if (action.equals("/update")) { 
	        editarTarefa(request, response);   
	    }else if (action.equals("/delete")) { 
	        removerTarefa(request, response);   
	    }
	}
	
	
	
	protected void tarefasCalendario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int idUsuario = (int) request.getSession().getAttribute("idUsuario"); // Obtém o ID do usuário da sessão
	    ArrayList<Tarefa> listaTarefas = tarefaDao.listarTarefas(idUsuario); // Lista as tarefas específicas do usuário
	    request.setAttribute("tarefas", listaTarefas);
	    RequestDispatcher rd = request.getRequestDispatcher("calendarioSemanal.jsp");
	    rd.forward(request, response);
	}

	protected void tarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int idUsuario = (int) request.getSession().getAttribute("idUsuario"); // Obtém o ID do usuário da sessão
	    String diaSelecionado = request.getParameter("dia_semana");
	    if (diaSelecionado != null) { 
	        ArrayList<Tarefa> listaTarefas = calendarioDao.listarTarefasDiaSemana(diaSelecionado, idUsuario); // Usando o método modificado do CalendarioDAO
	        request.setAttribute("tarefas", listaTarefas);
	    }
	    request.setAttribute("diaSelecionado", diaSelecionado != null ? diaSelecionado : ""); // Passa o dia selecionado para o JSP
	    RequestDispatcher rd = request.getRequestDispatcher("rotina.jsp");
	    rd.forward(request, response);
	}



	
	protected void adicionarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int idUsuario = (int) request.getSession().getAttribute("idUsuario");
		System.out.println("ID do usuário obtido da sessão: " + idUsuario);
	    tarefa.setNome(request.getParameter("nome"));
	    tarefa.setDescricao(request.getParameter("descricao"));
	    tarefa.setHorario(request.getParameter("horario"));
	    tarefa.setDia_semana(request.getParameter("dia_semana"));
	    
	    tarefaDao.adicionarTarefa(tarefa,idUsuario);  
	    
	    response.sendRedirect("manage?dia_semana=" + java.net.URLEncoder.encode(tarefa.getDia_semana(), "UTF-8"));

	}
	
	protected void listarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                
	    int id = Integer.parseInt(request.getParameter("id"));
	    tarefa.setId(id);
	    tarefaDao.selecionarTarefa(tarefa);
	    request.setAttribute("nome", tarefa.getNome());
	    request.setAttribute("descricao", tarefa.getDescricao());
	    request.setAttribute("horario", tarefa.getHorario());
	    request.setAttribute("dia_semana", tarefa.getDia_semana());
	    RequestDispatcher rd = request.getRequestDispatcher("editarTarefa.jsp");
	    rd.forward(request, response);
	}
	
	protected void editarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tarefa.setNome(request.getParameter("nome"));
	    tarefa.setDescricao(request.getParameter("descricao"));
	    tarefa.setHorario(request.getParameter("horario"));
	    tarefa.setDia_semana(request.getParameter("dia_semana"));
	    
	    
	    
	    tarefaDao.alterarTarefa(tarefa);
	    
	    calendarioDao.atualizarTarefa(tarefa);
	    
	    response.sendRedirect("manage?dia_semana=" + java.net.URLEncoder.encode(tarefa.getDia_semana(), "UTF-8"));

	}
	
	protected void removerTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tarefa.setId(id);
		
		
		tarefaDao.deletarTarefa(tarefa);
		calendarioDao.removerTarefa(tarefa);
		
		String diaSemana = java.net.URLEncoder.encode(request.getParameter("dia_semana"), "UTF-8");
		response.sendRedirect("manage?dia_semana=" + diaSemana);

	}
}
