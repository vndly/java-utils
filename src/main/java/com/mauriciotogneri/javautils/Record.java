package com.mauriciotogneri.javautils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Record
{
    private final File file;

    public Record(File file)
    {
        this.file = file;
    }

    public Record(String path)
    {
        this(new File(path));
    }

    public File file()
    {
        return file;
    }

    public boolean exists()
    {
        return file.exists();
    }

    public String name()
    {
        return file.getName();
    }

    public String path()
    {
        return file.getAbsolutePath();
    }

    public Record parent()
    {
        return new Record(file.getParentFile());
    }

    public boolean isDirectory()
    {
        return file.isDirectory();
    }

    public boolean isFile()
    {
        return file.isFile();
    }

    public boolean create() throws IOException
    {
        File parent = file.getParentFile();

        return ((parent.exists() || parent.mkdirs()) && (file.exists() || file.createNewFile()));
    }

    public boolean remove()
    {
        return file.exists() && file.delete();
    }

    public String string() throws IOException
    {
        return new String(bytes());
    }

    public byte[] bytes() throws IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bytes = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bytes);
        randomAccessFile.close();

        return bytes;
    }

    public boolean write(String content) throws IOException
    {
        return write(content.getBytes("UTF-8"));
    }

    public boolean write(byte[] data) throws IOException
    {
        if (create())
        {
            FileOutputStream outputStream = null;

            try
            {
                outputStream = new FileOutputStream(file);
                outputStream.write(data);
                outputStream.flush();
            }
            finally
            {
                if (outputStream != null)
                {
                    outputStream.close();
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}