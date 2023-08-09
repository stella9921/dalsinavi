package com.example.dalsi;

public class DB {
    String email; //문의자 이메일
    String content; //문의 내용

    public DB(){} // 생성자 메서드


    //getter, setter 설정
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




    //값을 추가할때 쓰는 함수, MainActivity에서 addDB함수에서 사용할 것임.
    public DB(String email, String content){
        this.email = email;
        this.content = content;
    }
}
