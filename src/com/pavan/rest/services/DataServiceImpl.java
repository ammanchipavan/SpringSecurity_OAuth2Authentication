/**
 * 
 */
package com.pavan.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pavan.rest.model.User;

/**
 * @author pammanchi
 *
 */
@Service
public class DataServiceImpl implements IDataService{

	@Override
	public List<User> getUsersList() {

		List<User> userList = new ArrayList<>();	
		//DAO Object
		userList.add(new User("ABC", "abc@gmail.com", "99999999"));
		userList.add(new User("EFG", "efg@gmail.com", "88888888"));
		userList.add(new User("GHI", "ghi@gmail.com", "77777777"));
		userList.add(new User("JKL", "jkl@gmail.com", "66666666"));
		return userList;
	}

}
