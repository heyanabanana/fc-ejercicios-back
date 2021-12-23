package ejerciciodos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService {

    public ArrayList<User> users;

//    a) **Registrar usuario.** Se debe almacenar, en un ArrayList de Users, el correo electrónico y la contraseña hasheada.
//    **Signatura:** public boolean register(String email, String password)
//    Devuelve true si se ha podido almacenar, false si el correo ya existía.

    public RegisterService(ArrayList<User> users) {
        this.users = users;
    }

    // Registrar usuario

    public boolean isRegister(String email, String password) {
        String passwordHash = makeHash(password);

        if (verifyEmail(email) && !verifyDuplicateEmail(email)) {
            User user = new User(email, passwordHash);
            users.add(user);

            System.out.println("Registro realizado");
            return true;
        }
        System.out.println("Email no existe / duplicado");
        return false;
    }

    public boolean verifyEmail(String email) {
        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher mather = patternEmail.matcher(email);
        return mather.find();
    }


    public boolean verifyDuplicateEmail(String email) { //verificar email no duplicado
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        } return false;
    }

    //https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html
    //https://www.yoelprogramador.com/como-encriptar-contrasenas-en-md5-en-java/

    public static String makeHash(String password) {
        MessageDigest messd;

        try {
            messd = MessageDigest.getInstance("MD5");
            messd.update(password.getBytes());

            String passwd = new BigInteger(1, messd.digest()).toString(16);
            System.err.println((passwd));
            return passwd;
        } catch ( Exception err) {
            err.printStackTrace();
            return password;
        }
    }


}
