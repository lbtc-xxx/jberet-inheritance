package org.nailedtothex.jberet_inheritance;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class MyItemWriter extends AbstractItemWriter {
    private static final Logger log = Logger.getLogger(MyItemWriter.class.getName());

    @Inject
    JobContext jobCtx;
    @Inject
    StepContext stepCtx;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        log.log(Level.INFO, "jobProps: {0}", jobCtx.getProperties());
        log.log(Level.INFO, "stepProps: {0}", stepCtx.getProperties());
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        log.log(Level.INFO, "write: {0}", items.toString());
    }
}
