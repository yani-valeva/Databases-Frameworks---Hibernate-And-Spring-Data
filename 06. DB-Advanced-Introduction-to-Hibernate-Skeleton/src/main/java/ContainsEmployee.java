import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String employeeName = reader.readLine();
        Query selectQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE CONCAT(e.firstName, ' ', e.lastName) = :name", Employee.class);
        selectQuery.setParameter("name", employeeName);
        List<Employee> employees = selectQuery.getResultList();

        if (employees.size() > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
