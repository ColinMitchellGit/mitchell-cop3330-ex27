package ex27;

import org.junit.jupiter.api.Test;

import static ex27.App.validateName;
import static ex27.App.validateEmployeeID;
import static ex27.App.validateZIPCode;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    @Test
    void testvalidateName() {
        assertEquals(0, validateName("John"));
    }
    @Test
    void testvalidateEmployeeID() {
        assertEquals(0, validateEmployeeID("AA-1234"));
    }
    @Test
    void testvalidateZIP() {
        assertEquals(0, validateZIPCode("55555"));
    }
}
