package com.example.demo;

//public class ListRepository {

import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ToDoList, Long>{

}
//}
