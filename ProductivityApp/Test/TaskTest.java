import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Hashtable;

public class TaskTest {
    User user1, user2;
    User.Task task1, task2, task3;

    LaunchingTask launchedTask;

    /**
     * Setting up the components to be used in the Tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        user1=new User("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        user2=new User("tester","Luke","Skywalker","jediforce@gmail.com","yoda123");
        task1 = user1. new Task("Homework","finish the BYT assignment","2h");
        task2 = user1. new Task("Japanese study","Learn 10 new words","1.5h");
        task3 = user2. new Task("Start BYT project","start preparing for the project","3h");

        launchedTask = new LaunchingTask("10h");
    }

    /**
     * Testing if getter function returns the correct title of the Task
     */
    @Test
    public void testGetTitle(){
        assertEquals("Homework",task1.getTitle());
        assertEquals("Japanese study",task2.getTitle());
        assertEquals("Start BYT project",task3.getTitle());
    }

    /**
     * Testing if getter function returns the correct description of the Task
     */
    @Test
    public void testGetDescription(){
        assertEquals("finish the BYT assignment",task1.getDescription());
        assertEquals("Learn 10 new words",task2.getDescription());
        assertEquals("start preparing for the project",task3.getDescription());
    }

    /**
     * Testing if getter function returns the correct time of the Task
     */
    @Test
    public void testGetTime(){
        assertEquals("2h",task1.getTime());
        assertEquals("1.5h",task2.getTime());
        assertEquals("3h",task3.getTime());
    }

    /**
     * Testing if setter function sets the correct title of the Task
     */
    @Test
    public void testSetTitle(){
        assertEquals("Homework",task1.getTitle());
        task1.setTitle("Schoolwork");
        assertEquals("Schoolwork",task1.getTitle());
    }

    /**
     * Testing if setter function sets the correct description of the Task
     */
    @Test
    public void testSetDescription(){
        assertEquals("finish the BYT assignment",task1.getDescription());
        task1.setDescription("finish the BYT tasks");
        assertEquals("finish the BYT tasks",task1.getDescription());
    }

    /**
     * Testing if setter function sets the correct time of the Task
     */
    @Test
    public void testSetTime(){
        assertEquals("2h",task1.getTime());
        task1.setTime("4h");
        assertEquals("4h",task1.getTime());
    }

    /**
     * Testing if method sets and gets the Launching task properly
     */
    @Test
    public void testSetGetLaunchingTask(){
        task1.setLaunchingTask(launchedTask);
        assertEquals(launchedTask,task1.getLaunchingTask());
    }

    /**
     * Testing if the method shows the list of tasks correctly
     */
    @Test
    public void testShowListOfTasks(){
        Hashtable<String, User.Task> user1list=task1.Show_list_of_Tasks();
        assertTrue(user1list.containsKey("Homework"));
        assertTrue(user1list.containsKey("Japanese study"));
        assertFalse(user1list.containsKey("Start BYT project"));
    }

    /**
     * Testing if the method correctly creates a new Task
     */
    @Test
    public void testCreateTask(){
        assertTrue(user1.taskExists("Homework"));
        assertTrue(user1.taskExists("Japanese study"));
        assertTrue(user2.taskExists("Start BYT project"));
        assertFalse(user2.taskExists("free time"));

        User.Task task4 = user2. new Task("physical exercises","do some push ups and sit ups","0.5h");
        assertTrue(user2.taskExists("physical exercises"));
    }

    /**
     * Testing if the method starts the task correctly
     */
    @Test
    public void testStartTask(){
        assertEquals("Task has started! Remaining time: 2h",task1.start_a_Task());
    }

}
