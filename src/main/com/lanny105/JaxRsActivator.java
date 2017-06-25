package com.lanny105;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 2017/6/24.
 */
@ApplicationPath("/")
public class JaxRsActivator extends Application {

    public JaxRsActivator(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:4080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("com.lanny105");
        beanConfig.setScan(true);
    }
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        resources.add(com.lanny105.app.class);
        return resources;
    }
}