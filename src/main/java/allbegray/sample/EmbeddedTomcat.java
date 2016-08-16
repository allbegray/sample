package allbegray.sample;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by allbegray on 2016-05-19.
 * @see <a href="http://stackoverflow.com/questions/11669507/embedded-tomcat-7-servlet-3-0-annotations-not-working">http://stackoverflow.com/questions/11669507/embedded-tomcat-7-servlet-3-0-annotations-not-working</a>
 */
public class EmbeddedTomcat {

    public static void main(String[] args) throws ServletException, LifecycleException {
        String docBase = "webapp/";
        String contextPath = "";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        StandardContext ctx = (StandardContext) tomcat.addWebapp(contextPath, new File(docBase).getAbsolutePath());

        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }

}
