package quru.qa;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @BeforeEach
    void setUp() {


    }

    @DisplayName("Проверка, что 3 > 2")
    @Tag("Blocker")
    @Test
    void firstTest(){
        assertTrue(3>2);
    }
}
