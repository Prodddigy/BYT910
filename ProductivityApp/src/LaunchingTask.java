import java.time.Duration;
import java.time.LocalDateTime;

public class LaunchingTask {

    private User user;
    private User.Task task;

    private final LocalDateTime StartDateTime;
   private LocalDateTime EndDateTime =null;

   private Duration duration=null;



    private String time;
   LaunchingTask(String time)
   {
       this.time = time;
       this.StartDateTime = LocalDateTime.now();
   }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User.Task getTask() {
        return task;
    }

    public void setTask(User.Task task) {
        this.task = task;
    }

    public LocalDateTime getStartDateTime() {
        return StartDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return EndDateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public static void save_Statistics()
    {
        System.out.println("*saving...*");
    }
    public void finishTimer()
    {
        this.EndDateTime = LocalDateTime.now();
    }
    public void calculateTaskDuration()
    {
        if(EndDateTime!=null)
        {
            this.duration = Duration.between(StartDateTime, EndDateTime);
        }
    }
    public void overTimeStop()
    {
     //stops when time is passed for the certain task
    }


}
