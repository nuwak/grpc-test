package org.example.helloworld

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.Closeable
import java.util.concurrent.TimeUnit

class HelloWorldClient(private val channel: ManagedChannel) : Closeable {
    private val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)

    suspend fun greet(name: String) {
        val request = helloRequest {
            this.name = name
            age = (10..50).random()
        }
        val response = stub.sayHello(request)
        response.map {
            println("res")
            println(it)
        }.collect()
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}

suspend fun main(args: Array<String>) {
    val port = 50051

    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build()

    val client = HelloWorldClient(channel)

    val user = args.singleOrNull() ?: "world"
    client.greet(user)
}
