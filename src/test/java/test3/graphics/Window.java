package test3.graphics;

import java.awt.LayoutManager;
import java.awt.BorderLayout;

import org.jetbrains.annotations.NotNull;

import commonGraphics.UpdatingWindow;
import test3.player.Player;

//
public class Window extends UpdatingWindow {
    private final @NotNull Player player;
    private final @NotNull PanelPalette panelPalette;

    //
    public Window(@NotNull Player player) {
        super(new TestWindowSettings()); //default frame rate
        this.player = player;
        panelPalette = new PanelPalette();
        //add stuff before panels here
        addPanels();
        //add key listener here
        revalidate();
        startUpdating();
    }

    //
    @Override
    public void addPanels() {
        @NotNull LayoutManager layout = new BorderLayout();
        getContentPane().setLayout(layout);
        add(new BottomPanel(player, panelPalette), BorderLayout.SOUTH);
        add(new MainPanel(player, panelPalette));
    }
}