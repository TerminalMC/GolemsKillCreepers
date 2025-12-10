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

package dev.terminalmc.golemskillcreepers.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.terminalmc.golemskillcreepers.GolemsKillCreepers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.golem.AbstractGolem;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IronGolem.class)
public class IronGolemFabricMixin extends AbstractGolem {

    protected IronGolemFabricMixin(EntityType<? extends @NotNull AbstractGolem> entityType, Level world) {
        super(entityType, world);
    }

    @Definition(
            id = "Creeper",
            type = Creeper.class

    )
    @Expression("? instanceof Creeper")
    @ModifyExpressionValue(
            method = "method_6498",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean thisIsNotTheCreeperYouAreLookingFor1(
            boolean original,
            @Local(argsOnly = true) ServerLevel world
    ) {
        if (GolemsKillCreepers.doAttack(world)) {
            return false;
        }
        return original;
    }
}
