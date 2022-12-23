package com.board.mybatisboard.utill;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
// Entity 종류 상관없이 공통으로 가지고 있어야할 정보가 있을때 사용 (ex 생성 시간 수정 시간 등등) 공통 클래스로 추출하고 이를 상속받는 방식.
// 해당 클래스가 상속될 속성을 포함하고 있는 SuperClass
@EntityListeners(AuditingEntityListener.class) // Entity 변경 시 자동업데이트
public abstract class Timestamped {

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name =  "UPDATED_AT")
    private LocalDateTime updatedAt;

}
