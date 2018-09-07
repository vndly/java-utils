package com.mauriciotogneri.javautils;

import org.greenrobot.eventbus.EventBus;

public class Bus
{
    private Bus()
    {
    }

    public static void register(Object subscriber, EventBus bus)
    {
        try
        {
            if (!bus.isRegistered(subscriber))
            {
                bus.register(subscriber);
            }
        }
        catch (Exception e)
        {
            // ignore
        }
    }

    public static void unregister(Object subscriber, EventBus bus)
    {
        try
        {
            if (bus.isRegistered(subscriber))
            {
                bus.unregister(subscriber);
            }
        }
        catch (Exception e)
        {
            // ignore
        }
    }
}