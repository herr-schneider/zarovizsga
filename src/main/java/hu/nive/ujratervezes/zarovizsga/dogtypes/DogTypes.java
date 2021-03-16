package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DogTypes {
    MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){
        List<String> results = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT name, country FROM dog_types WHERE country = ?;")) {
            stmt.setString(1, country.toUpperCase());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("name").toLowerCase());
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("DataBase error!");
        }
        Collections.sort(results);
        return results;
    }
}
