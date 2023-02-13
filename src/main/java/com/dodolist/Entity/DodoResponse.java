package com.dodolist.Entity;

import com.dodolist.Entity.DodoEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;

    private String url;

    public DodoResponse(DodoEntity dodoEntity) {
        this.id = dodoEntity.getId();
        this.title = dodoEntity.getTitle();
        this.order = dodoEntity.getOrder();
        this.completed = dodoEntity.getCompleted();

        this.url = "http://localhost:8080/" + this.id;
    }
}
