package com.publicis.sapient.common.api.config;

import com.publicis.sapient.common.api.provider.ObjectMapperProvider;
import com.publicis.sapient.security.api.exceptionmapper.AccessDeniedExceptionMapper;
import com.publicis.sapient.security.api.exceptionmapper.AuthenticationExceptionMapper;
import com.publicis.sapient.security.api.exceptionmapper.AuthenticationTokenRefreshmentExceptionMapper;
import com.publicis.sapient.security.api.resource.AuthenticationResource;
import com.publicis.sapient.user.api.resource.FootballResource;
import com.publicis.sapient.user.api.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey configuration class.
 *
 *
 */
@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(AuthenticationResource.class);
        register(UserResource.class);
        register(FootballResource.class);

        register(AccessDeniedExceptionMapper.class);
        register(AuthenticationExceptionMapper.class);
        register(AuthenticationTokenRefreshmentExceptionMapper.class);

        register(ObjectMapperProvider.class);
    }
}