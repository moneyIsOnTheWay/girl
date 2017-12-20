package com.example.girl.service;

import com.example.girl.emums.ResultEnum;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import com.example.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(14);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(15);
        girlRepository.save(girlB);
    }


    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
            //小学
        }else if( age >= 10 && age < 16){
            //初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else if(age >=16 && age < 22){
            throw new GirlException(ResultEnum.LARGER_SCHOOL);
        }else {
            //其他
            throw new GirlException(ResultEnum.LIFE);
        }

    }

}
