package com.example.provider.app.service;

import com.example.api.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class EchoServiceImpl implements EchoService {
    @Override
    public String ping() {
        return "pong";
    }
}
