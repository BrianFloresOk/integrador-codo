package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.DAO.UsuarioDAO;

@WebServlet("/login")
public class LoginUsuario extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // En el método GET, simplemente redirige a la vista registro.jsp

        // Redirige a la vista registro.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (Exception e) {
            // Manejar excepciones si ocurren durante el reenvío
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
	}

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UsuarioDAO user = new UsuarioDAO();
		Boolean credenciales = user.validarCredenciales(email, password);

		if(!credenciales) {
			String msgError = "¡Credenciales inválidas!";
			req.setAttribute("msg", msgError);
	        RequestDispatcher dispatcher = req.getRequestDispatcher("/vews/login.jsp");
	        dispatcher.forward(req, res);
		}

		res.sendRedirect(req.getContextPath() + "/mi-perfil");
	}

}
