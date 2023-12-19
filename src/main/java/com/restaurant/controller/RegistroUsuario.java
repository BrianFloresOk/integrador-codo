package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.DAO.UsuarioDAO;
import com.restaurant.modelo.Usuario;

@WebServlet("/registro")
public class RegistroUsuario extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // En el método GET, simplemente redirige a la vista registro.jsp

        // Redirige a la vista registro.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Manejar excepciones si ocurren durante el reenvío
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener datos del cuerpo de la solicitud
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("password");

        // Crear un objeto Usuario con los datos recibidos
        Usuario nuevoUsuario = new Usuario(nombre, email, contrasena);

        // Guardar el nuevo usuario en la base de datos utilizando un DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insertarUsuario(nuevoUsuario);

        // Redirige después de procesar el formulario POST (como lo estabas haciendo antes)
        response.sendRedirect(request.getContextPath() + "/login");
    }
}