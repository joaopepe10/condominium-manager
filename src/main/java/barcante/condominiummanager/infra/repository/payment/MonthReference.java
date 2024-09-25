package barcante.condominiummanager.infra.repository.payment;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;

@Getter
public enum MonthReference {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int monthNumber;

    MonthReference(int i) {
        this.monthNumber = i;
    }

    public static MonthReference getMonthCurrent(final LocalDate month) {
        return Arrays.stream(values())
                .filter(monthReference -> monthReference.getMonthNumber() == month.getMonthValue())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Month reference not found"));
    }
}
