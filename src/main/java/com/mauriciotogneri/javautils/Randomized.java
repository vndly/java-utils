package com.mauriciotogneri.javautils;

import java.util.Random;

public class Randomized
{
    private static final Random random = new Random();

    private Randomized()
    {
    }

    // 3 out of 5 => [ 0 1 2 ] 3 4
    public static boolean chance(int valid, int outOf)
    {
        return (nextInt(outOf) < valid);
    }

    public static boolean chance(int outOf)
    {
        return (nextInt(outOf) == 0);
    }

    public static int of(int min, int max)
    {
        return nextInt((max - min) + 1) + min;
    }

    public static int nextInt()
    {
        return random.nextInt();
    }

    public static int nextInt(int max)
    {
        return random.nextInt(max);
    }

    public static long nextLong()
    {
        return random.nextLong();
    }

    public static double nextDouble()
    {
        return random.nextDouble();
    }

    public static double nextDouble(int places)
    {
        return nextDouble() * Math.pow(10, places);
    }

    public static double nextDouble(double max)
    {
        return nextDouble() * max;
    }

    public static double nextSignedDouble()
    {
        return nextDouble() * sign();
    }

    public static double nextSignedDouble(double max)
    {
        return nextDouble(max) * sign();
    }

    public static int sign()
    {
        return (nextBoolean() ? 1 : -1);
    }

    public static boolean nextBoolean()
    {
        return random.nextBoolean();
    }
}