package com.notryken;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GolemsKillCreepers implements ModInitializer {

    public static final String MOD_ID = "golems-kill-creepers";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static final GameRules.Key<GameRules.BooleanRule> DO_IRON_GOLEMS_ATTACK_CREEPERS =
            GameRuleRegistry.register(
                    "doIronGolemsAttackCreepers",
                    Category.MOBS,
                    GameRuleFactory.createBooleanRule(true)
            );

    public static final GameRules.Key<GameRules.BooleanRule> DO_IRON_GOLEMS_INSTAKILL_CREEPERS =
            GameRuleRegistry.register(
                    "doIronGolemsInstakillCreepers",
                    Category.MOBS,
                    GameRuleFactory.createBooleanRule(true)
            );

    @Override
    public void onInitialize() {
    }

    public static boolean doAttack(World world) {
        return world.getGameRules().getBoolean(DO_IRON_GOLEMS_ATTACK_CREEPERS);
    }

    public static boolean doInstakill(World world) {
        return world.getGameRules().getBoolean(DO_IRON_GOLEMS_INSTAKILL_CREEPERS);
    }
}
