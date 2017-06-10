package com.mauriciotogneri.javautils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams
{
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException
    {
        try
        {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes, 0, read);
            }

            outputStream.flush();
        }
        finally
        {
            close(inputStream);
            close(outputStream);
        }
    }

    public static void close(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            catch (Exception e)
            {
                // ignore
            }
        }
    }
}