import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FindLatestTenProjects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query projectsQuery = entityManager.createQuery("SELECT p FROM Project AS p " +
                "ORDER BY p.startDate DESC").setMaxResults(10);
        List<Project> projects = projectsQuery.getResultList();

        projects.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(p -> System.out.println(String.format("Name: %s, Description: %s, Start date: %s, End date: %s",
                        p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate())));

        entityManager.close();
        entityManagerFactory.close();
    }
}
