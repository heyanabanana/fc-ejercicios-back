package ejerciciosiete.models;

import ejerciciosiete.util.Validation;

import java.util.ArrayList;

public class Candidate {

    public static ArrayList<Candidate> candidates = new ArrayList<>();

    //ATRIBUTOS CANDIDATO
    private int id_candidate;
    private String fullname;
    private String email;
    private String phone;
    private boolean remote; //remote true/false
    private boolean mobility; //mobility true/false
    private String photo; //URL
    private String curriculum; //URL
    private ArrayList<Skill> skills = new ArrayList<>(); //relacion skills
    private City city; //relacion ciudad
    private User user; //relacion user


    public Candidate() {} //constructor vacio

    public Candidate(int id_candidate, String fullname, String email, String phone, boolean remote, boolean mobility, String photo, String curriculum) {
        if (Validation.verifyValidEmail(email)) {
            if (Validation.verifyFullname(fullname)) {
                this.id_candidate = id_candidate;
                this.fullname = fullname;
                this.email = email;
                this.phone = phone;
                this.remote = remote;
                this.mobility = mobility;
                this.photo = photo;
                this.curriculum = curriculum;
                candidates.add(this);
            } else {
                System.out.println("El nombre solo puede contener letras y espacios");
            }
        } else {
            System.out.println("El email no es válido");
        }

        }

        //GETTERS Y SETTERS
        public int getId() {
            return id_candidate;
         }

         public void setId(int id_candidate) {
            this.id_candidate = id_candidate;
         }

         public String getFullname(){
            return fullname;
         }

         public void setFullname(String fullname){
            this.fullname = fullname;
         }

         public String getEmail(){
            return email;
         }

         public void setEmail(String email){
            this.email = email;
         }

         public String getPhone(){
            return phone;
         }

         public void setPhone(String phone){
            this.phone = phone;
         }

         public boolean getRemote(){
            return remote;
         }

         public void setRemote(boolean remote) {
            this.remote = remote;
         }

         public boolean getMobility(){
            return mobility;
         }

         public void setMobility(boolean mobility){
            this.mobility = mobility;
         }

         public String getPhoto(){
            return photo;
         }

         public void setPhoto(String photo){
            this.photo = photo;
         }

         public String getCurriculum(){
            return curriculum;
         }

         public void setCurriculum(String curriculum){
            this.curriculum = curriculum;
         }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills){
        this.skills = skills;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city){
        this.city = city;
        city.getCandidates().add(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
        user.getCandidates().add(this);
    }


    @Override
    public String toString() {
        return "Candidato {" +
                "\nid=" + id_candidate +
                ",\n nombre='" + fullname + '\'' +
                ",\n email='" + email + '\'' +
                ",\n telefono='" + phone + '\'' +
                ",\n remoto=" + remote +
                ",\n mobilidad=" + mobility +
                ",\n foto='" + photo + '\'' +
                ",\n curriculum='" + curriculum + '\'' +
                ",\n " + skills +
                ",\n " + city +
                ",\n pais=" + city.getCountry().getCountry() +
                ",\n usuario=" + user.getId_user()  +
                "\n}";
    }

}
