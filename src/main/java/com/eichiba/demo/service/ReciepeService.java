package com.eichiba.demo.service;

import com.eichiba.demo.entitys.Reciepe;
import com.eichiba.demo.repository.ReciepeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReciepeService {

    @Autowired
    private ReciepeRepository reciepeRepository;

    public Reciepe saveReciepe(Reciepe reciepe){
        return reciepeRepository.save(reciepe);
    }

    public Reciepe getReciepe(String id){
        return reciepeRepository.getOne(Integer.parseInt(id));
    }

}
