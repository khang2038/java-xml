package com.company.khang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view {
    int i=0;
    view(){
        JFrame frame=new JFrame("xml");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        danhsachhocsinh danhsach=new danhsachhocsinh();

        JLabel ten=new JLabel("hoten:");
        ten.setBounds(10,0,100,30);
        frame.add(ten);

        JTextField ten1=new JTextField();
        ten1.setBounds(60,0,150,30);
        frame.add(ten1);

        JLabel toan=new JLabel("toan: ");
        toan.setBounds(220,0,100,30);
        frame.add(toan);

        JTextField toan1=new JTextField();
        toan1.setBounds(280,0,150,30);
        frame.add(toan1);

        JLabel ly=new JLabel("ly:");
        ly.setBounds(10,40,100,30);
        frame.add(ly);

        JTextField ly1=new JTextField();
        ly1.setBounds(60,40,150,30);
        frame.add(ly1);

        JLabel hoa=new JLabel("hoa:");
        hoa.setBounds(220,40,100,30);
        frame.add(hoa);

        JTextField hoa1=new JTextField();
        hoa1.setBounds(280,40,150,30);
        frame.add(hoa1);



        JButton themmoi=new JButton("them");
        themmoi.setBounds(50,200,100,30);
        themmoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=ten1.getText();
                int math=Integer.parseInt(toan1.getText());
                int ly=Integer.parseInt(ly1.getText());
                int hoa=Integer.parseInt(hoa1.getText());
                student hs=new student(name,math,ly,hoa);
                danhsach.addhs(hs);
            }
        });
        frame.add(themmoi);

        JButton xoa=new JButton("xoa");
        xoa.setBounds(160,200,100,30);
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danhsach.xoahs(i);
                ten1.setText("");
                toan1.setText("");
                ly1.setText("");
                hoa1.setText("");
            }
        });
        frame.add(xoa);

        JButton savefile=new JButton("SaveFile");
        savefile.setBounds(270,200,120,30);
        savefile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danhsach.savefile();
            }
        });
        frame.add(savefile);

        JButton docFilePAX=new JButton("docfilePAX");
        docFilePAX.setBounds(70,250,150,30);
        docFilePAX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danhsach.docfilepax();
            }
        });
        frame.add(docFilePAX);

        JButton docFileDOM=new JButton("docFileDOM");
        docFileDOM.setBounds(230,250,150,30);
        docFileDOM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    danhsach.docfileDOM();
            }
        });
        frame.add(docFileDOM);

        JButton next=new JButton("Next");
        next.setBounds(230,300,150,30);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i += 1;
                ten1.setText(danhsach.truydenhs(i).getHoten());
                toan1.setText(String.valueOf(danhsach.truydenhs(i).getToan()));
                ly1.setText(String.valueOf(danhsach.truydenhs(i).getLy()));
                hoa1.setText(String.valueOf(danhsach.truydenhs(i).getHoa()));
            }
        });
        frame.add(next);

        JButton back=new JButton("Back");
        back.setBounds(80,300,150,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i -= 1;
                ten1.setText(danhsach.truydenhs(i).getHoten());
                toan1.setText(String.valueOf(danhsach.truydenhs(i).getToan()));
                ly1.setText(String.valueOf(danhsach.truydenhs(i).getLy()));
                hoa1.setText(String.valueOf(danhsach.truydenhs(i).getHoa()));
            }
        });
        frame.add(back);

        frame.setVisible(true);
    }
}
