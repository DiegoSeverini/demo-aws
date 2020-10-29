package com.sequoia.demoaws;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

@SpringBootTest
@Import(AwsTestConfiguration.class)
@ActiveProfiles("integration")
@Testcontainers
class DemoAwsApplicationTests {

    @Container
    static LocalStackContainer localStack = new LocalStackContainer("0.10.0")
            .withServices(SQS)
            .withEnv("DEFAULT_REGION", "eu-east-2");

    @SneakyThrows
    @BeforeAll
    static void before() {
        localStack.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", "my-queue");
    }

    @Test
    void contextLoads() {

    }

}
