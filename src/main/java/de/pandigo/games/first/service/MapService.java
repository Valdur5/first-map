package de.pandigo.games.first.service;

import de.pandigo.games.first.entity.Position;

/**
 * Service for providing map related operations
 */
public interface MapService {
    /**
     * Method for locating a object in the map.
     *
     * @param objectId The object id which should be located in the map
     * @return The Position object containing all location based information about the object
     */
    Position getPosition(long objectId);
}
