import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "de.chriskn"
version = "0.0.1-SNAPSHOT"

plugins {
    val kotlinVersion = "1.3.60"
    val springVersion = "2.2.1.RELEASE"
    id("org.springframework.boot") version springVersion
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    mavenCentral()
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2") // Required for coroutines
    compile("org.jetbrains.kotlin:kotlin-stdlib") // Required for Kotlin integration
    compile("org.springframework.boot:spring-boot-starter-web")
    compile ("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testCompile("org.assertj:assertj-core")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}