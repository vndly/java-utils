package com.mauriciotogneri.javautils;

import java.util.Random;

public class Randomized
{
    private static final Random random = new Random();

    private Randomized()
    {
    }

    // 3 out of 5 => [ 0 1 2 ] 3 4
    public static Boolean chance(Integer valid, Integer outOf)
    {
        return (nextInt(outOf) < valid);
    }

    public static Boolean chance(Integer outOf)
    {
        return (nextInt(outOf) == 0);
    }

    public static Integer of(Integer min, Integer max)
    {
        return nextInt((max - min) + 1) + min;
    }

    public static Integer nextInt()
    {
        return random.nextInt();
    }

    public static Integer nextInt(Integer max)
    {
        return random.nextInt(max);
    }

    public static Long nextLong()
    {
        return random.nextLong();
    }

    public static Double nextDouble()
    {
        return random.nextDouble();
    }

    public static Double nextDouble(Integer places)
    {
        return nextDouble() * Math.pow(10, places);
    }

    public static Double nextDouble(Double max)
    {
        return nextDouble() * max;
    }

    public static Double nextSignedDouble()
    {
        return nextDouble() * sign();
    }

    public static Double nextSignedDouble(Double max)
    {
        return nextDouble(max) * sign();
    }

    public static Integer sign()
    {
        return (nextBoolean() ? 1 : -1);
    }

    public static Boolean nextBoolean()
    {
        return random.nextBoolean();
    }
}