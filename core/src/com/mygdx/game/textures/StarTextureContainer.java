package com.mygdx.game.textures;

import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.textures.stars.advancedFactory.AdvancedFactoryStarFriendly;
import com.mygdx.game.textures.stars.advancedFactory.AdvancedFactoryStarHostile;
import com.mygdx.game.textures.stars.advancedFactory.AdvancedFactoryStarNone;
import com.mygdx.game.textures.stars.factory.FactoryStarTexturesFriendly;
import com.mygdx.game.textures.stars.factory.FactoryStarTexturesHostile;
import com.mygdx.game.textures.stars.factory.FactoryStarTexturesNone;
import com.mygdx.game.textures.stars.mine.MineStarFriendly;
import com.mygdx.game.textures.stars.mine.MineStarHostile;
import com.mygdx.game.textures.stars.mine.MineStarNone;
import com.mygdx.game.textures.stars.small.SmallStarFriendly;
import com.mygdx.game.textures.stars.small.SmallStarHostile;
import com.mygdx.game.textures.stars.small.SmallStarNone;

public class StarTextureContainer {

    private ConditionTextures smallStar;
    private ConditionTextures mineStar;
    private ConditionTextures factoryStar;
    private ConditionTextures advancedFactoryStar;

    public StarTextureContainer(ConditionTextures smallStar, ConditionTextures mineStar,
                                ConditionTextures factoryStar, ConditionTextures advancedFactoryStar) {

        this.smallStar = smallStar;
        this.mineStar = mineStar;
        this.factoryStar = factoryStar;
        this.advancedFactoryStar = advancedFactoryStar;
    }

    public StarTextureContainer() {
        smallStar = new ConditionTextures(new SmallStarNone(), new SmallStarFriendly(), new SmallStarHostile());
        mineStar = new ConditionTextures(new MineStarNone(), new MineStarFriendly(), new MineStarHostile());
        factoryStar = new ConditionTextures(new FactoryStarTexturesNone(), new FactoryStarTexturesFriendly(), new FactoryStarTexturesHostile());
        advancedFactoryStar = new ConditionTextures(new AdvancedFactoryStarNone(), new AdvancedFactoryStarFriendly(), new AdvancedFactoryStarHostile());
    }

    public ConditionTextures getSmallStar() {
        return smallStar;
    }

    public ConditionTextures getMineStar() {
        return mineStar;
    }

    public ConditionTextures getFactoryStar() {
        return factoryStar;
    }

    public ConditionTextures getAdvancedFactoryStar() {
        return advancedFactoryStar;
    }
}
