package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ObatServiceImpl implements ObatService {
    @Autowired
    ObatDb obatDb;

    @Override
    public void addObat(ObatModel obat) {
        obatDb.save(obat);
    }

    @Override
    public ObatModel getObatById(Long idObat) {
        return obatDb.findObatModelById(idObat);
    }

    @Override
    public ObatModel changeObat(ObatModel obat) {
        obatDb.save(obat);

        return obat;
    }

    @Override
    public void deleteObatById(Long idObat) {
        obatDb.deleteById(idObat);
    }
}
