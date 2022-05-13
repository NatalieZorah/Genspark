import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CavesTest {
    Caves cave;
    @BeforeEach
    void setUp() {
        cave = new Caves();
    }

    @Test
    void isNumber() {
        assertTrue(cave.isNumber(String.valueOf(54)),"Method [isNumber] works.");
    }


    @AfterEach
    void tearDown() {
    }
}