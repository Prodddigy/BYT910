import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskTest {
    Task task1;

    @Before
    public void setUp() throws Exception{
        task1 = new Task("Homework","finish the BYT assignment","2");
    }

    @Test
    public void testGetTitle(){
        assertEquals("Homework",task1.getTitle());
    }
}
