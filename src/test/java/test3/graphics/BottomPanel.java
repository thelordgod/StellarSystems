package test3.graphics;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.panels.FixedHorizontalPanel;
import test3.models.TestModule;
import test3.models.WrongModuleTypeException;
import test3.models.SpacecraftModule;
import test3.player.Player;

//
final class BottomPanel extends FixedHorizontalPanel {
    private static final int PANEL_HEIGHT = 300;
    private static final @NotNull Color TEXT_COLOR = Color.white;
    private final @NotNull Player player;
    private int hoveredPart;
    @SuppressWarnings("FieldCanBeLocal")
    private final @NotNull BottomPanelMouseListener mouseListener;
    private final @NotNull BottomPanelMouseMotionListener mouseMotionListener;

    //
    public BottomPanel(@NotNull Player player, @NotNull PanelPalette palette) {
        super(PANEL_HEIGHT, palette.getPanelBackground(),
                palette.getPanelBorder(), true,
                palette.getPanelDiagonals(), false);
        this.player = player;
        hoveredPart = -1;
        mouseListener = new BottomPanelMouseListener(this);
        addMouseListener(mouseListener);
        mouseMotionListener = new BottomPanelMouseMotionListener();
        addMouseMotionListener(mouseMotionListener);
    }

    @NotNull Player getPlayer() {
        return player;
    }

    //
    @Override
    public void mainPaint(@NotNull Graphics g) {
        switch (player.getPaintMode()) {
            case FLIGHT -> paintMode_flight(g);
            case SHIPYARD -> paintMode_shipyard(g);
            case MISSIONS -> paintMode_missions(g);
            default -> paintMode_default(g);
        }
    }

    private void paintMode_default(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Painting for this PaintMode not defined.", 50, 50);
    }

    private void paintMode_flight(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Flight mode not ready yet...", 50, 50);
    }

    private void paintMode_shipyard(@NotNull Graphics g) {
        setDrawDiagonals(false);
        int @NotNull [] partDrawLocation = new int [] {100, 100};
        int
                partSeparation = 160,
                infoY = 180, textOffsetX = -40;
        @NotNull List<@NotNull SpacecraftModule> partInventory = player.getShipPartInventory();
        hoveredPart = -1; //resets the hovered part
        partInventory = filterParts(partInventory);
        for (int i = 0; i < partInventory.size(); i++) {
            @NotNull SpacecraftModule part = partInventory.get(i);
            int partX = partDrawLocation[0] + partSeparation * i;
            boolean active = ShipPartPainter.paintShipPart(g, part, new int [] {partX, partDrawLocation[1]}, mouseMotionListener.getLocation());
            ShipPartPainter.paintPartInfo(g, part, TEXT_COLOR, new int [] {partX + textOffsetX, infoY});
            if (active) {
                hoveredPart = i;
            }
        }
    }

    private @NotNull List<@NotNull SpacecraftModule> filterParts(@NotNull List<@NotNull SpacecraftModule> partInventory) {
        @NotNull List<@NotNull SpacecraftModule> filteredParts = new ArrayList<>();
        for (@NotNull SpacecraftModule part : partInventory) {
            switch (player.getShipyardMode()) {
                case CREATE_SHIP -> {
                    if (part instanceof TestModule) {
                        continue;
                    }
                }
                case ADD_MODULE -> {
                }
                default -> {
                    throw new RuntimeException("Undefined ShipyardMode");
                }
            }
            filteredParts.add(part);
        }
        return filteredParts;
    }

    int getHoveredPart() {
        return hoveredPart;
    }

    private void paintMode_missions(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Missions mode not ready yet...", 50, 50);
    }

    //
    private static final class BottomPanelMouseListener implements MouseListener {
        private final @NotNull BottomPanel panel;

        //
        BottomPanelMouseListener(@NotNull BottomPanel panel) {
            this.panel = panel;
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) {
            printLine("Mouse pressed at " + e.getX() + " x " + e.getY());
            int hoveredPart = panel.getHoveredPart();
            if (hoveredPart >= 0) {
                printLine("Part number " + hoveredPart);
            }
        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            printLine("Mouse released at " + e.getX() + " x " + e.getY());
            int hoveredPart = panel.getHoveredPart();
            if (hoveredPart >= 0) {
                printLine("Part number " + hoveredPart);
                switch (panel.getPlayer().getShipyardMode()) {
                    case CREATE_SHIP -> {
                        try {
                            panel.getPlayer().createNewShip(hoveredPart);
                        } catch (@NotNull WrongModuleTypeException exception) {
                            printLine(exception.getMessage());
                        }
                    }
                    case ADD_MODULE -> {}
                    default -> {
                        throw new RuntimeException("Undefined ShipyardMode");
                    }
                }

            }
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {}

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {}

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    //
    private static final class BottomPanelMouseMotionListener implements MouseMotionListener {
        private final int @NotNull [] location;

        //
        BottomPanelMouseMotionListener() {
            location = new int[2];
        }

        //
        public int @NotNull [] getLocation() {
            return new int [] {location[0], location[1]};
        }

        private void setLocation(@NotNull MouseEvent e) {
            location[0] = e.getX();
            location[1] = e.getY();
        }

        /**
         * Invoked when the mouse cursor has been moved onto a component
         * but no buttons have been pushed.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseMoved(@NotNull MouseEvent e) {
            setLocation(e);
        }

        /**
         * Invoked when a mouse button is pressed on a component and then
         * dragged.  {@code MOUSE_DRAGGED} events will continue to be
         * delivered to the component where the drag originated until the
         * mouse button is released (regardless of whether the mouse position
         * is within the bounds of the component).
         * <p>
         * Due to platform-dependent Drag&amp;Drop implementations,
         * {@code MOUSE_DRAGGED} events may not be delivered during a native
         * Drag&amp;Drop operation.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseDragged(@NotNull MouseEvent e) {
            setLocation(e);
        }
    }
}