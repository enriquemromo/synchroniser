package mx.rfpro;

import java.util.Date;
import java.util.List;
import mx.rfpro.model.Employee;
import mx.rfpro.repository.EmployeeRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SynchroniserJob implements Job {
    
    private EmployeeRepository er = new EmployeeRepository();

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Job execute"+ new Date());
        
        List<Employee> all = er.getAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }

    }


}