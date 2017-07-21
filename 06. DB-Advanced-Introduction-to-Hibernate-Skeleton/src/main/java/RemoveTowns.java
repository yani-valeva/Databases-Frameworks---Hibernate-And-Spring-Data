import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName = reader.readLine();

        try {
            Query townQuery = entityManager.createQuery("SELECT t FROM Town AS t " +
                    "WHERE t.name = :name");
            townQuery.setParameter("name", townName);
            Town town = (Town) townQuery.getSingleResult();

            Query addressQuery = entityManager.createQuery("SELECT a FROM Address AS a " +
                    "WHERE a.town.name = :name");
            addressQuery.setParameter("name", townName);
            List<Address> addresses = addressQuery.getResultList();
            int deletedAddresses = addresses.size();

            entityManager.getTransaction().begin();

            for (Address address : addresses) {
                for (Employee employee : address.getEmployees()) {
                    employee.setAddress(null);
                }

                entityManager.flush();
                entityManager.remove(address);
            }

            entityManager.remove(town);

            System.out.println(deletedAddresses == 1 ? String.format("1 address in %s was deleted", townName) :
                    String.format("%d addresses in %s were deleted", deletedAddresses, townName));
            entityManager.getTransaction().commit();
        } catch (NoResultException nre) {

        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
