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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IronGolem.class)
public class IronGolemNeoForgeMixin extends AbstractGolem {

    protected IronGolemNeoForgeMixin(EntityType<? extends AbstractGolem> entityType, Level world) {
        super(entityType, world);
    }

    @Definition(
            id = "Creeper",
            type = Creeper.class

    )
    @Expression("? instanceof Creeper")
    @ModifyExpressionValue(
            method = "lambda$registerGoals$0",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean thisIsNotTheCreeperYouAreLookingFor1(
            boolean original,
            @Local(argsOnly = true) LivingEntity entity
    ) {
        if (GolemsKillCreepers.doAttack(entity.level())) {
            return false;
        }
        return original;
    }
}
