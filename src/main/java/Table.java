public class Table {
    private int width;
    private int length;
    private int height;
    private int currentHeight;
    private boolean isAdjustable;
    private String color;
    private int numberOfLegs;

    public Table(int width, int length, int height) {
        this(width, length, height, height, false, "wood", 4);
    }

    public Table(int width, int length, int height, int currentHeight) {
        this(width, length, height, currentHeight, true, "wood", 4);
    }

    public Table(int width, int length, int height, int currentHeight, boolean isAdjustable, String color, int numberOfLegs) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = currentHeight;
        this.isAdjustable = isAdjustable;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public void setHeight(int newHeight) {
        if (this.isAdjustable && newHeight >= 0 && newHeight <= 200) {
            this.currentHeight = newHeight;
        }
    }

    public int area() {
        return this.width * this.length;
    }

    public int getCapacity() {
        return (2 * (this.length + this.width)) / 60;
    }

    public void repaint(String newColor) {
        this.color = newColor;
    }

    public boolean isStable() {
        return this.numberOfLegs >= 3;
    }

    public boolean isFoldable() {
        return this.isAdjustable && this.numberOfLegs >= 4;
    }

    public int getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public boolean isAdjustable() {
        return isAdjustable;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}