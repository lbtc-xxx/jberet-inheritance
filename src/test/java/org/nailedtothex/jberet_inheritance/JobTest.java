package org.nailedtothex.jberet_inheritance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.batch.operations.JobOperator;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class JobTest {

    static Context ctx;
    static JobOperator jobOperator;

    @BeforeClass
    public static void before() throws Exception {
        Properties props = new Properties();
        props.setProperty("remote.connections", "default");
        props.setProperty("remote.connection.default.port", "8080");
        props.setProperty("remote.connection.default.host", "localhost");
        props.setProperty("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
        props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.setProperty("org.jboss.ejb.client.scoped.context", "true");
        ctx = new InitialContext(props);
        jobOperator = (JobOperator) ctx.lookup("ejb:/jberet-inheritance//JobOperatorFacade!javax.batch.operations.JobOperator");
    }

    @AfterClass
    public static void after() throws Exception {
        ctx.close();
    }

    @Test
    public void test() throws Exception {
        final long executionId = jobOperator.start("child", new Properties());
        System.out.println("executionId: " + executionId);
    }
}
