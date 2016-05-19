package flowctrl.sample.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by allbegray on 2016-05-10.
 */
@Controller
public class SignupController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid SignupForm signupForm, BindingResult result, Model model) {
        signupForm.validate(result);
        if (result.hasErrors()) {
            return "signup";
        }
        return "main";
    }

}
