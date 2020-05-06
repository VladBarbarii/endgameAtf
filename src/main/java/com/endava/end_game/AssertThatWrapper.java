package com.endava.end_game;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;

public class AssertThatWrapper {
    private static final String ASSERTION_EXPECTED_ACTUAL_MESSAGE = "%s%4$s - [EXPECTED]: %s%4$s - [ACTUAL]: %s";

    public static <T> void assertThat(final String message, final T actual, final Matcher<? super T> matcher) {
        final String fullMessage = "Assert that " + message;
        final String logMessage = getAssertionExpectedActualMessage(fullMessage, String.valueOf(matcher), valueOf(actual));
        try {
            MatcherAssert.assertThat(fullMessage, actual, matcher);
            System.out.println(logMessage);
        } catch (AssertionError error) {
            System.out.println(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    public static <T> void assertThat(final T actual, final Matcher<? super T> matcher) {
        final String fullMessage = "Assert that actual result matches the expected one";
        assertThat(fullMessage,actual, matcher);
    }

    private static String getAssertionExpectedActualMessage(final String fullMessage, final String expected, final String actual) {
        return format(ASSERTION_EXPECTED_ACTUAL_MESSAGE, fullMessage, expected, actual, lineSeparator());
    }
}