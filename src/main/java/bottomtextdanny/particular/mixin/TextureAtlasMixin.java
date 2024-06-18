package bottomtextdanny.particular.mixin;

import bottomtextdanny.particular.Particular;
import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.renderer.texture.TextureAtlas;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextureAtlas.class)
public class TextureAtlasMixin {
	@Inject(method = "upload", at = @At("TAIL"))
	private void upload(SpriteLoader.Preparations preparations, CallbackInfo ci) {
		Particular.particleHandlers().onTextureAtlasPost((TextureAtlas) (Object) this);
	}
}
