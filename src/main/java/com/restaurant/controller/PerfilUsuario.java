package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.DAO.PlatoDAO;
import com.restaurant.modelo.Plato;

@WebServlet("/mi-perfil")
public class PerfilUsuario extends HttpServlet{

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // En el método GET, simplemente redirige a la vista registro.jsp

        // Redirige a la vista registro.jsp
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/profile.jsp");
        try {

        	PlatoDAO platoDAO = new PlatoDAO();
        	List<Plato> listaPlatos = platoDAO.obtenerTodos();

        	req.setAttribute("menu", listaPlatos);

            dispatcher.forward(req, res);

        } catch (Exception e) {
            // Manejar excepciones si ocurren durante el reenvío
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
    }


}
