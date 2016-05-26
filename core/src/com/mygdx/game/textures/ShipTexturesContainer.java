package com.mygdx.game.textures;

import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.textures.ships.cruiser.CruiserTextureFriendly;
import com.mygdx.game.textures.ships.cruiser.CruiserTextureHostile;
import com.mygdx.game.textures.ships.cruiser.CruiserTextureNone;
import com.mygdx.game.textures.ships.oneCruiser.OneCruiserTexturesFriendly;
import com.mygdx.game.textures.ships.oneCruiser.OneCruiserTexturesHostile;
import com.mygdx.game.textures.ships.oneCruiser.OneCruiserTexturesNone;
import com.mygdx.game.textures.ships.oneShield.OneShieldTexturesFriendly;
import com.mygdx.game.textures.ships.oneShield.OneShieldTexturesHostile;
import com.mygdx.game.textures.ships.oneShield.OneShieldTexturesNone;
import com.mygdx.game.textures.ships.raptor.RaptorTextureFriendly;
import com.mygdx.game.textures.ships.raptor.RaptorTextureHostile;
import com.mygdx.game.textures.ships.raptor.RaptorTextureNone;
import com.mygdx.game.textures.ships.shield.ShieldTextureFriendly;
import com.mygdx.game.textures.ships.shield.ShieldTextureHostile;
import com.mygdx.game.textures.ships.shield.ShieldTextureNone;
import com.mygdx.game.textures.ships.twoCruiser.TwoCruiserTexturesFriendly;
import com.mygdx.game.textures.ships.twoCruiser.TwoCruiserTexturesHostile;
import com.mygdx.game.textures.ships.twoCruiser.TwoCruiserTexturesNone;
import com.mygdx.game.textures.ships.twoShield.TwoShieldTexturesFriendly;
import com.mygdx.game.textures.ships.twoShield.TwoShieldTexturesHostile;
import com.mygdx.game.textures.ships.twoShield.TwoShieldTexturesNone;

public class ShipTexturesContainer {

    private ConditionTextures raptor;
    private ConditionTextures shield;
    private ConditionTextures twoShield;
    private ConditionTextures oneShield;
    private ConditionTextures cruiser;
    private ConditionTextures twoCruiser;
    private ConditionTextures oneCruiser;

    public ShipTexturesContainer() {

        raptor = new ConditionTextures(new RaptorTextureNone(), new RaptorTextureFriendly(), new RaptorTextureHostile());

        shield = new ConditionTextures(new ShieldTextureNone(), new ShieldTextureFriendly(), new ShieldTextureHostile());
        twoShield = new ConditionTextures(new TwoShieldTexturesNone(), new TwoShieldTexturesFriendly(), new TwoShieldTexturesHostile());
        oneShield = new ConditionTextures(new OneShieldTexturesNone(), new OneShieldTexturesFriendly(), new OneShieldTexturesHostile());

        cruiser = new ConditionTextures(new CruiserTextureNone(), new CruiserTextureFriendly(), new CruiserTextureHostile());
        twoCruiser = new ConditionTextures(new TwoCruiserTexturesNone(), new TwoCruiserTexturesFriendly(), new TwoCruiserTexturesHostile());
        oneCruiser = new ConditionTextures(new OneCruiserTexturesNone(), new OneCruiserTexturesFriendly(), new OneCruiserTexturesHostile());

    }

    public ShipTexturesContainer(ConditionTextures raptor, ConditionTextures shield, ConditionTextures cruiser) {

        this.raptor = raptor;
        this.shield = shield;
        this.cruiser = cruiser;

    }

    public void dispose() {
        raptor.dispose();
        shield.dispose();
        twoCruiser.dispose();
        twoShield.dispose();
        oneCruiser.dispose();
        oneShield.dispose();
    }

    public ConditionTextures getRaptor() {
        return raptor;
    }

    public ConditionTextures getShield() {
        return shield;
    }

    public ConditionTextures getCruiser() {
        return cruiser;
    }

    public ConditionTextures getTwoShield() {
        return twoShield;
    }

    public ConditionTextures getOneShield() {
        return oneShield;
    }

    public ConditionTextures getTwoCruiser() {
        return twoCruiser;
    }

    public ConditionTextures getOneCruiser() {
        return oneCruiser;
    }
}
