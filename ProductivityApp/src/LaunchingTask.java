import java.time.Duration;
import java.time.LocalDateTime;

public class LaunchingTask {
    private final LocalDateTime StartDateTime;
   private LocalDateTime EndDateTime =null;

   private Duration duration;

   LaunchingTask()
   {
       this.StartDateTime = LocalDateTime.now();
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
        this.duration = Duration.between(StartDateTime,EndDateTime);
    }


}
