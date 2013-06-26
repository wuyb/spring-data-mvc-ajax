package com.springapp.mvc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.springapp.mvc.domain.Todo;

public interface TodoRepository extends PagingAndSortingRepository <Todo, Long> {
}
