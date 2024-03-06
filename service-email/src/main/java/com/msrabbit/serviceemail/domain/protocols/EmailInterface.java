package com.msrabbit.serviceemail.domain.protocols;

import com.msrabbit.serviceemail.domain.model.EmailModel;

public interface EmailInterface {


    EmailModel sendEmail(EmailModel emailModel);
}
