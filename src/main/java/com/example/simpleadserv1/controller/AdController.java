package com.example.simpleadserv1.controller;

import com.example.simpleadserv1.resource.ActivationResponse;
import com.example.simpleadserv1.resource.Ad;
import com.example.simpleadserv1.resource.AdCollection;
import com.example.simpleadserv1.resource.ActivationRequest;
import com.example.simpleadserv1.service.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/v1/marketing")
public class AdController {

    private AdService adService;

    public AdController(AdService AdService) {
        this.adService = AdService;
    }

    @PostMapping("/activate")
    @ResponseStatus(code = HttpStatus.OK)
    public ActivationResponse activate(@RequestBody ActivationRequest activationRequest) {
        return new ActivationResponse(new Random().nextLong(), "ACTIVATED");
    }


    @PostMapping("/ads")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Ad create(@RequestBody Ad Ad) {
        return adService.createAd(Ad);
    }


    @GetMapping("/ads/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Ad read(@PathVariable("id") Long id) {
        return adService.getAd(id);
    }


    @PutMapping("/ads/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateAd(@PathVariable("id") Long id, @RequestBody Ad Ad) {
        adService.updateAd(id, Ad);
    }


    @GetMapping(value = "/ads")
    @ResponseStatus(code = HttpStatus.OK)
    public AdCollection search(@RequestParam(required = false) Optional<String> adName) {

        System.out.println("Looking for: " + adName);
        AdCollection adCollection = new AdCollection();
        List<Ad> adList = adService.findAds(adName);
        adCollection.setItems(adList);
        return adCollection;

    }

}


