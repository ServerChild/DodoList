package com.dodolist.Controller;

import com.dodolist.Entity.DodoEntity;
import com.dodolist.Entity.DodoRequest;
import com.dodolist.Service.DodoService;
import com.dodolist.Entity.DodoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class DodoController {
    private final DodoService service;

    //React 연동 테스트
    @GetMapping("/api/main")
    public String getMain() {
        return "Hello Spring Boot🎃";
    }

    //할 일 등록
    @PostMapping
    public ResponseEntity<DodoResponse> create(@RequestBody DodoRequest request) {
        System.out.println("CREATE!");

        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);

        if(ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        DodoEntity result = this.service.addList(request);

        return ResponseEntity.ok(new DodoResponse(result));
    }

    //이미 한 일 완료, 할 일 수정
    @PatchMapping("/{id}")
    public ResponseEntity<DodoResponse> update(@PathVariable Long id, @RequestBody DodoRequest request) {
        System.out.println("UPDATE!");

        DodoEntity result = this.service.updateId(id, request);

        return ResponseEntity.ok(new DodoResponse(result));
    }

    //전체 할 일 조회
    @GetMapping
    public ResponseEntity<List<DodoResponse>> readAll() {
        System.out.println("READ ALL!");
        List<DodoEntity> list = this.service.searchAll();

        List<DodoResponse> responses = list.stream().map(DodoResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    //특정 id 할 일 조회
    @GetMapping("/{id}")
    public ResponseEntity<DodoResponse> readId(@PathVariable Long id) {
        System.out.println("READ ID!");

        DodoEntity response = this.service.searchId(id);

        return ResponseEntity.ok(new DodoResponse(response));
    }

    //전체 할 일 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL!");

        this.service.deleteAll();

        return ResponseEntity.ok().build();
    }

    //특정 id 할 일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id) {
        System.out.println("DELETE ID!");

        this.service.deleteId(id);

        return ResponseEntity.ok().build();
    }
}
