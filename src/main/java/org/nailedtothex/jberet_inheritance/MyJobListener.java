package org.nailedtothex.jberet_inheritance;

import javax.batch.api.listener.JobListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class MyJobListener implements JobListener {
    private static final Logger log = Logger.getLogger(MyJobListener.class.getName());

    @Inject
    JobContext jobCtx;
    
    @Override
    public void beforeJob() throws Exception {
        log.log(Level.INFO, "Job {0} starting", jobCtx.getJobName());
    }

    @Override
    public void afterJob() throws Exception {
        log.log(Level.INFO, "Job {0} done", jobCtx.getJobName());
    }
}
