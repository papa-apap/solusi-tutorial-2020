package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResepServiceImpl implements ResepService {
    @Autowired
    ResepDb resepDb;

    @Override
    public void addResep(ResepModel resep) {
        resepDb.save(resep);
    }

    @Override
    public List<ResepModel> getResepList() {
        return resepDb.findAllByOrderByNoResepDesc();
    }

    @Override
    public Optional<ResepModel> getResepByNomorResep(Long noResep) {
        return resepDb.findByNoResep(noResep);
    }

    @Override
    public ResepModel updateResep(ResepModel resep) {
        resepDb.save(resep);

        return resep;
    }

    @Override
    public void deleteResep(Long noResep) {
        resepDb.deleteById(noResep);
    }
}


