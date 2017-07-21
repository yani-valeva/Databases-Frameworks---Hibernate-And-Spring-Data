import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesFromSeattle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query selectQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "INNER JOIN e.department AS d WHERE d.name = 'Research and Development'");
        List<Employee> employees = selectQuery.getResultList();
        employees.stream().sorted((e1, e2) -> {
            int result = e1.getSalary().compareTo(e2.getSalary());
            if (result == 0) {
                result = e2.getFirstName().compareTo(e1.getFirstName());
            }

            return result;
        }).forEach(e -> System.out.println(String.format("%s %s from %s - $%.2f",
                e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary())));

        entityManager.close();
        entityManagerFactory.close();
    }
}
