package com.notryken.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.notryken.GolemsKillCreepers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IronGolemEntity.class)
public class IronGolemEntityMixin extends GolemEntity {

    protected IronGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Definition(
            id = "CreeperEntity",
            type = CreeperEntity.class

    )
    @Expression("? instanceof CreeperEntity")
    @ModifyExpressionValue(
            method = "method_6498",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean thisIsNotTheCreeperYouAreLookingFor1(
            boolean original,
            @Local(argsOnly = true) ServerWorld world
    ) {
        if (GolemsKillCreepers.doAttack(world)) {
            return false;
        }
        return original;
    }

    @Definition(
            id = "CreeperEntity",
            type = CreeperEntity.class

    )
    @Expression("? instanceof CreeperEntity")
    @ModifyExpressionValue(
            method = "pushAway",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private boolean thisIsNotTheCreeperYouAreLookingFor2(boolean original) {
        if (getEntityWorld() instanceof ServerWorld world && GolemsKillCreepers.doAttack(world)) {
            return false;
        }
        return original;
    }

    @Definition(
            id = "CREEPER",
            field = "Lnet/minecraft/entity/EntityType;CREEPER:Lnet/minecraft/entity/EntityType;"

    )
    @Expression("? == CREEPER")
    @ModifyExpressionValue(
            method = "canTarget",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private boolean thisIsNotTheCreeperYouAreLookingFor3(boolean original) {
        if (getEntityWorld() instanceof ServerWorld world && GolemsKillCreepers.doAttack(world)) {
            return false;
        }
        return original;
    }

    @ModifyExpressionValue(
            method = "tryAttack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/IronGolemEntity;getAttackDamage()F"
            )
    )
    private float yeetTheCreeper(float original, ServerWorld world, Entity target) {
        if (target instanceof CreeperEntity && GolemsKillCreepers.doInstakill(world)) {
            return Float.MAX_VALUE;
        }
        return original;
    }
}
