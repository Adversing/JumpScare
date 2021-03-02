package me.Adversing.jumpscare.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Adversing.jumpscare.JumpScare;
import me.Adversing.jumpscare.command.Command;
import me.Adversing.jumpscare.command.CommandArgs;

public class JumpScareCommand {
	@Command(name = "jumpscare", permission = "jumpscare.use", inGameOnly = true)
	public void onCommand(CommandArgs cmd) {
		CommandSender sender = cmd.getSender();
		String[] args = cmd.getArgs();
		if (args.length != 1) {
			sender.sendMessage("§cParametri non validi.");
			sender.sendMessage("§cUtilizzo: /jumpscare <player>");
			return;
		}
		Player target = Bukkit.getPlayer(args[0]);
		if (target == null) {
			sender.sendMessage("§cPlayer non valido.");
			return;
		}
		
		if (target == sender) {
			sender.sendMessage("§4E allora sei coglione.");
			target.playSound(target.getLocation(), Sound.ENDERDRAGON_DEATH, Integer.MAX_VALUE, Integer.MAX_VALUE);
			return;
		}
		
		sender.sendMessage("§aHai fatto cagare sotto " + target.getName());
		target.sendMessage("§4BOOO!");
		target.playSound(target.getLocation(), Sound.ENDERDRAGON_DEATH, Integer.MAX_VALUE, Integer.MAX_VALUE);
		return;
	}
}
