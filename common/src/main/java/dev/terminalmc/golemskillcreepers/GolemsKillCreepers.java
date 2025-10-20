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

import dev.terminalmc.golemskillcreepers.util.ModLogger;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;

public class GolemsKillCreepers {

    public static final String MOD_ID = "golemskillcreepers";
    public static final String MOD_NAME = "GolemsKillCreepers";
    public static final ModLogger LOG = new ModLogger(MOD_NAME);

    public static GameRules.Key<GameRules.BooleanValue> DO_IRON_GOLEMS_ATTACK_CREEPERS;
    public static GameRules.Key<GameRules.BooleanValue> DO_IRON_GOLEMS_INSTAKILL_CREEPERS;

    /**
     * Client initialization.
     */
    public static void init() {
    }

    public static boolean doAttack(ServerLevel world) {
        return world.getGameRules().getBoolean(DO_IRON_GOLEMS_ATTACK_CREEPERS);
    }

    public static boolean doInstakill(ServerLevel world) {
        return world.getGameRules().getBoolean(DO_IRON_GOLEMS_INSTAKILL_CREEPERS);
    }
}
