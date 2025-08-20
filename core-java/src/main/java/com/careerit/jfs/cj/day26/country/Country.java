package com.careerit.jfs.cj.day26.country;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Country {

    String commonName;
    String officialName;
    List<String> capital;
    long population;
    long area;
    String region;
    String flagSvgUrl;
}
