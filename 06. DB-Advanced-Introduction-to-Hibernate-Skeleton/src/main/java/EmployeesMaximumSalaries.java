import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query departmentQuery = entityManager.createQuery("SELECT d.name, MAX(e.salary) FROM Department AS d " +
                "INNER JOIN Employee AS e " +
                "ON e.department.id = d.id " +
                "GROUP BY d.name HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000");
        List<Object[]> departments = departmentQuery.getResultList();

        departments.stream()
                .forEach(d -> System.out.println(String.format("%s - %.2f",
                        d[0], d[1])));

        entityManager.close();
        entityManagerFactory.close();
    }
}
