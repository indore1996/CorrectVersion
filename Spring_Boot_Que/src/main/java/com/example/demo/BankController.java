package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class BankController {

	@Autowired
	private BankRepo bRepo;
	
	@GetMapping
	public Page<Bank> getAll(@RequestParam int pageNo,@RequestParam int size){
		Pageable p = PageRequest.of(pageNo,size);
		
		return bRepo.findAll(p);
	}
	
	
	@GetMapping("/sort")
	public List<Bank> gtBySort(@RequestParam String sortBy){
		Sort s = Sort.by(sortBy);
		
		return bRepo.findAll(s);
	}
	
	@PostMapping
	public Bank createBAnk(@RequestBody Bank bank) {
		return bRepo.save(bank);
	}
	
	@GetMapping("/{id}")
	public Optional<Bank> createBAnkByid(@PathVariable Long id) {
		return bRepo.findById(id);
	}
	
	@PutMapping("/{id}")
	public Bank updateBAnk(@RequestBody Bank bank,@PathVariable Long id) throws Exception {
		Bank ba = bRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		ba.setBname(bank.getBname());
		ba.setpNo(bank.getpNo());
		ba.setId(bank.getId());
		return bRepo.save(ba);
	}
	
	@DeleteMapping("/{id}")
	public void delBAnk(@PathVariable Long id) {
		bRepo.deleteById(id);
	}
}
