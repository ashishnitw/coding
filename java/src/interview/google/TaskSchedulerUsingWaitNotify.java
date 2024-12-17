package interview.google;

import java.util.LinkedList;
import java.util.Queue;

public class TaskSchedulerUsingWaitNotify {

    private final Queue<Runnable> taskQueue;        // Shared task queue
    private final Thread[] workerThreads;           // Array of worker threads
    private volatile boolean isRunning;             // Flag to indicate if the scheduler is running

    public TaskSchedulerUsingWaitNotify(int numOfThreads) {
        taskQueue = new LinkedList<>();
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
     * @param task The task to execute.
     */
    public void postTask(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify(); // Notify a waiting worker thread
        }
    }

    /**
     * Worker thread function to process tasks from the queue.
     */
    public void processTasks() {
        while (true) {
            Runnable task;

            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && isRunning) {
                    try {
                        taskQueue.wait(); // Wait until a task is available or shutdown is triggered
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return; // Exit the thread if interrupted
                    }
                }

                // Exit if the scheduler is shutting down and no tasks are left
                if (!isRunning && taskQueue.isEmpty()) {
                    return;
                }

                // Dequeue the next task
                task = taskQueue.poll();
            }

            // Execute the task outside the synchronized block
            if (task != null) {
                task.run();
            }
        }
    }

    /**
     * Gracefully shuts down the scheduler and waits for worker threads to complete.
     */
    public void shutdown() {
        synchronized (taskQueue) {
            isRunning = false;
            taskQueue.notifyAll();  // Notify all worker threads to exit
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
        TaskSchedulerUsingWaitNotify scheduler = new TaskSchedulerUsingWaitNotify(3);

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

        scheduler.shutdown();
        System.out.println("Scheduler is shutdown");

    }

}
