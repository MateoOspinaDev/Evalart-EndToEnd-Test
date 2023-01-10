package model;

public class CandidateFactory {
    private CandidateFactory() {
    }

    public static Candidate createByName(String name){
        return Candidate.builder()
                .name(name)
                .credentials(Credentials.builder()
                        .username("516522")
                        .password("10df2f32286b7120Mi00LTIyNTYxNQ==30e0c83e6c29f1c3")
                        .build())
                .build();
    }
}
