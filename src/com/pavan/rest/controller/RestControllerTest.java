/**
 * 
 */
package com.pavan.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pavan.rest.model.User;
import com.pavan.rest.services.IDataService;

/**
 * @author pammanchi
 *
 */
@Controller
@RequestMapping(value="/user/")
public class RestControllerTest {
	
	@Autowired(required=true)
	IDataService dataService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsersList(){
		return dataService.getUsersList();
	}
	
	@RequestMapping(value="/home")
	@ResponseBody
	public String getHome(){
		return "Welcome, Create New User";
	}
}
