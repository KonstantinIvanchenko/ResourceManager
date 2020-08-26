package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChannelResourceManager <T> {

    private final static int maxNumberOfChannels = 10;
    private final Semaphore semaphore;
    private final Queue<T> resourceQueue = new LinkedList<T>();

    public ChannelResourceManager(LinkedList<T> resources){
        resourceQueue.addAll(resources);

        if (maxNumberOfChannels < resources.size())
            semaphore = new Semaphore(maxNumberOfChannels, true);
        else
            semaphore = new Semaphore(resources.size(), true);
    }

    public T getResource(long waitTimeMaxMs) throws ResourceManagerException {
        try {
            if (semaphore.tryAcquire(waitTimeMaxMs, TimeUnit.MILLISECONDS)) {
                return resourceQueue.poll();
            }
        }catch (InterruptedException e){
            throw new ResourceManagerException(e);
        }

        throw new ResourceManagerException("Resource waiting timeout of: ms = "+waitTimeMaxMs);
    }

    public void returnResource(T res){
        resourceQueue.add(res);
        semaphore.release();
    }
}
