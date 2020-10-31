package Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Vanish implements CommandExecutor {

    String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    String pre = "§7[§cServer§7]";

    public static List<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;

        Player p = (Player) sender;
        if (!p.hasPermission("p.vanish")) return true;

        if (args.length == 0) {
            if (vanished.contains(p)) {
                vanished.remove(p);
                p.sendMessage(pre + " §cDu bist nun sichtbar!");
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.showPlayer(p);
                }
            } else {
                vanished.add(p);
                p.sendMessage(pre + "");
                for (Player all : Bukkit.getOnlinePlayers()) {

                    if (!all.hasPermission("sys.vanish.see")) {
                        all.hidePlayer(p);
                    }
                }
            }
        }
        return false;
    }
}