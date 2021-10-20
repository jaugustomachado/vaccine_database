package cesar.panthers.next.project.controller;

import cesar.panthers.next.project.model.TipoVacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cesar.panthers.next.project.model.Dose;
import cesar.panthers.next.project.service.DoseService;

import java.util.Date;

@Controller
public class DoseController {

    private final DoseService doseService;

    @Autowired
    public DoseController(final DoseService doseService) {
        this.doseService = doseService;
    }

    @GetMapping({"/", "/dose/list", "/dose/list/"})
    public String showListDose(Model model) {
        model.addAttribute("doses", this.doseService.listagemDoses());
        return "listadoses";
    }

    @GetMapping({"/dose/{ordem}/detail", "/aluno/{ordem}/detail/"})
    public String showAlunoDetails(@PathVariable(value="ordem") final Integer ordem, Model model) {
        model.addAttribute("dose", this.doseService.obterDose(ordem));
        return "detaildoses";
    }

    @PostMapping({"/dose/edit/save", "/dose/edit/save/"})
    public String saveEditAluno(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "data", required = false) Date data_vacinacao,
            @RequestParam(value = "ordem", required = false) Integer ordem,
            @RequestParam(value = "tipo", required = false) TipoVacina tipo,
            Model model
    ) {
        Dose dose = new Dose();
        dose.setDataVacinacao(data_vacinacao);
        dose.setOrdem(ordem);
        dose.setTipo(tipo);

        try {
            this.doseService.cadastrarOuAtualizarDose(dose);
            model.addAttribute("success", "Dose atualizado com sucesso!");
            return this.showListDose(model);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "editdose";
        }
    }

    @GetMapping({"/aluno/new", "/aluno/new/"})
    public String showNewAlunoScreen() {
        return "newaluno";
    }

    @PostMapping({"/dose/new/save", "/dose/new/save/"})
    public String saveNewDose(
            @RequestParam(value = "data", required = false) Date data,
            @RequestParam(value = "ordem", required = false) Integer ordem,
            @RequestParam(value = "tipo", required = false) TipoVacina tipo,
            Model model
    ) {
        Dose dose = new Dose();
        dose.setDataVacinacao(data);
        dose.setOrdem(ordem);
        dose.setTipo(tipo);

        try {
            this.doseService.cadastrarOuAtualizarDose(dose);
            model.addAttribute("success", "Dose cadastrada com sucesso!");
            return this.showListDose(model);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "newDose";
        }
    }
}