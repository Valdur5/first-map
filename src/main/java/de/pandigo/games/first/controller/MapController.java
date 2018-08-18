package de.pandigo.games.first.controller;

import de.pandigo.games.first.domain.entity.map.Position;
import de.pandigo.games.first.service.MapService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
