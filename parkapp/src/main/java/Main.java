import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.Parking.jpa");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();

//        Employee e1=new Employee(1,"Alexandru Mihai","12345");
//        Employee e2=new Employee(2,"Alexandru Popescu","1239045");
          Employee e3=new Employee(3,"Ion Mihai","12378");

//        entityManager.persist(e1);
//        entityManager.persist(e2);
//    entityManager.persist(e3);

//        ParkingSpace p1=new ParkingSpace("12A","2019-08-09","2019-09-03");
//        ParkingSpace p2=new ParkingSpace("14B","2019-08-19","2019-09-07");
//        ParkingSpace p3=new ParkingSpace("14C","2019-08-07","2019-08-09");

//        entityManager.persist(p1);
//        entityManager.persist(p2);
//        entityManager.persist(p3);

        Repository r=new Repository();
        r.reserve(e3,"2019-08-08","2019-08-08");
        entityManager.getTransaction().commit();



    }

}
