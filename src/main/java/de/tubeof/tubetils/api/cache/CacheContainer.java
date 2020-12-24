package de.tubeof.tubetils.api.cache;

import de.tubeof.tubetils.data.Data;
import de.tubeof.tubetils.main.TubeTils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class CacheContainer {

    private final Data data = TubeTils.getData();
    private final ConsoleCommandSender ccs = Bukkit.getConsoleSender();

    private String cacheContainerName;

    public CacheContainer(String cacheContainerName) {
        if(data.isDebuggingEnabled()) ccs.sendMessage(TubeTils.getData().getPrefix() + "Created new CacheContainer with name: " + cacheContainerName);
        this.cacheContainerName = cacheContainerName;
    }

    private final HashMap<Class, HashMap<String, Object>> objectHashMap = new HashMap<>();

    public void registerCacheType(Class paramClass) {

        HashMap<String, Object> map = new HashMap<>();

        objectHashMap.put(paramClass, map);
        if(data.isDebuggingEnabled()) ccs.sendMessage(TubeTils.getData().getPrefix() + "Created new Cache-Type: " + paramClass.getSimpleName() + " [" + cacheContainerName + "]");
    }

    public void add(Class paramClass, String valueName, Object content) {
        objectHashMap.get(paramClass).put(valueName, content);
    }

    public Object get(Class paramClass, String valueName) {
        return objectHashMap.get(paramClass).get(valueName);
    }

}