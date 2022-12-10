package org.example.helloworld;

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map


class HelloWorldService : GreeterGrpcKt.GreeterCoroutineImplBase() {
//    private val log: Logger = LoggerFactory.getLogger(HelloWorldService::class.java)

    override fun sayHello(request: HelloRequest): Flow<HelloReply> {
        println(request)
        return (0..10).asFlow().map {
            delay(300)
            helloReply {
                message = "Hello ${request.name} $it"
                number = (0..100000).random()
                some.addAll(listOf("age", request.age.toString()))
            }
        }
    }
}