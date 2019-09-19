/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.rfpro.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.rfpro.controller.EmployeeJpaController;
import mx.rfpro.model.Employee;

/**
 *
 * @author rfprodeveloper
 */
public class EmployeeRepository {
    private static final String PERSISTENCE_UNIT_NAME = "mx.rfpro.synchroniser";
    private static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    private EmployeeJpaController ec = new EmployeeJpaController(factory);
    
    
    public List<Employee> getAll(){
        return ec.findEmployeeEntities();
    }
    
    
}
