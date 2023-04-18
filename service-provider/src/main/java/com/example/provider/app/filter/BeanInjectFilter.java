package com.example.provider.app.filter;

import com.example.provider.app.config.BeanToInject;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

@Activate(group = PROVIDER, order = 1)
public class BeanInjectFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(BeanInjectFilter.class);


    private BeanToInject beanToInject;

//    private BeanProperties beanProperties;

    //Spring inject
    public void setBeanToInject(BeanToInject beanToInject) {
        this.beanToInject = beanToInject;
    }

//    public void set(BeanProperties beanToInject) {
//        this.beanProperties = beanToInject;
//    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation inv) throws RpcException {
        try {
            logger.info("Properties enabled status {}", beanToInject.isEnabled());
        } catch (Exception ex) {
            logger.error("BeanToInject is null.", ex);
        }
        return invoker.invoke(inv);
    }

}
