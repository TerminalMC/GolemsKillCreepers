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

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.Category;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod(value = GolemsKillCreepers.MOD_ID)
@EventBusSubscriber(modid = GolemsKillCreepers.MOD_ID)
public class GolemsKillCreepersForge {

    public GolemsKillCreepersForge() {
        // Register game rules
        GolemsKillCreepers.DO_IRON_GOLEMS_ATTACK_CREEPERS = GameRules.register(
                "doIronGolemsAttackCreepers",
                Category.MOBS,
                GameRules.BooleanValue.create(true)
        );
        GolemsKillCreepers.DO_IRON_GOLEMS_INSTAKILL_CREEPERS = GameRules.register(
                "doIronGolemsInstakillCreepers",
                Category.MOBS,
                GameRules.BooleanValue.create(true)
        );
        // Initialize mod
        GolemsKillCreepers.init();
    }
}
