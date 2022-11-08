package fr.aluny.gameapi.timer;

import fr.aluny.gameapi.service.Service;
import fr.aluny.gameapi.value.TimeValue;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public interface TimerService extends Service {

    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, Runnable runOnTick, Runnable runOnEnd);

    Timer createTimerFromTimeValue(String key, TimeValue step, TimeValue end, Runnable runOnTick, Runnable runOnEnd);

    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, Consumer<Long> runOnTick, Consumer<Long> runOnEnd);

    Timer createTimerFromTimeValue(String key, TimeValue step, TimeValue end, Consumer<Long> runOnTick, Consumer<Long> runOnEnd);

    Optional<Timer> getTimer(String key);

    boolean unregisterTimer(String key);

}
