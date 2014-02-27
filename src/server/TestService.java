package server;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Map;

/**
 * Created by luke on 2/26/14.
 */
@WebService(targetNamespace = "http://test")
@HandlerChain(file= "server/handler-chain.xml")
public class TestService {
    @Resource
    WebServiceContext wsctx;
    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        MessageContext mctx = wsctx.getMessageContext();

        //get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new TestService();
        String address = "http://localhost:9000/TestService";
        Endpoint.publish(address, implementor);
    }
}
