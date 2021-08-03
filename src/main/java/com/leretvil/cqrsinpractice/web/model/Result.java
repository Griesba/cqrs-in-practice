package com.leretvil.cqrsinpractice.web.model;

import lombok.Data;

@Data
public class Result {
    private boolean isSuccess;
    private String error;

    public Result() {
        this.isSuccess = true;
    }

    public Result(boolean isFailure, String error) {
        this.isSuccess = isFailure;
        this.error = error;
    }
}
