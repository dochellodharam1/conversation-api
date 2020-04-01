package com.sapient.how.hellodoc.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class Dialogue {
    @Id
    private String id;

    private String intent;
    private String reply;
    private String action;
    private String whenToAct;
    private String replyAfterAction;
}
