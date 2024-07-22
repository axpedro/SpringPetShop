package br.com.pedro.demo.services;

import br.com.pedro.demo.models.Pet;
import br.com.pedro.demo.models.Tutor;
import br.com.pedro.demo.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public void cadastrar(Tutor tutor) {

        tutorRepository.addTutor(tutor);
    }

    public List<Tutor> listar() {

        return tutorRepository.listar();
    }

    public Tutor buscar(int id) {
        return tutorRepository.buscaTutor(id);
    }

    public boolean excluir(int id) {
        Tutor tutorExcluir = tutorRepository.buscaTutor(id);
        if(tutorExcluir != null) {
            tutorRepository.removePet(tutorExcluir);
            return true;
        }
        return false;
    }

    public boolean atualizar(Tutor tutor) {
        var tutorAtualizar = tutorRepository.buscaTutor(tutor.getId());
        if(tutorAtualizar != null){
            tutorAtualizar.setNome(tutor.getNome());

            return true;

        }
        return false;
    }
}
