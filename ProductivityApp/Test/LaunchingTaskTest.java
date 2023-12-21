import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LaunchingTaskTest {

    LaunchingTask launchedTask;
    LocalDateTime localDateTime;
    @Before
    public void setUp()
    {
         launchedTask = new LaunchingTask("10h");
         localDateTime = LocalDateTime.now();
    }


    @Test
    public void setTime()
    {

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
