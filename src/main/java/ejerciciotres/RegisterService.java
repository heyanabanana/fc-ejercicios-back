package ejerciciotres;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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


    public static String makeHash(String password) { //CON ARGON2 en lugar de hash
        Argon2 argPassword = Argon2Factory.create();
        String hashPassword = null;
        char[] passArray = password.toCharArray();
        try {
            hashPassword = argPassword.hash(12, 1024, 8, passArray);

        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
        } finally {
            argPassword.wipeArray(passArray);
            System.out.println("Password argon 2" + hashPassword);
        }

        return hashPassword;
    }


//CAMBIAR HASH A ARGON2
//https://www.twelve21.io/how-to-use-argon2-for-password-hashing-in-java/

    public static boolean passwordArgon2(String hashPassword, String password) {
        Argon2 passwArgon = Argon2Factory.create();
        char[] passArray = password.toCharArray();

        boolean result = false;

        try {
            result = passwArgon.verify(hashPassword, passArray);
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
        }
        return result;
    }

}
