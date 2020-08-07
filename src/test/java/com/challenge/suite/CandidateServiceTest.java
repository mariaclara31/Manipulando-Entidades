package com.challenge.suite;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.suite.AbstractTest.AccelerationIds;
import com.challenge.suite.AbstractTest.CompanyIds;
import com.challenge.suite.AbstractTest.UserIds;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import com.challenge.service.interfaces.CandidateServiceInterface;
import com.challenge.service.interfaces.CompanyServiceInterface;
import com.challenge.service.interfaces.UserServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user_service_test.sql")
public class CandidateServiceTest {

    @Autowired
    private CandidateServiceInterface service;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @Test
    @Transactional
    public void whenFindById() {
        Optional<Candidate> result = service.findById(new CandidateId(userServiceInterface.findById(UserIds.THREE).get(),
                accelerationServiceInterface.findById(AccelerationIds.ONE).get(),
                companyServiceInterface.findById(CompanyIds.ONE).get()));

        assertThat(result.isPresent(), equalTo(true));
    }

    @Test
    @Transactional
    public void whenFindByIdThenNotFound() {
        Optional<Candidate> result = service.findById(new CandidateId(userServiceInterface.findById(UserIds.THREE).get(),
                accelerationServiceInterface.findById(AccelerationIds.ONE).get(),
                companyServiceInterface.findById(CompanyIds.TWO).get()));

        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    @Transactional
    public void whenFindByCompanyId() {
        List<Candidate> result = service.findByCompanyId(CompanyIds.TWO);

        assertThat(result, hasSize(3));
    }

    @Test
    @Transactional
    public void whenFindByAccelerationId() {
        List<Candidate> result = service.findByAccelerationId(AccelerationIds.TWO);

        assertThat(result, hasSize(3));
    }
}
