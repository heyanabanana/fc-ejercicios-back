package ejerciciosiete.models;

import ejerciciosiete.util.Validation;

import java.util.ArrayList;

public class CandidatesList {

    private ArrayList<Candidate> candidates;

    public CandidatesList(){
        this.candidates = new ArrayList<>();
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates){
        this.candidates = candidates;
    }

    //CREAR CANDIDATO
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }
    //BORRAR CANDIDATO
    public void removeCandidate(Candidate candidate) {
        candidates.remove(candidate);
    }


    // FILTRO EMAIL
    public Candidate filterEmail(String email) {
        if (Validation.verifyValidEmail(email)) {
            for (Candidate candidate : candidates) {
                if (candidate.getEmail().equals(email)) {
                    return candidate;
                }
            }
        } return null;
    }

    // FILTRO TELEFONO
    public Candidate filterPhone(String phone) {
            for (Candidate candidate : candidates) {
                if (candidate.getPhone().equals(phone)) {
                    return candidate;
                }
            }
         return null;
    }

    //FILTRO REMOTO
    public ArrayList<Candidate> filterRemote(boolean remote) {
        ArrayList<Candidate> candidatesFiltered = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getRemote() == remote) {
                candidatesFiltered.add(candidate);
            }
        }     return candidatesFiltered;
    }

    //FILTRO MOBILIDAD
    public ArrayList<Candidate> filterMobility(boolean mobility) {
        ArrayList<Candidate> candidatesFiltered = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getMobility() == mobility) {
                candidatesFiltered.add(candidate);
            }
        }     return candidatesFiltered;
    }

    //FILTRO CIUDAD
    public ArrayList<Candidate> filterCity(String city) {
        ArrayList<Candidate> candidatesFiltered = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getCity().getCity().equals(city)) {
                candidatesFiltered.add(candidate);
            }
        }
        return candidatesFiltered;
    }

    // FILTRO CIUDAD + REMOTO + PRESENCIAL
    public ArrayList<Candidate> filter(String city, boolean remote, boolean mobility) {
        ArrayList<Candidate> candidatesFiltered = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (candidate.getCity().getCity().equals(city) && candidate.getRemote() == remote && candidate.getMobility() == mobility) {
                candidatesFiltered.add(candidate);
            }
        }
        return candidatesFiltered;
    }

}
