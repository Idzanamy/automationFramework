package framework.hardcore.service;

import framework.hardcore.model.Email;

public class EmailCreator {


    public final String TEST_DATA_SHORT_EMAIL = "liza";
    public final String TEST_DATA_FULL_EMAIL = TEST_DATA_SHORT_EMAIL + "@as-aws-dev.com";

    public Email withShortEmailFromProperty(){
        return new Email(TEST_DATA_SHORT_EMAIL);
    }

    public Email withFullEmailFromProperty(){
        return new Email(TEST_DATA_FULL_EMAIL);
    }
}

