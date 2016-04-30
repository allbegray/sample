package flowctrl.sample.modules.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allbegray on 2016-04-30.
 */
@Controller
public class ErrorController {

    @RequestMapping("/error/404")
    public void noMappingFound() {
        System.out.println("404에러 페이지 출력");
    }

}
