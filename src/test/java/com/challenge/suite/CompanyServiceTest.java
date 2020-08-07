package com.challenge.suite;

import com.challenge.entity.Company;
import com.challenge.suite.AbstractTest.AccelerationIds;
import com.challenge.suite.AbstractTest.UserIds;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user_service_test.sql")
public class CompanyServiceTest {

    public static final String COMPANY_5002_NAME = "Green Company";
    @Autowired
    private CompanyServiceInterface service;

    @Test
    @Transactional
    public void whenFindById() {
        Optional<Company> result = service.findById(AbstractTest.CompanyIds.TWO);

        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getName(), equalTo(COMPANY_5002_NAME));
    }

    @Test
    @Transactional
    public void whenFindByIdThenNotFound() {
        Optional<Company> result = service.findById(5005L);

        assertThat(result.isPresent(), is(false));
    }

    @Test
    @Transactional
    public void whenFindByAccelerationId() {
        List<Company> result = service.findByAccelerationId(AccelerationIds.TWO);

        assertThat(result, hasSize(1));
    }

    @Test
    @Transactional
    public void whenFindByUserId() {
        List<Company> result = service.findByUserId(UserIds.THREE);

        assertThat(result, hasSize(2));
    }

}
