package com.jagan.redis.springredis.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {

    private String id;

    private String name;

    private int age;

}
