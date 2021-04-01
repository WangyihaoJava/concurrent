package com.example.concurrent.exception;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyihao
 * @ClassName ExceptionController
 * @date 2020/12/18 14:58
 * @Description
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {

    @RequestMapping("/resourceNotFound")
    public void throwException() {
        Person p=new Person(1L,"SnailClimb");
        throw new ResourceNotFoundException(ImmutableMap.of("person id:", p.getId()));
    }

}