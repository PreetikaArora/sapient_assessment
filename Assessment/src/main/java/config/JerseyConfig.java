package config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import resource.FootBallResource;

import static org.graalvm.compiler.nodes.java.RegisterFinalizerNode.register;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(FootBallResource.class);
    }
}
