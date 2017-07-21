import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine();

        Query employeeQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.firstName LIKE :pattern");
        employeeQuery.setParameter("pattern", pattern + "%");
        List<Employee> employees = employeeQuery.getResultList();

        employees.stream()
                .forEach(e -> System.out.println(String.format("%s %s - %s - ($%.2f)",
                        e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary())));

        entityManager.close();
        entityManagerFactory.close();
    }
}
