package com.secbro.drools.chapter2;

import com.secbro.drools.model.Goods;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

/**
 * Created by zhuzs on 2017/8/12.
 */
public class Drools5ApiTest2 {

    @Test
    public void testDrools5Api() throws UnsupportedEncodingException {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        String s = "package com.rules\n" +
                "import com.secbro.drools.model.Goods;\n" +
                "\n" +
                "rule \"test-drools5-api\"\n" +
                "\n" +
                "when\n" +
                "    $goods : Goods(discount == 100)\n" +
                "then\n" +
                "    $goods.setDiscount(50);\n" +
                "    System.out.println(\"test-drools5-api has fired！\");\n" +
                "end" ;
        kbuilder.add(ResourceFactory.newByteArrayResource(s.getBytes("utf-8")), ResourceType.DRL);

        s = "package com.rules2\n" +
                "import com.secbro.drools.model.Goods;\n" +
                "\n" +
                "rule \"test-drools5-api\"\n" +
                "\n" +
                "when\n" +
                "\n" +
                "then\n" +
                "    System.out.println(\"good2！\");\n" +
                "end" ;
        kbuilder.add(ResourceFactory.newByteArrayResource(s.getBytes("utf-8")), ResourceType.DRL);

        if(kbuilder.hasErrors()){
            System.out.println(kbuilder.getErrors());
        }

        KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
        Collection<KnowledgePackage> pks = kbuilder.getKnowledgePackages();
        knowledgeBase.addKnowledgePackages(pks);

        StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase.newStatefulKnowledgeSession();

        Goods goods = new Goods();

        statefulKnowledgeSession.insert(goods);

        int count = statefulKnowledgeSession.fireAllRules();
        statefulKnowledgeSession.dispose();

        System.out.println("Fire " + count + " rule(s)!");
        System.out.println("The new discount is " + goods.getDiscount() + "%");
    }
}
