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



    //SORTING

    //SORT REMOTO TRUE
    public int totalRemote(){
        int total = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getRemote()) {
                total++;
            }
        } return total;
    }


    //SORT MOBILITY TRUE
    public int totalMobility(){
        int total = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getMobility()) {
                total++;
            }
        } return total;
    }

    //SORT MOBILITY FALSE REMOTE FALSE
    public int totalMobilityAndRemote(){
        int total = 0;
        for (Candidate candidate : candidates) {
            if (!candidate.getMobility() && !candidate.getRemote()) {
                total++;
            }
        } return total;
    }

    //SORT COUNTRY
    public ArrayList<Country> setCountryTop() {
        ArrayList<Country> countries = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (!candidates.contains(candidate.getCity().getCountry())) {
                countries.add(candidate.getCity().getCountry());
            }
        }
        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < countries.size() - 1; j++) {
                if (filterCity(countries.get(j).getCountry()).size() < filterCity(countries.get(j + 1).getCountry()).size()) {
                    Country plus = countries.get(j);
                    countries.set(j, countries.get(j + 1));
                    countries.set(j + 1, plus);
                }
            }
        }
        return countries;
    }}
