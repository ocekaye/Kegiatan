package solfa.ratri.kegiatan.FourSquare;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Hinata on 12/9/2016.
 */
public class ModelApi {
    public Response response;

    public Response getResponse() {
        return (response == null ? new Response() : response);
    }

    public void setResponse(Response meta) {
        this.response = meta;
    }

    public class Response{
        List<Venues> venues = new ArrayList<>();

        public List<Venues> getVenues() {
            return venues;
        }

        public void setVenues(List<Venues> venues) {
            this.venues = venues;
        }
    }

    public class Venues{
        String name = "";
        Location location;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return (location == null ? new Location() : location);
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    public class Location{
        String address;
        String crossStreet;
        String lat;
        String lng;
        String city;
        String state;
        String country;

        public String getAddress() {
            return (address == null ? "" : address);
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCrossStreet() {
            return (crossStreet == null ? "" : crossStreet);
        }

        public void setCrossStreet(String crossStreet) {
            this.crossStreet = crossStreet;
        }

        public String getLat() {
            return (lat == null ? "" : lat);
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return (lng == null ? "" : lng);
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getCity() {
            return (city == null ? "" : city);
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return (state == null ? "" : state);
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return (country == null ? "" : country);
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getFullAdress(){
            String koma = ", ";
            StringBuilder s = new StringBuilder();
            s.append(getAddress());
            s.append((getAddress().length() < 2) ? "" : koma);
            s.append(getCity());
            s.append((getCity().length() < 2) ? "" : koma);
            s.append(getState());
            s.append((getState().length() < 2) ? "" : koma);
            s.append(getCountry());
            return s.toString();
        }
    }
}
