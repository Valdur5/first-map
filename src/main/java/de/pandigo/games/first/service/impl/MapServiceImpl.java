package de.pandigo.games.first.service.impl;

import de.pandigo.games.first.entity.Position;
import de.pandigo.games.first.service.MapService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapServiceImpl implements MapService {

    private final Map<Long, Position> positionMap = new HashMap<>();

    @Override
    public Position getPosition(final long objectId) {
        this.positionMap.putIfAbsent(objectId, new Position(0, 0));
        return this.positionMap.get(objectId);
    }

    @Override
    public void moveObjectToPosition(final long objectId, final Position newPosition) {
        final Position oldPosition = this.getPosition(objectId);
        oldPosition.setX(oldPosition.getX() + newPosition.getX());
        oldPosition.setY(oldPosition.getY() + newPosition.getY());
        this.positionMap.put(objectId, oldPosition);
    }
}
