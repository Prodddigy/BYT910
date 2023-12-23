import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LaunchingTaskTest {

    LaunchingTask launchedTask;
    LocalDateTime localDateTime;
    User user1;
    User.Task task1;

    @Before
    public void setUp()
    {
         launchedTask = new LaunchingTask("10h");
         localDateTime = LocalDateTime.now();

        user1=new User("Admin","Albert","Einstein","albertein@gmail.com","Emc2");
        task1 = user1. new Task("Homework","finish the BYT assignment","2h");

    }


    @Test
    public void setTime()
    {
        launchedTask.setTime("11h");
        assertEquals("11h",launchedTask.getTime());
    }

    @Test
    public void getTime()
    {
        assertEquals("10h",launchedTask.getTime());
    }

    @Test
    public void getSetUser()
    {
        launchedTask.setUser(user1);
        assertEquals(user1,launchedTask.getUser());
    }

    @Test
    public void getSetTask()
    {
        launchedTask.setTask(task1);
        assertEquals(task1,launchedTask.getTask());
    }

    @Test
    public void getStartDateTime()
    {
        /*
        here we are testing if start time is equal to the minute it was created
         */
       assertEquals(localDateTime.getMinute() ,launchedTask.getStartDateTime().getMinute());
    }

    @Test
    public void getEndDateTime()
    {
        /*
        here we first check the unfinished but lanched task
        next we check the finishing time if the minutes are correct
         */
        assertNull(launchedTask.getEndDateTime());
        launchedTask.finishTimer();
        LocalDateTime endtime = LocalDateTime.now();
        assertEquals(endtime.getMinute(),launchedTask.getEndDateTime().getMinute());


    }

    @Test
    public void getDuration()
    {
        /*
        the following test checks if the duration between start time and end time
        of launched task is not null
        next
        if the time is within the range the test is successful
        However note that some CPU's can perform better or worse
         */
        launchedTask.finishTimer();
        launchedTask.calculateTaskDuration();
        assertNotNull(launchedTask.getDuration());
       long dur =  launchedTask.getDuration().get(ChronoUnit.NANOS);
        System.out.println("Duration: "+dur );
        assertTrue("mynum is out of range: " + dur, 1000000 <= dur && dur <= 4000000);

    }



}
