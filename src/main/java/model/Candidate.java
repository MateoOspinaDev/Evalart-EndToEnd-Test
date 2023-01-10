package model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Candidate {

    public static final String CANDIDATE_INFORMATION = "candidate information";


    private String name;
    private Credentials credentials;
}
