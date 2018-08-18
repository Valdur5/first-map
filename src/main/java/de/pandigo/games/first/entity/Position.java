package de.pandigo.games.first.entity;

public class Position {
    private long x;
    private long y;

    public Position() {
    }

    public Position(final long x, final long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return this.x;
    }

    public void setX(final long x) {
        this.x = x;
    }

    public long getY() {
        return this.y;
    }

    public void setY(final long y) {
        this.y = y;
    }
}
