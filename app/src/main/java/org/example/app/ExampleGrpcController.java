package org.example.app;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import sf.v1.HelloWorldServiceGrpc;
import sf.v1.Sfv1;

@GrpcService
@RequiredArgsConstructor
public class ExampleGrpcController extends
        HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    private final ExampleService exampleService;

    @Override
    public StreamObserver<Sfv1.HelloWorldRequest> sayHello(
            StreamObserver<Sfv1.HelloWorldResponse> responseObserver) {
        return StreamObserverUtility.proxyStream(responseObserver,
                it -> this.hello(it.getName()));
    }

    private Sfv1.HelloWorldResponse hello(String message) {
        return Sfv1.HelloWorldResponse.newBuilder()
                    .setGreeting(exampleService.hello(message))
                    .build();
    }
}
