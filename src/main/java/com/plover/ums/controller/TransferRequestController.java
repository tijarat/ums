package com.plover.ums.controller;

import com.plover.ums.dto.TransferRequestDTO;
import com.plover.ums.service.TransferRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer-requests")
public class TransferRequestController {

    private final TransferRequestService service;

    public TransferRequestController(TransferRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransferRequestDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<TransferRequestDTO> create(@RequestBody TransferRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}