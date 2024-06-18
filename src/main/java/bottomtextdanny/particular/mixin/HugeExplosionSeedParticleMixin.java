package bottomtextdanny.particular.mixin;

import bottomtextdanny.particular.ExplosionHandler;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.HugeExplosionSeedParticle;
import net.minecraft.client.particle.NoRenderParticle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HugeExplosionSeedParticle.class)
public class HugeExplosionSeedParticleMixin extends NoRenderParticle {
	protected HugeExplosionSeedParticleMixin(ClientLevel level, double x, double y, double z) {
		super(level, x, y, z);
	}

	@Inject(method = "tick", at = @At("TAIL"))
	private void tick(CallbackInfo ci) {
		ExplosionHandler.emitterTick(this, level, age, x, y, z, random);
	}
}
