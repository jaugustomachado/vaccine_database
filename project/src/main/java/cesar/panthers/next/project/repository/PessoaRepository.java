package cesar.panthers.next.project.repository;

import cesar.panthers.next.project.model.Pessoa;
import cesar.panthers.next.project.repository.interfaces.VaccineRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends VaccineRepository<Pessoa> {

}
