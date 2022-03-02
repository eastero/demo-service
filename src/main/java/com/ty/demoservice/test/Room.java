package com.ty.demoservice.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    int high;
    int width;
    int length;
}
