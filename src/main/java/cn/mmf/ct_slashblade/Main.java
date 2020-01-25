package cn.mmf.ct_slashblade;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, dependencies = 
"required-after:forge@[14.23.4.2768,);required-after:flammpfeil.slashblade@[mc1.12-r17,);required-after:crafttweaker;")
public class Main {
    public static final String MODID = "ct_slashblade";
    public static final String NAME = "SlashBladeCraftTweaker";
    public static final String VERSION = "@version@";

    public static Logger logger;
    public static List<IAction> actions = new ArrayList<IAction>();
    public static List<IAction> recipe_actions = new ArrayList<IAction>();
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	doRegisterTask();
    }

	public static void addAction(IAction action) {
        actions.add(action);
    }

    public static void doRegisterTask() {
        for (IAction act : actions) {
            CraftTweakerAPI.apply(act);
            if (act.describe() != null)
            	logger.log(Level.INFO, act.describe());
        }
        actions.clear();
    }

}
