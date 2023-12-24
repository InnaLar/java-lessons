package org.example.jdbc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileRs {
    private Long uniqueId;
    private String fileName;
    private String type;
    private String url;
    private String ext;
}
