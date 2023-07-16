package fr.aluny.gameapi.timer;

import fr.aluny.gameapi.service.Service;
import fr.aluny.gameapi.value.TimeValue;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public interface TimerService extends Service {

    @Deprecated
    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, Runnable runOnTick, Runnable runOnEnd);

    @Deprecated
    Timer registerTimer(String key, Long delay, Long step, Long stop, TimeUnit timeUnit, LongConsumer runOnTick, LongConsumer runOnEnd);

    Timer createTimer(String key, Duration step, Duration stop, Consumer<Timer> runOnTick, Consumer<Timer> runOnEnd);

    Timer registerTimer(String key, Duration step, Duration stop, Consumer<Timer> runOnTick, Consumer<Timer> runOnEnd);

    Timer registerRunnableTimer(String key, Duration step, Duration stop, Runnable runOnTick, Runnable runOnEnd);

    Timer registerValueTimer(String key, long step, Long stop, TimeUnit timeUnit, LongConsumer runOnTick, LongConsumer runOnEnd);

    Timer registerTimerFromTimeValue(String key, TimeValue step, TimeValue stop, Consumer<Timer> runOnTick, Consumer<Timer> runOnEnd);

    Optional<Timer> getTimer(String key);

    void registerTimer(Timer timer);

    boolean unregisterTimer(String key);

    boolean unregisterTimer(Timer timer);

}
