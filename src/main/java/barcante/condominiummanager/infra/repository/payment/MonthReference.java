package barcante.condominiummanager.infra.repository.payment;

import java.time.LocalDate;
import java.util.Arrays;

public enum MonthReference {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static MonthReference getMonthCurrent(final LocalDate month) {
        return Arrays.stream(values())
                .filter(monthReference -> monthReference.ordinal() == month.getMonthValue())
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Month reference not found"));
    }
}
