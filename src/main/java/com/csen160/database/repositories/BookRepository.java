package com.csen160.database.repositories;

import com.csen160.database.domain.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String>,
        PagingAndSortingRepository<Book, String> {
}
