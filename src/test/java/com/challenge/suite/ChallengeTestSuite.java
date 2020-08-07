package com.challenge.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AccelerationServiceTest.class, CandidateServiceTest.class,
        ChallengeServiceTest.class, CompanyServiceTest.class,
        SubmissionServiceTest.class, UserServiceTest.class})
public class ChallengeTestSuite {
}
