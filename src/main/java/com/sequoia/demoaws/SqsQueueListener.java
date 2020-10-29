package com.sequoia.demoaws;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SqsQueueListener {

    @SqsListener(value = SqsConstants.OTHER_QUEUE, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    void getMessageFromSqs(MyDomainObject message, @Header("MessageId") String messageId) {
        log.info("Message received: " + message);
        log.info(messageId);
    }
}
