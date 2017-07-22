package com.vaytee.shapes.history;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Admin on 2017-07-22.
 */
@RepositoryRestResource(collectionResourceRel = "history", path = "history")
public interface HistoryRepository extends MongoRepository<HistoryItem, String> {
}
