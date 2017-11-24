package com.mauriciotogneri.javautils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lists
{
    private Lists()
    {
    }

    public static <T> T random(List<T> list)
    {
        return list.get(Randomized.nextInt(list.size()));
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] asArray(Collection<T> list, Class<T> clazz)
    {
        T[] result = (T[]) Array.newInstance(clazz, list.size());

        list.toArray(result);

        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] arrayAppend(T[] array, T value, Class<T> clazz)
    {
        T[] result = (T[]) Array.newInstance(clazz, array.length + 1);
        System.arraycopy(array, 0, result, 0, array.length);
        result[result.length - 1] = value;

        return result;
    }

    public static <T> List<T> split(String list, String separator, Factory<T> factory)
    {
        List<T> result = new ArrayList<>();

        if (list != null)
        {
            String[] parts = list.split(separator);

            for (String part : parts)
            {
                T element;

                try
                {
                    element = factory.create(part);
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }

                result.add(element);
            }
        }

        return result;
    }

    public interface Factory<T>
    {
        T create(String input) throws Exception;
    }
}