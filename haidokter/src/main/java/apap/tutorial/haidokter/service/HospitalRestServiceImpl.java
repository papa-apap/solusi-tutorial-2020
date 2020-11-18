package apap.tutorial.haidokter.service;

import org.springframework.stereotype.Service;
import apap.tutorial.haidokter.rest.Setting;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalRestServiceImpl implements HospitalRestService {
    private final WebClient webClient;

    public HospitalRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hospitalUrl).build();
    }

    @Override
    public Mono<String> getHospitalsinState(String state) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("state", state).build())
                .retrieve().bodyToMono(String.class);
    }
}
