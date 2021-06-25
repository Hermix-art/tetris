package com.epam.prejap.tetris.game;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "colors")
public class ColorsTest {

    @DataProvider
    public Object[][] colorCodesProvider() {
        return new Object[][]{
                {Color.RESET.asciiCode, "\u001B[0m"},
                {Color.RED.asciiCode, "\u001B[31m"},
                {Color.GREEN.asciiCode, "\u001B[32m"},
                {Color.YELLOW.asciiCode, "\u001B[33m"},
                {Color.BLUE.asciiCode, "\u001B[34m"},
                {Color.PURPLE.asciiCode, "\u001B[35m"},
                {Color.CYAN.asciiCode, "\u001B[36m"},
                {Color.WHITE.asciiCode, "\u001B[37m"},
                {Color.BLACK.asciiCode, "\033[0;30m"},
        };
    }

    public void colorResetShouldReturnProperAsciiCode() {
        assertEquals(Color.RESET.toString(), "\u001B[0m", "RESET has wrong code.");
    }

    @DataProvider
    public Object[][] colorIdProvider() {
        return new Object[][]{
                {Color.RESET.id, (byte) 1},
                {Color.RED.id, (byte) 2},
                {Color.GREEN.id, (byte) 3},
                {Color.YELLOW.id, (byte) 4},
                {Color.BLUE.id, (byte) 5},
                {Color.PURPLE.id, (byte) 6},
                {Color.CYAN.id, (byte) 7},
                {Color.WHITE.id, (byte) 8},
                {Color.BLACK.id, (byte) 9},
        };
    }

    @Test(dataProvider = "colorCodesProvider")
    public void correctnessOfReturnedAsciiCode(String colorGetter, String asciiCode) {
        assertEquals(colorGetter, asciiCode, "Colors from enums have wrong codes.");
    }

    @Test(dataProvider = "colorIdProvider")
    public void correctnessOfReturnedId(byte idGetter, byte id) {
        assertEquals(idGetter, id, "Colors from enums have wrong id.");
    }


    @DataProvider
    public Object[][] colorIdAndCodesProvider() {
        return new Object[][]{
                {Color.RESET.id, Color.RESET.toString()},
                {Color.RED.id, Color.RED.toString()},
                {Color.GREEN.id, Color.GREEN.toString()},
                {Color.YELLOW.id, Color.YELLOW.toString()},
                {Color.BLUE.id, Color.BLUE.toString()},
                {Color.PURPLE.id, Color.PURPLE.toString()},
                {Color.CYAN.id, Color.CYAN.toString()},
                {Color.WHITE.id, Color.WHITE.toString()},
                {Color.BLACK.id, Color.BLACK.toString()},
        };
    }

    @DataProvider
    public Object[][] wrongIdProvider() {
        return new Object[][]{
                {(byte) 'A', Color.WHITE + "#" + Color.RESET},
                {(byte) 'B', Color.WHITE + "#" + Color.RESET},
                {(byte) 'a', Color.WHITE + "#" + Color.RESET},
                {(byte) '@', Color.WHITE + "#" + Color.RESET},
                {(byte) '#', Color.WHITE + "#" + Color.RESET},
                {(byte) '&', Color.WHITE + "#" + Color.RESET},
        };
    }

    @Test(dataProvider = "colorIdAndCodesProvider")
    public void printHashShouldPrintCorrectMessage(byte idGetter, String code) {
        assertEquals(Color.printHash(idGetter), code + "#" + Color.RESET, "'#' is printed badly.");
    }

    @Test(dataProvider = "colorIdProvider")
    public void idShouldReturnProperIdValue(byte idGetter, byte id) {
        assertEquals(idGetter, id);
    }

    @Test(dataProvider = "wrongIdProvider")
    public void printHashWithBadParameterShouldReturnWhiteHash(byte wrongInput, String whiteColorCode) {
        assertEquals(Color.printHash(wrongInput), whiteColorCode, "Wrong input didn't change color to default white.");
    }

    @Test(dataProvider = "colorIdAndCodesProvider")
    public void mapShouldContainAllColors(byte id, String code) {
        assertTrue(Color.colorsMap.containsKey(id), "Map doesn't have all the colors.");
    }
}
