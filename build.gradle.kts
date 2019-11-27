import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "de.chriskn"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.50"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2") // Required for coroutines
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    testImplementation("io.mockk:mockk:1.9")
    testCompile("org.assertj:assertj-core:3.6.1")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}

val test by tasks.getting(Test::class) {
        useJUnitPlatform()
}

