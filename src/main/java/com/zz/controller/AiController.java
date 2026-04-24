//
//package com.zz.controller;
//
//import com.zz.service.AiService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/ai")
//public class AiController {
//
//    @Resource
//    private AiService aiService;
//
//    @GetMapping("/chat")
//    public String chat(@RequestParam String message) {
//        return aiService.chatWithAi(message);
//    }
//}


package com.zz.controller;

import com.google.gson.Gson;
import com.zz.entities.AiApi;
import com.zz.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ai")
@CrossOrigin
public class AiController {

    @Autowired
    private AiService aiService;

    @GetMapping("/chat")
    public String chatWithAi(@RequestParam String userInput) {
        String response = aiService.chatWithAi(userInput);
        Gson gson = new Gson();
        AiApi result = gson.fromJson(response, AiApi.class);
        return result.getOutput().getChoices().get(0).getMessage().getContent();
    }
}

