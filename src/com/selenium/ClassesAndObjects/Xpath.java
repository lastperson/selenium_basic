package com.selenium.ClassesAndObjects;

/**
 // - ������ �����
 / - ������ �� ������� ����
 //book[@author='Tolstoy'] - ����� ������ � ���������� author='Tolstoy'
 //book[2] - ������ �����
 //*[@id='name'] - ����� ��� � id=name
 //pages[text()='999']    - tag pages � ������� ����� ������ �������� 999
 //pages[text()='999']/.. - �� ������� ����
    //book/pages[text()='999']
 ����������� ������ ������� ����� ��������:
 � �� ������ �������� ul/li[position() mod 2 = 1]
 � ������ ��������: ul/li[position() mod 2 = 0]

 ������ ul/li/div/p[last()] � ��������� ��������� ��������� ��� ������� ���� ������ �ul�

 �������� ���������
 < � ���������� �������
 > � ���������� �������
 <= � ���������� ������� ���� �����
 >= � ���������� ������� ���� �����

 ul/li[position() > 2] , ul/li[position() <= 2] � �������� ������ ������� � 3�� ������ � ��������.

 ���� � ����� ��� name
 //book[count(name) = 2]

 ��������� �������
 //title[text()='hi']/following::shelf[1]

 */
public class Xpath {


    public static void main(String[] args) {

    }
}
