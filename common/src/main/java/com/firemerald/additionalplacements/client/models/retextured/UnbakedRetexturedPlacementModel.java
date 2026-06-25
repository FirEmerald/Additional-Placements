package com.firemerald.additionalplacements.client.models.retextured;

import com.firemerald.additionalplacements.client.models.IAPUnbakedModel;
import com.firemerald.additionalplacements.client.models.Unwrapper;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Function;

public class UnbakedRetexturedPlacementModel<T extends UnbakedRetexturedPlacementModel<T>> implements IAPUnbakedModel<T> {
	public final ResourceLocation ourModelLocation;
	public final BlockState theirModelState;

	public UnbakedRetexturedPlacementModel(RetexturedModelData data) {
        this.ourModelLocation = data.ourModel();
        this.theirModelState = data.theirState();
    }

	@Override
	public BakedModel bake(ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation) {
		BakedModel theirModel = Unwrapper.unwrap(baker.bake(BlockModelShaper.stateToModelLocation(theirModelState), modelState));
		return BakedRetexturedPlacementModel.of(baker.bake(ourModelLocation, modelState), theirModel, theirModelState);
	}

	@Override
	public void resolveParents(Function<ResourceLocation, UnbakedModel> function) {
		function.apply(ourModelLocation);
		function.apply(BlockModelShaper.stateToModelLocation(theirModelState));
	}
}
