
package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.CustomerDTO;
import com.pablo.bakeryManager.dto.ParameterDTO;
import com.pablo.bakeryManager.model.Customer;

@Component
public class CustomerConverter implements Converter<Customer, CustomerDTO> {

	@Override
	public CustomerDTO toDTO(Customer c) {
		
		return CustomerDTO.builder()
				.id(c.getIdCustomer())
				.name(c.getName())
				.phone(c.getPhone())
				.status(ParameterDTO.builder()
						.id(c.getStatus().getIdParameter())
						.description(c.getStatus().getDescription())
						.build())
				.build();
	}

	@Override
	public List<CustomerDTO> toDTOList(List<Customer> customers) {
		
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		customers.forEach(customer -> customerDTOList.add(toDTO(customer)));
		return customerDTOList;
	}
}
