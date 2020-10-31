package Listener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

    public static String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    public static String pre = "§7[§cServer§7]";

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aDas §3Vanish-Plugin §awurde erfolgreich aktiviert!");

        getCommand("vanish").setExecutor(new CMD_Vanish());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Vanish-Plugin §4wurde erfolgreich deaktiviert!");
    }
}
