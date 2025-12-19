package com.plover.ums.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plover.ums.repo.UserRepository;
import jakarta.transaction.Transactional;
import com.plover.ums.entity.UserEntity;
import com.plover.ums.dto.UserDto;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class UserService 
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) 
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UserDto toDto(UserEntity e) 
    {
        UserDto d = new UserDto();
        d.setId(e.getId());
        d.setUsername(e.getUsername());
        d.setActiveInd(e.getActiveInd());
        d.setUserType(e.getUserType());
        d.setPassword(e.getPassword());
        d.setExpiryDate(e.getExpiryDate());
        return d;
    }

    private UserEntity toEntity(UserDto d) 
    {
        UserEntity e = new UserEntity();
        e.setId(d.getId());
        e.setUsername(d.getUsername());
        e.setActiveInd(d.getActiveInd());
        e.setUserType(d.getUserType());
        e.setPassword(d.getPassword());
        e.setExpiryDate(d.getExpiryDate());
        return e;
    }

    public List<UserDto> findAll() 
    {
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<UserDto> findById(Long id) 
    {
        return userRepository.findById(id).map(this::toDto);
    }

    public UserDto create(UserDto dto)
    {
        UserEntity e = toEntity(dto);
        e.setId(null); // ensure id is generated
        e.setPassword(passwordEncoder.encode(dto.getPassword()));
        UserEntity saved = userRepository.save(e);
        return toDto(saved);
    }

    public UserDto update(Long id, UserDto dto) 
    {
        UserEntity existing = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        existing.setUsername(dto.getUsername());
        existing.setActiveInd(dto.getActiveInd());
        existing.setUserType(dto.getUserType());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) 
        {
            existing.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        existing.setExpiryDate(dto.getExpiryDate());
        UserEntity saved = userRepository.save(existing);
        return toDto(saved);
    }

    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }
}
