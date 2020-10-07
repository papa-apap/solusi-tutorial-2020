package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    // Routing URL untuk menambahkan resep
    @RequestMapping("/resep/add")
    public String addResep(
            //   Request Parameter yang ingin dibawa
            @RequestParam(value = "noResep", required = true) String noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model
            ){
        //  Membuat objek ResepModel
        ResepModel resep= new ResepModel(noResep, namaDokter, namaPasien, catatan);

        //  Memanggil service addResep
        resepService.addResep(resep);

        //  Add variabel nomor resep ke 'nomorResep' untuk dirender pada thymeleaf
        model.addAttribute("nomorResep", noResep);

        //  Return view template yang ingin digunakan
        return "add-resep";
    }

    // Routing URL untuk mendapatkan list resep
    @RequestMapping("/resep/viewall")
    public String listResep(Model model){

        //  Mendapatkan semua ResepModel
        List<ResepModel> listResep= resepService.getResepList();

        //  Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
        model.addAttribute("listResep", listResep);

        //  Return view template yang ingin digunakan
        return "viewall-resep";
    }


//===================With Path===============================
    // Routing URL untuk melihat detail resep
    @RequestMapping("/resep/view/no-resep/{noResep}")
    public String detailResepPath(
            @PathVariable("noResep") String noResep,
            Model model){

        //  Cek apakah terdapat nomor resep yang diminta
        if(resepService.getResepByNomorResep(noResep) !=null){
            //  Mendapatkan ResepModel sesuai nomor resep
            ResepModel resep= resepService.getResepByNomorResep(noResep);

            //  Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
            model.addAttribute("resep", resep);

            //  Return view template yang ingin digunakan
            return "view-resep";
        }
        else{
            return "view-resep-error";
        }

    }

//========================== With Param=========================
// Routing URL untuk melihat detail resep
    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") String noResep,
            Model model){

        //  Cek apakah terdapat nomor resep yang diminta
        if(resepService.getResepByNomorResep(noResep) !=null) {
            //  Mendapatkan ResepModel sesuai nomor resep
            ResepModel resep = resepService.getResepByNomorResep(noResep);

            //  Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
            model.addAttribute("resep", resep);

            //  Return view template yang ingin digunakan
            return "view-resep";
        }
        else{
            return "view-resep-error";
        }

    }



//  ============Latihan============
    @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String updateResep(
            @PathVariable("noResep") String noResep,
            @PathVariable("catatan") String catatan,
            Model model){


        //  Cek apakah terdapat nomor resep yang diminta
        if(resepService.getResepByNomorResep(noResep) !=null) {
            //  Mendapatkan ResepModel sesuai nomor resep
            ResepModel resep = resepService.getResepByNomorResep(noResep);

            //  Melakukan pemanggilan service update catatan
            ResepModel resepUpdated = resepService.updateCatatanResep(resep, catatan);

            //  Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
            model.addAttribute("resep", resepUpdated);

            //  Return view template yang ingin digunakan
            return "update-resep";
        }
        else{
            return "update-resep-error";
        }
    }

    @RequestMapping("/resep/delete/no-resep/{noResep}")
    public String deleteResep(
            @PathVariable("noResep") String noResep,
            Model model){

        //  Cek apakah terdapat nomor resep yang diminta
        if(resepService.getResepByNomorResep(noResep) !=null) {
            //  Mendapatkan ResepModel sesuai nomor resep
            ResepModel resep = resepService.getResepByNomorResep(noResep);

            //  Melakukan pemanggilan service delete
            ResepModel resepDeleted = resepService.deleteResep(resep);

            //  Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
            model.addAttribute("resep", resepDeleted);

            //  Return view template yang ingin digunakan
            return "delete-resep";
        }
        else{
            return "delete-resep-error";
        }
    }

}

