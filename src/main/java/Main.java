import testServices.HelloWorldService;

import java.util.ServiceLoader;

public class Main {

    static ServiceLoader<HelloWorldService> helloWorldServices = ServiceLoader.load(HelloWorldService.class);

    public static void main(String[] args) {
        for (HelloWorldService helloWorldService : helloWorldServices) {
            helloWorldService.sayHello();
        }
    }
}
