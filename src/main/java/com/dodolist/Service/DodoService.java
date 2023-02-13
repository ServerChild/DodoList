package com.dodolist.Service;

import com.dodolist.Entity.DodoEntity;
import com.dodolist.Repository.DodoRepository;
import com.dodolist.Entity.DodoRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DodoService {
    private final DodoRepository dodoRepository;

    //할 일 등록
    public DodoEntity addList(DodoRequest dodoRequest) {
        DodoEntity dodoEntity = new DodoEntity();

        dodoEntity.setTitle(dodoRequest.getTitle());
        dodoEntity.setOrder(dodoRequest.getOrder());
        dodoEntity.setCompleted(dodoRequest.getCompleted());

        return this.dodoRepository.save(dodoEntity);
    }

    //전체 할 일 조회
    public List<DodoEntity> searchAll() {
        return this.dodoRepository.findAll();
    }

    //특정 id 할 일 조회
    public DodoEntity searchId(Long id) {
        return this.dodoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //특정 id 할 일 수정
    public DodoEntity updateId(Long id, DodoRequest request) {
        DodoEntity dodoEntity = this.searchId(id);

        if(request.getTitle() != null) {
            dodoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            dodoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            dodoEntity.setCompleted(request.getCompleted());
        }

        return this.dodoRepository.save(dodoEntity);
    }

    //전체 할 일 삭제
    public void deleteAll() {
        this.dodoRepository.deleteAll();
    }

    //특정 id 할 일 삭제
    public void deleteId(Long id) {
        this.dodoRepository.deleteById(id);
    }

}
