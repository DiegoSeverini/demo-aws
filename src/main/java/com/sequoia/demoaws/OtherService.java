package com.sequoia.demoaws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtherService {
    private final MyDomainObjectRepository repository;
}
