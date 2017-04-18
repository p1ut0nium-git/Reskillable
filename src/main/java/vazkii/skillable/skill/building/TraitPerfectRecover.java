package vazkii.skillable.skill.building;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import vazkii.skillable.skill.Skills;
import vazkii.skillable.skill.base.Trait;

public class TraitPerfectRecover extends Trait {

	public TraitPerfectRecover() {
		super("perfect_recover", 1, 1, 4);
		addRequirement(Skills.building, 8);
		addRequirement(Skills.gathering, 6);
		addRequirement(Skills.mining, 6);
	}

	@Override
	public void onBlockDrops(HarvestDropsEvent event) { 
		if(event.getState().getBlock() == Blocks.GLOWSTONE) {
			event.getDrops().removeIf((s) -> s.getItem() == Items.GLOWSTONE_DUST);
			event.getDrops().add(new ItemStack(Items.GLOWSTONE_DUST, 4));
		}
		else if(event.getState().getBlock() == Blocks.SEA_LANTERN) {
			event.getDrops().removeIf((s) -> s.getItem() == Items.PRISMARINE_CRYSTALS);
			event.getDrops().add(new ItemStack(Items.PRISMARINE_CRYSTALS, 5));
			event.getDrops().add(new ItemStack(Items.PRISMARINE_SHARD, 4));
		} else for(ItemStack stack : event.getDrops())
			if(stack.getItem().getRegistryName().toString().equals("quark:glass_shards") && stack.getCount() < 4)
				stack.setCount(4);
	}

}