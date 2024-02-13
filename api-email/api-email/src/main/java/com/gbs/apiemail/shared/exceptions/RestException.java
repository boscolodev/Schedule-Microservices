package com.gbs.apiemail.shared.exceptions;

import com.gbs.apiemail.api.dto.ApiError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestException extends RuntimeException{

    private final ApiError apiError;

}
