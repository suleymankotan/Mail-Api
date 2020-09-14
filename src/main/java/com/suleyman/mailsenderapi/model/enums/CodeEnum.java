package com.suleyman.mailsenderapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CodeEnum {
    NOT_SUCCESS(0),
    SUCCESS(1);

    private Integer code;
}
