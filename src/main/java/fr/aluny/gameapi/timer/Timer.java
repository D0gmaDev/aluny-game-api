package fr.aluny.gameapi.timer;

import reactor.core.publisher.Flux;

public interface Timer {

    void start();
    void stop();

    String getIncreasingFormattedValue();
    String getDecreasingFormattedValue();

    Flux<Timer> onTick();
    void addEndTask(Runnable consumer);
    void setValue(long value);
    long getValue();
    long getMaxValue();

    boolean isEnded();

    void setMaxValue(long value);

    void reset();
}
