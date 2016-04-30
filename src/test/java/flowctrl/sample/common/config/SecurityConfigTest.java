package flowctrl.sample.common.config;

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
        Assert.assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }

}