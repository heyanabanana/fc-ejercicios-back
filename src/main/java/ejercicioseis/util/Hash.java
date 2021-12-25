package ejercicioseis.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {

    public Hash(){
        //constructor vacio
    }

        public static String HashPassword(String password) {
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
