package com.sequoia.demoaws;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;


@Testcontainers
@Import(AwsTestConfiguration.class)
@ActiveProfiles("test")
@SpringBootTest
class SqsMessageSenderServiceTest {

    @Container
    static LocalStackContainer localStack = new LocalStackContainer("0.10.0")
            .withServices(SQS)
            .withEnv("DEFAULT_REGION", "eu-east-2");

    @SneakyThrows
    @BeforeAll
    static void before() {
        localStack.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", "my-queue");
    }

    @Autowired
    private SqsMessageSenderService target;

    @Test
    void testSendMessage() {
        target.sendMessage(new MyDomainObject(1, "from test", "from test", new Date()));
    }
}
