package com.stevenlu.rpc.demo;

import java.io.IOException;

public class Provider implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public static void main(String[] args) throws IOException {
        Provider service = new Provider();
        RPCFramework.exportService(service, 9203);
    }

}
