

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="permanent_parking")
    public class PermanentParkingSpaces {
    @Column(name="employeeid")
    private int employeeid;
    @Column(name="parkingId")
    private String assignedSpace;

    public PermanentParkingSpaces(int employeeid, String assignedSpace) {
        this.employeeid = employeeid;
        this.assignedSpace = assignedSpace;
    }
    public PermanentParkingSpaces(){}

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getAssignedSpace() {
        return assignedSpace;
    }

    public void setAssignedSpace(String assignedSpace) {
        this.assignedSpace = assignedSpace;
    }

    @Override
    public String toString() {
        return "PermanentParkingSpaces{" +
                "employeeid=" + employeeid +
                ", assignedSpace='" + assignedSpace + '\'' +
                '}';
    }
}
