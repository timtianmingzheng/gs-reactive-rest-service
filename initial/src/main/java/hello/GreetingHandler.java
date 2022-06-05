package hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Mono<GreetingRequest> greetingRequestMono = request.bodyToMono(GreetingRequest.class);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(greetingRequestMono.map((req -> new Greeting("Hello, " + req.getName() + "!"))), Greeting.class);
    }
}