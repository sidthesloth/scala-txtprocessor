package com.antworks.txtprocessor

import org.scalatest.FunSuite

/**
  * Created by Dennis Saka on 2018/04/30.
  */
class UserTweetTXTReaderTest extends FunSuite {

  test("Load User TXT file") {
    val lines = new UserTweetFileTXTReader("src/main/resources/user.txt").stringsFromUserFile
    assert(lines == "Ward follows Alan Alan follows Martin Ward follows Martin, wade, Daniel, freddie")
  }

  test("Load Tweet TXT file") {
    val lines = new UserTweetFileTXTReader("src/main/resources/user.txt").stringsFromTweetFile
    assert(lines == List("Ward follows Alan", "Alan follows Martin", "Ward follows Martin, wade, Daniel, freddie"))
  }
}


