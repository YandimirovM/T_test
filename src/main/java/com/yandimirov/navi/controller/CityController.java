package com.yandimirov.navi.controller;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cities")
public final class CityController extends AbstractController<City, City> {

  @Autowired
  private CityService cityService;

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.City.class)
  public List<City> findAll() {
    LOGGER.info("Finding All Cities");
    return cityService.findAll();
  }

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.City.class)
  public City findOne(@PathVariable("id") final Long id) {
    LOGGER.info("Finding City With ID = {}", id);
    return cityService.findOne(id);
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @JsonView(RequestView.City.class)
  public City create(@RequestBody final City city) {
    LOGGER.info("Creating City = {}", city);
    return cityService.save(city);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.City.class)
  public City update(@PathVariable("id") final Long id,
      @RequestBody final City city) {
    LOGGER.info("Update City With ID = {}, {}", id, city);
    city.setId(id);
    return cityService.save(city);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.City.class)
  public void delete(@PathVariable("id") final Long id) {
    LOGGER.info("Deleting City With ID = {}", id);
    cityService.delete(id);
  }
}
