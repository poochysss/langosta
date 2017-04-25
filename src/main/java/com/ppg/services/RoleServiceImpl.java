package com.ppg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.ppg.domain.Role;

@Service
@Profile("springdatajpa")
@PropertySource("file:application.properties")

public class RoleServiceImpl implements RoleService {



    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
      //  roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return null;//roleRepository.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return null;//roleRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        //roleRepository.delete(id);
    }
}
