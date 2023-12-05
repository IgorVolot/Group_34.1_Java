package ait.tarakansrace.model;

public class TarakansRaceImpl implements Runnable {
    String name;
    int rounds;
    int randomTime = (int) (Math.random() * (5 - 2 + 1) + 2);

    public TarakansRaceImpl(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Tarakan# " + name + " started race");
        for (int i = 0; i < rounds; i++) {
            System.out.println("Tarakan# " + name + ", round = " + i);
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
