package com.springboot.restapisample.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HeaderMessage
{
    private String header;
    private String text;
}
