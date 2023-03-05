package com.electric.demo.service.impl;

import com.electric.demo.model.entity.Station;
import com.electric.demo.repository.StationRepository;
import com.electric.demo.service.StationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository stationRepository;

    @Override
    public List<Station> getAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station findStation(Long id) {
        Optional<Station> station = stationRepository.findById(id);
        if(station.isPresent()){
            return station.get();
        }
        return null;
    }

    @Override
    public void add(Station station) {
        stationRepository.save(station);
    }

    @Override
    public String update(Station station, Long id) {
        Optional<Station> stationRes = stationRepository.findById(id);
        if(stationRes.isPresent()){
            Station reponse = stationRes.get();
            BeanUtils.copyProperties(station,reponse);
            stationRepository.save(reponse);
            return String.valueOf(id);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Optional<Station> stationRes = stationRepository.findById(id);
        if(stationRes.isPresent()){
            Station reponse = stationRes.get();
            stationRepository.delete(reponse);
            return String.valueOf(id);
        }
        return null;
    }

    @Override
    public List<Station> limited(Long id) {

        return stationRepository.findTopN(id);
    }
}
