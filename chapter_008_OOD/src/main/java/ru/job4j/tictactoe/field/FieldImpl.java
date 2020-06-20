package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.models.Mark;

public class FieldImpl implements Field {

    private static final String LN = System.lineSeparator();
    private static final int DEFAULT_SIZE = 3;
    private Mark[][] values;
    private final Symbols symbols;
    private final int width;
    private final int height;

    public FieldImpl() {
        this(new SingleSymbols(), DEFAULT_SIZE, DEFAULT_SIZE);
    }

    public FieldImpl(Symbols symbols) {
        this(symbols, DEFAULT_SIZE, DEFAULT_SIZE);
    }

    public FieldImpl(int width, int height) {
        this(new SingleSymbols(), width, height);
    }

    public FieldImpl(Symbols symbols, int width, int height) {
        this.width = width;
        this.height = height;
        this.symbols = symbols;
        this.values = new Mark[width][height];
        this.clear();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void draw() {
        System.out.println(getGridWithValues());
    }

    @Override
    public void clear() {
        this.values = new Mark[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.values[i][j] = Mark.NULL;
            }
        }
    }

    @Override
    public void markCellAs(Mark mark, int x, int y) {
        this.values[x][y] = mark;
    }

    @Override
    public Mark getSymbol(int x, int y) {
        return this.values[x][y];
    }

    @Override
    public boolean isEmpty(int x, int y) {
        return (this.values[x][y] == Mark.NULL);
    }

    @Override
    public String getGridWithValues() {
        StringBuilder sb = new StringBuilder();
        String line;
        sb.append(drawUpperBorder());
        line = drawInnerWithSpaces();
        line = this.getLineWithValues(line, 0);
        sb.append(line);
        for (int h = 1; h < this.height; h++) {
            sb.append(drawInnerBorder());
            line = drawInnerWithSpaces();
            line = this.getLineWithValues(line, h);
            sb.append(line);
        }
        sb.append(drawLowerBorder());
        return sb.toString();
    }

    /**
     * Get line of board
     * @param line input line
     * @param hLevel index of line by height
     * @return line with marks
     */
    private String   getLineWithValues(String line, int hLevel) {
        StringBuilder sb = new StringBuilder(line);
        for (int w = 0; w < width; w++) {
            if (this.values[w][hLevel] != Mark.NULL) {
                int pos = (
                    this.symbols.getVerticalLine().length()
                        + this.symbols.getHorizontalLine().length()
                ) * (w + 1) - this.symbols.getHorizontalLine().length() / 2;
                if (pos < line.length()) {
                    sb.setCharAt(pos - 1, this.values[w][hLevel].getMark());
                }
            }
        }
        return sb.toString();
    }

    /**
     * draw upper border
     * @return string representation of upper border
     */
    private String drawUpperBorder() {
        return drawLine(
            symbols.getLeftUpperCorner(),
            symbols.getHorizontalLine(),
            symbols.getUpperCross(),
            symbols.getRightUpperCorner()
        );
    }

    /**
     * draw inner borders with spaces
     * @return string representation of inner borders
     */
    private String drawInnerWithSpaces() {
        return drawLine(
            symbols.getVerticalLine(),
            symbols.getSpace(),
            symbols.getVerticalLine(),
            symbols.getVerticalLine()
        );
    }

    /**
     * draw inner borders with crosses
     * @return string representation of inner borders
     */
    private String drawInnerBorder() {
        return drawLine(
            symbols.getLeftCross(),
            symbols.getHorizontalLine(),
            symbols.getInnerCross(),
            symbols.getRightCross()
        );
    }

    /**
     * draw lower border
     * @return string representation of lower borders
     */
    private String drawLowerBorder() {
        return drawLine(
            symbols.getLeftLowerCorner(),
            symbols.getHorizontalLine(),
            symbols.getLowerCross(),
            symbols.getRightLowerCorner()
        );
    }

    /**
     * draw line
     * @param start first symbol of line
     * @param line line symbol
     * @param cross cross symbol
     * @param end last symbol of line
     * @return string line
     */
    private String drawLine(String start, String line, String cross, String end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int w = 0; w < this.width - 1; w++) {
            sb.append(line).append(cross);
        }
        sb.append(line).append(end).append(LN);
        return sb.toString();
    }
}
