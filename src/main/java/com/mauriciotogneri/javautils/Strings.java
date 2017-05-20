package com.mauriciotogneri.javautils;

import java.util.Arrays;

public class Strings
{
    private Strings()
    {
    }

    public static Boolean isEmpty(String value)
    {
        return (value == null) || (value.isEmpty());
    }

    public static Boolean isNotEmpty(String value)
    {
        return !isEmpty(value);
    }

    public static String trim(String value)
    {
        return (value != null) ? value.trim() : null;
    }

    public static String join(Iterable<?> list, String separator)
    {
        StringBuilder builder = new StringBuilder();

        for (Object element : list)
        {
            if (builder.length() != 0)
            {
                builder.append(separator);
            }

            builder.append(element.toString());
        }

        return builder.toString();
    }

    public static String join(Object[] list, String separator)
    {
        return join(Arrays.asList(list), separator);
    }

    public static Boolean equals(String a, String b)
    {
        return (a != null) && (b != null) && (a.equals(b));
    }
}