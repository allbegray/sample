package flowctrl.sample.web.global;

import flowctrl.sample.common.config.RootConfig;
import flowctrl.sample.common.config.WebMvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by allbegray on 2016-04-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebMvcConfig.class})
@WebAppConfiguration(value = "/webapp")
public class GlobalExceptionHandlerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void handleMethodArgumentTypeMismatchExceptionTest() throws Exception {
        this.mockMvc.perform(get("/shuttle/1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Controller
    static class TestContoller {
        @RequestMapping(method = RequestMethod.GET, value = "/shuttle/{number}")
        public ResponseEntity shuttle(@PathVariable int number) {
            System.out.println("TestContoller - shuttle 메서드");
            return null;
        }
    }

}