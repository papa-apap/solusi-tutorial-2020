package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResepInMemoryService implements ResepService {
    private List<ResepModel> listResep;

    //  Constructor
    public ResepInMemoryService(){
        listResep= new ArrayList<>();
    }

    @Override
    public void addResep(ResepModel resep) {
        listResep.add(resep);
    }

    @Override
    public List<ResepModel> getResepList() {
        return listResep;
    }

    @Override
    public ResepModel getResepByNomorResep(String noResep) {
        for (ResepModel resep: listResep) {
            if(resep.getNoResep().equalsIgnoreCase(noResep)){
                return resep;
            }
        }
        return null;
    }

//    ==========LATIHAN=========


    @Override
    public ResepModel updateCatatanResep(ResepModel resep, String catatan) {
        resep.setCatatan(catatan);
        return resep;
    }

    @Override
    public ResepModel deleteResep(ResepModel resep) {
        listResep.remove(resep);
        return resep;
    }
}
