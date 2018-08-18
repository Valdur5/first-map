package de.pandigo.games.first.controller;

import de.pandigo.games.first.domain.entity.map.Position;
import de.pandigo.games.first.domain.type.CustomMediaType;
import de.pandigo.games.first.service.MapService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/map")
public class MapController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private MapService mapService;

    @RequestMapping(value = "/{objectId}", method = RequestMethod.GET)
    public Position getPositionForObject(@PathVariable(value = "objectId") final long objectId) {
        LOGGER.trace("Called getPositionForObject {}", objectId);
        return this.mapper.map(this.mapService.getPosition(objectId), Position.class);
    }

    @RequestMapping(value = "/{objectId}", method = RequestMethod.POST, consumes = CustomMediaType.APPLICATION_MAP_OBJECTMOVETOPOSITION_JSON)
    public void moveObjectToPosition(@PathVariable(value = "objectId") final long objectId, @RequestBody() final Position position) {
        LOGGER.trace("Called moveObjectToPosition objectId: {}, x: {} y: {}", objectId, position.getX(), position.getY());
        this.mapService.moveObjectToPosition(objectId, this.mapper.map(position, de.pandigo.games.first.entity.Position.class));
    }

}
