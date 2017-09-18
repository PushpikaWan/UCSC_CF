package com.example.pushpika.ucsc_cf;

/**
 * Created by pushpika on 8/25/17.
 */

public class Data {
    //json file for firebase database
    /*

{
  "Stoles" : [ {
    "authEmails" : "simcentric@gmail.com",
    "floor" : "A",
    "isAvailable" : "Not Available",
    "stoleID" : "A1",
    "stoleName" : "Simcentric",
    "stoleNumber" : 1
  }, {
    "authEmails" : "inovait@gmail.com",
    "floor" : "A",
    "isAvailable" : "Not Available",
    "stoleID" : "A2",
    "stoleName" : "Inova IT",
    "stoleNumber" : 2
  }, {
    "authEmails" : "virtusa@gmail.com",
    "floor" : "A",
    "isAvailable" : "Available",
    "stoleID" : "A3",
    "stoleName" : "Virtusa",
    "stoleNumber" : 3
  }, {
    "authEmails" : "virtusa@gmail.com",
    "floor" : "A",
    "isAvailable" : "Available",
    "stoleID" : "A4",
    "stoleName" : "Virtusa",
    "stoleNumber" : 4
  }, {
    "authEmails" : "syscolabs@gmail.com",
    "floor" : "A",
    "isAvailable" : "Available",
    "stoleID" : "A5",
    "stoleName" : "SYSCO LABS",
    "stoleNumber" : 5
  }, {
    "authEmails" : "syscolabs@gmail.com",
    "floor" : "A",
    "isAvailable" : "Not Available",
    "stoleID" : "A6",
    "stoleName" : "SYSCO LABS",
    "stoleNumber" : 6
  }, {
    "authEmails" : "syscolabs@gmail.com",
    "floor" : "A",
    "isAvailable" : "Available",
    "stoleID" : "A7",
    "stoleName" : "SYSCO LABS",
    "stoleNumber" : 7
  }, {
    "authEmails" : "synopsis@gmail.com",
    "floor" : "A",
    "isAvailable" : "Not Available",
    "stoleID" : "A8",
    "stoleName" : "Synopsis",
    "stoleNumber" : 8
  }, {
    "authEmails" : "codegen@gmail.com",
    "floor" : "A",
    "isAvailable" : "Not Available",
    "stoleID" : "A9",
    "stoleName" : "Codegen",
    "stoleNumber" : 9
  }, {
    "authEmails" : "codegen@gmail.com",
    "floor" : "A",
    "isAvailable" : "Available",
    "stoleID" : "A10",
    "stoleName" : "Codegen",
    "stoleNumber" : 10
  }, {
    "authEmails" : "ifs@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B1",
    "stoleName" : "IFS",
    "stoleNumber" : 11
  }, {
    "authEmails" : "camms@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B2",
    "stoleName" : "CAMMS",
    "stoleNumber" : 12
  }, {
    "authEmails" : "eyepax@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B3",
    "stoleName" : "EyePax",
    "stoleNumber" : 13
  }, {
    "authEmails" : "fortude@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B4",
    "stoleName" : "Fortude",
    "stoleNumber" : 14
  }, {
    "authEmails" : "fortude@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B5",
    "stoleName" : "Fortude",
    "stoleNumber" : 15
  }, {
    "authEmails" : "geveo@gmail.com",
    "floor" : "B",
    "isAvailable" : "Not Available",
    "stoleID" : "B6",
    "stoleName" : "Geveo",
    "stoleNumber" : 16
  }, {
    "authEmails" : "99xtechnology@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C1",
    "stoleName" : "99X Technology",
    "stoleNumber" : 17
  }, {
    "authEmails" : "vizuamatix@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C2",
    "stoleName" : "Vizua Matix",
    "stoleNumber" : 18
  }, {
    "authEmails" : "mobitel@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C3",
    "stoleName" : "Mobitel",
    "stoleNumber" : 19
  }, {
    "authEmails" : "me11@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C4",
    "stoleName" : "comp11",
    "stoleNumber" : 20
  }, {
    "authEmails" : "me11@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C5",
    "stoleName" : "comp11",
    "stoleNumber" : 21
  }, {
    "authEmails" : "me11@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C6",
    "stoleName" : "comp11",
    "stoleNumber" : 22
  }, {
    "authEmails" : "earthuniversity@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C7",
    "stoleName" : "Earth University",
    "stoleNumber" : 23
  }, {
    "authEmails" : "me11@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C8",
    "stoleName" : "comp11",
    "stoleNumber" : 24
  }, {
    "authEmails" : "orangehrm@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C9",
    "stoleName" : "OrangeHRM",
    "stoleNumber" : 25
  }, {
    "authEmails" : "wso2@gmail.com",
    "floor" : "C",
    "isAvailable" : "Not Available",
    "stoleID" : "C10",
    "stoleName" : "Wso2",
    "stoleNumber" : 26
  }, {
    "authEmails" : "masandattune@gmail.com",
    "floor" : "D",
    "isAvailable" : "Not Available",
    "stoleID" : "D1",
    "stoleName" : "MAS and Attune",
    "stoleNumber" : 27
  }, {
    "authEmails" : "masandattune@gmail.com",
    "floor" : "D",
    "isAvailable" : "Not Available",
    "stoleID" : "D2",
    "stoleName" : "MAS and Attune",
    "stoleNumber" : 28
  }, {
    "authEmails" : "cambio@gmail.com",
    "floor" : "D",
    "isAvailable" : "Not Available",
    "stoleID" : "D3",
    "stoleName" : "Cambio",
    "stoleNumber" : 29
  }, {
    "authEmails" : "cambio@gmail.com",
    "floor" : "D",
    "isAvailable" : "Available",
    "stoleID" : "D4",
    "stoleName" : "Cambio",
    "stoleNumber" : 30
  } ],
  "Users" : [ {
    "email" : "lucefer41@gmail.com",
    "userName" : "Kamal"
  }, {
    "email" : "vihangaliyanage007@gmail.com",
    "userName" : "Nimal"
  }, {
    "email" : "me@gmail.com",
    "userName" : "me"
  }, {
    "email" : "kasun@gmail.com",
    "userName" : "Kasun"
  }, {
    "email" : "pasan@gmail.com",
    "userName" : "Pasan"
  }, {
    "email" : "chamal@gmail.com",
    "userName" : "Chamal"
  } ]
}


     */
}
