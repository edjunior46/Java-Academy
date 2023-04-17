package br.com.academy.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.academy.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
    
    List<Student> findByNameContaining(@Param("name") String searchName);

}
