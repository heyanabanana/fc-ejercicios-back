package ejercicioocho;

import java.util.ArrayList;

public class Country {

    // INICIO VARIABLES
    public static ArrayList<Country> countries = new ArrayList<>();

    private int id_country;
    private String country;
    private ArrayList<City> cities = new ArrayList<>();

    // CONSTRUCTOR
    public Country(int id_country, String country){
        if(Validation.verifyFullname(country)) {
            this.id_country = id_country;
            this.country = country;
            countries.add(this);
        } else {
            System.out.println("El nombre del Pais solo puede contener letras y espacios");
        }
    }

    //GETTERS Y SETTERS
    public int getId(){
        return id_country;
    }

    public void setId(int id_country){
        this.id_country = id_country;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public ArrayList<City> getCities(){
       return cities;
    }

    public void setCities(ArrayList<City> cities){
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id_country +
                ", pais='" + country + '\'' +
                '}';
    }


}
