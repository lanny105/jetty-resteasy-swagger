package com.lanny105;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.server.ssl.SslSocketConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class start {
    public static void main(String[] args) throws Exception {

        Server server = new Server();

        SslContextFactory sslContextFactory = new SslContextFactory("./src/keystore/keystore.jks");
        sslContextFactory.setKeyStorePassword("lanny105");

        // Create a new SocketConnector at port 443, which is the default port for
        // HTTPS web pages (no port number needs to be specified in the browser).
        SslSocketConnector sslConnector = new SslSocketConnector(sslContextFactory);
        sslConnector.setPort(8090);

        // Add the SocketConnector to the server

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);

        server.setConnectors(new Connector[] {connector, sslConnector});


        WebAppContext context = new WebAppContext();
        context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("./src/main/webapp");
        context.setContextPath("/");

        server.setHandler(context);

        server.start();
        server.join();

    }

}
