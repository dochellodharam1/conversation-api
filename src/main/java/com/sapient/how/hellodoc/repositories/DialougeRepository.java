package com.sapient.how.hellodoc.repositories;

import com.sapient.how.hellodoc.model.Dialogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialougeRepository extends MongoRepository<Dialogue, String> {
}
