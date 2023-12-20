package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.DAO.PlatoDAO;
import com.restaurant.modelo.Plato;

@WebServlet("/plato/*")
public class PlatoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/agregar".equals(pathInfo)) {
            // Lógica para manejar la ruta /plato/agregar
            mostrarFormularioAgregar(request, response);
        } else if (pathInfo.startsWith("/editar")) {
            // Lógica para manejar la ruta /plato/editar?id=n
            editarPlato(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/agregar".equals(pathInfo)) {
            // Lógica para manejar la ruta /plato/agregar
            agregarPlato(request, response);
        } else if (pathInfo.startsWith("/editar")) {
            // Lógica para manejar la ruta /plato/editar
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 2) {
                String idParam = pathParts[2];
                // Lógica para manejar la edición con el parámetro id
                int id = Integer.parseInt(idParam);
                actualizarDatosPlato(request, response, id);
            } else {
                // Manejo de error si no se proporciona un parámetro id en la URL
                System.out.println("Error: No se proporcionó un ID válido para editar.");
                // Aquí podrías redirigir o mostrar un mensaje de error adecuado.
            }
        }  else if (pathInfo.startsWith("/eliminar")) {
            // Lógica para manejar la ruta /plato/editar
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 2) {
                String idParam = pathParts[2];
                // Lógica para manejar la edición con el parámetro id
                int id = Integer.parseInt(idParam);
                eliminarDatosPlato(request, response, id);
            } else {
                // Manejo de error si no se proporciona un parámetro id en la URL
                System.out.println("Error: No se proporcionó un ID válido para editar.");
                // Aquí podrías redirigir o mostrar un mensaje de error adecuado.
            }
        }
    }

    

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para mostrar el formulario de agregar plato
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/addPlato.jsp");
        dispatcher.forward(request, response);
    }

    private void editarPlato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para editar el plato
    	String id = request.getParameter("id");
    	int idInt = Integer.parseInt(id);
    	        
        PlatoDAO platoDAO = new PlatoDAO();
        Plato plato = platoDAO.obtenerPorId(idInt);
        
        request.setAttribute("plato", plato);
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/editPlato.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void actualizarDatosPlato(HttpServletRequest request, HttpServletResponse response, int id2) throws IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        int precioInt = Integer.parseInt(precio);

        PlatoDAO platoDAO = new PlatoDAO();
        Plato plato = platoDAO.obtenerPorId(id2);

        // Actualizar los valores del plato con los nuevos valores del formulario
        plato.setNombre(nombre);
        plato.setDescripcion(descripcion);
        plato.setPrecio(precioInt);

        // Llamar al método de actualización en el DAO
        platoDAO.actualizarPlato(plato);

        response.sendRedirect(request.getContextPath() + "/mi-perfil");
    }
    
    private void eliminarDatosPlato(HttpServletRequest request, HttpServletResponse response, int id2) throws IOException {
    	
        PlatoDAO platoDAO = new PlatoDAO();
        
        try {
            Plato plato = platoDAO.obtenerPorId(id2);
            
            if (plato != null) {  // Verifica si el plato existe
                platoDAO.eliminarPlato(id2);

                response.sendRedirect(request.getContextPath() + "/mi-perfil");
            } else {
                // El plato no existe, puedes redirigir a una página de error o mostrar un mensaje al usuario
                response.sendRedirect(request.getContextPath() + "/mi-perfil");
            }
        } catch (Exception e) {
            // Manejo de errores, redirige a una página de error o muestra un mensaje al usuario
            e.printStackTrace();  // o utiliza un logger para registrar el error
            System.out.println("Error al eliminar");
        }
        
    }

    
    
    private void agregarPlato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        int precioInt = Integer.parseInt(precio);
        
        Plato nuevoPlato = new Plato(nombre, descripcion, precioInt);
        
        PlatoDAO platoDAO = new PlatoDAO();
        platoDAO.insertarPlato(nuevoPlato);
        
        response.sendRedirect(request.getContextPath() + "/mi-perfil");
        
    }
}
