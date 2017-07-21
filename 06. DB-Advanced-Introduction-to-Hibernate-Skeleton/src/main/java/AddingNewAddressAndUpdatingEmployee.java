import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");

        Employee employee = (Employee) entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'").getSingleResult();
        employee.setAddress(address);
        entityManager.persist(address);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        System.out.println(employee.getAddress().getText());
        entityManager.close();
        entityManagerFactory.close();
    }
}
