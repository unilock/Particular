package bottomtextdanny.particular.particle;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MutableSpriteSet implements SpriteSet {
	private List<TextureAtlasSprite> sprites;

	@Override
	@NotNull
	public TextureAtlasSprite get(int age, int lifetime) {
		return this.sprites.get(age * (this.sprites.size() - 1) / lifetime);
	}

	@Override
	@NotNull
	public TextureAtlasSprite get(RandomSource random) {
		return this.sprites.get(random.nextInt(this.sprites.size()));
	}

	public void rebind(List<TextureAtlasSprite> p_107416_) {
		this.sprites = ImmutableList.copyOf(p_107416_);
	}
}
