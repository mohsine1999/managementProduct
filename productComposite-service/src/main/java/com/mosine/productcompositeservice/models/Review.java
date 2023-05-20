package com.mosine.productcompositeservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {

        private Long idreview;

        private String author;

        private String subject;

        private String content;

}
