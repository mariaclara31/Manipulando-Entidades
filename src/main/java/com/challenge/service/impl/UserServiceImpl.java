package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User object) {
        return repository.save(object);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return repository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return repository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return repository.findById(userId);
    }
}