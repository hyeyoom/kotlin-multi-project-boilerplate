import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    base
    kotlin("jvm") version "1.3.50" apply false
    kotlin("plugin.spring") version "1.3.50" apply false
    kotlin("plugin.jpa") version "1.3.50" apply false

    id("org.springframework.boot") version "2.1.1.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
}

allprojects {
    group = "com.github.hyeyoom"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    /*apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }*/

    tasks.withType<KotlinCompile>().configureEach {
        println("Configuring $name in project ${project.name}...")
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
