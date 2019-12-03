plugins {
    kotlin("jvm")
}

dependencies {
    compile(project(":module-core"))
    implementation(kotlin("stdlib-jdk8"))
}