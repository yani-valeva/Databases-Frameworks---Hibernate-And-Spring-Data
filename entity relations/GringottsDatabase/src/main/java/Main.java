import entities.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        WizardDeposit dumbledoor = new WizardDeposit();
        dumbledoor.setFirstName("Albus");
        dumbledoor.setLastName("Dumbledore");
        dumbledoor.setAge(150);
        dumbledoor.setMagicWandCreator("Antoich Peverell");
        dumbledoor.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 20);
        Date depositStart = calendar.getTime();
        dumbledoor.setDepositStartDate(depositStart);
        calendar.set(2020, 10, 20);
        Date depositEnd = calendar.getTime();
        dumbledoor.setDepositExpirationDate(depositEnd);
        dumbledoor.setDepositAmount(new BigDecimal(2000.24));
        dumbledoor.setDepositCharge(new BigDecimal(0.2));
        dumbledoor.setDepositExpired(false);

        entityManager.persist(dumbledoor);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
