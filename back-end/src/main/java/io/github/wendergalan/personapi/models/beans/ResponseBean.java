package io.github.wendergalan.personapi.models.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseBean<T> implements Serializable {
    private Integer currentPage;
    private Integer totalPages;
    private Long totalElements;
    private List<T> content;
}
