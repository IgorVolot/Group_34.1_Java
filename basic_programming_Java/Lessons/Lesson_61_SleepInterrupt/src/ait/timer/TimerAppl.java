package ait.timer;

import ait.timer.task.Timer;
import ait.timer.task.TimerMySleep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    public static void main(String[] args) throws IOException {
//        Timer timer = new Timer();
        TimerMySleep timer = new TimerMySleep();
        Thread thread = new Thread(timer);

//        thread.setDaemon(true); //
        thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Enter time interval, or press q for exit");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)){
//                thread.stop(); // практически не используется (он убивает thread)
                thread.interrupt(); // корректно прерывает работу thread
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread has just finished");
    }
}
