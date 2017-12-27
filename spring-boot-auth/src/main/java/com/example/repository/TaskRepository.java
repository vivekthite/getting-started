/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Task;


/**
 * @author vivekanandt
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
