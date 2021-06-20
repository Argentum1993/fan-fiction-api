package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.entity.FanficEntity;
import com.fanfiction.fanfictionapi.entity.RoleEntity;
import com.fanfiction.fanfictionapi.entity.UserEntity;
import com.fanfiction.fanfictionapi.entity.UserStatus;
import com.fanfiction.fanfictionapi.repository.RoleEntityRepository;
import com.fanfiction.fanfictionapi.repository.UserEntityRepository;
import com.fanfiction.fanfictionapi.service.Role;
import com.fanfiction.fanfictionapi.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final FanficServiceImpl     fanficService;
  private final UserEntityRepository  userEntityRepository;
  private final RoleEntityRepository  roleEntityRepository;
  private final PasswordEncoder       passwordEncoder;

  @Autowired
  public UserServiceImpl(
      FanficServiceImpl fanficService,
      UserEntityRepository userEntityRepository,
      RoleEntityRepository roleEntityRepository,
      @Lazy PasswordEncoder passwordEncoder) {
    this.fanficService = fanficService;
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
}
