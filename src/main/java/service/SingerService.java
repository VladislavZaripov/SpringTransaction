package service;

import entity.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    Long countAll();
}