package ejercicioseis;

import ejercicioseis.models.*;
import ejercicioseis.models.Candidate;
import ejercicioseis.util.CreatePdf;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //RELLENAR DATOS

        //USUARIOS
        User useruno = User.registerService("Ana Fdez", "ana@ana.es", "ana");

        //PAISES
        Country countryuno = new Country(1,"España");

        //CIUDADES
        City cityuno = new City(1,"Gijon");
        cityuno.setCountry(countryuno); //LO ASOCIAMOS CON EL PAIS

        //CERTIFICACIONES

        Skill skilldos = new Skill(2, "CSS");
        Skill skilltres = new Skill(3, "REACT");

        Candidate candidateuno = new Candidate(1,
                "Ana Fernandez",
                "ana@ana.es",
                "612121212",
                true,
                false,
                "www.google.es",
                "www.yahoo.es"
                );

        candidateuno.setCity(cityuno);
        ArrayList<Skill> skillsuno = new ArrayList<>();
        skillsuno.add(skilldos);
        skillsuno.add(skilltres);
        candidateuno.setSkills(skillsuno);
        candidateuno.setUser(useruno);


        //IMPRESION POR CONSOLA
        System.out.println("----");
        System.out.println("Listado de Candidatos");
        for(Candidate candidate : Candidate.candidates) {
            System.out.println(candidate);
            System.out.println("\n----");
        }
        System.out.println("----");

        CreatePdf.createPDF("curriculum.pdf", candidateuno);
    }
}
