package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catogeries")
public class PeopleController {

	@Autowired
	private PeopleRepo bRepo;
	
	@GetMapping
	public Page<People> getAll(@RequestParam int pageNo,@RequestParam int size){
		Pageable p = PageRequest.of(pageNo,size);
		
		return bRepo.findAll(p);
	}
	
	
	@GetMapping("/sort")
	public List<People> gtBySort(@RequestParam String sortBy){
		Sort s = Sort.by(sortBy);
		
		return bRepo.findAll(s);
	}
	
	@PostMapping
	public People createBAnk(@RequestBody People bank) {
		return bRepo.save(bank);
	}
	
	@GetMapping("/{id}")
	public Optional<People> createBAnkByid(@PathVariable Long id) {
		return bRepo.findById(id);
	}
	
	@PutMapping("/{id}")
	public People updateBAnk(@RequestBody People bank,@PathVariable Long id) throws Exception {
		People ba = bRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		ba.setBank(bank.getBank());
		ba.setFname(bank.getFname());
		ba.setbDay(bank.getbDay());
		ba.setId(bank.getId());
		ba.setLname(bank.getLname());
		return bRepo.save(ba);
	}
	
	@DeleteMapping("/{id}")
	public void delBAnk(@PathVariable Long id) {
		bRepo.deleteById(id);
	}
}
