package com.fanfiction.fanfictionapi.DTO;

import lombok.Data;

@Data
public class PaginationRequestDTO {
 private Integer pageSize;
 private Integer pageNumber;
 private String sortedBy;
}
