package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.controller.UserController;
import com.fanfiction.fanfictionapi.entity.FandomEntity;
import com.fanfiction.fanfictionapi.entity.RoleEntity;
import com.fanfiction.fanfictionapi.entity.UserEntity;
import com.fanfiction.fanfictionapi.entity.UserStatus;
import com.fanfiction.fanfictionapi.exception.ResourceNotFoundException;
import com.fanfiction.fanfictionapi.mapper.FandomEntityDTOMapper;
import com.fanfiction.fanfictionapi.repository.RoleEntityRepository;
import com.fanfiction.fanfictionapi.repository.UserEntityRepository;
import com.fanfiction.fanfictionapi.entity.Role;
import com.fanfiction.fanfictionapi.service.FandomService;
import com.fanfiction.fanfictionapi.service.FanficService;
import com.fanfiction.fanfictionapi.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final FanficService         fanficService;
  private final FandomService         fandomService;
  private final FandomEntityDTOMapper fandomEntityDTOMapper;
  private final UserEntityRepository  userEntityRepository;
  private final RoleEntityRepository  roleEntityRepository;
  private final PasswordEncoder       passwordEncoder;

  @Autowired
  public UserServiceImpl(
      FanficServiceImpl fanficService,
      FandomService fandomService,
      FandomEntityDTOMapper fandomEntityDTOMapper,
      UserEntityRepository userEntityRepository,
      RoleEntityRepository roleEntityRepository,
      @Lazy PasswordEncoder passwordEncoder) {
    this.fanficService = fanficService;
    this.fandomService = fandomService;
    this.fandomEntityDTOMapper = fandomEntityDTOMapper;
    this.userEntityRepository = userEntityRepository;
    this.roleEntityRepository = roleEntityRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserEntity saveUser(UserEntity userEntity) {
    RoleEntity userRole = roleEntityRepository.findByName(Role.ROLE_USER.name());
    userEntity.setRoleEntity(userRole);
    System.out.println(userEntity.getPassword());
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    System.out.println(userEntity.getPassword());
    userEntity.setStatus(UserStatus.ACTIVE);
    return userEntityRepository.save(userEntity);
  }

  @Override
  public Optional<UserEntity> findByEmail(String email) {
    return userEntityRepository.findByEmail(email);
  }

  public List<FanficDTO> getUserFanfics(Long userId, PaginationRequestDTO pagination){
    if (userEntityRepository.existsById(userId)){
      return fanficService.findByUserId(userId, pagination);
    }
    return null;
  }

  @Override
  public List<FandomDTO> putFandoms(Long userId, Set<Long> fandomsId) {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    logger.info(" invoke putFandoms before userEntityRepository.findById(userId)");
    UserEntity userEntity = userEntityRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
    logger.info(" invoke putFandoms AFTER userEntityRepository.findById(userId)");
    logger.info(" invoke putFandoms Before  fandomService.getFandomsById(fandomsId)");
    List<FandomEntity> fandomEntities = fandomService.getFandomsById(fandomsId);
    logger.info(" invoke putFandoms AFTER  fandomService.getFandomsById(fandomsId)");
    if (fandomEntities == null || fandomEntities.isEmpty())
      throw new ResourceNotFoundException("Don't found fandoms");
    logger.info(" invoke putFandoms Before userEntity.getFandomEntities()");
    Set<FandomEntity> userFandoms = userEntity.getFandomEntities();
    logger.info(" invoke putFandoms AFTER userEntity.getFandomEntities()");
    if (userFandoms == null) {
      userFandoms = fandomEntities.stream().collect(Collectors.toSet());
    } else
      userFandoms.addAll(fandomEntities);
    userEntity.setFandomEntities(userFandoms);
    userEntityRepository.save(userEntity);
    return fandomEntityDTOMapper.map(userFandoms);
  }
}
