package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.mapper.EmployeeMapper;
import com.yandimirov.navi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return StreamSupport
                .stream(employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findOne(long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee save(EmployeeDto employeeDto) {
        return employeeRepository.save(employeeMapper.mapDtoToEntity(employeeDto));
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }
}