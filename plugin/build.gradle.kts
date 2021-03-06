plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    `maven-publish`
    id("com.github.johnrengelman.shadow")
    id("org.jmailen.kotlinter")
}

group = "com.github.cs125-illinois"
version = "2021.3.1"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(gradleApi())
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.apache.commons:commons-text:1.9")
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.11.0.202103091610-r")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.12.2")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.16.0")
}
gradlePlugin {
    plugins {
        create("plugin") {
            id = "com.github.cs125-illinois.gradlegrader"
            implementationClass = "edu.illinois.cs.cs125.gradlegrader.plugin.GradleGraderPlugin"
        }
    }
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
publishing {
    publications {
        create<MavenPublication>("gradlegrader") {
            artifactId = "gradlegrader"
            from(components["java"])
        }
    }
}
