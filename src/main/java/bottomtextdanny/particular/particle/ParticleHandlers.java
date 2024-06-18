package bottomtextdanny.particular.particle;

import bottomtextdanny.particular.Particular;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class ParticleHandlers {
	private final ImmutableList<ModularParticleClient<?>> particleManagers;

	public ParticleHandlers(List<ModularParticleClient<?>> particleManagers) {
		this.particleManagers = ImmutableList.copyOf(particleManagers);
		//bus.addListener(this::onTextureAtlasPre);
		//bus.addListener(this::onTextureAtlasPost);
	}

//	private void onTextureAtlasPre(TextureStitchEvent.Pre event){
//		System.out.println("Stitching particle textures");
//		if (event.getAtlas().location().equals(TextureAtlas.LOCATION_PARTICLES)) {
//			particleManagers.forEach(manager -> {
//				manager.textures.forEach(event::addSprite);
//			});
//		}
//	}

	public void onTextureAtlasPost(TextureAtlas atlas){
		System.out.println("Fetching particle textures");
		if (atlas.location().equals(TextureAtlas.LOCATION_PARTICLES)) {
			System.out.println(atlas.getSprite(new ResourceLocation(Particular.ID, "particle/dust_0.png")));
			particleManagers.forEach(manager -> {
				manager.spriteSet.rebind(manager.textures.stream().map(atlas::getSprite).toList());
			});
		}
	}
}
