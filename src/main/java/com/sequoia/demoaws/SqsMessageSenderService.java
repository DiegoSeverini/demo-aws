package com.sequoia.demoaws;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SqsMessageSenderService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public void sendMessage(MyDomainObject myDomainObject) {
        queueMessagingTemplate.convertAndSend(SqsConstants.OTHER_QUEUE, myDomainObject);
        log.info("message sent");
    }
}
