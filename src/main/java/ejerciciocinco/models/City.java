package ejerciciocinco.models;

import ejerciciocinco.util.Validation;

import java.util.ArrayList;

public class City {

    //INICIALIZACION

    public static ArrayList<City> cities = new ArrayList<>();

    private int id_city;
    private String city;
    private Country country;
    private ArrayList<Candidate> candidates = new ArrayList<>();

    public City(int id_city, String city) {
        if(Validation.verifyFullname(city)) {
            this.id_city = id_city;
            this.city = city;

            cities.add(this);
        } else {
            System.out.println("El nombre de la ciudad solo puede contener letras y espacios");
        }
    }

    //GETTERS Y SETTERS

    public int getId() {
        return id_city;
    }

    public void setId(int id) {
        this.id_city = id_city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return  "Ciudad{" +
                "id=" + id_city +
                ", ciudad='" + city + '\'' +
                '}';
    }
}
