package org.webjars;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class MainService extends Service<Configuration> {

    public static void main(String[] args) throws Exception {
        new MainService().run(args);
    }

    private MainService() {
        super("bars");
        addBundle(new AssetsBundle("/assets", 0, "/"));
        addBundle(new AssetsBundle("/META-INF/resources/webjars", 0, "/webjars"));
    }

    @Override
    protected void initialize(Configuration configuration, Environment environment) {
        environment.addResource(new MainResource());
    }

}
