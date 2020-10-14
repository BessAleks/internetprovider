package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.RateDto;
import com.bessaleks.internetprovider.servises.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("rate")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class RateController {

    private final RateService rateService;

    @PostMapping
    public RateDto createRate(@RequestBody RateDto rateDto) {
        return rateService.createRate(rateDto);
    }

    @GetMapping
    public List<RateDto> getAll() {
        return rateService.getAll();
    }

    @GetMapping("id")
    public RateDto getRate(@PathParam("id") Long id) {
        return rateService.getRate(id);
    }

    @PutMapping
    public RateDto updateRate(@RequestBody RateDto rateDto) {
        return rateService.updateRate(rateDto);
    }

    @DeleteMapping
    public void deleteRate(@PathParam("id") Long id) {
        rateService.deleteRate(id);
    }
}
