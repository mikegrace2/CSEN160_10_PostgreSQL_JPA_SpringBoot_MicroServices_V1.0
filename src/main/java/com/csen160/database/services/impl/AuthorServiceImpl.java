package com.csen160.database.services.impl;

import com.csen160.database.domain.entities.Author;
import com.csen160.database.domain.dto.AuthorDto;
import com.csen160.database.repositories.AuthorRepository;
import com.csen160.database.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return StreamSupport.stream(authorRepository
                        .findAll()
                        .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Author> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public Author partialUpdate(Long id, Author author) {
        author.setId(id);

        return authorRepository.findById(id).map(existingAuthor -> {
            Optional.ofNullable(author.getName()).ifPresent(existingAuthor::setName);
            Optional.ofNullable(author.getAge()).ifPresent(existingAuthor::setAge);
            return authorRepository.save(existingAuthor);
        }).orElseThrow(() -> new RuntimeException("Author does not exist"));
    }

    public Author update(Long id, AuthorDto dto) {
        Author existing = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        return authorRepository.save(existing); // managed entity
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
