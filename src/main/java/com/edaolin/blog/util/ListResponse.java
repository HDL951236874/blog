package com.edaolin.blog.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ListResponse<T> {
    List<T> response;
}
