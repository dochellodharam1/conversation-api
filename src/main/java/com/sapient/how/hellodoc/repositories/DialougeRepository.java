package com.sapient.how.hellodoc.repositories;

import com.sapient.how.hellodoc.model.Dialogue;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialougeRepository extends PagingAndSortingRepository<Dialogue, String> {
}
