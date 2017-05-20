package com.mauriciotogneri.javautils;

public class EnumValue
{
    public static <T extends Enum<T>> T from(Class<T> clazz, String text, T defaultValue)
    {
        for (T value : clazz.getEnumConstants())
        {
            if (value.toString().equals(text))
            {
                return value;
            }
        }

        return defaultValue;
    }

    public static <T extends Enum<T>> T from(Class<T> clazz, String text)
    {
        return from(clazz, text, null);
    }

    public static <T extends Enum> T random(Class<T> clazz)
    {
        T[] values = clazz.getEnumConstants();

        return values[Randomized.of(0, values.length - 1)];
    }
}