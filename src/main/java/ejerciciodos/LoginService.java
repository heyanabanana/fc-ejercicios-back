package ejerciciodos;
import java.util.ArrayList;

public class LoginService {
    private ArrayList<User> users;

//    b) **Login usuario.** Se debe comprobar con el ArrayList previo si el usuario existe y en caso de que exista, hashear la contraseña recibida y comprobar que son iguales.
//    **Signatura:** public int login(String email, String password)
//    Devuelve -1 si el email no existe
//    Devuelve -2 si la contraseña es incorrecta
//    Devuelve 1 si el usuario existe y la contraseña es correcta

    public LoginService(ArrayList<User> users) {
        this.users = users;
    }

    // Comprobacion para el login devolvemos el responseLogin
    public int login(String email, String password) {

        if (verifyUser(email) != null) { //si el user existe seguimos
            if(getPassword(email).equals(RegisterService.makeHash(password))) {
                return 1; //correcto
            }
            return -2; //contraseña incorrecta
        }
        return -1; //user no existe
    }



    // usuario existe?
    public User verifyUser(String email) {
        for (User u : users)
            if (u.getEmail().equals(email)) {
                return u;  // devolver user si existe
            }

            return null; //si no existe no devuelve nada
    }

    // usuario + password
    public String getPassword(String email) {
        User u = verifyUser(email);
        return u.getPassword();
    }

    // login ok?
    public String responseLogin (int result) {
        String responseLogin;
        if (result == -1) {
            responseLogin = "Usuario no encontrado";
        } else if (result == -2) {
            responseLogin = "Contraseña incorrecta";
        } else if (result == 1) {
            responseLogin = "Login realizado";
        } else responseLogin = "Error desconocido";

        return responseLogin;
    }


    //getUsers

    public ArrayList<User> getUsers() {
        return users;
    }

    //setUsers


    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
