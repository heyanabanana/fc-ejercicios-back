package ejercicioocho;

import java.util.ArrayList;


public class User {

    public static ArrayList<User> users = new ArrayList<>();

    //ATRIBUTOS
    private int id_user;
    private String fullname;
    private String email;
    private String password;

    private ArrayList<Candidate> candidates = new ArrayList<>(); //Relacion con candidatos

    //CONSTRUCTOR USUARIO
    public User(int id_user, String fullname, String email, String password) {

        if (Validation.verifyValidEmail(email) && Validation.verifyFullname(fullname)) {
            if (Validation.verifyDuplicateEmail(users, email)) {
                this.id_user = id_user;
                this.fullname = fullname;
                this.email = email;
                this.password = Hash.HashPassword(password);
                System.out.println("Usuario creado correctamente");
                users.add(this);
            } else {
                System.out.println("Usuario no creado, el correo ya existe " + email);
            }
        } else {
            System.out.println("Usuario no creado, datos incorrectos " + fullname + " " + email);
        }

    }

    //REGISTRO
    public static User registerService(int id_user, String fullname, String email, String password) {
        String hashPassword = Hash.HashPassword(password);
        return new User(id_user, fullname, email, hashPassword);
    }

    //LOGIN
    public int loginService(String email, String password) {

        if (verifyUser(email) != null) { //si el user existe seguimos
            if(getPassword(email).equals(Hash.HashPassword(password))) {
                return 1; //correcto
            }
            return -2; //contraseña incorrecta
        }
        return -1; //user no existe
    }

    // usuario + password
    public String getPassword(String email) {
        User u = verifyUser(email);
        return u.getPassword();
    }

    // usuario existe?
    public User verifyUser(String email) {
        for (User u : users)
            if (u.getEmail().equals(email)) {
                return u;  // devolver user si existe
            }

        return null; //si no existe no devuelve nada
    }


    // GETTERS Y SETTERS
    public int getId_user(){
        return id_user;
    }

    public void setId_user(int id_user){
        this.id_user = id_user;
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

    public String getPassword(){
        return password;
    }

    public void setPassword (String password) {
        this.password = Hash.HashPassword(password);
    }

    public ArrayList<Candidate> getCandidates(){
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString(){
        return "Usuario {" +
                "id=" + id_user +
                ", nombre='" + fullname + "\'" +
                ", email=" + email + "\'" +
                ", contraseña=" + password + "\'" +
                "}";
    }
}
