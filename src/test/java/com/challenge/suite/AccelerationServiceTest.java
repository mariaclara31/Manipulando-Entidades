package com.challenge.suite;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
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
public class AccelerationServiceTest {

    public static final String ACCELERATION_ONE_NAME = "Metallica Acceleration";
    @Autowired
    private AccelerationServiceInterface service;

    @Test
    @Transactional
    public void whenFindById() {
        Optional<Acceleration> result = service.findById(AbstractTest.AccelerationIds.ONE);

        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getName(), equalTo(ACCELERATION_ONE_NAME));
    }

    @Test
    @Transactional
    public void whenFindByCompanyId() {
        List<Acceleration> result = service.findByCompanyId(AbstractTest.CompanyIds.TWO);

        assertThat(result, hasSize(3));
    }

}
