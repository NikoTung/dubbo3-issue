package com.example.provider.app.config;

public class BeanToInject {

    private final BeanProperties properties;

    public BeanToInject(BeanProperties properties) {
        this.properties = properties;
    }

    public boolean isEnabled() {
        return properties.isEnabled();
    }

}
