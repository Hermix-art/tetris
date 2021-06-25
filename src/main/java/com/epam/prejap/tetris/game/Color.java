package com.epam.prejap.tetris.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains definition of colors used in tetris game to print blocks in different colors.
 * Each value contains ascii code and id.
 *
 * @author Wojciech Kolarczyk
 */
public enum Color {
    RESET("\u001B[0m", (byte)1),
    RED("\u001B[31m", (byte)2),
    GREEN("\u001B[32m", (byte)3),
    YELLOW("\u001B[33m", (byte)4),
    BLUE("\u001B[34m", (byte)5),
    PURPLE("\u001B[35m", (byte)6),
    CYAN("\u001B[36m", (byte)7),
    WHITE("\u001B[37m", (byte)8),
    BLACK("\033[0;30m", (byte)9);

    final String asciiCode;
    public final byte id;
    static final Map<Byte, Color> colorsMap = new HashMap<>();
    /**
     * Constructor of each color value.
     *
     * @param asciiCode needed to change color of printed message in console.
     * @param id needed to recognize color of block in playfield.
     */
    Color(String asciiCode, byte id){
        this.asciiCode = asciiCode;
        this.id = id;
    }

    /**
     * @return color from it's id.
     */
    public static Color getColorById(byte id){
        return colorsMap.get(id);
    }

    static {
        for(var x: Color.values()){
            colorsMap.putIfAbsent(x.id, x);
        }
    }

    /**
     * Prints "#" in color of it's block color field.
     *
     * @param id color id.
     * @return String with colored "#".
     */
    public static String printHash(byte id){
        return colorsMap.getOrDefault(id, Color.WHITE) + "#" + Color.RESET;
    }

    /**
     * @return Color ASCII code.
     */
    @Override
    public java.lang.String toString() {
        return asciiCode;
    }
}
