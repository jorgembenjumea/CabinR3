package com.usa.g36eq9.service;

import com.usa.g36eq9.model.Cabin;
import com.usa.g36eq9.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin b){
        if(b.getId() == null){
            return cabinRepository.save(b);
        }else{
            Optional<Cabin> baux = cabinRepository.getCabin(b.getId());
            if(baux.isPresent()){
                return b;
            }else{
                return cabinRepository.save(b);
            }
        }
    }
    public Cabin update(Cabin b){
        if(b.getId() != null){
            Optional<Cabin> q = cabinRepository.getCabin(b.getId());
            if(q.isPresent()){
                if(b.getName() != null){
                    q.get().setName(b.getName());
                }
                if(b.getBrand() != null){
                    q.get().setBrand(b.getBrand());
                }
                if(b.getYear() != null){
                    q.get().setYear(b.getYear());
                }
                if(b.getDescription() != null){
                    q.get().setDescription(b.getDescription());
                }
                if(b.getCategory() != null){
                    q.get().setCategory(b.getCategory());
                }
                cabinRepository.save(q.get());
                return q.get();
            }else{
                return b;
            }
        }else{
            return b;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Cabin> b = cabinRepository.getCabin(id);
        if(b.isPresent()){
            cabinRepository.delete(b.get());
            flag = true;
        }
        return flag;
    }
}
