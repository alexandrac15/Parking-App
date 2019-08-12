import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class Repository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.Parking.jpa");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional

    public boolean reserve(Employee e,String start, String end){
        entityManager.getTransaction().begin();

        Query q    = entityManager.createQuery("SELECT f" + " FROM " + ParkingSpace.class.getName() + " f "+"WHERE cast(f.end as date) "+">= cast('"+ end+"' as date) and cast(f.start as date) "+"<= cast('"+ start+"' as date)",ParkingSpace.class);
        List<ParkingSpace> freeParkingSpaces=q.getResultList();

            //if the list has something then do a reservation:
        if(!freeParkingSpaces.isEmpty()){
            ParkingSpace ps=freeParkingSpaces.get(0);
            Reservation r=new Reservation(e,ps, start, end);
            entityManager.persist(r);
            //make the changes:
           // Query q1 =entityManager.createQuery("Update " + ParkingSpace.class.getName() +" f SET"+ " f.occupied"+"=:PARAM1 "+"WHERE f.idparkspace "+"=:idp");
           // Query q2 =entityManager.createQuery("Update " + ParkingSpace.class.getName() +" f SET"+ " f.until="+end+" WHERE f.idparkspace "+"=:idp");
            Query q1=entityManager.createQuery("Update "+ ParkingSpace.class.getName() +" f SET"+ " f.start="+end+"WHERE f.idparkspace "+"=:idp");
            q1.setParameter("idp",ps.getIdparkspace());
            q1.executeUpdate();

            entityManager.getTransaction().commit();
            return true;
        }
    return false;
    }


    public boolean cancelReservation(Employee e,String end){
        entityManager.getTransaction().begin();
        Query q    = entityManager.createQuery("SELECT f" + " FROM " + Reservation.class.getName() +" f  WHERE employeeid ='"+e.getEmployeeId()+"'",Reservation.class);
        List<Reservation> r=q.getResultList();

        Reservation r1=r.get(0);
        entityManager.persist(new ParkingSpace(r1.getParkingSpace(),r1.getStart(),r1.getEnd()));
        Query q1 =entityManager.createQuery("Delete from " + Reservation.class.getName() +"    WHERE employeeid"+"= '"+e.getEmployeeId()+"' ");
        q1.executeUpdate();


        //change in parkingSpace
       // Query q3 =entityManager.createQuery("Update " + ParkingSpace.class.getName() +"  SET"+ " f.start"+"= cast('"+ end+"' as date)"+"WHERE idparkspace ='"+e.getEmployeeId()+"'");
       // Query q2 =entityManager.createQuery("Update " + ParkingSpace.class.getName() +"  SET"+ " until='"+end+"' WHERE idparkspace "+"=:idp");

        entityManager.getTransaction().commit();
        return false;

    }

    public boolean  releaseSpot(Employee e,String start,String end){

        entityManager.getTransaction().begin();
        Query q1=entityManager.createQuery("SELECT f" + " FROM " + PermanentParkingSpaces.class.getName() +" f  WHERE employeeid ='"+e.getEmployeeId()+"'",PermanentParkingSpaces.class);
         PermanentParkingSpaces ps=(PermanentParkingSpaces) q1.getResultList();
         ParkingSpace parkingSpace=new ParkingSpace(ps.getAssignedSpace(),start,end);
         entityManager.persist(parkingSpace);
         entityManager.getTransaction().commit();
         return true;
    }

    public Employee validUser(String id,String pass){
        entityManager.getTransaction().begin();
        Query q1=entityManager.createQuery("SELECT f" + " FROM " + Employee.class.getName() +" f  WHERE employeeid ='"+id+"' and employeePass= '"+pass+"'",Employee.class);
        Employee e=(Employee) q1.getSingleResult();
        entityManager.getTransaction().commit();
        return e;
    }
}
