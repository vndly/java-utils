package com.mauriciotogneri.jsonschema;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public static <T> T[] asArray(List<T> list, Class<T> clazz)
    {
        T[] result = (T[]) Array.newInstance(clazz, list.size());

        list.toArray(result);

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