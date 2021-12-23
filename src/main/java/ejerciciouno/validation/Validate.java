package ejerciciouno.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    /** Comprobar email duplicado
     * @param users
     * @param user
     * @return true si el correo no existe en el array false si ya existe
     */

    public static boolean verifyDuplicateEmail(ArrayList<String[]> users, String[] user) {
        for (String[] strings : users) {
            if (strings[0].equals(user[0])) {
                return false;
            }
        }
        return true;
    }

    /** Verificar tres campos
     *
     * @param user
     * @param n
     * @return true si la linea tiene 3 campos
     */
    public static boolean verifyThreeParameters(String[] user, int n) {
        return user.length == n;
    }

    /** Verificar patron email
     *
     * @param email
     * @return true si el email sigue el patron
     */
    public static boolean verifyEmail(String email) {

        Pattern pattern =
                Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    /** Verificar patron fullname
     *
     * @param fullname
     * @return true si el fullname sigue el patron
     */
    public static boolean verifyFullname(String fullname) {

        Pattern pattern =
                Pattern.compile("^[a-zA-Z]+(\s[a-zA-Z]+)+$");
        Matcher mather = pattern.matcher(fullname);
        return mather.find();
    }

    /** Verificar patron username
     *
     * @param username
     * @return true si el username sigue el patron
     */
    public static boolean verifyUsername(String username) {

        Pattern pattern =
                Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher mather = pattern.matcher(username);
        return mather.find();
    }

}

