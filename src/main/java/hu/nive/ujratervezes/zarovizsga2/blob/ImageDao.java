package hu.nive.ujratervezes.zarovizsga2.blob;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class ImageDao {
    private final MariaDbDataSource dataSource = initDB();

    private MariaDbDataSource initDB() {
        try {
            MariaDbDataSource source = new MariaDbDataSource();
            source.setUrl("jdbc:mariadb://localhost:3308/tasteexp?useUnicode=true");
            source.setUser("foni");
            source.setPassword("haverok");
            return source;
        } catch (SQLException sql) {
            throw new IllegalArgumentException("");
        }
    }


    public void saveImage(String filename, InputStream is) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO taste (filename, content) values ?, ?;")) {
            stmt.setString(1, filename);

            Blob blob = conn.createBlob();

            try (OutputStream os = blob.setBinaryStream(1)) {
                is.transferTo(os);
            } catch (IOException ioe) {
                throw new IllegalStateException("File error! " + ioe);
            }
            stmt.setBlob(2, blob);
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
    }

    public InputStream loadImage(String filename) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT content FROM taste WHERE filename = ?;")) {
            stmt.setString(1, filename);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Blob blob = rs.getBlob("content");
                    return blob.getBinaryStream();
                }
                throw new IllegalStateException("Not found!");
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
    }

    public void saveFile(String filename, InputStream is) {
        Path file = Path.of(filename);
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            is.transferTo(os);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!");
        }
    }

    public InputStream loadFile(String filename) {
        Path file = Path.of(filename);
        try (InputStream is = Files.newInputStream(file)) {
            return is;
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!");
        }
    }

    public void saveImageFromFile(String source, String destination) {
        Path file = Path.of(source);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO taste (filename, content) values (?, ?);")) {
            stmt.setString(1, destination);

            Blob blob = conn.createBlob();

            try (OutputStream os = blob.setBinaryStream(1);
                 InputStream is = Files.newInputStream(file)) {
                is.transferTo(os);
            } catch (IOException ioe) {
                throw new IllegalStateException("File error! " + ioe);
            }
            stmt.setBlob(2, blob);
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        }
    }

    public void loadImageToFile(String source, String destination) {
        Path file = Path.of(destination);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT content FROM taste WHERE filename = ?;")) {
            stmt.setString(1, source);
            try (ResultSet rs = stmt.executeQuery();
                 OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
                if (rs.next()) {
                    Blob blob = rs.getBlob("content");
                    blob.getBinaryStream().transferTo(os);
                } else {
                    throw new IllegalStateException("Not found! 2");
                }

            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DataBase error! " + sqlException);
        } catch (IOException ioe) {
            throw new IllegalStateException("File error! " + ioe);
        }
    }

}