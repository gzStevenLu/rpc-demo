package com.stevenlu.rpc.demo;

import java.util.ArrayList;
import java.util.List;

public class Consumer {

    private HelloService helloService;

    public Consumer() {
        this.helloService = RPCFramework.referService(HelloService.class, "localhost", 9203);
    }

    public String callHello(String name) {
        return helloService.sayHello(name);
    }

    public static void main(String[] args) {
        Consumer client = new Consumer();

        List<String> nameList = new ArrayList<>();
        nameList.add("Steven");
        nameList.add("Alibaba");
        nameList.add("Netease");
        nameList.add("Tencent");

        // Java 8 流式编程
        nameList.parallelStream().map(client::callHello).forEach(System.out::println);
    }
}
