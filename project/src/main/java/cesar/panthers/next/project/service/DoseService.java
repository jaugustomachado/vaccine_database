package cesar.panthers.next.project.service;

import cesar.panthers.next.project.repository.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import cesar.panthers.next.project.model.Dose;



@Service
public class DoseService {

    private final DoseRepository doseRepository;

    @Autowired
    public DoseService(final DoseRepository doseRepository) {
        this.doseRepository = doseRepository;
    }

    @Transactional
    public void cadastrarOuAtualizarDose(final Dose dose) throws Exception {
        try {
            List<Dose> alunos = this.doseRepository.findAll();

            this.doseRepository.save(dose);
        } catch (DataIntegrityViolationException e) {
            throw e;
        }
    }

    @Transactional
    public Set<Dose> listagemDoses() {
        return new LinkedHashSet<>(this.doseRepository.findAll());
    }

    @Transactional
    public Dose obterDose(final long ordem) {
        return this.doseRepository.findById(ordem).orElse(null);
    }
}

