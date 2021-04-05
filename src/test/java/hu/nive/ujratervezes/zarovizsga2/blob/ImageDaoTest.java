package hu.nive.ujratervezes.zarovizsga2.blob;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ImageDaoTest {

    @BeforeEach
    void init() throws SQLException {

        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3308/tasteexp?useUnicode=true");
        source.setUser("foni");
        source.setPassword("haverok");

        Flyway flyway = Flyway.configure()
                .locations("/db/migration")
                .dataSource(source)
                .load();


        flyway.clean();
        flyway.migrate();}

        @Test
        public void testRead() {
            ImageDao id = new ImageDao();
            id.saveImageFromFile("src/main/java/hu/nive/ujratervezes/zarovizsga2/blob/TasteExpertKftQR.png","Taste");
            id.loadImageToFile("Taste","src/main/java/hu/nive/ujratervezes/zarovizsga2/blob/TasteExpertKftQR2.png");
        }
    }