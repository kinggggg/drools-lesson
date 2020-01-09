package com.secbro.drools.chapter2;

import com.secbro.drools.model.Goods;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by zhuzs on 2017/8/12.
 */
public class Drools5ApiTest2 {

    @Test
    public void testDrools5Api() throws UnsupportedEncodingException {

        KieServices kieServices = KieServices.get();

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        String s = "package com.rules1\n" +
                "\n" +
                "\n" +
                "rule \"my-rule1\"\n" +
                "\n" +
                "when\n" +
                "\n" +
                "then\n" +
                "    System.out.println(\"my-rule1！\");\n" +
                "end" ;
        kbuilder.add(ResourceFactory.newByteArrayResource(s.getBytes("utf-8")), ResourceType.DRL);

        s = "package com.rules2\n" +
                "\n" +
                "\n" +
                "rule \"my-rule2\"\n" +
                "\n" +
                "when\n" +
                "\n" +
                "then\n" +
                "    System.out.println(\"my-rule2！\");\n" +
                "end" ;
        kbuilder.add(ResourceFactory.newByteArrayResource(s.getBytes("utf-8")), ResourceType.DRL);

        s = "package com.rules2\n" +
                "\n" +
                "\n" +
                "rule \"my-rule22\"\n" +
                "\n" +
                "when\n" +
                "\n" +
                "then\n" +
                "    System.out.println(\"my-rule22！\");\n" +
                "end" ;
        kbuilder.add(ResourceFactory.newByteArrayResource(s.getBytes("utf-8")), ResourceType.DRL);

        if(kbuilder.hasErrors()){
            System.out.println(kbuilder.getErrors());
        }

        KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
        Collection<KnowledgePackage> pks = kbuilder.getKnowledgePackages();

        /**
         * addKnowledgePackages函数的作用（来自7.10.0.Final中KnowledgeBaseImpl的addPackages方法说明）：
         *
         * Add a <code>Package</code> to the network. Iterates through the
         * <code>Package</code> adding Each individual <code>Rule</code> to the
         * network. Before update network each referenced <code>WorkingMemory</code>
         * is locked.
         *
         * @param newPkgs The package to add.
         */
        /**
         * 下面的方法已经不推荐使用了，不起作用，例如：从pks中删除一个元素后（一个package后），位于该删除的package下的规则还是会执行
         * 类似：
         * ArrayList pks1 = (ArrayList) pks;
         * pks1.remove(0);
         * knowledgeBase.addKnowledgePackages(pks1);
         *
         **/
//        knowledgeBase.addKnowledgePackages(pks);

        Collection<KnowledgePackage> knowledgePackages = knowledgeBase.getKnowledgePackages();
        System.out.println(knowledgePackages);

        // 根据package的名称和规则的名称删除规则
//        knowledgeBase.removeRule("com.rules1", "my-rule1");

        // 通过package的名称删除规则，位于该package下的规则都会被删除
//        knowledgeBase.removeKiePackage("com.rules1");
        knowledgeBase.removeKiePackage("com.rules2");


        StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase.newStatefulKnowledgeSession();

        Goods goods = new Goods();

        statefulKnowledgeSession.insert(goods);

        int count = statefulKnowledgeSession.fireAllRules();
        statefulKnowledgeSession.dispose();

        System.out.println("Fire " + count + " rule(s)!");
        System.out.println("The new discount is " + goods.getDiscount() + "%");
    }
}
