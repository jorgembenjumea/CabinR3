package com.usa.g36eq9.repository;
import com.usa.g36eq9.model.Cabin;
import com.usa.g36eq9.repository.crud.CabinCrudReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudReposotory cabinCrudRepository;
    public List<Cabin> getAll(){
        return (List<Cabin>)cabinCrudRepository.findAll();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
    public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }
}
