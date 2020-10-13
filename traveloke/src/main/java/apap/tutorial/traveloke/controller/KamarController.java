package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    // @GetMapping("/kamar/add/{idHotel}")
    // private String addKamarFormPage(
    //         @PathVariable Long idHotel,
    //         Model model
    // ){
    //     KamarModel kamar = new KamarModel();
    //     HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
    //     kamar.setHotel(hotel);
    //     model.addAttribute("kamar", kamar);
    //     model.addAttribute("hotel", hotel);
    //     model.addAttribute("idHotel", idHotel);

    //     return "form-add-kamar";
    // }

    @RequestMapping(value = "/kamar/add/{idHotel}")
    private String add(@PathVariable(value = "idHotel") Long idHotel, Model model) {
        model.addAttribute("titleTab", "Add La,ar");
        HotelModel hotel = new HotelModel();
        hotel.setListKamar(new ArrayList<KamarModel>());
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel);
        model.addAttribute("idHotel", idHotel);
        return "form-add-kamar";
    }

    @RequestMapping(value = "/kamar/add/{idHotel}", method = RequestMethod.POST, params= {"save"})
    private String addMenuSubmit(@PathVariable(value = "idHotel") Long idHotel, @ModelAttribute HotelModel hotel, ModelMap model) {
        model.addAttribute("titleTab", "Add Menu");
        HotelModel oldHotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("kamarCount", hotel.getListKamar().size());

        model.addAttribute("idHotel", idHotel);
        for (KamarModel kamar : hotel.getListKamar()) {
            kamar.setHotel(oldHotel);
            kamarService.addKamar(kamar);
        }
        return "add-kamar";
    }

    @RequestMapping(value = "/kamar/add/{idHotel}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@PathVariable(value = "idHotel") Long idHotel, @ModelAttribute HotelModel hotel, Model model) {
        model.addAttribute("titleTab", "Add Menu");
        KamarModel kamar = new KamarModel();
        hotel.getListKamar().add(kamar);
        model.addAttribute("hotel", hotel);
        model.addAttribute("idHotel", idHotel);
        return "form-add-kamar";
    }

    @RequestMapping(value = "/kamar/add/{idHotel}", method = RequestMethod.POST, params={"removeRow"})
    private String removeRow(@PathVariable(value = "idHotel") Long idHotel,@ModelAttribute HotelModel hotel, Model model, HttpServletRequest req) {
        Integer rowId =  Integer.valueOf(req.getParameter("removeRow"));
        hotel.getListKamar().remove(rowId.intValue());
        model.addAttribute("hotel", hotel);
        model.addAttribute("idHotel", idHotel);
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

    @GetMapping(value = "/kamar/change/{noKamar}")
    public String changeKamarFormPage(@PathVariable Long noKamar, Model model){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.changeKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "update-kamar";
    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        
        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }

        return "delete-kamar";
    }

    // @GetMapping(path = "/kamar/delete/{noKamar}")
    // public String deleteWithPathVariable(
    //         @PathVariable(value = "noKamar", required = true) Long noKamar,
    //         Model model
    // ){
    //     KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
    //     kamarService.deleteKamar(kamar);

    //     model.addAttribute("kamar", kamar);

    //     return "delete-kamar";
    // }
}
