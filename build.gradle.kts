plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.diffplug.spotless") version "7.0.0.BETA3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

spotless {
    yaml {
        target("src/**/*.yaml", "src/**/*.yml")
        jackson()
            // com.fasterxml.jackson.databind.SerializationFeature
            .feature("INDENT_OUTPUT", true)
            .feature("ORDER_MAP_ENTRIES_BY_KEYS", true)
            // com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature
            .yamlFeature("WRITE_DOC_START_MARKER", false)
            .yamlFeature("MINIMIZE_QUOTES", true)
    }
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
