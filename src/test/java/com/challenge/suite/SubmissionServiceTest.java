package com.challenge.suite;

import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import com.challenge.suite.AbstractTest.AccelerationIds;
import com.challenge.suite.AbstractTest.ChallengeIds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user_service_test.sql")
public class SubmissionServiceTest {

    @Autowired
    private SubmissionServiceInterface service;

    @Test
    @Transactional
    public void whenFindHigherScoreByChallengeId() {
        BigDecimal result = service.findHigherScoreByChallengeId(ChallengeIds.TRHEE);

        assertThat(result, equalTo(BigDecimal.valueOf(99.0)));
    }

    @Test
    @Transactional
    public void whenFindHigherScoreByChallengeIdReturnNotFound() {
        BigDecimal result = service.findHigherScoreByChallengeId(ChallengeIds.ONE);

        assertThat(result, comparesEqualTo(BigDecimal.ZERO));
    }

    @Test
    @Transactional
    public void whenFindByChallengeIdAndAccelerationId() {
        List<Submission> result = service.findByChallengeIdAndAccelerationId(ChallengeIds.TRHEE, AccelerationIds.TWO);

        assertThat(result, hasSize(3));
    }

}
