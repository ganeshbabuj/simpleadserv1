package com.example.simpleadserv1.service;


import com.example.simpleadserv1.resource.Ad;

import java.util.List;
import java.util.Optional;

public interface AdService {

    Ad createAd(Ad ad);
    Ad getAd(long id);
    void updateAd(long id, Ad ad);
    List<Ad> findAds(Optional<String> adname);

}
