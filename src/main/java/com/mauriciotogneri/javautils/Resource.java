package com.mauriciotogneri.javautils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Resource
{
    private Resource()
    {
    }

    public static String string(InputStream inputStream)
    {
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
    }

    public static byte[] bytes(InputStream inputStream) throws IOException
    {
        int read;
        byte[] buffer = new byte[1024];

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        while ((read = inputStream.read(buffer, 0, buffer.length)) != -1)
        {
            bos.write(buffer, 0, read);
        }

        return bos.toByteArray();
    }

    public static String string(String pattern, Object... parameters)
    {
        return string(inputStream(String.format(pattern, parameters)));
    }

    public static byte[] bytes(String pattern, Object... parameters) throws IOException
    {
        return bytes(inputStream(String.format(pattern, parameters)));
    }

    public static InputStream inputStream(String path)
    {
        ClassLoader classLoader = Resource.class.getClassLoader();

        return classLoader.getResourceAsStream(path);
    }

    public static void save(File file, String content) throws IOException
    {
        File parent = file.getParentFile();

        if ((parent.exists() || parent.mkdirs()) && (file.exists() || file.createNewFile()))
        {
            try (FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()))
            {
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(content);
                bw.close();
            }
        }
    }

    public static boolean close(Closeable resource)
    {
        boolean result = false;

        if (resource != null)
        {
            try
            {
                resource.close();
                result = true;
            }
            catch (Exception e)
            {
                // exception swallowed on purpose
            }
        }

        return result;
    }

    public static boolean close(AutoCloseable resource)
    {
        boolean result = false;

        if (resource != null)
        {
            try
            {
                resource.close();
                result = true;
            }
            catch (Exception e)
            {
                // exception swallowed on purpose
            }
        }

        return result;
    }
}