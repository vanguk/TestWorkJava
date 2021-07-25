package task02;


import org.jetbrains.annotations.NotNull;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.util.ServiceLoader;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {


    @Test
    @TestMethodInfo(priority = Priority.Minor, author = "Test Bob", lastModified = "13.08.2019")
    public void annotation() {
        assertEquals(1, 1);
    }

}
