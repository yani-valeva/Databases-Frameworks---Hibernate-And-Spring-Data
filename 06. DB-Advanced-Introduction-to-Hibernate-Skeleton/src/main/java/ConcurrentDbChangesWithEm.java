import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class ConcurrentDbChangesWithEm {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager firstEntityManager = entityManagerFactory.createEntityManager();
        EntityManager secondEntityManager = entityManagerFactory.createEntityManager();

        firstEntityManager.getTransaction().begin();
        Employee firstEmployee = firstEntityManager.find(Employee.class, 3);
        firstEmployee.setMiddleName("Fernando");

        secondEntityManager.getTransaction().begin();
        Employee secondEmployee = secondEntityManager.find(Employee.class, 3);
        secondEmployee.setLastName(secondEmployee.getLastName().toLowerCase());

        firstEntityManager.lock(firstEmployee, LockModeType.PESSIMISTIC_WRITE);
        secondEntityManager.lock(secondEmployee, LockModeType.PESSIMISTIC_WRITE);

        firstEntityManager.getTransaction().commit();
        secondEntityManager.getTransaction().commit();

        firstEntityManager.close();
        secondEntityManager.close();
        entityManagerFactory.close();
    }
}
