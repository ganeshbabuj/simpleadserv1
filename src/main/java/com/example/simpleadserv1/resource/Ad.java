package com.example.simpleadserv1.resource;

import com.example.simpleadserv1.enumeration.AdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    private long id;
    private String username;
    private long activationId;
    private String adName;
    private String description;
    private AdType adType;
    private String imageUrl;
    private String targetUrl;
}
