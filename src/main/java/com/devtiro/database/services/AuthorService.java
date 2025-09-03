package com.devtiro.database.services;

import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);

    boolean isExists(Long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void delete(Long id);

    public AuthorEntity update(Long id, AuthorDto dto);
}
