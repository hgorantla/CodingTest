package com.java.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import com.java.assignment.bean.Unicorn;


public interface Repository extends CrudRepository<Unicorn, Integer>{
}
