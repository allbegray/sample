package allbegray.sample.common.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.*;

/**
 * Created by allbegray on 2016-04-30.
 */
public class SecurityConfigTest {

    @Test
    public void bCryptPasswordEncoderTest() {
        String rawPassword = "1234";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println(String.format("BCryptPasswordEncoder test : %s -> %s", rawPassword, encodedPassword));

        Assert.assertNotEquals(rawPassword, encodedPassword);

        // 아래 두 조건이 일종의 BCrypt 스펙이라 볼 수 있다.
        Assert.assertTrue(encodedPassword.startsWith("$2a$10$"));
        Assert.assertTrue(encodedPassword.length() == 60);

        Assert.assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }

}