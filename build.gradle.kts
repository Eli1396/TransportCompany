plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.hibernate:hibernate-core:6.2.7.Final")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}