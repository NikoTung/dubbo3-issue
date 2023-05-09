## Require JDK 17 and above, docker and docker-compose

## Build
```
    ./build.sh
```
## Run
```agsl
    cd docker
    docker-compose up -d
```
## Check logs 

```agsl
    docker logs -f provider
    docker logs -f consumer
```

In the provider logs, the `NullPointException` for the metaService request from consumer.
```agsl
    java.lang.NullPointerException: Cannot invoke "com.example.provider.app.config.BeanToInject.isEnabled()" because "this.beanToInject" is null
        at com.example.provider.app.filter.BeanInjectFilter.invoke(BeanInjectFilter.java:34) ~[classes!/:0.0.1-SNAPSHOT]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.protocol.dubbo.filter.TraceFilter.invoke(TraceFilter.java:79) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.filter.TimeoutFilter.invoke(TimeoutFilter.java:44) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.monitor.support.MonitorFilter.invoke(MonitorFilter.java:101) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.filter.ExceptionFilter.invoke(ExceptionFilter.java:54) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.filter.AccessLogFilter.invoke(AccessLogFilter.java:118) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.metrics.observation.ObservationReceiverFilter.invoke(ObservationReceiverFilter.java:56) ~[dubbo-3.2.0.jar!/:3.2.0]
        at org.apache.dubbo.rpc.cluster.filter.FilterChainBuilder$CopyOfFilterChainNode.invoke(FilterChainBuilder.java:331) ~[dubbo-3.2.0.jar!/:3.2.0]
```

Run the curl command to request to provider,the filter is invoked without `NullPointException`. It will print the log `Properties enabled status true`
```agsl
    curl -X GET --location "http://localhost:8801/call/echo"
```

## Nacos console

Login nacos console [http://127.0.0.1:8848/nacos/](http://127.0.0.1:8848/nacos/),only the provider list on it.