package com.greenway.test.proxy.cglibproxy;

public class TestCglib {
public static void main(String[] args) {
	BookFacadeCglib cglib = new BookFacadeCglib();
	BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
	bookCglib.addBook();
}
}
