
package net.mcreator.youtubersmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.youtubersmod.item.YTItem;
import net.mcreator.youtubersmod.YoutubersmodModElements;

@YoutubersmodModElements.ModElement.Tag
public class YouTubersItemGroup extends YoutubersmodModElements.ModElement {
	public YouTubersItemGroup(YoutubersmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabyou_tubers") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(YTItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
