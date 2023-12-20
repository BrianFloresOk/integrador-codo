package com.restaurant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.modelo.Plato;
import com.restaurant.util.ConexionDB;

public class PlatoDAO {

    // Método para obtener todos los platos
    public List<Plato> obtenerTodos() {
        List<Plato> platos = new ArrayList<>();
        String query = "SELECT * FROM plato ORDER BY id desc";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                int precio = resultSet.getInt("precio");

                Plato plato = new Plato(id, nombre, descripcion, precio);
                platos.add(plato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return platos;
    }

    // Método para obtener un plato por ID
    public Plato obtenerPorId(int id) {
        String query = "SELECT * FROM plato WHERE id = ?";
        Plato plato = null;

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String descripcion = resultSet.getString("descripcion");
                    int precio = resultSet.getInt("precio");

                    plato = new Plato(id, nombre, descripcion, precio);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plato;
    }

    // Método para insertar un nuevo plato
    public void insertarPlato(Plato plato) {
        String query = "INSERT INTO plato (nombre, descripcion, precio) VALUES (?, ?, ?)";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, plato.getNombre());
            preparedStatement.setString(2, plato.getDescripcion());
            preparedStatement.setInt(3, plato.getPrecio());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un plato
    public void actualizarPlato(Plato plato) {
        String query = "UPDATE plato SET nombre = ?, descripcion = ?, precio = ? WHERE id = ?";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, plato.getNombre());
            preparedStatement.setString(2, plato.getDescripcion());
            preparedStatement.setInt(3, plato.getPrecio());
            preparedStatement.setInt(4, plato.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un plato por ID
    public void eliminarPlato(int id) {
        String query = "DELETE FROM plato WHERE id = ?";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}