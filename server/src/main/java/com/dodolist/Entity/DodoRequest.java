package com.dodolist.Entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DodoRequest {
    private String title;
    private Long order;
    private Boolean completed;
}