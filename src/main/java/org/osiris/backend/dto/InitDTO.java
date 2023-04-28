package org.osiris.backend.dto;

import lombok.Data;

@Data
public class InitDTO {
    private String msg;

    public InitDTO(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
