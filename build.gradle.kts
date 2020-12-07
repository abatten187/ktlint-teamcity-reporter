import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "abatten187.ktlint-teamcity-reporter"
version = "0.1"

publishing {
    publications {
        create<MavenPublication>("ktlintTeamCityReporter") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "myRepo"
            url = uri("file://${buildDir}/repo")
        }
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.pinterest.ktlint:ktlint-core:0.40.0")
    testImplementation("junit:junit:4.13")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
