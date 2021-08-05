/**
 * 
 */
package com.hcl.ing;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nailesh
 * This class demonstrate to achieve concurrency using executor service
 *
 */
public class ExecutorConcurrency {
	private static ExecutorService executorService = Executors.newSingleThreadExecutor();
	private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		runnableExecutors(); // returns null if the task has finished successfully
		callableExecutor(); // returns task1
		Future<Integer> future = calculate(10);
		while (!future.isDone()) {
			System.out.println("Calculating..." + Thread.currentThread().getName());
			Thread.sleep(300);
		}
		System.out.println("Calculated value: " + future.get());
		if(!executorService.isShutdown())
			executorService.shutdown();
		if(!fixedThreadPool.isShutdown())
			fixedThreadPool.shutdown();

	}

	/**
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void callableExecutor() throws InterruptedException, ExecutionException {
		@SuppressWarnings("rawtypes")
		Future future;
		Callable<String> callable = () -> "task 1 ";
		future = executorService.submit(callable);
		System.out.println("value - " + future.get());
	}

	/**
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void runnableExecutors() throws InterruptedException, ExecutionException {
		Runnable task = () -> {
			System.out.println("runnable task");
		};
		@SuppressWarnings("rawtypes")
		Future future = executorService.submit(task);
		System.out.println("value - " + future.get());
	}

	/**
	 * @param input
	 * @return Future
	 */
	public static Future<Integer> calculate(Integer input) {
		return fixedThreadPool.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}

}
