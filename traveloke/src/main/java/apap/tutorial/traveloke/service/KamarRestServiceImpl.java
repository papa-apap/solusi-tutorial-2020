package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
    private final WebClient webClient;

    @Autowired
    private KamarDb kamarDb;

    public KamarRestServiceImpl(WebClient.Builder webClientuildeer){
        this.webClient = webClientuildeer.baseUrl(Setting.kamarUrl).build();
    }

    @Override
    public KamarModel createKamar(KamarModel kamar){ return kamarDb.save(kamar);}

    @Override
    public List<KamarModel> retriveListKamar() {return kamarDb.findAll();}

    @Override
    public KamarModel getKamarByIdKamar(Long idKamar){
        Optional<KamarModel> kamar = kamarDb.findById(idKamar);
        if(kamar.isPresent()){
            return kamar.get();
        } else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteKamar(Long idKamar){
        KamarModel kamar = getKamarByIdKamar(idKamar);
        kamarDb.delete(kamar);
    }

    @Override
    public KamarModel changeKamar(Long idKamar, KamarModel kamarUpdate){
        KamarModel kamar = getKamarByIdKamar(idKamar);
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        kamar.setNoKamar(kamarUpdate.getNoKamar());
        kamar.setTipe(kamarUpdate.getTipe());
        return kamarDb.save(kamar);
    }
}