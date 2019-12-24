package com.secbro.drools.chapter0;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhuzs on 2017/8/9.
 */
public class LearnDroolsTest extends BaseTest{

    /**
     *  时间差 测试
     */
    @Test
    public void datetimeNumTest() throws ParseException {
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  double 测试
     */
    @Test
    public void doubleTest() throws ParseException {



        String format = "yyyy-MM-dd HH:mm:ss";
//        String format = "dd-MMM-yyyy";
//        String format = "dd-MMM-yyyy HH:mm:ss:SSS";
//        System.setProperty("drools.dateformat", format);
        KieSession kieSession = getKieSessionBySessionName("learn-drools");


        Person p1 = new Person();
        p1.setBalance(0.7);
        p1.setSalary(100);
        p1.setMarry(true);
        p1.setName("dfba");

//        DateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        DateFormat dateFormat = new SimpleDateFormat(format);
//        p1.setBornDate(dateFormat.parse("27-Oct-2009 09:00:01:300"));
//        System.out.println(dateFormat.format(new Date()));
//        p1.setBornDate(dateFormat.parse("2018-08-13 09:00:01"));
//        p1.setBornDate(dateFormat.parse("12-12-2008"));
//        p1.setBornDate(dateFormat.parse("27-Oct-2009"));

        Date date = new Date();
        p1.setBornDate(date);

//        String dateString = "13-Aug-2018" ;
//        System.out.println(dateFormat.format(date));
//        p1.setBornDate(new Date( 115, 1, 20 ));

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }


    /**
     *  not in 测试
     */
    @Test
    public void notInTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("zhaoliu");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  in 测试
     */
    @Test
    public void inTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("wangwu");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  != null 测试
     */
    @Test
    public void neNullTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("wangwu");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  == null 测试
     */
    @Test
    public void eNullTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName(null);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  not soundslike 测试
     */
    @Test
    public void notSoundsLikeTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("word");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  soundslike 测试
     */
    @Test
    public void soundsLikeTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("world");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  not matches 测试
     */
    @Test
    public void notMatchesTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("李四");

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  matches 测试
     */
    @Test
    public void matchesTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName("三三");
        p1.setAge(30);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  != 测试
     */
    @Test
    public void neTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(19);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  == 测试
     */
    @Test
    public void eTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(18);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  <= 测试
     */
    @Test
    public void leTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(17);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  < 测试
     */
    @Test
    public void lTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(17);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  >= 测试
     */
    @Test
    public void geTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(18);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    /**
     *  > 测试
     */
    @Test
    public void gTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(20);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    @Test
    public void nullSafeTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setName(null);
        p1.setAge(18);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    @Test
    public void testDateFormat() {

        DateFormat dateFormat = new SimpleDateFormat("dd-mmm-yyyy", Locale.US);

        System.out.println(dateFormat.format(new Date()));
    }

    @Test
    public void equalsTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setBornDate(new Date(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis());

        p1.setMarry(true);
        p1.setAdult('0');
        p1.setName("zhangsan");
        p1.setAge(18);
        p1.setSalary(101);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }

    @Test
    public void bindingTest(){
        KieSession kieSession = getKieSessionBySessionName("learn-drools");

        Person p1 = new Person();
        p1.setAge(18);

        kieSession.insert(p1);

        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }
}
