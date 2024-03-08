package com.example.nation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class enactRevisionData {
    public enactRevisionData(int i, String revisionContents2, String write2, String sign2, String date2) {
        //TODO Auto-generated constructor stub
    }
    private Float revisionNum;
    private String revisionContents;
    private String write;
    private String sign;
    private String date;
}
