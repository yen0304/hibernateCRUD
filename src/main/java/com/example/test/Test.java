package com.example.test;


import com.example.entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Map;

public class Test {

    public static void main(String[] args){
        //創建Configuration
        Configuration configuration =new Configuration().configure();
        System.out.println(configuration);
        //獲取Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //獲取session
        Session session = sessionFactory.openSession();
        //建立事務
        Transaction transaction = session.beginTransaction();
        //create
        Member member=new Member();
        member.setName("hb測試");
        member.setAccount("hb123@gm.com");
        member.setPassword("hb123");

        //傳進去
        //session.save(member);
        //提交
        //session.beginTransaction().commit();

        //read

        //Member member1=session.get(Member.class,16);

        try{
            String hql = "from Member where name=:Name";

            Query query = session.createQuery(hql);
            query.setParameter("Name", "test123");
            Member member1= (Member) query.list().get(0);
            System.out.println(member1);

            System.out.println(member1.getId());
            System.out.println(member1.getName());
            System.out.println(member1.getAccount());
            System.out.println(member1.getPassword());
        } catch (Exception e){
            System.out.println("找不到名稱");
            throw (e);
        }

        //update
        /*
        member1.setName("修改改");
        session.update(member1);
        transaction.commit();
        */


        //delete

        //session.delete(member1);
        //transaction.commit();

        session.close();
    }


}
