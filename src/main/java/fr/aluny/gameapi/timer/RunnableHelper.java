package fr.aluny.gameapi.timer;

import fr.aluny.gameapi.service.Service;
import java.util.function.IntConsumer;
import org.bukkit.scheduler.BukkitTask;

public interface RunnableHelper extends Service {

    void runSynchronously(Runnable runnable);

    void runAsynchronously(Runnable runnable);

    void runLaterSynchronously(Runnable runnable, long delay);

    void runLaterAsynchronously(Runnable runnable, long delay);

    BukkitTask runTimerSynchronously(Runnable runnable, long delay, long interval);

    BukkitTask runTimerAsynchronously(Runnable runnable, long delay, long interval);

    BukkitTask runRepeatSynchronously(IntConsumer runnable, long delay, long interval, int occurrences);

    BukkitTask runRepeatAsynchronously(IntConsumer runnable, long delay, long interval, int occurrences);
}
