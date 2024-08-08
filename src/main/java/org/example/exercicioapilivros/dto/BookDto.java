package org.example.exercicioapilivros.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        @NotBlank String title,
        @NotNull Integer releaseYear,
        @NotBlank String authorName,
        @NotBlank String genre
) {
}
