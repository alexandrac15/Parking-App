import java.util.List;
//every site has a parking space.
public class ParkingLot {

    private String site;
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(String site, List<ParkingSpace> parkingSpaces) {
        this.site = site;
        this.parkingSpaces = parkingSpaces;

    }

    public String getSite() {
        return site;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
