package apap.tutorial.haidokter.service;

import reactor.core.publisher.Mono;

public interface HospitalRestService {
    Mono<String> getHospitalsinState(String state);
}
