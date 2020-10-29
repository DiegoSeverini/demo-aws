package com.sequoia.demoaws;

import com.amazonaws.services.sqs.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
class OnReadyPublishAndRead {
    private final SqsMessageSenderService service;

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        Message payload = new Message();
        payload.setMessageId(UUID.randomUUID().toString());
        service.sendMessage(new MyDomainObject(1, UUID.randomUUID().toString(), UUID.randomUUID().toString() + " name", new Date()));
    }
}
