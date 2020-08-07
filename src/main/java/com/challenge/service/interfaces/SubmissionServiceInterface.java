package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.service.interfaces.ServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
