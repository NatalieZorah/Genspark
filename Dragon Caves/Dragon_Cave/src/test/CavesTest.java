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
        assertTrue(Caves.isNumber(String.valueOf(54)),"Method [isNumber] works.");
    }

    @Test
    void sysInput() {
        assertEquals(1,Caves.sysInput(),"Method [sysInput] works.");
    }

    @AfterEach
    void tearDown() {
    }
}