package org.nailedtothex.jberet_inheritance;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class MyBatchlet extends AbstractBatchlet {
    private static final Logger log = Logger.getLogger(MyBatchlet.class.getName());

    @Inject
    JobContext jobCtx;
    @Inject
    StepContext stepCtx;

    @Override
    public String process() throws Exception {
        log.info("hello world!");
        log.log(Level.INFO, "jobProps: {0}", jobCtx.getProperties());
        log.log(Level.INFO, "stepProps: {0}", stepCtx.getProperties());
        return null;
    }
}
