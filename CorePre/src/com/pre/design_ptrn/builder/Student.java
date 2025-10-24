package com.pre.design_ptrn.builder;

public class Student {
    private int id;
    private String name;
    private String address;

    private Student(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String address;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public static Builder newInstance(){

            return new Builder();
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
