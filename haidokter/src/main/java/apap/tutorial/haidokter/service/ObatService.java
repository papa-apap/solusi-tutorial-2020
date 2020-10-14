package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;

public interface ObatService {
    void addObat(ObatModel obat);

    ObatModel getObatById(Long idObat);

    ObatModel changeObat(ObatModel obat);

    void deleteObatById(Long idObat);
}
