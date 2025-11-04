package com.movieapi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "movieApi")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseEntity {

    // 테이블 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @Column(length = 50)
    private String description;

    // 생성자
    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // 메서드
    public void updateMovie(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
