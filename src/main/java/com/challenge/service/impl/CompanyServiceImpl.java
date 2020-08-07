package com.challenge.service.impl;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository repository;

    @Override
    public  Company save(Company object) {
        return repository.save(object);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return repository.findDistinctByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return repository.findByCandidatesIdUserId(userId);
    }
}