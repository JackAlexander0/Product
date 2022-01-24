import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product y = new Product("000001", "Tape", "Sticky_Tape", 5.00);
    @BeforeEach
    void setUp() {
        Product y = new Product("000001", "Tape", "Sticky_Tape", 5.00);
    }

    @Test
    void setName() {
        y.setName("Phone");
        assertEquals("Phone", y.getName());
    }

    @Test
    void setDescription() {
        y.setDescription("Call_People");
        assertEquals("Call_People", y.getDescription());
    }

    @Test
    void setCost() {
        y.setCost(10.00);
        assertEquals(10.00, y.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Tape, Sticky_Tape, 5.0", y.toCSVDataRecord());
    }
}