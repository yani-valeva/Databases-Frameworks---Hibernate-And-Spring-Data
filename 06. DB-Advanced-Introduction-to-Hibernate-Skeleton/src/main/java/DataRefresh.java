import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = entityManager.find(Employee.class, 4);
        employee.setFirstName(employee.getFirstName().toUpperCase());
        entityManager.refresh(employee);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        System.out.println(employee.getFirstName());
        entityManager.close();
        entityManagerFactory.close();
    }
}
