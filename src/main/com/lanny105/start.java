package com.lanny105;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class start {
    public static void main(String[] args) throws Exception {

        Server server = new Server(4080);
        WebAppContext context = new WebAppContext();
        context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("./src/main/webapp");
        context.setContextPath("/");

        server.setHandler(context);

        server.start();
        server.join();



    }

}
