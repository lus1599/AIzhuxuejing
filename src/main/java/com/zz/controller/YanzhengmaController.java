package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.service.YanzhengmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/code")
public class YanzhengmaController {
    @Autowired
    private YanzhengmaService yanzhengmaService;

    @RequestMapping
    public ResultData code(){
        return ResultData.ok(yanzhengmaService.create());
    }
}
