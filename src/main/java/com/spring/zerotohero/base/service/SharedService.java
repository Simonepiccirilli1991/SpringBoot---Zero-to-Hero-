package com.spring.zerotohero.base.service;

import com.spring.zerotohero.base.model.shared.BaseProperty;
import com.spring.zerotohero.base.model.shared.Opera;
import com.spring.zerotohero.base.model.shared.OperaTemporanea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SharedService {


    private List<BaseProperty> opere = new ArrayList<>();


    public void aggiungiOpera(BaseProperty opera){

        opere.add(opera);

    }

    public List<BaseProperty> getOpere(){
        return opere;
    }

    public BaseProperty getOpera(Class <?> cls){

        var resp = opere.stream().filter( op -> cls.equals(op)).findFirst();

        if(resp.isPresent())
            return resp.get();

        else
            throw new RuntimeException();
    }
}
