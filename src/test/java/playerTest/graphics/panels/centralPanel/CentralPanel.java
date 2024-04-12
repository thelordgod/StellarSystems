package playerTest.graphics.panels.centralPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.BorderLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.panels.MinimalPanel;
import commonGraphics.panels.sidePanels.SectionContainerInterface;

//
public final class CentralPanel extends MinimalPanel implements SectionContainerInterface {
    private final @Nullable Color sectionBorderColor, sectionDiagonalColor;

    //
    public CentralPanel(@Nullable Color background, @Nullable Color borderColor) {
        super(
                background,
                borderColor, true,
                borderColor, true);
        printLine("Creating central panel");
        this.sectionBorderColor = borderColor;
        this.sectionDiagonalColor = borderColor;
        addSections();
    }

    @Override
    public void addSections(){
        LayoutManager layout = new BorderLayout();
        setLayout(layout);
        //TODO: fix this
        @NotNull BottomSection bottomSection = new BottomSection(sectionBorderColor, sectionDiagonalColor);
        add(bottomSection, BorderLayout.SOUTH);
        @NotNull MainPanel mainPanel = new MainPanel(sectionBorderColor, sectionDiagonalColor);
        add(mainPanel);
        //validate();
        revalidate();

        //debugging:
        //bottomSection.printSizeToConsole("Central bottom section created,");
        mainPanel.printSizeToConsole("Main panel created,");
    }

    //
    @Override
    public void mainPaint(@NotNull Graphics g) {
        printLine("asd 1");
    }
}