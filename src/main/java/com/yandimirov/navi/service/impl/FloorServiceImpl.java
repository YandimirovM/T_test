package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.FloorMapper;
import com.yandimirov.navi.model.dto.FloorDto;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.repository.FloorRepository;
import com.yandimirov.navi.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FloorServiceImpl implements FloorService{

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private FloorRepository floorRepository;

    @Override
    public List<Floor> findAll() {
        return StreamSupport
                .stream(floorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Floor findOne(long id) {
        return floorRepository.findOne(id);
    }

    @Override
    public Floor save(FloorDto floorDto) {
        Floor floor = floorMapper.mapDtoToEntity(floorDto);
        return floorRepository.save(floor);
    }

    @Override
    public void delete(long id) {
        floorRepository.delete(id);
    }
}
