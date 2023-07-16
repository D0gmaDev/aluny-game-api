package fr.aluny.gameapi.value;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public interface TimeValue extends NumericValue<Long> {

    long getLongValue();

    String getFormattedTime();

    String getFormattedSmallStep();

    String getFormattedMediumStep();

    String getFormattedLargeStep();

    TimeUnit getTimeUnit();

    Duration toDuration();

}
