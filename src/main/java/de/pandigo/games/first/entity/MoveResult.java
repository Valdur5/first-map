package de.pandigo.games.first.entity;

public class MoveResult {

    private Position newPosition;
    private boolean success;
    private String failReason;

    public MoveResult() {
    }

    public MoveResult(final Position newPosition, final boolean success, final String failReason) {
        this.newPosition = newPosition;
        this.success = success;
        this.failReason = failReason;
    }

    public Position getNewPosition() {
        return this.newPosition;
    }

    public void setNewPosition(final Position newPosition) {
        this.newPosition = newPosition;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public void setFailReason(final String failReason) {
        this.failReason = failReason;
    }
}
