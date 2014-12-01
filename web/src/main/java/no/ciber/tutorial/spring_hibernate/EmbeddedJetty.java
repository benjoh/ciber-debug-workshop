package no.ciber.tutorial.spring_hibernate;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class EmbeddedJetty {

    private static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String BASE_URL = "/";
    private static final String CONFIG = "no.ciber.tutorial.spring_hibernate.config";
    private static final String BASE_WEBAPP_FOLDER = "webapp";


    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty(getPort(args));
    }

    private void startJetty(int port) throws Exception {
        Server server = new Server(port);
        server.setHandler(getServletContextHandler());
        server.start();
        server.join();
    }

    private static int getPort(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException ignore) {
                // Ignorer ugyldig port og faller tilbake til standard port.
            }
        }
        return DEFAULT_PORT;
    }

    public ServletContextHandler getServletContextHandler() throws IOException {
        ServletContextHandler handler = new ServletContextHandler();
        WebApplicationContext context = getContext();

        handler.setErrorHandler(null);
        handler.setContextPath(CONTEXT_PATH);
        handler.addServlet(new ServletHolder(new DispatcherServlet(context)), BASE_URL);
        handler.addEventListener(new ContextLoaderListener(context));
        handler.setResourceBase(new ClassPathResource(BASE_WEBAPP_FOLDER).getURI().toString());
        return handler;
    }

    public WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG);
        return context;
    }
}
