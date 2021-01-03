package com.skullzbones.devbeans.Events;

import com.skullzbones.devbeans.Devbeans;
import com.skullzbones.devbeans.Events.allevents.BuildBeanWandEvent;

public class EventsRegistrar {
    public static void RegisterAllEvents(Devbeans devbeans){
        //#TODO Register All Events Here!s
        devbeans.getServer().getPluginManager().registerEvents(new BuildBeanWandEvent(), devbeans);
    }
}
