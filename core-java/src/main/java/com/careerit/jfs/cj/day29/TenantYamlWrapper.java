package com.careerit.jfs.cj.day29;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantYamlWrapper {
    private Tenant tenant;
    private DatabaseProperties db;
} 