package ejerciciocuatro;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
public class Main {

    public static void main(String[] args) throws SparkPostException {

    String API_KEY = "23995ca4b9d70f150eca7bcf2aeb73cd7bc32f11";
    Client client = new Client(API_KEY);
        client.sendMessage(
        "info@info.heyanabanana.es",
        "hola@heyanabanana.es",
        "Este es el asunto",
        "Este es el cuerpo ",
        "<b>HOLA CARACOLA</b>");
            }
}
