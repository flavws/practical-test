package com.example.api.web.rest;

import java.util.List;

import com.example.api.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@GetMapping("/page")
	public ResponseEntity<Page<Customer>> getAllCustomers(Pageable pageable) {
		Page<Customer> page = service.findAll(pageable);
		return ResponseEntity.ok(page);
	}

	@PostMapping("/{customerId}/addresses")
	public ResponseEntity<Address> addAddress(@PathVariable Long customerId, @Valid @RequestBody Address address) {
		Address savedAddress = service.addAddress(customerId, address);
		return ResponseEntity.ok(savedAddress);
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = service.saveCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
		Customer updatedCustomer = service.updateCustomer(id, customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}

}
