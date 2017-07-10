/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kylu
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);

}
