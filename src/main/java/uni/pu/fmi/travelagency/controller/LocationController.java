package uni.pu.fmi.travelagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pu.fmi.travelagency.dto.CreateLocationDTO;
import uni.pu.fmi.travelagency.dto.ResponseLocationDTO;
import uni.pu.fmi.travelagency.dto.UpdateLocationDTO;
import uni.pu.fmi.travelagency.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocationDTO>> getAllLocations(){
        List<ResponseLocationDTO> locations = locationService.getLocations();

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable Long id){
        ResponseLocationDTO location = locationService.getLocationById(id);

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Boolean> deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseLocationDTO> createLocation(@RequestBody CreateLocationDTO createLocationDTO){
        ResponseLocationDTO createLocation = locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>(createLocation, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseLocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO){
        ResponseLocationDTO updateLocation = locationService.updateLocation(updateLocationDTO);
        return new ResponseEntity<>(updateLocation, HttpStatus.OK);
    }
}
