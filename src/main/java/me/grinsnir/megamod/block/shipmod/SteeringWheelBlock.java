package me.grinsnir.megamod.block.shipmod;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SteeringWheelBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<SteeringWheelBlock> CODEC = simpleCodec(SteeringWheelBlock::new);

    //VoxelShapes - Parts
    private static final VoxelShape BASE_NORTH = Block.box(0,0,3,16,1,16);
    private static final VoxelShape STAND_NORTH = Block.box(4, 0, 8, 12, 15, 14);
    private static final VoxelShape BASE_WEST = Block.box(3,0,3,16,1,16);
    private static final VoxelShape STAND_WEST = Block.box(8, 0, 4, 14, 15, 12);
    private static final VoxelShape BASE_SOUTH = Block.box(0,0,0,16,1,13);
    private static final VoxelShape STAND_SOUTH = Block.box(4, 0, 2, 12, 15, 8);
    private static final VoxelShape BASE_EAST = Block.box(0,0,0,13,1,16);
    private static final VoxelShape STAND_EAST = Block.box(2, 0, 4, 8, 15, 12);

    //VoxelShapes - Combined
    private static final VoxelShape SHAPE_NORTH = Shapes.or(BASE_NORTH, STAND_NORTH);
    private static final VoxelShape SHAPE_WEST = Shapes.or(BASE_WEST, STAND_WEST);
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(BASE_SOUTH, STAND_SOUTH);
    private static final VoxelShape SHAPE_EAST = Shapes.or(BASE_EAST, STAND_EAST);

    public SteeringWheelBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(FACING);

        return switch (dir) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Setzt FACING abhängig von Spielerplatzierung
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Block-Entity

    @Override
    protected RenderShape getRenderShape(BlockState state){
        return RenderShape.MODEL;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }

}
