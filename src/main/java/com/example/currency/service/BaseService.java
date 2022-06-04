package com.example.currency.service;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BaseService<Response, Request> {
    Response save(Request t);

    List<Response> getAll();

    Response findById(Long id) throws ChangeSetPersister.NotFoundException;

    Boolean delete(Long id);
}