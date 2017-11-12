package com.willam.girl.controller;
/*
 *Created by William on 2017/11/11 0011
 */

import com.willam.girl.properties.Result;
import com.willam.girl.repository.GirlRepository;
import com.willam.girl.entity.GirlTable;
import com.willam.girl.service.GirlSerivce;
import com.willam.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlSerivce girlSerivce;
    /**
     * 查询所以女生列表
     * @return
//     */
    @GetMapping(value = "/girl")
    public List<GirlTable> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 增，插入一条新数据
     * @return
     */
    @PostMapping(value = "/girl")
    public Result<GirlTable> girlAdd(@Valid GirlTable girl, BindingResult bindingResult){
        ResultUtil resultUtil = new ResultUtil();
        if(bindingResult.hasErrors()){
//            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return resultUtil.setData(1,bindingResult.getFieldError().getDefaultMessage(),null);
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return resultUtil.setData(0,"成功",girlRepository.save(girl));
    }

    /**
     * 通过id查数据，一条
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public GirlTable girlQueryThroughId(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新数据
     * @param id
     */
    @PutMapping(value = "/girl/{id}")
    public GirlTable girlUpdate(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){

        GirlTable girlTable = new GirlTable();
        girlTable.setId(id);
        girlTable.setCupSize(cupSize);
        girlTable.setAge(age);
        return girlRepository.save(girlTable);
    }

    @DeleteMapping(value = "/girl/{id}")
    public String girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return "id ="+ id + " has been deleted";
    }

    @GetMapping(value = "/girl/girlQueryThroughIdReturnCupSize/{id}")
    public String girlQueryThroughIdReturnCupSize(@PathVariable("id") Integer id){
        GirlTable girl = new GirlTable();
        girl = girlRepository.getOne(id);
        return id+"号， cupSize为： "+girl.getCupSize();
    }

    @PostMapping(value = "girl/two")
    public void girlTwo(){
        girlSerivce.intserTwo();
    }
}
