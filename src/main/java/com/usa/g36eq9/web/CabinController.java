package com.usa.g36eq9.web;

import com.usa.g36eq9.model.Cabin;
import com.usa.g36eq9.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/all")
    public List<Cabin> getCabins(){
        return cabinService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int id){
        return cabinService.getCabin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin b){
        return cabinService.save(b);
    }

    @PutMapping("/update")
    public Cabin update(@RequestBody Cabin b){
        return cabinService.update(b);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return cabinService.delete(id);
    }
}
