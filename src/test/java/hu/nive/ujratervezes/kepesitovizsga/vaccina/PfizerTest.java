package hu.nive.ujratervezes.kepesitovizsga.vaccina;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PfizerTest {
    MariaDbDataSource dataSource;

    @BeforeEach
    void init() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3308/tasteexp?useUnicode=true");
        dataSource.setUser("foni");
        dataSource.setPassword("haverok");
    }

//        Flyway flyway = Flyway.configure()
//                .locations("/db/migration")
//                .dataSource(dataSource)
//                .load();
//
//        flyway.clean();
//        flyway.migrate();

    @Test
    public void testPfeizer() {
        Pfizer pf = new Pfizer(dataSource);
        assertEquals(50, pf.getVaccinationList().size());
        System.out.println(pf.getVaccinationList());
    }

    @Test
    public void testSinopharma() {
        SinoPharm si = new SinoPharm(dataSource);
        assertEquals(12, si.getVaccinationList().size());
        System.out.println(si.getVaccinationList());
    }

    @Test
    public void testAstra() {
        AstraZeneca az = new AstraZeneca(dataSource);
        assertEquals(21, az.getVaccinationList().size());
        System.out.println(az.getVaccinationList());
    }
}