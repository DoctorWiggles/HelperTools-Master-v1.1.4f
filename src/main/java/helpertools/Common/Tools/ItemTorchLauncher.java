package helpertools.Common.Tools;

import helpertools.Common.ItemRegistry;
import helpertools.Common.Entity.Entity_DynamiteProjectile;
import helpertools.Common.Entity.Entity_RedTorchProjectile;
import helpertools.Common.Entity.Entity_TorchProjectile;
import helpertools.Utils.HelpTab;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class ItemTorchLauncher extends ToolBase_Crossbow{

   public ItemTorchLauncher(ToolMaterial material, String unlocalizedName) {
       super(material);
       this.maxStackSize = 1;  
       setUnlocalizedName(unlocalizedName);
       setCreativeTab(HelpTab.HelperTools);
       
   }
   @Override
   public void addInformation(ItemStack stack, EntityPlayer entity, List list, boolean par4)
   {
	   list.add(EnumChatFormatting.ITALIC + "fires torches ");
	   list.add(EnumChatFormatting.ITALIC + "& more");
	   if (stack.hasTagCompound()){
		    if(whatModeString(stack) != "null"){
		    	list.add(whatModeString(stack)+ " mode");
		    	//list.add(getTload(stack)+ "");
		    	}}
   }
   
     
	 public void onCreated(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) 
	 {
		 //Add unique name for bow
		 // Player's Torch Launcher
	 }
	
	//Tinker's Construct Stone Torch Support
	
	String TinkTorch = "TConstruct:decoration.stonetorch";
	//String TinkTorch = "HelperToolsID:SugarBlock";
	String Tcon = "TConstruct";
	//String Tcon = "HelperToolsID";
	
	public boolean StoneTorchSearch(EntityLivingBase entityLiving) {
		
		if(Loader.isModLoaded(Tcon))
		 {			
			 return ((EntityPlayer) entityLiving).inventory.hasItem(Item.getItemFromBlock(Block.getBlockFromName(TinkTorch)));
			 
			}
		 else
			return false;
			};
			
	public boolean StoneTorchConsume(EntityLivingBase entityLiving) {
		
		if(Loader.isModLoaded(Tcon))
		 {			
			 return ((EntityPlayer)entityLiving).inventory.consumeInventoryItem(Item.getItemFromBlock(Block.getBlockFromName(TinkTorch)));
					 
			}
		 else
			return false;
			};
			
			
   @Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
   {
	   EntityPlayer player = (EntityPlayer) entityLiving;
	   World world = entityLiving.worldObj;
	   
	   if(world.isRemote){return false;}
		  
		if (entityLiving.isSneaking() )
		{ 	
			if(Transfer_Mode(stack, world, player)){
				return true;
			}
			else {return false;}
		}  
		 return false;
   }
   
   @Override
   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
   {	
	   if( player.worldObj.isRemote){return stack;}
	   
	   if(!player.isSneaking() && getTload(stack) ==2){
		   //Firing function
		   crossbow_FIRE(stack, world, player);       	   
   		}
	   	if(player.isSneaking() && getTload(stack)== 0){
	   		//Loading function
	   		crossbow_LOAD(stack, world, player);
	   	}	  
	   	return stack;
   }
}
