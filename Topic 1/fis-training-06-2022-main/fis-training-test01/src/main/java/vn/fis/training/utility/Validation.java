package vn.fis.training.utility;

import vn.fis.training.domain.CustomerStatus;

import java.time.LocalDate;

public class Validation {
    public static boolean validateName(String name) {
        return name != null &&
                name.trim().length() > 0 &&
                name.length() <= 50 &&
                name.length() >= 5 &&
                name.matches("[a-z,A-Z ]+");
    }

    public static boolean validateDob(LocalDate dob) {
        return dob.isBefore(LocalDate.now().plusDays(1).minusYears(10));
    }

    public static boolean validateMobile(String mobile) {
        return mobile != null &&
                mobile.trim().length() > 0 &&
                mobile.length() == 10 &&
                mobile.startsWith("0") &&
                mobile.matches("[0-9 ]+");
    }

    public static boolean validateStatus(CustomerStatus status) {
        return status != null;
    }
}
