package eu.donals;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Terminal terminal;
    private Screen screen;
    private TextGraphics tg;

    private static UserInterface instance;

    static {
        try {
            instance = new UserInterface();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private UserInterface() throws IOException {
        terminal = new DefaultTerminalFactory().setPreferTerminalEmulator(true).setInitialTerminalSize(new TerminalSize(160, 40)).createTerminal();
        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
    }

    public static UserInterface getInstance() { return instance; }

    // displays the game initialisation, returns the character's name
    public String initGame() throws IOException, InterruptedException {
        String presentationText  = "Team 15 studios present...";
        String gameTitle = "Super Ultimate Pizza Maker 69";
        String playernamePrompt = "Please enter your character's name: ";
        String userInput = "";
        int cursorX = (centreText(160, playernamePrompt) + playernamePrompt.length() + 1);
        int cursorY = 10;
        TerminalPosition initialPromptPosition = new TerminalPosition(cursorX, cursorY);

        tg.putString(centreText(160, presentationText), 10, presentationText);
        screen.refresh();

        Thread.sleep(1000);
        Thread.yield();
        screen.clear();

        tg.putString(centreText(160, gameTitle), 10, gameTitle);
        screen.refresh();

        Thread.sleep(1000);
        Thread.yield();
        screen.clear();

        tg.putString(centreText(160, playernamePrompt), 10, playernamePrompt);
        screen.setCursorPosition(initialPromptPosition);
        screen.refresh();

        userInput = readUserInput(initialPromptPosition);

        screen.clear();
        return userInput;
    }

    // displays the game UI in it's default configuration
    public void displayGame() throws IOException {
        screen.clear();

        // image box
        tg.drawRectangle(new TerminalPosition(45, 3), new TerminalSize(70, 15), Symbols.BLOCK_SOLID);

        // display box
        tg.drawRectangle(new TerminalPosition(30, 21), new TerminalSize(100, 10), Symbols.BLOCK_MIDDLE);

        // input box
        tg.drawRectangle(new TerminalPosition(30, 34), new TerminalSize(100, 3), Symbols.BLOCK_MIDDLE);
        screen.setCursorPosition(new TerminalPosition(31, 35));
        screen.refresh();
    }

    // displays a text-based image within the image box
    // @imageBlock a list of strings to be displayed, each string must be no more than 68 chars long and there can be no more than 13
    // strings displayed at once
    public void displayImage(List<String> imageBlock) throws IOException {
        String clearLine = "                                                                    ";
        int counter = 4;

        try {
            for (String string : imageBlock) {
                if (string.length() > 68) { throw new DisplayError("image input string is too long"); }
                if (counter > 17) { throw new DisplayError("too many image input strings to display"); }

                tg.putString(46, counter, clearLine);
                tg.putString(46, counter, string);

                counter++;
            }

            screen.refresh();
        } catch (DisplayError e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // displays text within the text box
    // @textBlock a list of strings to be displayed, each string must be no more than 98 chars long and there can be no more than 8
    // strings displayed at once
    public void displayText(List<String> textBlock) throws IOException {
        int counter = 22;
        String clearLine = "                                                                                                  ";

        try {
            for (String string : textBlock) {
                if (string.length() > 98){ throw new DisplayError("text input string is too long: " + string); }
                if (counter > 30){ throw new DisplayError("too many text input strings to display: " + textBlock); }

                tg.putString(31, counter, clearLine);
                tg.putString(31, counter, string);

                counter++;
            }

            screen.refresh();
        } catch (DisplayError e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // displays text within the text box
    // @string  must be no more than 98 chars long, if it is longer, stringSplit() will attempt to make it fit
    public void displayText(String string) throws IOException {
        String clearLine = "                                                                                                  ";
        List<String> splitString = new ArrayList<String>();

        try {
            if (string.length() > 98){
                splitString = stringSplit(string);
                if (splitString != null){
                    displayText(splitString);
                    return;
                } else { throw new DisplayError("text input string is too long: " + string); }
            }

            // clears the text box
            for (int i = 22; i < 30; i++) {
                tg.putString(31, i, clearLine);
            }

            tg.putString(31, 22, string);
            screen.refresh();
        } catch (DisplayError e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // wraps readUserInput() and supplies the correct information so that input can be taken from the input box
    public String takeInput() throws IOException {
        String clearLine = "                                                                                                  ";
        TerminalPosition termPos = new TerminalPosition(31, 35);

        try {
            return readUserInput(termPos);
        } finally {
            tg.putString(31, 35, clearLine);
            screen.setCursorPosition(termPos);
        }
    }

    // @initialPromptPosition: the position of the cursor before any input is read
    private String readUserInput(TerminalPosition initialPromptPosition) throws IOException {
        String userInput = "";
        int posX = initialPromptPosition.getColumn();
        int posY = initialPromptPosition.getRow();
        KeyStroke keyStroke = new KeyStroke(' ', false, false);

        while (keyStroke.getKeyType() != KeyType.Enter) {
            keyStroke = screen.readInput();

            switch (keyStroke.getKeyType()) {
                case Character:
                    if (userInput.length() > 20) {
                        terminal.bell();
                        break;
                    }

                    userInput += keyStroke.getCharacter();
                    tg.putString(initialPromptPosition, userInput);
                    posX++;
                    screen.setCursorPosition(new TerminalPosition(posX, posY));
                    screen.refresh();
                    break;
                case Backspace:
                    if (userInput.length() == 0) {
                        terminal.bell();
                        break;
                    }

                    userInput = userInput.substring(0, userInput.length() - 1);
                    screen.setCharacter(posX - 1, posY, new TextCharacter(' '));
                    posX--;
                    screen.setCursorPosition(new TerminalPosition(posX, posY));
                    screen.refresh();
                    break;
            }
        }

        return userInput;
    }

    // centres text horizontally
    // @units the width of the screen
    // @text the text to be centred
    private static int centreText(int units, String text){ return (units - text.length()) / 2; }

    // splits long strings into a List of smaller strings
    private static List<String> stringSplit(String string) {
        List<String> output = new ArrayList<String>();
        int splitPoint = 0, index = 98;
        String splitString;

        while (true) {

            for (; index > 0; index--) {
                if (string.charAt(index) == ' '){
                    splitPoint = index;
                    break;
                }
            }

            splitString = string.substring(0, splitPoint);
            output.add(splitString);
            string = string.substring(splitPoint + 1);

            if (string.length() < 98) {
                output.add(string);
                break;
            }
        }

        if (output.size() > 6) { return null; }
        else { return output; }
    }
}
