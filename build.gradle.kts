import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "de.itemis"
version = "0.0.1-SNAPSHOT"

plugins {
    val kotlinVersion = "1.3.11"
    val springVersion = "2.1.1.RELEASE"
    id("org.springframework.boot") version springVersion
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

repositories {
    mavenCentral()
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib") // Required for Kotlin integration
    compile("org.springframework.boot:spring-boot-starter-web")
    compile(group = "org.jetbrains.kotlinx", name= "kotlinx-coroutines-core", version= "1.1.0") // Required for coroutines
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testCompile("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}