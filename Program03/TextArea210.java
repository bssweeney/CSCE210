import javafx.scene.control.TextArea;

/**
 * This is a smarter TextArea. It's almost like a log.
 * Two smart things here: 
 * 1) a println/print interface like System.out, and
 * 2) append text to the area until you clear.
 * 
 * @author williamkrieger
 */
public class TextArea210 {
    /** the JavaFX TextArea used throughout */
    private final TextArea area;
    /** this StringBuilder holds the text in the TextArea */
    private final StringBuilder sb;

    /**
     * ctor
     */
    public TextArea210() {
        area = new TextArea();
        sb = new StringBuilder();
    }

    /**
     * Getter for the JavaFX TextArea so you can add it to your Scene
     * or whatever.
     * @return Returns the JavaFX TextArea.
     */
    TextArea getTextArea() { return this.area; }

    /**
     * Append text to the TextArea, with a newline.
     * @param string The text to append.
     */
    public void println( String string) {
        sb.append( string);
        sb.append( "\n");
        area.setText(sb.toString());
        area.requestFocus();
        area.end();
    }

    /**
     * Append text to the TextArea, no newline here.
     * @param s The text to append.
     */
    public void print( String s) {
        sb.append( s);
        area.setText(sb.toString());
    }

    /**
     * Clear all text from the area.
     */
    public void clear() {
        sb.setLength(0);
        area.setText(sb.toString());
    }
}