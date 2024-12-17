package interview.google;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskSchedulerUsingConcurrent {

    private final Queue<Runnable> taskQueue;        // Shared task queue
    private final Lock lock;                        // Access to the queue is synchronized using a ReentrantLock.
    private Condition taskAvailable;                // Condition to signal when tasks are available. Condition objects are used to avoid inefficient polling. Threads block on taskAvailable.await() until a new task is posted.
    private final Thread[] workerThreads;           // Array of worker threads
    private volatile boolean isRunning;             // Flag to indicate if the scheduler is running

    public TaskSchedulerUsingConcurrent(int numOfThreads) {
        taskQueue = new LinkedList<>();
        lock = new ReentrantLock();
        taskAvailable = lock.newCondition();
        workerThreads = new Thread[numOfThreads];
        isRunning = true;

        // Create and start worker threads
        for (int i = 0; i < numOfThreads; i++) {
            workerThreads[i] = new Thread(this::processTasks);
            workerThreads[i].start();
        }
    }

    /**
     * Posts a task to the scheduler for asynchronous execution.
     *
     * @param task The task to execute.
     */
    public void postTask(Runnable task) {
        lock.lock();
        try {
            taskQueue.add(task);
            taskAvailable.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Worker thread function to process tasks from the queue.
     */
    public void processTasks() {
        while (true) {
            Runnable task;
            lock.lock();
            try {
                // Wait for tasks to become available or for shutdown signal
                while (taskQueue.isEmpty() && isRunning) {
                    try {
                        taskAvailable.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                // Exit if the scheduler is shutting down
                if (!isRunning && taskQueue.isEmpty()) {
                    return;
                }

                // Dequeue the next task
                task = taskQueue.poll();
            } finally {
                lock.unlock();
            }

            // Execute the task outside the lock to prevent blocking other threads
            if (task != null) {
                task.run();
            }
        }
    }

    /**
     * Gracefully shuts down the scheduler and waits for worker threads to complete.
     */
    public void shutdown() {
        lock.lock();
        try {
            isRunning = false;
            taskAvailable.signalAll();  // Wake up all worker threads to exit
        } finally {
            lock.unlock();
        }
        // Wait for all worker threads to terminate
        for (Thread worker : workerThreads) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + numberOfThreads);  // M3 Pro has 12-core processor

        //TaskScheduler scheduler = new TaskScheduler(numberOfThreads);
        TaskSchedulerUsingConcurrent scheduler = new TaskSchedulerUsingConcurrent(3);

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            System.out.println("Posting task : " + taskId);
            scheduler.postTask(() -> {
                System.out.println("Executing task " + taskId + " on thread " + Thread.currentThread().getName());
                try {
                    // Simulate some work
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task " + taskId + " was interrupted.");
                }
            });
        }

        System.out.println("Shutting down the scheduler gracefully after submitting tasks");
        scheduler.shutdown();
        System.out.println("Scheduler is shutdown");

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            scheduler.postTask(() -> {
                System.out.println("Executing task " + taskId + " on thread " + Thread.currentThread().getName());
                try {
                    // Simulate some work
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task " + taskId + " was interrupted.");
                }
            });
        }
    }

}
