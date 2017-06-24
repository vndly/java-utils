package com.mauriciotogneri.javautils;

public class EnumValue
{
    public enum Mode
    {
        NORMAL,
        UPPERCASE,
        LOWERCASE;

        public String format(String text)
        {
            if (text != null)
            {
                if (this == UPPERCASE)
                {
                    return text.toUpperCase();
                }
                else if (this == LOWERCASE)
                {
                    return text.toLowerCase();
                }
            }

            return text;
        }
    }

    public static <T extends Enum<T>> T from(Class<T> clazz, String text, T defaultValue, Mode mode)
    {
        String input = mode.format(text);

        for (T value : clazz.getEnumConstants())
        {
            if (value.toString().equals(input))
            {
                return value;
            }
        }

        return defaultValue;
    }

    public static <T extends Enum<T>> T from(Class<T> clazz, String text, T defaultValue)
    {
        return from(clazz, text, defaultValue, Mode.NORMAL);
    }

    public static <T extends Enum<T>> T from(Class<T> clazz, String text, Mode mode)
    {
        return from(clazz, text, null, mode);
    }

    public static <T extends Enum<T>> T from(Class<T> clazz, String text)
    {
        return from(clazz, text, null, Mode.NORMAL);
    }

    public static <T extends Enum> T random(Class<T> clazz)
    {
        T[] values = clazz.getEnumConstants();

        return values[Randomized.of(0, values.length - 1)];
    }
}