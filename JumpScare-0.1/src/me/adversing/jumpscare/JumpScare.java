package me.Adversing.jumpscare;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.Adversing.jumpscare.command.CommandFramework;
import me.Adversing.jumpscare.commands.JumpScareCommand;

public class JumpScare extends JavaPlugin {
	
	private CommandFramework cf;
	private static JumpScare instance;
	
	public void onEnable() {
		instance = this;
		registerCommands();
		Bukkit.getConsoleSender().sendMessage("§5[JS] §6Plugin abilitato.");
	}
	
	public void onDisable() {
		instance = null;
	}
	
	public static JumpScare getInstance() {
		return instance;
	}
	
	public void registerCommands() {
		cf = new CommandFramework(this);
		cf.registerCommands(new JumpScareCommand());
	}
}
