import java.util.*;

class TextStyle { // instrinsic (flyweight)
    private final String fontFamily;
    private final int fontSize;
    private final boolean isBold;
    private final boolean isItalic;

    public TextStyle (String fontFamily, int fontSize, boolean isBold, boolean isItalic) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    public void printStyle() {
        System.out.printf("Style: %s, %dpt, bold=%b, italic=%b\n", fontFamily, fontSize, isBold, isItalic);
    }
}

class TextCharacter { // extrinsic
    private final char c;
    private final int position;
    private final String color;
    private final TextStyle style;

    public TextCharacter(char c, int position, String color, TextStyle style) {
        this.c = c;
        this.position = position;
        this.color = color;
        this.style = style;
    }

    public void render() {
        System.out.printf("Char: '%c' at %d, color: %s - ", this.c, this.position, this.color);
        style.printStyle();
    }
}

class TextStyleFactory { // flyweight factory
    private final Map<String, TextStyle> cache = new HashMap<>();

    public TextStyle getTextStyle(String font, int size, boolean bold, boolean italic) {
        final String key = font + size + bold + italic;
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold, italic));
    }

    public int totalStylesCreated() {
        return cache.size();
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        final TextStyleFactory factory = new TextStyleFactory();
        final List<TextCharacter> characters = new ArrayList<>();

        final String text = "flyweight_design_pattern";
        for (int i = 0; i < text.length(); i++) {
            final char c = text.charAt(i);
            final String color = (i % 2 == 0) ? "black" : "blue";
            final TextStyle style = factory.getTextStyle("Arial", 12, true, false);
            characters.add(new TextCharacter(c, i, color, style));
        }
        for (TextCharacter ch : characters) {
            ch.render();
        }
        System.out.println("Unique TextStyle objects created: " + factory.totalStylesCreated());
    }
}
