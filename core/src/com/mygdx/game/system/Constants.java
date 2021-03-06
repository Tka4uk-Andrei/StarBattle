package com.mygdx.game.system;

import com.badlogic.gdx.graphics.Color;

public class Constants {

    public static class Sides {
        public static final int FRIENDLY = 1;
        public static final int HOSTILE = -1;
        public static final int NONE = 0;
    }

    public static class Colors {
        public static final Color none = new Color(1, 1, 1, 1);
        public static final Color friendly = new Color(0, 0.675f, 1, 1);
        public static final Color hostile = new Color(1, 0.325f, 0, 1);
    }

    public enum Side{ NONE, FRIENDLY, HOSTILE }

    public enum SideColors {
        NONE(new Color(1, 1, 1, 1)),
        FRIENDLY(new Color(0, 0.675f, 1, 1)),
        HOSTILE(new Color(1, 0.325f, 0, 1));

        Color color;
        SideColors(Color color)
        {
            this.color = color;
        }
    }
}
