package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.repositories.CakeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Transactional
    public List<Cake> findAll(){
       return cakeRepository.findAll();
    }

    @Transactional
    public void saveCake(Cake cake){
            cakeRepository.save(cake);
        }

    @Transactional
    public void updateCake(int id, Cake cakeUpdate){
        Cake cake = cakeRepository.findById(id).orElse(null);
        assert cake != null;
        cake.setNameCake(cakeUpdate.getNameCake());
        cake.setDescriptionCake(cakeUpdate.getDescriptionCake());
        if(cakeUpdate.getImage() != null && !cakeUpdate.getImage().equals("")){
            cake.setImage(cakeUpdate.getImage());
        }
        cakeRepository.save(cake);
    }


    public Optional<Cake> findCakeByID(int id){
        Optional<Cake> cake = cakeRepository.findById(id);
        return cake;
    }

    public void deleteCakeById(int id){
        cakeRepository.deleteById(id);
    }
}
