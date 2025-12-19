package com.plover.ums.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.plover.ums.service.UserService;
import com.plover.ums.dto.UserDto;
import com.plover.ums.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService userService;
    public UserController(UserService svc) {this.userService = svc;}


    @GetMapping("/test")
    public String test() 
    {
        return "SHOULD Test  SEE THIS";
    }


    @PreAuthorize("hasAuthority('View User')")
    @GetMapping
    public List<UserDto> getAll() 
    {
        return userService.findAll();
    }
    
    @PreAuthorize("hasAuthority('View User')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) 
    {
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority('Add User')")
    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody UserDto dto) 
    {
        try 
        {
            userService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(201, "User created successfully"));
        }catch (IllegalArgumentException ex) 
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
        }catch (Exception ex) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('Update User')")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody UserDto dto) 
    {
        try 
        {
            UserDto updated = userService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) 
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAuthority('Delete User')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
