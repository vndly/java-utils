package com.mauriciotogneri.javautils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

import java.util.Locale;

public class FormattedDateTime
{
    private final DateTimeFormatter formatter;

    public FormattedDateTime(DateTimeFormatter formatter, DateTimeFormatter... formatters)
    {
        this.formatter = new DateTimeFormatterBuilder().append(formatter.getPrinter(), parsers(formatter, formatters)).toFormatter();
    }

    public FormattedDateTime(String pattern, String... patterns)
    {
        this.formatter = new DateTimeFormatterBuilder().append(DateTimeFormat.forPattern(pattern).getPrinter(), parsers(pattern, patterns)).toFormatter();
    }

    public FormattedDateTime()
    {
        this("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    private DateTimeParser[] parsers(DateTimeFormatter formatter, DateTimeFormatter... formatters)
    {
        DateTimeParser[] parsers = new DateTimeParser[formatters.length + 1];
        parsers[0] = formatter.getParser();

        for (int i = 0; i < formatters.length; i++)
        {
            parsers[i + 1] = formatters[i].getParser();
        }

        return parsers;
    }

    private DateTimeParser[] parsers(String pattern, String... patterns)
    {
        DateTimeParser[] parsers = new DateTimeParser[patterns.length + 1];
        parsers[0] = DateTimeFormat.forPattern(pattern).getParser();

        for (int i = 0; i < patterns.length; i++)
        {
            parsers[i + 1] = DateTimeFormat.forPattern(patterns[i]).getParser();
        }

        return parsers;
    }

    // ============================================================================================

    public String date(DateTime dateTime, DateTimeZone timeZone, Locale locale, String defaultValue)
    {
        try
        {
            return formatter.withZone(timeZone).withLocale(locale).print(dateTime);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    public String date(DateTime dateTime, Locale locale, String defaultValue)
    {
        return date(dateTime, DateTimeZone.getDefault(), locale, defaultValue);
    }

    public String date(DateTime dateTime, DateTimeZone timeZone, Locale locale)
    {
        return date(dateTime, timeZone, locale, null);
    }

    public String date(DateTime dateTime, Locale locale)
    {
        return date(dateTime, DateTimeZone.getDefault(), locale, null);
    }

    // ============================================================================================

    public DateTime date(String timestamp, DateTimeZone timeZone, DateTime defaultValue)
    {
        try
        {
            return formatter.withZone(timeZone).parseDateTime(timestamp);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    public DateTime date(String timestamp, DateTime defaultValue)
    {
        return date(timestamp, DateTimeZone.getDefault(), defaultValue);
    }

    public DateTime date(String timestamp, DateTimeZone timeZone)
    {
        return date(timestamp, timeZone, null);
    }

    public DateTime date(String timestamp)
    {
        return date(timestamp, DateTimeZone.getDefault(), null);
    }
}