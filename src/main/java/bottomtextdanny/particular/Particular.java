package bottomtextdanny.particular;

import bottomtextdanny.particular.config.ParticularConfig;
import bottomtextdanny.particular.particle.ParticleHandlers;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;

public class Particular implements ClientModInitializer {
    public static final String ID = "particular";
    private static ParticleHandlers particleHandlers;
    private static ParticularConfig config;

	@Override
	public void onInitializeClient() {
        particleHandlers = new ParticleHandlers(List.of(
            ParticularParticles.DUST,
            ParticularParticles.CLOUD,
            ParticularParticles.HASTY_SMOKE,
            ParticularParticles.SHINE,
            ParticularParticles.FLASHY_EXPLOSION,
            ParticularParticles.LIT_EXPLOSION,
            ParticularParticles.SHOCKY_EXPLOSION,
            ParticularParticles.SOUL,
            ParticularParticles.LITTLE_SOUL,
            ParticularParticles.INK_SPLASH
        ));

        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

        config = new ParticularConfig(configBuilder);
        ForgeConfigRegistry.INSTANCE.register(ID, ModConfig.Type.CLIENT, configBuilder.build());
    }

    public static ParticularConfig config() {
        return config;
    }

    public static ParticleHandlers particleHandlers() {
        return particleHandlers;
    }
}
