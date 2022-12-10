plugins {
    application
    kotlin("jvm")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    implementation(project(":stub"))
    runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")
}

tasks.register<JavaExec>("HelloWorldClient") {
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.helloworld.HelloWorldClientKt")
}

//tasks.register<JavaExec>("RouteGuideClient") {
//    dependsOn("classes")
//    classpath = sourceSets["main"].runtimeClasspath
//    mainClass.set("org.example.routeguide.RouteGuideClientKt")
//}
//
//tasks.register<JavaExec>("AnimalsClient") {
//    dependsOn("classes")
//    classpath = sourceSets["main"].runtimeClasspath
//    mainClass.set("org.example.animals.AnimalsClientKt")
//}

val helloWorldClientStartScripts = tasks.register<CreateStartScripts>("helloWorldClientStartScripts") {
    mainClass.set("org.example.helloworld.HelloWorldClientKt")
    applicationName = "hello-world-client"
    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
}

//val routeGuideClientStartScripts = tasks.register<CreateStartScripts>("routeGuideClientStartScripts") {
//    mainClass.set("org.example.routeguide.RouteGuideClientKt")
//    applicationName = "route-guide-client"
//    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
//    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
//}
//
//val animalsClientStartScripts = tasks.register<CreateStartScripts>("animalsClientStartScripts") {
//    mainClass.set("org.example.animals.AnimalsClientKt")
//    applicationName = "animals-client"
//    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
//    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
//}

tasks.named("startScripts") {
    dependsOn(helloWorldClientStartScripts)
//    dependsOn(routeGuideClientStartScripts)
//    dependsOn(animalsClientStartScripts)
}
