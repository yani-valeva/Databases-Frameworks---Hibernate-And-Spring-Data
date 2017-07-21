import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CreateObjects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee manager = (Employee) entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.id = 5").getSingleResult();
        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address firstAddress = new Address();
        firstAddress.setTown(burgas);
        firstAddress.setText("122 Vitosha Str");

        Address secondAddress = new Address();
        secondAddress.setTown(burgas);
        secondAddress.setText("26 Nikola Petkov Str");

        Address thirdAddress = new Address();
        thirdAddress.setTown(burgas);
        thirdAddress.setText("121 Izgrev Str");

        Address fourthAddress = new Address();
        fourthAddress.setTown(burgas);
        fourthAddress.setText("18 Rodopi Str");

        Address fifthAddress = new Address();
        fifthAddress.setTown(burgas);
        fifthAddress.setText("1 San Stefano Str");

        Employee sasho = new Employee();
        sasho.setFirstName("Sasho");
        Date sashoHireDate = new Date();
        sasho.setHireDate(new Timestamp(sashoHireDate.getTime()));
        sasho.setJobTitle("Java developer");
        sasho.setLastName("Petrov");
        sasho.setMiddleName("Ivanov");
        sasho.setSalary(new BigDecimal("45000"));
        sasho.setAddress(fifthAddress);
        sasho.setDepartment(training);
        sasho.setManager(manager);

        Employee misho = new Employee();
        misho.setFirstName("Misho");
        Date mishoHireDate = new Date();
        misho.setHireDate(new Timestamp(mishoHireDate.getTime()));
        misho.setJobTitle("Application programmer");
        misho.setLastName("Mihailov");
        misho.setMiddleName("Stojanov");
        misho.setSalary(new BigDecimal("21000"));
        misho.setAddress(firstAddress);
        misho.setDepartment(training);
        misho.setManager(manager);

        Employee ivo = new Employee();
        ivo.setFirstName("Ivo");
        Date ivoHireDate = new Date();
        ivo.setHireDate(new Timestamp(ivoHireDate.getTime()));
        ivo.setJobTitle("Computer game developer");
        ivo.setLastName("Petkov");
        ivo.setMiddleName("Ivov");
        ivo.setSalary(new BigDecimal("13000"));
        ivo.setAddress(secondAddress);
        ivo.setDepartment(training);
        ivo.setManager(manager);

        Employee niki = new Employee();
        niki.setFirstName("Niki");
        Date nikiHireDate = new Date();
        niki.setHireDate(new Timestamp(nikiHireDate.getTime()));
        niki.setJobTitle("Multimedia developer");
        niki.setLastName("Nikolov");
        niki.setMiddleName("Slavov");
        niki.setSalary(new BigDecimal("1000"));
        niki.setAddress(thirdAddress);
        niki.setDepartment(training);
        niki.setManager(manager);

        Employee sisi = new Employee();
        sisi.setFirstName("Sisi");
        Date sisiHireDate = new Date();
        sisi.setHireDate(new Timestamp(sisiHireDate.getTime()));
        sisi.setJobTitle("Special effects programmer");
        sisi.setLastName("Stoimenova");
        sisi.setMiddleName("Simeonova");
        sisi.setSalary(new BigDecimal("102000"));
        sisi.setAddress(fourthAddress);
        sisi.setDepartment(training);
        sisi.setManager(manager);

        entityManager.getTransaction().begin();

        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(firstAddress);
        entityManager.persist(secondAddress);
        entityManager.persist(thirdAddress);
        entityManager.persist(fourthAddress);
        entityManager.persist(fifthAddress);
        entityManager.persist(sasho);
        entityManager.persist(misho);
        entityManager.persist(ivo);
        entityManager.persist(niki);
        entityManager.persist(sisi);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
