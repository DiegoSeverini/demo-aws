package com.sequoia.demoaws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface MyDomainObjectRepository extends CrudRepository<MyDomainObject, Long> {
}
