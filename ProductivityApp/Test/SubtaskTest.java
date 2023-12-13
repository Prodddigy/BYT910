import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubtaskTest {
    User user1;
    User.Task task1;
    User.Task.Subtask subtask1, subtask2;

    /**
     * Setting up the components to be used in the Tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        user1=new User("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        task1 = user1. new Task("Homework","finish the BYT assignment","2h");
        subtask1=task1.new Subtask("task 9-10", "finish making the junit tests");
        subtask2=task1.new Subtask("japanese assignment", "start doing the japanese homework");
    }

    /**
     * Testing if getter function returns the correct title of the Subtask
     */
    @Test
    public void testGetTitle(){
        assertEquals("task 9-10",subtask1.getTitle());
        assertEquals("japanese assignment",subtask2.getTitle());
    }

    /**
     * Testing if getter function returns the correct description of the Subtask
     */
    @Test
    public void testGetDescription(){
        assertEquals("finish making the junit tests",subtask1.getDescription());
        assertEquals("start doing the japanese homework",subtask2.getDescription());
    }

    /**
     * Testing if setter function sets the correct title of the Subtask
     */
    @Test
    public void testSetTitle(){
        assertEquals("task 9-10",subtask1.getTitle());
        subtask1.setTitle("task 11");
        assertEquals("task 11",subtask1.getTitle());
    }

    /**
     * Testing if setter function sets the correct description of the Subtask
     */
    @Test
    public void testSetDescription(){
        assertEquals("finish making the junit tests",subtask1.getDescription());
        subtask1.setDescription("finish making the classes");
        assertEquals("finish making the classes",subtask1.getDescription());
    }

    /**
     * Testing if the method correctly creates a new Subtask
     */
    @Test
    public void testCreateSubtask(){
        assertTrue(task1.subtaskExists("task 9-10"));
        assertTrue(task1.subtaskExists("japanese assignment"));
        assertFalse(task1.subtaskExists("sleep"));

        User.Task.Subtask subtask3=task1.new Subtask("presentation","prepare for the important presentation");
        assertTrue(task1.subtaskExists("presentation"));


    }

}
