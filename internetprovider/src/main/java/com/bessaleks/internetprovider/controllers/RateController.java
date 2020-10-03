package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.RateDto;
import com.bessaleks.internetprovider.servises.RateServise;
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

    private RateServise rateServise;

    @PostMapping
    public RateDto createRate(@RequestBody RateDto rateDto) {
        return rateServise.createRate(rateDto);
    }

    @GetMapping
    public List<RateDto> getAll() {
        return rateServise.getAll();
    }

    @GetMapping("id")
    public RateDto getRate(@PathParam("id") Long id) {
        return rateServise.getRate(id);
    }

    @PutMapping
    public RateDto updateRate(@RequestBody RateDto rateDto) {
        return rateServise.updateRate(rateDto);
    }

    @DeleteMapping
    public void deleteRate(@PathParam("id") Long id) {
        rateServise.deleteRate(id);
    }
}
