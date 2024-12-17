package interview.google;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskSchedulerUsingExecutor {

    private final ExecutorService executor;

    public TaskSchedulerUsingExecutor(int numOfThreads) {
        executor = Executors.newFixedThreadPool(numOfThreads);
    }

    /**
     * Submits a task for asynchronous execution.
     * @param task The task to be executed.
     * @return A Future object representing the result of the task.
     */
    public Future<?> postTask(Runnable task) {
        if (task == null)
            throw new IllegalArgumentException("Task cannot be null");
        return executor.submit(task);
    }

    /**
     * Gracefully shuts down the task scheduler. Waits for currently executing tasks to finish.
     */
    public void shutdown() {
        executor.shutdown();
    }

    /**
     * Forcefully shuts down the task scheduler. Attempts to stop all actively executing tasks.
     */
    public void shutdownNow() {
        executor.shutdownNow();
    }

    public static void main(String[] args) {

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + numberOfThreads);  // M3 Pro has 12-core processor

        TaskSchedulerUsingExecutor scheduler = new TaskSchedulerUsingExecutor(numberOfThreads);
        for (int i=0; i<100; i++) {
            int taskId = i;
            scheduler.postTask(() -> {
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
                try {
                    // Simulate some work
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task " + taskId + " was interrupted.");
                }
            });
        }

        System.out.println("Shutting down the scheduler gracefully after submitting tasks");
        scheduler.shutdown();
        System.out.println("Scheduler is shutdown");
    }

}
