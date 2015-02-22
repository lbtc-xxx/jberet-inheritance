package org.nailedtothex.jberet_inheritance;

import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

@Named
@Dependent
public class MyItemReader extends AbstractItemReader {

    Iterator<Integer> it;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        it = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).iterator();
    }

    @Override
    public Object readItem() throws Exception {
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }
}
