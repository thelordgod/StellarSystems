package commonGraphics;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//Color utilities.
public final class ColorUtils {
    private static final int OPAQUE_ALPHA = 255;

    @SuppressWarnings("unused")
    public static final @NotNull Color TRANSPARENT_BLACK = getGray(0, 0);

    /**
     * Gets a gray color from brightness and alpha.
     *
     * @param brightness A brightness value 0-255 (inclusive).
     * @param alpha Alpha value for transparency, 0-255 (inclusive). Lower values are more transparent.
     * @return A gray color.
     */
    public static @NotNull Color getGray(int brightness, int alpha) {
        return new Color(brightness, brightness, brightness, alpha);
    }

    /**
     * Gets an opaque gray color from brightness.
     *
     * @param brightness A brightness value 0-255 (inclusive).
     * @return An opaque gray color.
     */
    public static @NotNull Color getOpaqueGray(int brightness) {
        return getGray(brightness, OPAQUE_ALPHA);
    }
}