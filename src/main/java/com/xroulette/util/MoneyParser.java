package com.xroulette.util;

public class MoneyParser {

    public static double parse(String input) {
        try {
            input = input.toLowerCase().replace(",", "").trim();

            double multiplier = 1;

            if (input.endsWith("k")) {
                multiplier = 1_000;
                input = input.replace("k", "");
            } else if (input.endsWith("m")) {
                multiplier = 1_000_000;
                input = input.replace("m", "");
            } else if (input.endsWith("b")) {
                multiplier = 1_000_000_000;
                input = input.replace("b", "");
            }

            double value = Double.parseDouble(input) * multiplier;

            if (value <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }

            if (Double.isInfinite(value) || Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid amount");
            }

            return value;

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}