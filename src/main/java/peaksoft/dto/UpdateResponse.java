package peaksoft.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record UpdateResponse(
        String name,
        String email,
        int age,
        Boolean isBlocked
) {
}
