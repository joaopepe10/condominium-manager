package barcante.condominiummanager.core.utils;

import lombok.experimental.UtilityClass;

import static java.util.Objects.nonNull;

@UtilityClass
public class ValidationStringUtil {

    public static boolean notBlank(String value) {
        return !value.isBlank();
    }

    public static boolean notNullAndNotBlank(String value) {
        return nonNull(value) && notBlank(value);
    }
}
