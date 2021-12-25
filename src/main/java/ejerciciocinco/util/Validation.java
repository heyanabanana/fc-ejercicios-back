package ejerciciocinco.util;

import ejerciciocinco.models.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


    //comprobar email duplicado
    public static boolean verifyDuplicateEmail(ArrayList<User> users, String email) {
        for(User user : users) {
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    //comprobar email valido
    public static boolean verifyValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    //validar nombre letras + espacios
    public static boolean verifyFullname(String fullname) {

        Pattern pattern =
                Pattern.compile("^[a-zA-ZñÑ&]+(\s[a-zA-ZñÑ&]+)*$");
        Matcher mather = pattern.matcher(fullname);
        return mather.find();
    }
}
