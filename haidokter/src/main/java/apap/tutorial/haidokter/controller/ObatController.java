package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addResepFormPage(@PathVariable Long noResep, Model model) {
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep).get();
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";
    }

    @PostMapping("/obat/add")
    private String addObatSubmit(@ModelAttribute ObatModel obat, Model model) {
        obatService.addObat(obat);
        model.addAttribute("nama", obat.getNama());

        return "add-obat";
    }

    @GetMapping("/obat/change/{idObat}")
    private String changeObatFormPage(@PathVariable Long idObat, Model model) {
        ObatModel existingObat = obatService.getObatById(idObat);
        model.addAttribute("obat", existingObat);

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(@ModelAttribute ObatModel obat, Model model) {
        ObatModel newObatData = obatService.changeObat(obat);
        model.addAttribute("obat", newObatData.getNama());

        return "update-obat";
    }

    @PostMapping(value = "/obat/delete")
    public String deleteMenuFormSubmit(@ModelAttribute ResepModel resep, Model model) {
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()) {
            obatService.deleteObatById(obat.getId());
        }
        return "delete-obat";
    }

    // Latihan 3 Tutorial 4
    @GetMapping("/obat/add-multiple/{noResep}")
    private String addMultipleObatFormPage(@PathVariable Long noResep, Model model) {
        ResepModel resep = resepService.getResepByNomorResep(noResep).get();
        ArrayList<ObatModel> listObat = new ArrayList<ObatModel>();
        listObat.add(new ObatModel());
        resep.setListObat(listObat);
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{idRestoran}", params = { "addRow" })
    public String addRow(@ModelAttribute ResepModel resep, BindingResult bindingResult, Model model) {
        if (resep.getListObat() == null) {
            resep.setListObat(new ArrayList<ObatModel>());
        }
        resep.getListObat().add(new ObatModel());

        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{idRestoran}", params = { "removeRow" })
    public String removeRow(@ModelAttribute ResepModel resep, final BindingResult bindingResult,
            final HttpServletRequest req, Model model) {
        final int rowIndex = Integer.valueOf(req.getParameter("removeRow"));
        resep.getListObat().remove(rowIndex);
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{idRestoran}", params = { "save" })
    private String addObatSubmitForm(@ModelAttribute ResepModel resep, Model model) {
        ResepModel currentResep = resepService.getResepByNomorResep(resep.getNoResep()).get();
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()) {
            obat.setResepModel(currentResep);
            obatService.addObat(obat);
        }
        return "add-multi-obat";
    }
}
