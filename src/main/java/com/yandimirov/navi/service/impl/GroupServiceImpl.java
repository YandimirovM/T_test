package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Group;
import com.yandimirov.navi.repository.GroupRepository;
import com.yandimirov.navi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GroupServiceImpl implements GroupService {

  @Autowired
  private GroupRepository groupRepository;

  @Override
  public List<Group> findAll() {
    return groupRepository.findAll();
  }

  @Override
  public Group findOne(final Long id) {
    return groupRepository.findOne(id);
  }

  @Override
  public Group save(final Group group) {
    return groupRepository.save(group);
  }

  @Override
  public void delete(final Long id) {
    groupRepository.delete(id);
  }
}
