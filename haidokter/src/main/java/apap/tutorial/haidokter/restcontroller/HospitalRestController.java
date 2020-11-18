package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.service.HospitalRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {
    @Autowired
    private HospitalRestService hospitalRestService;

    @GetMapping("/find")
    private Mono<String> getHospitalsinState(@RequestParam(value = "state") String state) {
        return hospitalRestService.getHospitalsinState(state);
    }
}
