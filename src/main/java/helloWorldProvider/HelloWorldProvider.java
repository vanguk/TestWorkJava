package helloWorldProvider;

import testServices.HelloWorldService;

public class HelloWorldProvider implements HelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
