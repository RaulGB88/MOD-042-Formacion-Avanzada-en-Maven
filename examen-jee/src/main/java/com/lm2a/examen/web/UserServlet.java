package com.lm2a.examen.web;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm2a.examen.dao.UsuarioDAO;
import com.lm2a.examen.model.Usuario;
import com.lm2a.examen.service.Horoscopo;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

//@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDAO;
	
	public void init() {
		userDAO = new UsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertar":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/again":
				tryAgain(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tryAgain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-future.jsp");
		request.setAttribute("user", existingUser);
		Date date = existingUser.getFechaNacimiento();
		request.setAttribute("signo", Horoscopo.signo(date.getDay(), date.getMonth()));
		
		request.setAttribute("presagio", Horoscopo.getPresagio());
		
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String fecha = request.getParameter("fecha");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		
		
		Usuario newUser = new Usuario(name, email, date);
		userDAO.insertUser(newUser);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-future.jsp");
		request.setAttribute("user", newUser);

		request.setAttribute("signo", Horoscopo.signo(date.getDay(), date.getMonth()));
		
		request.setAttribute("presagio", Horoscopo.getPresagio());
		
		dispatcher.forward(request, response);
	}
	
	/*
	 * private void insertUser(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException, ParseException { String name =
	 * request.getParameter("name"); String email = request.getParameter("email");
	 * String fecha = request.getParameter("fecha"); Date date = new
	 * SimpleDateFormat("yyyy-MM-dd").parse(fecha);
	 * 
	 * 
	 * Usuario newUser = new Usuario(name, email, date);
	 * userDAO.insertUser(newUser); response.sendRedirect("list"); }
	 */

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String fecha = request.getParameter("fecha");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

		Usuario book = new Usuario(id, name, email, date);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
}
