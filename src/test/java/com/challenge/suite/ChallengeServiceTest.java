package com.challenge.suite;

import com.challenge.entity.Challenge;
import com.challenge.suite.AbstractTest.AccelerationIds;
import com.challenge.suite.AbstractTest.ChallengeIds;
import com.challenge.suite.AbstractTest.UserIds;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user_service_test.sql")
public class ChallengeServiceTest {

    @Autowired
    private ChallengeServiceInterface service;

    @Test
    @Transactional
    public void whenFindByAccelerationIdAndUserId() {
        List<Challenge> result = service.findByAccelerationIdAndUserId(AccelerationIds.TWO, UserIds.THREE);

        assertThat(result, hasSize(1));
        assertThat(result.get(0).getId(), equalTo(ChallengeIds.TRHEE));
    }

}
