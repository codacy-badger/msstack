package com.grydtech.msstack.microservices.jaxrs;

import com.grydtech.msstack.core.MicroserviceApplication;
import com.grydtech.msstack.microservices.jaxrs.features.JacksonFeature;

import javax.ws.rs.Path;
import java.util.HashSet;
import java.util.Set;

public abstract class JaxRSApplication extends MicroserviceApplication {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        getHandlers().forEach(handlerClass -> {
            if (handlerClass.isAnnotationPresent(Path.class)) {
                classes.add(handlerClass);
            }
        });
        classes.add(JacksonFeature.class);
        return classes;
    }
}
