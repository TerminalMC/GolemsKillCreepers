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

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRuleCategory;

@SuppressWarnings("unused")
public class GolemsKillCreepersFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        // Register game rules
        GolemsKillCreepers.DO_IRON_GOLEMS_ATTACK_CREEPERS = GameRuleBuilder
                .forBoolean(true)
                .category(GameRuleCategory.MOBS)
                .buildAndRegister(
                        Identifier.fromNamespaceAndPath(
                                GolemsKillCreepers.MOD_ID,
                                "iron_golems_attack_creepers"
                        ));
        GolemsKillCreepers.DO_IRON_GOLEMS_INSTAKILL_CREEPERS = GameRuleBuilder
                .forBoolean(true)
                .category(GameRuleCategory.MOBS)
                .buildAndRegister(
                        Identifier.fromNamespaceAndPath(
                                GolemsKillCreepers.MOD_ID,
                                "iron_golems_instakill_creepers"
                        )
                );

        // Initialize client
        GolemsKillCreepers.init();
    }
}
