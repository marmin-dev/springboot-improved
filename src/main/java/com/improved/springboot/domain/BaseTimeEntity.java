package com.improved.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity클래스 들이 BaseTimeEntity를 상속할 경우 필드들도
//칼럼을 인식하도록 합니다
@EntityListeners(AuditingEntityListener.class) //Entity가 생성되어 시간이 자동 저장된다
public abstract class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동저장됩니다
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장된다
    private LocalDateTime modifiedDate;
}
