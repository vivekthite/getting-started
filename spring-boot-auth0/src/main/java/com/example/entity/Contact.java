/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author vivekanandt
 *
 */
@Data
@Builder
public class Contact {

    private String name;

    private String phone;
}
