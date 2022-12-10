package org.example.helloworld

import io.grpc.*

class ServerGrpc(private val port: Int) {
    internal class BookServerInterceptor : ServerInterceptor {
        override fun <ReqT : Any?, RespT : Any?> interceptCall(
            call: ServerCall<ReqT, RespT>?,
            headers: io.grpc.Metadata?,
            next: ServerCallHandler<ReqT, RespT>?
        ): ServerCall.Listener<ReqT> {
            println("Recieved following metadata: $headers")
            val im = Metadata.Key.of("A-IM", Metadata.ASCII_STRING_MARSHALLER)
            println(im)
            println(headers?.get(im))
            return next?.startCall(call, headers) ?: error("error")
        }
    }

    val server: Server = ServerBuilder
        .forPort(port)
        .addService(HelloWorldService())
        .intercept(BookServerInterceptor())
        .build()

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@ServerGrpc.stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 50051
    val server = ServerGrpc(port)
    server.start()
    server.blockUntilShutdown()
}