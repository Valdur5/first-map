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

    /**
     * Method for moving an object to a new position, this method does all the checks if this object is allowed to be
     * moved and if there is place to move the object to the given newPosition.
     *
     * @param objectId    A generic game object id which possibly can be moved
     * @param newPosition The new position which the object should be moved to
     */
    void moveObjectToPosition(long objectId, Position newPosition);
}
