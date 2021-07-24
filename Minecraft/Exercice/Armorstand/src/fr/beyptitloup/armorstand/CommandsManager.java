package fr.beyptitloup.armorstand;

public class CommandsManager {

	public static void register(Armorstand instance) {
		instance.getCommand("spawn").setExecutor(new SpawnArmorstandCommand(instance));
	}

}
