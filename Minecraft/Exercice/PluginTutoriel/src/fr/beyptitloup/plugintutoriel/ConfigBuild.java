package fr.beyptitloup.plugintutoriel;

import java.util.List;

public class ConfigBuild {
    public static String getString(String value){ return Manager.getInstance().getConfig().getString(value).replaceAll("&","§"); }

    public static int getInt(String value){
        return Manager.getInstance().getConfig().getInt(value);
    }

    public static boolean getBoolean(String value){ return Manager.getInstance().getConfig().getBoolean(value); }

    public static List getList(String value){
        return Manager.getInstance().getConfig().getList(value);
    }

    public static double getDouble(String value){
        return Manager.getInstance().getConfig().getDouble(value);
    }

    public static void set(String value, String data){
        Manager.getInstance().getConfig().set(value, data);
        Manager.getInstance().saveConfig();
        Manager.getInstance().reloadConfig();
    }

    public static void reload(){ Manager.getInstance().reloadConfig(); }
}