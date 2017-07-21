import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseSearchQueries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //First task
        Query addressQuery = entityManager.createQuery("SELECT DISTINCT a FROM Address AS a " +
                "ORDER BY a.employees.size DESC, a.town.name ASC").setMaxResults(10);
        List<Address> addresses = addressQuery.getResultList();

        for (Address address : addresses) {
            System.out.println(String.format("%s, %s - %d employees",
                    address.getText(), address.getTown().getName(), address.getEmployees().size()));
        }

        System.out.println();

        //Second task
        Employee employee = entityManager.find(Employee.class, 147);
        Set<Project> projects = employee.getProjects();

        System.out.println(String.format("%s %s - %s%nProjects:",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));
        projects.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(p -> System.out.println(String.format("- %s", p.getName())));

        System.out.println();

        //Third task
        List<Integer> projectsIds = entityManager.createQuery("SELECT p.id FROM Project AS p " +
                "WHERE YEAR(p.startDate) BETWEEN 2001 AND 2003").getResultList();
        Query employeeQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p " +
                "WHERE p.id IN (:ids)");
        employeeQuery.setParameter("ids", projectsIds);
        List<Employee> employees = employeeQuery.getResultList();

        for (Employee employee1 : employees) {
            System.out.println(String.format("%s %s - Manager: %s%nProjetcs:",
                    employee1.getFirstName(), employee1.getLastName(), employee1.getManager().getFirstName()));
            for (Project project : employee1.getProjects()) {
                System.out.println(String.format("- %s - start date: %s, end date: %s",
                        project.getName(), project.getStartDate(), project.getEndDate()));
                
            }
        }

        System.out.println();

        //Fourth task
        List<Department> departments = entityManager.createQuery("SELECT d FROM Department AS d " +
                "WHERE d.employees.size > 5").getResultList();

        System.out.println(departments.size());
        departments.stream()
                .sorted((a, b) -> Integer.compare(a.getEmployees().size(), b.getEmployees().size()))
                .forEach(d -> {
                    System.out.println(String.format("--%s - Manager: %s, Employees: %d%n%s",
                            d.getName(), d.getManager().getLastName(), d.getEmployees().size(),
                            d.getEmployees().stream().map(e -> String.format("----%s %s - hire date: %s, job title: %s",
                                    e.getFirstName(), e.getLastName(), e.getHireDate(), e.getJobTitle()))
                    .collect(Collectors.joining("\n"))));
                });

        entityManager.close();
        entityManagerFactory.close();
    }
}
