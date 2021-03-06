package allbegray.sample.common.initializer;

import allbegray.sample.Constants;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.ServletContext;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(Constants.ENCODING);
        encodingFilter.setForceEncoding(true);
        insertFilters(servletContext, encodingFilter);

        insertFilters(servletContext, new HiddenHttpMethodFilter());

//        MultipartFilter multipartFilter = new MultipartFilter();
//        multipartFilter.setMultipartResolverBeanName("multipartResolver");
//        insertFilters(servletContext, multipartFilter);
    }

}