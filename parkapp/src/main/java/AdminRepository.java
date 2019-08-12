import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.Parking.jpa");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public AdminRepository(){}
  //se mai poate adauga


    public void addEmployee(Employee e){
          entityManager.getTransaction().begin();
          entityManager.persist(e);
          entityManager.getTransaction().commit();

    }

    public void assignParkingSpace(PermanentParkingSpaces permanentParkingSpaces){

        entityManager.getTransaction().begin();
        entityManager.persist(permanentParkingSpaces);
        entityManager.getTransaction().commit();

    }
}
