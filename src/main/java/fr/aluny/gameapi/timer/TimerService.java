package fr.aluny.gameapi.timer;

import fr.aluny.gameapi.service.Service;
import fr.aluny.gameapi.value.TimeValue;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;

public interface TimerService extends Service {

    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, Runnable runOnTick, Runnable runOnEnd);

    Timer registerTimerFromTimeValue(String key, TimeValue step, TimeValue stop, Runnable runOnTick, Runnable runOnEnd);

    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, LongConsumer runOnTick, LongConsumer runOnEnd);

    Timer registerTimerFromTimeValue(String key, TimeValue step, TimeValue stop, LongConsumer runOnTick, LongConsumer runOnEnd);

    Optional<Timer> getTimer(String key);

    boolean unregisterTimer(String key);

}
