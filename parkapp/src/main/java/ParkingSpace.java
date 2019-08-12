import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkingSpaces")
public class ParkingSpace {
    @Id
    @Column(name = "parking_space_id")
    private String idparkspace;
    @Column(name="start")
    private String start;
    @Column(name="end")
    private String end;


    public ParkingSpace(String idparkspace,String Start, String End) {

        this.idparkspace = idparkspace;
        this.start = Start;
        this.end = End;
    }

    public ParkingSpace() {
    }

    public String getIdparkspace() {
        return idparkspace;
    }

    public void setIdparkspace(String idparkspace) {
        this.idparkspace = idparkspace;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "idparkspace='" + idparkspace + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
