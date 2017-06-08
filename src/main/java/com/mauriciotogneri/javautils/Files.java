package com.mauriciotogneri.javautils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Files
{
    public File create(File file) throws IOException
    {
        Record record = new Record(file);

        if (record.create())
        {
            return record.file();
        }
        else
        {
            throw new IOException(String.format("File '%s' cannot be created", file.getAbsolutePath()));
        }
    }

    public File create(String path) throws IOException
    {
        return create(new File(path));
    }

    public void copy(InputStream inputStream, OutputStream outputStream) throws IOException
    {
        int read;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1)
        {
            outputStream.write(bytes, 0, read);
        }

        outputStream.flush();

        close(outputStream);
    }

    public void close(Closeable closeable)
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