package ejerciciosiete.models;

import ejerciciosiete.util.Validation;

import java.util.ArrayList;

public class Skill {

    public static ArrayList<Skill> skills = new ArrayList<>();

    //INICIO VARIABLES
    private int id_skill;
    private String skill;
    private ArrayList<Candidate> candidates = new ArrayList<>();


    public Skill(int id_skill, String skill) {

        if(Validation.verifyFullname(skill)){
            this.id_skill = id_skill;
            this.skill = skill;
            skills.add(this);
        }else{
            System.out.println("El nombre de la skill solo puede contener letras y espacios");
        }
    }




    //GETTERS Y SETTERS
    public int getId() {
        return id_skill;
    }

    public void setId(int id) {
        this.id_skill = id_skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id_skill +
                ", skill='" + skill + '\'' +
                '}';
    }

}
