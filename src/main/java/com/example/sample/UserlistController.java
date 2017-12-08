package com.example.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
*/
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


import com.example.sample.UserService;
import com.example.sample.UserRepository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("userlist")
public class UserlistController {

	@Autowired
    UserService userService;
	
	@Autowired
	UserRepository repository;
	
	
	
	//一覧表示+ページング
	@GetMapping
	public String list(Model model,Pageable pageable) {
		List<User> users = repository.findAll();
		//Page<User> usersPage = repository.UserfindAll(pageable);
		model.addAttribute("users",users);
		//model.addAttribute("page",usersPage);
		return "userlist";
	}
	
	
	/*
	@DeleteMapping(path = "{no}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable Integer no) {
        repository.delete(no);
        return "userlist";   
    }
    */
	
	
	//削除
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@RequestParam Integer no) {
		repository.delete(no);
		
	}
	
	

	
}
