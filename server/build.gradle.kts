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
//    implementation("ch.qos.logback:logback:0.5")
    runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")

    testImplementation(kotlin("test-junit"))
    testImplementation("io.grpc:grpc-testing:${rootProject.ext["grpcVersion"]}")
}

tasks.register<JavaExec>("HelloWorldServer") {
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
//    mainClass.set("org.example.helloworld.HelloWorldServerKt")
    mainClass.set("org.example.helloworld.MainKt")
}

//tasks.register<JavaExec>("RouteGuideServer") {
//    dependsOn("classes")
//    classpath = sourceSets["main"].runtimeClasspath
//    mainClass.set("org.example.routeguide.RouteGuideServerKt")
//}
//
//tasks.register<JavaExec>("AnimalsServer") {
//    dependsOn("classes")
//    classpath = sourceSets["main"].runtimeClasspath
//    mainClass.set("org.example.animals.AnimalsServerKt")
//}

val helloWorldServerStartScripts = tasks.register<CreateStartScripts>("helloWorldServerStartScripts") {
    mainClass.set("org.example.helloworld.MainKt")
    applicationName = "hello-world-server"
    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
}

//val routeGuideServerStartScripts = tasks.register<CreateStartScripts>("routeGuideServerStartScripts") {
//    mainClass.set("org.example.routeguide.RouteGuideServerKt")
//    applicationName = "route-guide-server"
//    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
//    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
//}
//
//val animalsServerStartScripts = tasks.register<CreateStartScripts>("animalsServerStartScripts") {
//    mainClass.set("org.example.animals.AnimalsServerKt")
//    applicationName = "animals-server"
//    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
//    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
//}

tasks.named("startScripts") {
    dependsOn(helloWorldServerStartScripts)
//    dependsOn(routeGuideServerStartScripts)
//    dependsOn(animalsServerStartScripts)
}

tasks.withType<Test> {
    useJUnit()

    testLogging {
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStandardStreams = true
    }
}
