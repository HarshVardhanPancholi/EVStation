package com.electric.demo.controller;


import com.electric.demo.model.entity.Station;
import com.electric.demo.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Station>> viewAllStation() {
        log.info("----viewAllStation() method initialized");
        List<Station> list = stationService.getAll();
        ResponseEntity<List<Station>> retvalue = new ResponseEntity<List<Station>>(list, HttpStatus.OK);
        return retvalue;
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<Station> getStation(@PathVariable Long id) {
        log.info("----getStation() method initialized");
        Station response = stationService.findStation(id);
        if(response==null){
            return new ResponseEntity<Station>((Station) null, HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<Station> retvalue = new ResponseEntity<Station>(response, HttpStatus.OK);
        return retvalue;
    }

    @PostMapping(value="/")
    public ResponseEntity<Void> addStation(@RequestBody Station station){
        log.info("----addStation() method initialized");
        stationService.add(station);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @PutMapping(value= "/{id}/edit")
    public ResponseEntity<String> update(@RequestBody  Station station, @PathVariable Long id){
        log.info("----updateStation() method initialized");
        String value = stationService.update(station,id);
        if(value==null){
            return new ResponseEntity<String>("Station with ID: "+id+" not present.",HttpStatus.CONFLICT);
        }
        ResponseEntity<String> retvalue = new ResponseEntity<String>("Station with ID: "+id+" sucessfully updated.",HttpStatus.ACCEPTED);
        return retvalue;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String response = stationService.delete(id);
        if(response == null){
            return new ResponseEntity<String>("Station with ID: "+id+" not present.",HttpStatus.CONFLICT);
        }
        ResponseEntity<String> retvalue = new ResponseEntity<String>("Station with ID: "+id+" sucessfully deleted.",HttpStatus.ACCEPTED);
        return retvalue;
    }

    @GetMapping(value ="/?limit=10")
    public ResponseEntity<List<Station>> limitStation(@RequestParam Long id) {
        log.info("----limitStation() method initialized");
        List<Station> list = stationService.limited(id);
        ResponseEntity<List<Station>> retvalue = new ResponseEntity<List<Station>>(list, HttpStatus.OK);
        return retvalue;
    }
}
