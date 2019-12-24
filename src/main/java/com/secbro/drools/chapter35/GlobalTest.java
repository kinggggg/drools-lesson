package com.secbro.drools.chapter35;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class GlobalTest extends BaseTest{

    @Test
    public void testGlobal(){
        KieSession kieSession = this.getKieSessionBySessionName("global-rules");

        EmailService emailService = new EmailService();
        //第一个参数的值与drl文件中global定义的参数的名称要一致
        kieSession.setGlobal("emailService2",emailService);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
