package com.firemerald.additionalplacements.client.models.rotated.fabric;

import com.firemerald.additionalplacements.client.models.fabric.PlacementModelWrapperImpl;
import com.firemerald.additionalplacements.client.models.rotated.BakedRotatedPlacementModel;
import com.firemerald.additionalplacements.util.BlockRotation;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.BlockState;

public class BakedRotatedPlacementModelImpl extends BakedRotatedPlacementModel implements PlacementModelWrapperImpl {
	public static BakedRotatedPlacementModel of(BakedModel theirModel, BlockState theirModelState, BlockRotation modelRotation, boolean rotatesTexture) {
		return new BakedRotatedPlacementModelImpl(theirModel, theirModelState, modelRotation, rotatesTexture);
	}

	private BakedRotatedPlacementModelImpl(BakedModel theirModel, BlockState theirModelState, BlockRotation modelRotation, boolean rotatesTexture) {
		super(theirModel, theirModelState, modelRotation, rotatesTexture);
    }
}
