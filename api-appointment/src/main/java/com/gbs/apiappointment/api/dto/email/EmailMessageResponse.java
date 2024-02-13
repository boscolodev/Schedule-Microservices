package com.gbs.apiappointment.api.dto.email;

public record EmailMessageResponse(Long appointmentId, boolean isBooked) {
}
