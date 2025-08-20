package com.careerit.jfs.cj.jdbc.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain class representing a Contact entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private boolean deleted;
}
