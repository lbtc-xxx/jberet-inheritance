package org.nailedtothex.jberet_inheritance;

import javax.batch.api.chunk.listener.ChunkListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class MyChunkListener implements ChunkListener {
    private static final Logger log = Logger.getLogger(MyChunkListener.class.getName());

    @Inject
    JobContext jobCtx;
    @Inject
    StepContext stepCtx;

    @Override
    public void beforeChunk() throws Exception {
        log.log(Level.INFO, "Job {0}, Step {1} chunk starting", new Object[]{jobCtx.getJobName(), stepCtx.getStepName()});
    }

    @Override
    public void onError(Exception ex) throws Exception {
        log.log(Level.SEVERE, "onError", ex);
    }

    @Override
    public void afterChunk() throws Exception {
        log.log(Level.INFO, "Job {0}, Step {1} chunk done", new Object[]{jobCtx.getJobName(), stepCtx.getStepName()});
    }
}
