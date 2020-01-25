package cn.mmf.ct_slashblade;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.data.NBTConverter;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.item.IItemStack")
@ZenRegister
public class CTSlashBladeExpansion {
	@ZenMethod
	public static IItemStack setBaseAttackModifier(IItemStack stack,float attack) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.setBaseAttackModifier(tag, attack);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setTextureName(IItemStack stack,String name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.TextureName.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setModelName(IItemStack stack,String name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.ModelName.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setDefaultProudSoul(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.ProudSoul.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setDefaultKillCount(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.KillCount.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setStandbyRenderType(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.StandbyRenderType.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setSpecialAttackType(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.SpecialAttackType.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setDefaultRepairCount(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.RepairCount.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setSummonedSwordColor(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBlade.SummonedSwordColor.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setCurrentItemName(IItemStack stack,String name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBladeNamed.CurrentItemName.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setDefaultBewitched(IItemStack stack) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBladeNamed.IsDefaultBewitched.set(tag, true);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setCustomMaxDamage(IItemStack stack,int name) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
		ItemSlashBladeNamed.CustomMaxDamage.set(tag, name);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
	@ZenMethod
	public static IItemStack setSpecialEffectType(IItemStack stack,String name,int level) {
		NBTTagCompound tag = new NBTTagCompound();
		if(stack.getTag()!=null) tag = (NBTTagCompound) NBTConverter.from(stack.getTag());
	    NBTTagCompound etag = new NBTTagCompound();
	    tag.setTag("SB.SEffect", etag);
	    etag.setInteger(name, level);
		return stack.withTag(NBTConverter.from(tag, false),true);
	}
}
