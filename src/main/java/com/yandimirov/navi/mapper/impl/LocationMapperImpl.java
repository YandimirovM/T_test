package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.LocationMapper;
import com.yandimirov.navi.model.dto.LocationDto;
import com.yandimirov.navi.model.entity.Contract;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public final class LocationMapperImpl implements LocationMapper {

  @Autowired
  private ContractRepository contractRepository;

  @Override
  public Location mapDtoToEntity(final LocationDto locationDto) {
    if (ObjectUtils.isEmpty(locationDto)) {
      return null;
    }

    return Location.builder()
        .id(locationDto.getId())
        .contract(contractRepository.findOne(locationDto.getId()))
        .name(locationDto.getName())
        .square(locationDto.getSquare())
        .build();
  }

  @Override
  public LocationDto mapEntityToDto(final Location location) {
    if (ObjectUtils.isEmpty(location)) {
      return null;
    }

    Contract contract = location.getContract();
    long contractId = 0L;
    if (!ObjectUtils.isEmpty(contract)) {
      contractId = contract.getId();
    }
    return LocationDto.builder()
        .id(location.getId())
        .contractId(contractId)
        .name(location.getName())
        .square(location.getSquare())
        .build();
  }
}
