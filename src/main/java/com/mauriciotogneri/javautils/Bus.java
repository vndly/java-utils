package com.mauriciotogneri.javautils;

import org.greenrobot.eventbus.EventBus;

public class Bus
{
    private Bus()
    {
    }

    public static void register(Object subscriber)
    {
        register(subscriber, EventBus.getDefault());
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

    public static void unregister(Object subscriber)
    {
        unregister(subscriber, EventBus.getDefault());
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

    public static void post(Object event)
    {
        post(event, EventBus.getDefault());
    }

    public static void post(Object event, EventBus bus)
    {
        bus.post(event);
    }
}