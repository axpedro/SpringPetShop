package br.com.pedro.demo.repositories;


import br.com.pedro.demo.models.Pet;
import br.com.pedro.demo.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {
    private TutorRepository tutorRepository;
    private static List<Tutor> ListaDeTutores = new ArrayList<>();
    private static int ultimoId;

    public List<Tutor> listar() {

        return ListaDeTutores;
    }

    public  void addTutor(Tutor tutor) {
        tutor.setId(++ultimoId);
        ListaDeTutores.add(tutor);
    }
    public void removePet(Tutor tutor){
        ListaDeTutores.remove(tutor);
    }
    public Tutor buscaTutor(int id){

        return ListaDeTutores.stream().filter(tutor -> id == tutor.getId()).findFirst().orElse(null);
    }



}
