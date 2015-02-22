package org.nailedtothex.jberet_inheritance;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class MyStepListener implements StepListener {
    private static final Logger log = Logger.getLogger(MyStepListener.class.getName());

    @Inject
    JobContext jobCtx;
    @Inject
    StepContext stepCtx;

    @Override
    public void beforeStep() throws Exception {
        log.log(Level.INFO, "Job {0}, Step {1} starting", new Object[]{jobCtx.getJobName(), stepCtx.getStepName()});
    }

    @Override
    public void afterStep() throws Exception {
        log.log(Level.INFO, "Job {0}, Step {1} done", new Object[]{jobCtx.getJobName(), stepCtx.getStepName()});
    }
}
