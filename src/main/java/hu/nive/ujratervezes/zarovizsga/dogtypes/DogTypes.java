package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class DogTypes {
    private final MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogs = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT lower(NAME) as name, country FROM dog_types WHERE country = ? order by name;")) {
            stmt.setString(1, country.toUpperCase());
            fillList(dogs, stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
//        List<String> result = new ArrayList<>(dogs);
//        Collections.sort(result);
//        return result;
        return dogs;
    }

    private void fillList(List<String> results, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(rs.getString("name").toLowerCase());
            }
        }
    }
}
