package com.devsuperior.bds01.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	
	public List<DepartmentDTO> findAll(){
		List<Department> list = repository.findAll(Sort.by("name"));
		List<DepartmentDTO> ret = new ArrayList<>();
		
//		list.stream().forEach(a -> ret.add(new DepartmentDTO(a)));
//		return ret;
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
		
	}
}
