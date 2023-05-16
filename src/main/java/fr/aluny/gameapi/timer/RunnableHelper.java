package fr.aluny.gameapi.timer;

import fr.aluny.gameapi.service.Service;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import org.bukkit.scheduler.BukkitTask;

public interface RunnableHelper extends Service {

    void runSynchronously(Runnable runnable);

    void runAsynchronously(Runnable runnable);

    void runLaterSynchronously(Runnable runnable, long delay);

    void runLaterAsynchronously(Runnable runnable, long delay);

    BukkitTask runTimerSynchronously(Runnable runnable, long delay, long interval);

    BukkitTask runTimerAsynchronously(Runnable runnable, long delay, long interval);

    void runTimerSynchronously(Consumer<BukkitTask> task, long delay, long interval);

    void runTimerAsynchronously(Consumer<BukkitTask> task, long delay, long interval);

    void runRepeatSynchronously(IntConsumer runnable, IntPredicate earlyCancel, long delay, long interval, int occurrences);

    void runRepeatAsynchronously(IntConsumer runnable, IntPredicate earlyCancel, long delay, long interval, int occurrences);

    void runRepeatSynchronously(IntConsumer runnable, long delay, long interval, int occurrences);

    void runRepeatAsynchronously(IntConsumer runnable, long delay, long interval, int occurrences);
}
