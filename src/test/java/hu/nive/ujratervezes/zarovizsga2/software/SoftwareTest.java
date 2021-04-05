package hu.nive.ujratervezes.zarovizsga2.software;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareTest {

        DeveloperSoftware dev = new DeveloperSoftware("IDEA", 1000);
        OfficeSoftware office = new OfficeSoftware("MS Office", 1200);

    @Test
    void increasePrice() {
        assertEquals(1000, dev.getPrice());
        dev.increasePrice();
        assertEquals(1000*1.10, dev.getPrice());

        assertEquals(1200, office.getPrice());
        office.increasePrice();
        assertEquals(1200*1.05, office.getPrice());
    }
}