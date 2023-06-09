package betathunder.diamondbarrels;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import betathunder.diamondbarrels.init.ModBlocks;
import betathunder.diamondbarrels.init.ModItems;
import betathunder.diamondbarrels.proxy.CommonProxy;
import betathunder.diamondbarrels.util.handlers.RegistryHandler;

@Mod(modid = DiamondBarrels.MODID, name = DiamondBarrels.NAME, version = DiamondBarrels.VERSION)
public class DiamondBarrels
{
	
	@Instance
	public static DiamondBarrels instance;
	public static final int GUI_WOOD_BARREL = 2;
	public static final int GUI_IRON_BARREL = 1;
	public static final int GUI_DIAMOND_BARREL = 3;
	public static final int GUI_OBSIDIAN_BARREL = 5;
	
    public static final String MODID = "diamondbarrels";
    public static final String NAME = "Diamond Barrels";
    public static final String VERSION = "1.1";
    public static final String CLIENT_PROXY_CLASS = "betathunder.diamondbarrels.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "betathunder.diamondbarrels.proxy.CommonProxy";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("BLOCKS >> {}", ModBlocks.BLOCKS);
        logger.info("ITEMS >> {}", ModItems.ITEMS);
        RegistryHandler.initRegistries(event);
    }
    
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
	
}
