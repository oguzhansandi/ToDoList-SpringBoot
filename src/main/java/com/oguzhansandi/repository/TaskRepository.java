package com.oguzhansandi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguzhansandi.model.ToDo;

@Repository
public interface TaskRepository extends JpaRepository<ToDo, Long>{

}
