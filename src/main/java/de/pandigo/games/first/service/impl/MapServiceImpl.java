package de.pandigo.games.first.service.impl;

import de.pandigo.games.first.entity.Position;
import de.pandigo.games.first.service.MapService;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {
    @Override
    public Position getPosition(final long objectId) {
        return new Position(objectId, 24);
    }
}
