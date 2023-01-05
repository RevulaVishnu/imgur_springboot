package com.cognizant.userservice.repo;

import java.util.Optional;

import com.cognizant.userservice.model.UserData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserData, Long> {

	Optional<UserData> findByEmailIdAndPassword(String emailId, String password);

	Optional<UserData> findByEmail(String email);

	Optional<UserData> findByUserName(String userName);

}
