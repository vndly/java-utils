package com.mauriciotogneri.javautils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

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

    public Record(File parent, String path)
    {
        this(new File(parent, path));
    }

    public Record(Record parent, String path)
    {
        this(new File(parent.file, path));
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

    public long size()
    {
        return file.length();
    }

    public String extension()
    {
        String name = name();

        int index = name.lastIndexOf(".");

        if (index > -1)
        {
            String extension = name.substring(index + 1);

            return extension.trim();
        }
        else
        {
            return "";
        }
    }

    public Record parent()
    {
        return new Record(file.getParentFile());
    }

    public boolean rename(String name)
    {
        File newFile = new File(file.getParentFile(), name);

        return !newFile.exists() && file.renameTo(newFile);
    }

    public boolean isDirectory()
    {
        return file.isDirectory();
    }

    public List<Record> children()
    {
        List<Record> result = new ArrayList<>();

        if (isDirectory())
        {
            File[] children = file.listFiles();

            if (children != null)
            {
                for (File child : children)
                {
                    if (child != null)
                    {
                        result.add(new Record(child));
                    }
                }
            }
        }

        return result;
    }

    public boolean isFile()
    {
        return file.isFile();
    }

    public boolean createFile() throws IOException
    {
        File parent = file.getParentFile();

        return (parent.exists() || parent.mkdirs()) && (file.exists() || file.createNewFile());
    }

    public boolean createFolder() throws IOException
    {
        File parent = file.getParentFile();

        return (parent.exists() || parent.mkdirs());
    }

    public boolean copy(Record target) throws IOException
    {
        return copy(target, false);
    }

    public boolean move(Record target) throws IOException
    {
        return copy(target, true);
    }

    private boolean copy(Record target, boolean delete) throws IOException
    {
        if (target.isFile())
        {
            throw new IOException(String.format("Cannot copy '%s' to '%s'", path(), target.path()));
        }

        if (isDirectory())
        {
            Record targetFolder = new Record(target, name());
            targetFolder.createFolder();

            boolean allCopied = true;

            for (Record record : children())
            {
                allCopied &= record.copy(targetFolder, delete);
            }

            if (delete && allCopied)
            {
                return delete();
            }
            else
            {
                return allCopied;
            }
        }
        else
        {
            Record targetFile = new Record(target, name());
            targetFile.createFile();

            InputStream input = new FileInputStream(file);
            OutputStream output = new FileOutputStream(targetFile.file);

            Streams.copy(input, output);

            return !delete || delete();
        }
    }

    public boolean delete()
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
        if (createFile())
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

    @Override
    public String toString()
    {
        return path();
    }
}