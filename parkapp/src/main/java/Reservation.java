import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {
      @Id
      @Column(name="employeeid")
      private int employeeId;
      @Id
      @Column(name="parkingSpace")
      private String parkingSpaceId;

      @Column(name="period")
      private int time;
      @Column(name="start")
      private String start;
      @Column(name="end")
      private String end;

//   private Employee employee;
//   private ParkingSpace parkingSpace;
//   private String time;
    public Reservation(){}
    public Reservation(Employee employee, ParkingSpace parkingSpace, String start, String end) {
        this.employeeId = employee.getEmployeeId();
        this.parkingSpaceId = parkingSpace.getIdparkspace();
        this.start=start;
        this.end=end;
    }

    public int getEmployee() {
        return employeeId;
    }

    public void setEmployee(Employee employee) {
        this.employeeId = employee.getEmployeeId();
    }

    public String getParkingSpace() {
        return parkingSpaceId;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpaceId = parkingSpace.getIdparkspace();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "employeeId=" + employeeId +
                ", parkingSpaceId='" + parkingSpaceId + '\'' +
                ", time=" + time +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
