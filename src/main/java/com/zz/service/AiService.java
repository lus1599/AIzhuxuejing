
package com.zz.service;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AiService {

    private static final String API_KEY = ""; // 这里建议从配置文件读取
    private static final String MODEL_NAME = "qwen-plus"; // 你可以更换其他模型

    public String chatWithAi(String userInput) {
        try {
            Generation gen = new Generation();

            Message systemMsg = Message.builder()
                    .role(Role.SYSTEM.getValue())
                    .content("你要扮演台江县民族中学智能助学金管理信息系统的角色来回答")
                    .build();

            Message userMsg = Message.builder()
                    .role(Role.USER.getValue())
                    .content(userInput)
                    .build();

            GenerationParam param = GenerationParam.builder()
                    .apiKey(API_KEY) // 这里建议从配置文件读取，而不是硬编码
                    .model(MODEL_NAME)
                    .messages(Arrays.asList(systemMsg, userMsg))
                    .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                    .build();

            GenerationResult result = gen.call(param);

            return JsonUtils.toJson(result);
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            return "调用AI服务时发生错误：" + e.getMessage();
        }
    }
}
