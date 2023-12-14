package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ExecutorGroupSum extends GroupSum {
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
//        ExecutorService executorService = Executors.newWorkStealingPool();
        int poolSize = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        List<OneGroupSum> groupSums = Arrays.stream(numberGroups)
                .map(OneGroupSum::new)
                .peek(executorService::execute)
                .collect(Collectors.toList());
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return groupSums.stream().mapToInt(OneGroupSum::getSum).sum();
    }

//    @Override
//    public int computeSum() throws InterruptedException {
//        OneGroupSum[] tasks = new OneGroupSum[numberGroups.length];
//        for (int i = 0; i < tasks.length; i++) {
//            tasks[i] = new OneGroupSum(numberGroups[i]);
//        }
//        int poolSize = Runtime.getRuntime().availableProcessors();
//        long t1 = System.currentTimeMillis();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
//        for (int i = 0; i < tasks.length; i++) {
//            executorService.execute(tasks[i]);
//        }
//
//        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.MINUTES);
//
//        long t2 = System.currentTimeMillis();
//        System.out.println("Duration = " + (t2 - t1));
//        return (int) Arrays.stream(tasks).mapToDouble(OneGroupSum::getSum).sum();
//    }
}
