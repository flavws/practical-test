package com.example.api.service;

import java.util.List;
import java.util.Optional;

import com.example.api.domain.Address;
import com.example.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer saveCustomer(Customer customer){
		return repository.save(customer);
	}

	public Customer updateCustomer (Long id, Customer customer){
		Customer updatedCustomer = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		updatedCustomer.setEmail(customer.getEmail());
		updatedCustomer.setName(customer.getName());
		return repository.save(updatedCustomer);
	}

	public void deleteCustomer(Long id){
		repository.deleteById(id);
	}

	public Page<Customer> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Address addAddress(Long customerId, Address address) {
		Customer customer = repository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
		address.setCustomer(customer);
		return addressRepository.save(address);
	}

}
