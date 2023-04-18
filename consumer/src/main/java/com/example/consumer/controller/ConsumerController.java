package com.example.consumer.controller;

import com.example.api.EchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "call")
public class ConsumerController {

    @DubboReference
    private EchoService echoService;

    @GetMapping("echo")
    public String echo() {
        return echoService.ping();
    }
}
