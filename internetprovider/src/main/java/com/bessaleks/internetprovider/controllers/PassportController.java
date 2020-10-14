package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.servises.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("passport")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class PassportController {

    private final PassportService passportService;

    @PostMapping
    public PassportDto createPassport(@RequestBody PassportDto passportDto) {
        return passportService.createPassport(passportDto);
    }
    @GetMapping
    public List<PassportDto> getAll() {
        return passportService.getAll();
    }

    @GetMapping("id")
    public PassportDto getPassport(@PathParam("id") Long id) {
        return passportService.getPassport(id);
    }

    @PutMapping
    public PassportDto updatePassport(@RequestBody PassportDto passportDto) {
        return passportService.updatePassport(passportDto);
    }

    @DeleteMapping
    public void deletePassport(@PathParam("id") Long id) {
        passportService.deletePassport(id);
    }
}
