package com.example.traianos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value="select * from user as u, addresses as a where u.id=a.id and u.id=:newid", nativeQuery=true)User findUserById(@Param("newid") Integer newid);
}