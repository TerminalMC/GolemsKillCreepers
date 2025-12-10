/*
 * Copyright 2025 TerminalMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.terminalmc.golemskillcreepers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(value = GolemsKillCreepers.MOD_ID)
@EventBusSubscriber(modid = GolemsKillCreepers.MOD_ID)
public class GolemsKillCreepersNeoForge {

    public GolemsKillCreepersNeoForge() {
        // Initialize mod
        GolemsKillCreepers.init();
    }

    @SubscribeEvent
    static void registerSetup(RegisterEvent event) {
        if (event.getRegistry().equals(BuiltInRegistries.GAME_RULE)) {
            // Register game rules
            GolemsKillCreepers.DO_IRON_GOLEMS_ATTACK_CREEPERS = GameRules.registerBoolean(
                    Identifier.fromNamespaceAndPath(
                            GolemsKillCreepers.MOD_ID,
                            "iron_golems_attack_creepers"
                    ).toString(),
                    GameRuleCategory.MOBS,
                    true
            );
            GolemsKillCreepers.DO_IRON_GOLEMS_INSTAKILL_CREEPERS = GameRules.registerBoolean(
                    Identifier.fromNamespaceAndPath(
                            GolemsKillCreepers.MOD_ID,
                            "iron_golems_instakill_creepers"
                    ).toString(),
                    GameRuleCategory.MOBS,
                    true
            );
        }
    }
}
