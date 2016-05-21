package allbegray.sample.web.main;

import allbegray.sample.entity.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.Errors;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by allbegray on 2016-05-10.
 */
public class SignupForm {

    public void validate(Errors errors) {
        if (getPassword() != null && getConfirmPassword() != null && !getPassword().equals(getConfirmPassword())) {
            errors.rejectValue("password", "password.notmatch");
        }
    }

    @NotEmpty
    @Size(min = 8, max = User.LOGIN_ID_MAX_LENGTH)
    private String loginId;

    @NotEmpty
    @Size(min = 2, max = User.NAME_MAX_LENGTH)
    private String name;

    @Email
    @NotEmpty
    @Size(max = User.EMAIL_MAX_LENGTH)
    private String email;

    @NotEmpty
    @Pattern(regexp = User.PASSWORD_PATTERN, message = "{password.pattern}")
    private String password;

    @NotEmpty
    private String confirmPassword;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}