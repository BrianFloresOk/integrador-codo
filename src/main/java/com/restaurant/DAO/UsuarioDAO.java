package com.restaurant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.modelo.Usuario;
import com.restaurant.util.ConexionDB;

public class UsuarioDAO {

    // Métodos CRUD

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String contrasena = resultSet.getString("contrasena");

                Usuario usuario = new Usuario(nombre, email, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerPorId(int id) {
        String query = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String email = resultSet.getString("email");
                    String contrasena = resultSet.getString("contrasena");

                    usuario = new Usuario(nombre, email, contrasena);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    // Método para insertar un nuevo usuario
    public void insertarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (nombre, email, contrasena) VALUES (?, ?, ?)";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getContrasena());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET nombre = ?, email = ?, contrasena = ? WHERE id = ?";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getContrasena());
            preparedStatement.setInt(4, usuario.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario por ID
    public void eliminarUsuario(int id) {
        String query = "DELETE FROM usuario WHERE id = ?";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validarCredenciales(String email, String contrasena) {
        // Establecer la conexión con la base de datos (aquí se asume que tienes un método para obtener la conexión)
        try (Connection connection = ConexionDB.conectar()) {

            // Consulta SQL para validar las credenciales
            String sql = "SELECT * FROM usuario WHERE email = ? AND contrasena = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, contrasena);

                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
