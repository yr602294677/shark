package com.yangrui.shark.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGrouping {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();//初始化 并赋值
        a.add("**张壮**  ");
        a.add("**王宏达**");
        a.add("**张立珠**");
        a.add("赵温珂");
        a.add("高硕  ");
        a.add("高威  ");
        a.add("王福云");
        a.add("尹景涛");
        a.add("王阳  ");
        a.add("王超  ");
        a.add("刘伟  ");
        a.add("邵华  ");
        a.add("小王超");
        a.add("高祥炎");
        a.add("曹峰  ");
        a.add("田朋  ");
        a.add("宋建丽");
        a.add("杨锐  ");
        a.add("杨志强");
        a.add("赵春昀");
        a.add("张兴振");
        a.add("尹延明");
        a.add("段耀誉");
        a.add("王刚  ");
        a.add("王翠萍");
        a.add("曹莎  ");
        a.add("朱兆杰");
        a.add("刘承国");
        a.add("孙奉义");
        a.add("高得伟");
        a.add("**郑健**");
        a.add("杨栋林");
        a.add("张晨皓");
        a.add("梁思禹");
        a.add("李景毓");
        a.add("邹宗锐");
        a.add("孙安阳");
        a.add("陈超  ");
        a.add("荆总  ");
        a.add("冯十钰");

        Random ran = new Random();
        String b;
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + "组");//输出随机获得的String
            for (int j = 0; j < 10; j++) {
                b = a.get(ran.nextInt(a.size()));
                System.out.print("   " + b);
                a.remove(b);//在集合中删除输出的String
            }
            System.out.println("\n");

        }
    }
}