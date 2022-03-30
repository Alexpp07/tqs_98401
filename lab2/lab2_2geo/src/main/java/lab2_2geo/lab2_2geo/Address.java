package lab2_2geo.lab2_2geo;

import java.util.Objects;

public class Address {
    private String road;
    private String state;
    private String city;
    private String zio;
    private String houseNumber;

    public Address (String road, String state, String city, String zio, String houseNumber){
        this.road=road;
        this.state=state;
        this.city=city;        
        this.zio=zio;
        this.houseNumber=houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" + "road=" + road + ", state=" + state + ", city=" + city + ", zio=" + zio + ", houseNumber=" + houseNumber + '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(road, state, city, zio, houseNumber);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.road, other.road)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zio, other.zio)) {
            return false;
        }
        if (!Objects.equals(this.houseNumber, other.houseNumber)) {
            return false;
        }
        return true;
    }


    public String getRoad() {
        return this.road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZio() {
        return this.zio;
    }

    public void setZio(String zio) {
        this.zio = zio;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}
