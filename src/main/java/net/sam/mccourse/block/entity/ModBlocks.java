package net.sam.mccourse.block.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sam.mccourse.MCCourseMod;
import net.sam.mccourse.block.custom.JavaBlock;
import net.sam.mccourse.item.ModCreativeModeTab;
import net.sam.mccourse.item.ModItems;
import net.sam.mccourse.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> JAVA_BLOCK = registerBlock("java_block",
            () -> new JavaBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE)
                    .strength(0f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB, "tooltip.block.java_block");

    public static final RegistryObject<Block> SYNTAX_BLOCK = registerBlock("syntax_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB, "tooltip.block.syntax_block");

    public static final RegistryObject<Block> VAR_BLOCK = registerBlock("var_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(ModSounds.VAR_BLOCK_SOUNDS)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB, "tooltip.block.var_block");



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
