package helpertools.Common;

import helpertools.Main;
import helpertools.Common.Items.ItemChocolateMilk;
import helpertools.Common.Items.ItemMilkBottle;
import helpertools.Common.Tools.ItemStaffofExpansion;
import helpertools.Common.Tools.ItemStaffofTransformation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

	public static Item chocolatemilk;
	public static Item milkbottle;
	public static Item expandertool;
	public static Item exchange_tool;

	public static void createItems() {
		Main.logger.info("Registering items");
		GameRegistry.registerItem(chocolatemilk = new ItemChocolateMilk(3, 0.5f, true, "chocolatemilk_item"), "chocolatemilk_item");
		GameRegistry.registerItem(milkbottle = new ItemMilkBottle("bottledmilk_item"), "bottledmilk_item");
		GameRegistry.registerItem(expandertool = new ItemStaffofExpansion(ConfigurationFactory.ExpRodMatt, "expander_item"), "expander_item");
		GameRegistry.registerItem(exchange_tool = new ItemStaffofTransformation(ConfigurationFactory.ExpRodMatt, "exchange_item"), "exchange_item");
	
	}
	
	

}
