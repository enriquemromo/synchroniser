package mx.rfpro;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.SimpleTrigger;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;
import java.util.Properties;

import mx.rfpro.SynchroniserJob;

/**
 * Main Class
 *
 */
public class App {

    private static Properties properties;

    static{
        properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        String cronExpression = properties.getProperty("cron.expression","* * * * * ? *");
       
        try {

            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler(); 
           
            JobDetail job = newJob(SynchroniserJob.class).withIdentity("job1", "group1").build();

            Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
            .build();

            sched.scheduleJob(job, trigger);
            sched.start();
    
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

    
}
