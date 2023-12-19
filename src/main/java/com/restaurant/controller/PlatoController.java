package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plato/*")
public class PlatoController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);
        if ("/agregar".equals(pathInfo)) {
            // Lógica para manejar la ruta /plato/agregar
            mostrarFormularioAgregar(request, response);
        } else if (pathInfo.startsWith("/editar")) {
            // Lógica para manejar la ruta /plato/editar?id=n
            editarPlato(request, response);
        }
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/addPlato.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Manejar excepciones si ocurren durante el reenvío
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
    }

    private void editarPlato(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/editPlato.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Manejar excepciones si ocurren durante el reenvío
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
    }

}
