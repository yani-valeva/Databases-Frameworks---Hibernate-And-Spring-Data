import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> departments = new ArrayList<>(Arrays.asList("Engineering", "Tool Design", "Marketing", "Information Services"));
        Query employeeQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.department.name IN (:names)");
        employeeQuery.setParameter("names", departments);
        List<Employee> employees = employeeQuery.getResultList();

        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.12)));
            entityManager.persist(employee);
        }

        entityManager.getTransaction().commit();

        employees.stream()
                .forEach(e -> System.out.println(String.format("%s %s ($%.2f)",
                        e.getFirstName(), e.getLastName(), e.getSalary())));

        entityManager.close();
        entityManagerFactory.close();
    }
}
