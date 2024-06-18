package bottomtextdanny.particular.mixin;

import bottomtextdanny.particular.SquidSploinkyHandler;
import net.minecraft.world.entity.animal.Squid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Squid.class)
public class SquidMixin {
	@Inject(method = "handleEntityEvent", at = @At("HEAD"))
	private void hurt(byte flag, CallbackInfo ci) {
		if (flag == 2) {
			SquidSploinkyHandler.hurt((Squid) (Object) this);
		}
	}
}
