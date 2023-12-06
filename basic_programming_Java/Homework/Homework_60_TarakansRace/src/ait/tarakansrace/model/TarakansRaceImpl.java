package ait.tarakansrace.model;

import static ait.tarakansrace.TarakanRaceAppl.winnerName;

public class TarakansRaceImpl implements Runnable {
    String name;
    int rounds;

    public TarakansRaceImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Tarakan# " + name + " started race");
        for (int i = 0; i < rounds; i++) {
            int randomTime = (int) (Math.random() * (5 - 2 + 1) + 2);
            System.out.println("Tarakan# " + name + ", round = " + i);
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (winnerName == null) {
            winnerName = name;
        }
    }
}
