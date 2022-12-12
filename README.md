### Examples

- https://github.com/saturnism/grpc-by-example-java
- https://github.com/petrelevich/jvm-digging/tree/master/gRPC
- https://github.com/grpc/grpc-kotlin/tree/master/examples
- https://github.com/georgy-n/grpc-experiments
- https://github.com/grpc/grpc-java/tree/master/examples/src/main/java/io/grpc/examples
- https://github.com/godspeedchu/grpc-realworld-example

### libs

- [gRPC Spring Boot Starter](https://github.com/yidongnan/grpc-spring-boot-starter)
- [gRPC Kotlin - Coroutine based gRPC for Kotlin](https://github.com/rouzwawi/grpc-kotlin)
- https://github.com/grpc/grpc-kotlin
- https://github.com/apple/servicetalk
  - ServiceTalk is a JVM network application framework with APIs tailored to specific protocols (e.g. HTTP/1.x, HTTP/2.x, etc…​)
- https://github.com/stargate/stargate
    - An open source data API gateway.
    - Stargate is a data gateway deployed between client applications and a Cassandra database.
- https://github.com/line/armeria
    - https://armeria.dev/docs
        - Your go-to microservice framework for any situation, from the creator of Netty et al. You can build any type
          of
          microservice leveraging your favorite technologies, including gRPC, Thrift, Kotlin, Retrofit, Reactive
          Streams,
          Spring Boot and Dropwizard.
        - [Trustin Lee — Armeria: A microservice framework well-suited everywhere](https://www.youtube.com/watch?v=Vr-0GKUmzo8)
            - https://www.youtube.com/watch?v=4F0iQlz1KSc

### Docs

- [grpc-java](https://github.com/grpc/grpc-java)
- [Георгий Набойченко, Тинькофф - Как мы gRPC в проект тащили](https://www.youtube.com/watch?v=9WYTyTi_q38)
- [TECH SCHOOL](https://www.youtube.com/@TECHSCHOOLGURU)
- [Александр Борисов — Перенимаем опыт Google в построении микросервисов с gRPC](https://www.youtube.com/watch?v=zPbaKUIcFx0)
- [Python и сеть: REST, JSON, GraphQL или gRPC? / Григорий Петров](https://www.youtube.com/watch?v=XXzjxZH9ZUI)

### Tutorials

- https://grpc.io/docs/languages/kotlin/quickstart/
- [Secure gRPC connection with SSL/TLS | Interceptor | Metadata | Spring Boot | BloomRPC](https://www.youtube.com/watch?v=z0qg_PZdliU)

### Sharing gRPC protobufs between microservices

- https://docs.buf.build/introduction
- https://jozefcipa.com/blog/sharing-grpc-protobufs-between-microservices/
- https://github.com/grpc/grpc/blob/master/doc/server-reflection.md
- https://stackoverflow.com/questions/55922886/how-to-share-protobuf-definitions-for-grpc

## todo

- [ ] logging
- [ ] native-client for stream?
- [ ] 
  watch [[gRPC #15] Implement gRPC interceptor + JWT authentication in Go](https://www.youtube.com/watch?v=kVpB-uH6X-s&list=PLy_6D98if3UJd5hxWNfAqKMr15HZqFnqf&index=20)
- [x] headers?
- [x] intercept

### Mapping DTO

- [Mapping between Domain and DTO classes for gRPC APIs](https://lorefnon.me/2021/12/15/mapping-between-domain-and-dtos-for-grpc/)
- https://github.com/mapstruct/mapstruct
- https://github.com/modelmapper/modelmapper
    - https://techwithmaddy.com/replace-persistence-entity-with-a-dto-object
    - https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
- [Bring gRPC payloads and domain models closer with ScalaPB transformations](https://medium.com/teads-engineering/bring-grpc-payloads-and-domain-models-closer-with-scalapb-transformations-b23a7115d427)
    - [Protocol buffer compiler for Scala.](https://scalapb.github.io/docs/getting-started)

### tools

- https://json-to-proto.github.io/
- [Kotlin Code Generator and Runtime for Protocol Buffers](https://github.com/streem/pbandk)
- https://github.com/ktr0731/evans
- https://github.com/fullstorydev/grpcurl
- https://github.com/bloomrpc/bloomrpc

### grpc rest gateway

- https://techdozo.dev/restful-api-gatewat-with-grpc/
- https://medium.com/@thinhda/build-service-that-provides-http-and-grpc-api-with-spring-9e7cff7aa17a
- https://github.com/grpc-ecosystem/grpc-gateway

#### other

- https://zio.dev/ecosystem/community/zio-saga
- https://zio.dev/ecosystem/community/zio-grpc
- https://github.com/scalapb/zio-grpc
- https://habr.com/ru/search/?q=grpc&target_type=posts&order=relevance
- [Дмитрий Бугайченко — gRPC client-side load balancing — зачем, что, как и WTF?](https://www.youtube.com/watch?v=TD8qZgAtqRs)
- https://github.com/Netflix/conductor
    - Conductor is a platform created by Netflix to orchestrate workflows that span across microservices.
    - [Netflix Conductor demo: sequential HTTP REST requests](https://www.youtube.com/watch?v=zUIWC6Cj8GQ&list=PLa2RlPLMYyBU2MNJyPY5QE5oh3-Noh9GH)