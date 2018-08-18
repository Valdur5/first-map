package de.pandigo.games.first.service.impl;

import de.pandigo.games.first.entity.MoveResult;
import de.pandigo.games.first.entity.Position;
import de.pandigo.games.first.service.MapService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapServiceImpl implements MapService {

    private final Map<Long, Position> positionMap = new HashMap<>();

    private static final int MAX_DISTANCE = 10;

    @Override
    public Position getPosition(final long objectId) {
        this.positionMap.putIfAbsent(objectId, new Position(0, 0));
        return this.positionMap.get(objectId);
    }

    @Override
    public MoveResult moveObjectToPosition(final long objectId, final Position newPosition) {
        final Position oldPosition = this.getPosition(objectId);
        if (this.isTooFarAway(newPosition, oldPosition)) {
            return new MoveResult(oldPosition, false, "The location where you want to go is too far away");
        }
        oldPosition.setX(oldPosition.getX() + newPosition.getX());
        oldPosition.setY(oldPosition.getY() + newPosition.getY());
        this.positionMap.put(objectId, oldPosition);
        return new MoveResult(newPosition, true, null);
    }

    private boolean isTooFarAway(final Position newPosition, final Position oldPosition) {
        final long distanceX = Math.abs(oldPosition.getX() - newPosition.getX());
        final long distanceY = Math.abs(oldPosition.getY() - newPosition.getY());
        final double length = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        return length > MAX_DISTANCE;
    }
}
