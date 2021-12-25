package ejerciciosiete;

import ejerciciosiete.models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //RELLENAR DATOS

        //USUARIOS
        User useruno = User.registerService(1,"Ana Fdez", "ana@ana.es", "ana");
        User userdos = User.registerService(2,"Pruebita Dos", "prueba@prueba.es", "prueba");

        //PAISES
        Country countryuno = new Country(1,"España");
        Country countrydos = new Country(2,"Portugal");
        Country countrytres = new Country(3,"Alemania");

        //CIUDADES
        City cityuno = new City(1,"Gijon");
        cityuno.setCountry(countryuno); //LO ASOCIAMOS CON EL PAIS
        City citydos = new City(2,"Lisboa");
        citydos.setCountry(countrydos); //LO ASOCIAMOS CON EL PAIS
        City citytres = new City(3,"Berlin");
        citytres.setCountry(countrytres); //LO ASOCIAMOS CON EL PAIS


        //CERTIFICACIONES
        Skill skilluno = new Skill(1, "HTML");
        Skill skilldos = new Skill(2, "CSS");
        Skill skilltres = new Skill(3, "REACT");
        Skill skillcuatro = new Skill(4, "ANGULAR");
        Skill skillcinco = new Skill(5, "JAVA");
        Skill skillseis = new Skill(6, "SPRING");

        //CANDIDATOS
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

        Candidate candidatedos = new Candidate(2,
                "Manolito Gafotas",
                "manolito@manolito.es",
                "612121212",
                false,
                true,
                "www.google.es",
                "www.yahoo.es"
        );

        candidatedos.setCity(citydos);
        ArrayList<Skill> skillsdos = new ArrayList<>();
        skillsdos.add(skilluno);
        skillsdos.add(skilltres);
        skillsdos.add(skillcinco);
        candidatedos.setSkills(skillsdos);
        candidatedos.setUser(userdos);

        Candidate candidatetres = new Candidate(3,
                "Fulanito Menganito",
                "fulanito@fulanito.es",
                "622321312",
                false,
                true,
                "www.google.es",
                "www.yahoo.es"
        );

        candidatetres.setCity(cityuno);
        ArrayList<Skill> skillstres = new ArrayList<>();
        skillstres.add(skilldos);
        skillstres.add(skilltres);
        skillstres.add(skillseis);
        candidatetres.setSkills(skillstres);
        candidatetres.setUser(useruno);


        //IMPRESION POR CONSOLA
        System.out.println("----");
        System.out.println("Listado de Candidatos");
        for(Candidate candidate : Candidate.candidates) {
            System.out.println(candidate);
            System.out.println("\n----");
        }
        System.out.println("----");

        //FILTROS
        CandidatesList candidatesList = new CandidatesList();
        candidatesList.addCandidate(candidateuno);
        candidatesList.addCandidate(candidatedos);
        candidatesList.addCandidate(candidatetres);


        System.out.println("Ciudad: Gijon");
        System.out.println(candidatesList.filterCity("Gijon"));

        //SORT
        System.out.println("CANDIDATOS TRABAJO REMOTO");
        System.out.println(candidatesList.totalMobility());

        System.out.println("CANDIDATOS TRASLADO");
        System.out.println(candidatesList.totalMobility());

        System.out.println("CANDIDATOS NO REMOTO NO TRASLADO");
        System.out.println(candidatesList.totalMobility());

        System.out.println("CIUDADES POR CANDIDATO");
        System.out.println(candidatesList.setCountryTop());

    }
}
