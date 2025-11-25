package com.csen160.database.services;

import com.csen160.database.domain.entities.Author;
import com.csen160.database.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);

    List<Author> findAll();

    Optional<Author> findOne(Long id);

    boolean isExists(Long id);

    Author partialUpdate(Long id, Author author);

    void delete(Long id);

    public Author update(Long id, AuthorDto dto);
}
