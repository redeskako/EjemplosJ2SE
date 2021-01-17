package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import dbConector.Conector;
import model.Country;
import model.HealthIndicator;

public class HealthIndicatorDao {

    private Connection connection;

    public HealthIndicatorDao() {
        connection = Conector.getConnection();
    }

    public void addHealthIndicator(HealthIndicator healthIndicator) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into health_indicator(indicador_code,indicador_name,source_note,source_organization) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, healthIndicator.getIndicator_code());
            preparedStatement.setString(2, healthIndicator.getIndicator_name());
            preparedStatement.setString(3, healthIndicator.getSource_note());
            preparedStatement.setString(4, healthIndicator.getSource_organization());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHealthIndicator(String code) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from health_indicator where indicador_code=?");
            // Parameters start with 1
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateHealthIndicator(HealthIndicator healthIndicator) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update health_indicator set indicador_name=?, source_note=?, source_organization=?" +
                            "where indicador_code=?");
            // Parameters start with 1
            preparedStatement.setString(1, healthIndicator.getIndicator_name());
            preparedStatement.setString(2, healthIndicator.getSource_note());
            preparedStatement.setString(3, healthIndicator.getSource_organization());
            preparedStatement.setString(4, healthIndicator.getIndicator_code());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HealthIndicator> getAllHealth() {
        List<HealthIndicator> healthIndicators = new ArrayList<HealthIndicator>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from health_indicator");
            while (rs.next()) {
            	HealthIndicator healthIndicator = new HealthIndicator();
            	healthIndicator.setIndicator_code(rs.getString("indicador_code"));
            	healthIndicator.setIndicator_name(rs.getString("indicador_name"));
            	healthIndicator.setSource_note(rs.getString("source_note"));
            	healthIndicator.setSource_organization(rs.getString("source_organization"));
            	healthIndicators.add(healthIndicator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthIndicators;
    }

    public HealthIndicator getHealthIndicatorByCode(String code) {
    	HealthIndicator healthIndicator = new HealthIndicator();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from health_indicator where indicador_code=?");
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	healthIndicator.setIndicator_code(rs.getString("indicador_code"));
            	healthIndicator.setIndicator_name(rs.getString("indicador_name"));
            	healthIndicator.setSource_note(rs.getString("source_note"));
            	healthIndicator.setSource_organization(rs.getString("source_organization"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthIndicator;
    }
    
  //Paginaci�n de la tabla data
    /*
     * @param pag: pagina
     * @param numeroFilas: numero de filas por p�gina.
     */
    public List<HealthIndicator> getHealthPagination(int pag, int numeroFilas) {
    	List<HealthIndicator> healthIndicators = new ArrayList<HealthIndicator>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM health_indicator LIMIT "+numeroFilas+" OFFSET "+pag*numeroFilas+";");
            while (rs.next()) {
            	HealthIndicator healthIndicator = new HealthIndicator();
            	healthIndicator.setIndicator_code(rs.getString("indicador_code"));
            	healthIndicator.setIndicator_name(rs.getString("indicador_name"));
            	healthIndicator.setSource_note(rs.getString("source_note"));
            	healthIndicator.setSource_organization(rs.getString("source_organization"));
            	healthIndicators.add(healthIndicator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthIndicators;
    }

}