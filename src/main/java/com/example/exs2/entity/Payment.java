package com.example.exs2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Payment {
    private String name;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date supplyDate;
    private boolean state;
    private char part;
    private long value;
}
