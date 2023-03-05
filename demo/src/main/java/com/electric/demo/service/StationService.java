package com.electric.demo.service;

import com.electric.demo.model.entity.Station;

import java.util.List;

public interface StationService {
    List<Station> getAll();
    Station findStation(Long id);

    void add(Station station);

    String update(Station station,Long id);

    String delete (Long id);

    List<Station> limited(Long id);
}
