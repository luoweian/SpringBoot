package com.willam.girl.service;/*
 *Created by William on 2017/11/12 0012
 */

import com.willam.girl.repository.GirlRepository;
import com.willam.girl.entity.GirlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlSerivce {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void intserTwo(){
        GirlTable girlA = new GirlTable();
        girlA.setAge(29);
        girlA.setCupSize("F");
        girlRepository.save(girlA);

        GirlTable girlB = new GirlTable();
        girlB.setAge(19);
        girlB.setCupSize("C");
        girlRepository.save(girlB);
    }
}
