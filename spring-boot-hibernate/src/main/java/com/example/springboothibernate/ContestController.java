package com.example.springboothibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contests")
public class ContestController {
	
	@Autowired
	private ContestRepository contestRepsitory;
	
	@GetMapping
	public List<Contest> getAllContest(){
		return  contestRepsitory.findAll();
	}
	
	@PostMapping
	public Contest addContest(@RequestBody Contest contest) {
		return contestRepsitory.save(contest);
	}
	
}