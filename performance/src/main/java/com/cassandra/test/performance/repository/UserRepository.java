package com.cassandra.test.performance.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.cassandra.test.performance.table.User;



public interface UserRepository extends CassandraRepository<User, String> {

	@Query
	Optional<User> findById(String id);




	}