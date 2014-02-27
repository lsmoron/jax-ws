package client;

import client.test.TestService;
import client.test.TestServiceService;

/**
 * Created by luke on 2/26/14.
 */
public class ClientTest {
    public static void main(String[] argv) {
        TestService  testService = new TestServiceService().getTestServicePort();
        System.out.println(testService.sayHelloWorldFrom("bb"));
    }
}
