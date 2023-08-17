package com.application.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter

// Will be used to return custom response
public class PostResponse {

    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;

    // how many records
    private long totalElement;

    // total pages
    private int totalPages;

    // Last page
    private boolean lastPage;


}
