package com.cognizant.userservice.service;

import java.util.Optional;

import com.cognizant.userservice.exception.CustomException;
import com.cognizant.userservice.model.UserData;
import com.cognizant.userservice.repo.UserRepo;
import com.cognizant.userservice.util.RequestResponse;
import com.cognizant.userservice.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepo userRepository;


	public ResponseEntity<RequestResponse<String>> register(UserData user) {
		log.info(Constants.IN_REQUEST_LOG, "register", user.toString());
		Optional<UserData> isValid = userRepository.findByEmail(user.getEmail());
		String userRegistrationStatus = isValid.isPresent()
				? Constants.USER_NAME_ALREADY_EXIST
				: Constants.USER_NAME_REGISTERED_SUCCESSFULLY;
		if (isValid.isPresent())
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, userRegistrationStatus);
		else
			userRepository.save(user);
		log.info(Constants.EXITING_RESPONSE_LOG, "register", userRegistrationStatus);
		return ResponseEntity.ok(new RequestResponse<>(HttpStatus.OK.value(), HttpStatus.OK, user.getEmail() + ": " + userRegistrationStatus));
	}

/*
	public ResponseEntity<RequestResponse<String>> forgotPassword(String userName, String password) {
		log.info(Constants.IN_REQUEST_LOG, "forgotPassword", userName.concat(" " + password));
		Optional<UserData> userDataFromDb = userRepository.findByEmail(userName);
		if (userDataFromDb.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					Constants.USER_NAME_NOT_PRESENT);
		}
		else
		UserData userData = userDataFromDb.orElse(new UserData());
			userRepository.save()
*/
/*
		Query query = new Query();
		query.addCriteria(Criteria.where(Constants.EMAIL_ID).is(userName));
		Update update = new Update();
		update.set(Constants.PASSWORD, password);
		UserData user = mongoOperations.findAndModify(query, update, UserData.class);
*//*


		if (user == null)
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR,
					Constants.ERROR_WHILE_UPDATING_PASSWORD);
		log.info(Constants.EXITING_RESPONSE_LOG, "forgotPassword", user.toString());
		return ResponseEntity.ok(new RequestResponse<>(HttpStatus.OK.value(), HttpStatus.OK, Constants.PASSWORD_UPDATED));
	}
*/

}

