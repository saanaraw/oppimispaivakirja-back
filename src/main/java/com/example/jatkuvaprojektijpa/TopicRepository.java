package com.example.jatkuvaprojektijpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    Optional<Topic> findById(Integer id);

}
