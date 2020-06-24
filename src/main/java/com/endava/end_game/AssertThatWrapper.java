package com.endava.end_game;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;
import static java.lang.System.lineSeparator;

public class AssertThatWrapper {
    private static final Logger logger = LogManager.getLogger(AssertThatWrapper.class);
    private static final String ASSERTION_EXPECTED_ACTUAL_MESSAGE = "%s%4$s - [EXPECTED]: %s%4$s - [ACTUAL]: %s";

    public static <T> void assertThat(final String message, final T actual, final Matcher<? super T> matcher) {
        final String fullMessage = "Assert that " + message;
        final String logMessage = format(ASSERTION_EXPECTED_ACTUAL_MESSAGE, fullMessage, matcher, actual, lineSeparator());
        try {
            MatcherAssert.assertThat(fullMessage, actual, matcher);
            logger.info(logMessage);
        } catch (AssertionError error) {
            logger.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    public static <T> void assertThat(final T actual, final Matcher<? super T> matcher) {
        final String fullMessage = "Assert that actual result matches the expected one";
        assertThat(fullMessage,actual, matcher);
    }
}