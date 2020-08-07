package com.challenge.suite;

import com.challenge.entity.User;
import com.challenge.suite.AbstractTest.CompanyIds;
import com.challenge.suite.AbstractTest.UserIds;
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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user_service_test.sql")
public class UserServiceTest {

    private static final String EMAIL = "bruno@gmail.com";
    private static final String FULL_NAME = "Bruno";
    private static final String NICKNAME = "nick_bruno";
    private static final String PASSWORD = "123456";
    private static final String ACCELERATION_NAME = "Metallica Acceleration";

    @Autowired
    private UserServiceInterface userService;

    @Test
    @Transactional
    public void whenSave() {
        User user = getUser();

        User result = userService.save(user);

        assertUser(result);
    }

    @Test
    @Transactional
    public void whenFindById() {
        Optional<User> optResult = userService.findById(UserIds.ONE);

        assertThat(optResult.isPresent(), equalTo(true));
        assertUser(optResult.get());
    }

    @Test
    @Transactional
    public void whenFindByAccelerationName() {
        List<User> result = userService.findByAccelerationName(ACCELERATION_NAME);

        assertThat(result, hasSize(3));
    }

    @Test
    @Transactional
    public void whenFindByCompanyId() {
        List<User> result = userService.findByCompanyId(CompanyIds.TWO);

        assertThat(result, hasSize(3));
    }

    private void assertUser(User result) {
        assertThat(result.getId(), notNullValue());
        assertThat(result.getEmail(), equalTo(EMAIL));
        assertThat(result.getNickname(), equalTo(NICKNAME));
        assertThat(result.getPassword(), equalTo(PASSWORD));
        assertThat(result.getFullName(), equalTo(FULL_NAME));
        assertThat(result.getCreatedAt(), notNullValue());
    }


    private User getUser() {
        User user = new User();
        user.setEmail(EMAIL);
        user.setFullName(FULL_NAME);
        user.setNickname(NICKNAME);
        user.setPassword(PASSWORD);
        return user;
    }

}
