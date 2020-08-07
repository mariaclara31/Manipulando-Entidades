package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findDistinctByCandidatesIdAccelerationId(@Param("id") Long accelerationId);

    List<Company> findByCandidatesIdUserId(Long userId);
}